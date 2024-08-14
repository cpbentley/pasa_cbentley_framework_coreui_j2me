package pasa.cbentley.framework.core.ui.j2me.engine;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

import pasa.cbentley.framework.core.draw.j2me.engine.GraphicsJ2me;
import pasa.cbentley.framework.core.ui.j2me.ctx.CoreUiJ2meCtx;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;

/**
 * Basic bridge for classes that do not use GraphicsX
 * 
 * @author Charles-Philip
 *
 */
public class RealCanvasJ2me extends GameCanvas {

   protected final CoreUiJ2meCtx cac;

   private CanvasJ2me            canvas;

   /**
    * Used by J2ME
    */
   public RealCanvasJ2me(CanvasJ2me canvas, CoreUiJ2meCtx dd) {
      super(false);
      this.cac = dd;
      this.canvas = canvas;
   }

   public void flushMyGraphics() {
      flushGraphics();
   }

   public void flushMyGraphics(int x, int y, int w, int h) {
      flushGraphics(x, y, w, h);
   }

   public CanvasJ2me getCanvasJ2ME() {
      return canvas;
   }

   public Graphics getMyGraphics() {
      return getGraphics();
   }

   protected void hideNotify() {
      canvas.focusLostBridge();
   }

   protected void keyPressed(int keyCode) {
      int finalCode = cac.getKeyMap().getKeyMappedToFramework(keyCode);
      canvas.keyPressedBridge(finalCode);
   }

   protected void keyReleased(int keyCode) {
      int finalCode = cac.getKeyMap().getKeyMappedToFramework(keyCode);
      canvas.keyReleasedBridge(finalCode);
   }

   public void paint(Graphics g) {
      IGraphics gx = new GraphicsJ2me(g, cac.getCoreDrawJ2MECtx());
      canvas.paintBridge(gx);
   }

   protected void pointerDragged(int x, int y) {
      canvas.fingerMovedBridge(x, y, 0, 0);
   }

   protected void pointerPressed(int x, int y) {
      canvas.fingerPressedBridge(x, y, 0, 0);
   }

   /**
    * Pointer events are associated with Finder
    */
   protected void pointerReleased(int x, int y) {
      canvas.fingerReleasedBridge(x, y, 0, 0);
   }

   protected void showNotify() {
      canvas.focusGainedBridge();
   }
}
