package pasa.cbentley.framework.coreui.j2me.engine;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

import pasa.cbentley.framework.coredraw.j2me.engine.GraphicsJ2ME;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coreui.j2me.ctx.CoreUiJ2MECtx;

/**
 * Basic bridge for classes that do not use GraphicsX
 * 
 * @author Charles-Philip
 *
 */
public class RealCanvasJ2ME extends GameCanvas {

   protected final CoreUiJ2MECtx     cac;

   private CanvasJ2ME canvas;

   /**
    * Used by J2ME
    */
   public RealCanvasJ2ME(CanvasJ2ME canvas, CoreUiJ2MECtx dd) {
      super(false);
      this.cac = dd;
      this.canvas = canvas;
   }

   public CanvasJ2ME getCanvasJ2ME() {
      return canvas;
   }

   public void paint(Graphics g) {
      IGraphics gx = new GraphicsJ2ME(g, cac.getCoreDrawJ2MECtx());
      canvas.paintBridge(gx);
   }

   protected void keyPressed(int keyCode) {
      int finalCode = cac.getKeyMap().getKeyMappedToFramework(keyCode);
      canvas.keyPressedBridge(finalCode);
   }

   protected void keyReleased(int keyCode) {
      int finalCode = cac.getKeyMap().getKeyMappedToFramework(keyCode);
      canvas.keyReleasedBridge(finalCode);
   }

   protected void pointerPressed(int x, int y) {
      canvas.fingerPressedBridge(x, y, 0, 0);
   }

   protected void pointerDragged(int x, int y) {
      canvas.fingerMovedBridge(x, y, 0, 0);
   }

   /**
    * Pointer events are associated with Finder
    */
   protected void pointerReleased(int x, int y) {
      canvas.fingerReleasedBridge(x, y, 0, 0);
   }

   protected void hideNotify() {
      canvas.focusLostBridge();
   }

   public Graphics getMyGraphics() {
      return getGraphics();
   }

   public void flushMyGraphics() {
      flushGraphics();
   }

   public void flushMyGraphics(int x, int y, int w, int h) {
      flushGraphics(x, y, w, h);
   }

   protected void showNotify() {
      canvas.focusGainedBridge();
   }
}
