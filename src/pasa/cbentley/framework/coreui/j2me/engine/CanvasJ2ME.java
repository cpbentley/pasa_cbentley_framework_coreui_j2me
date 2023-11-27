package pasa.cbentley.framework.coreui.j2me.engine;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.framework.coredraw.j2me.engine.GraphicsJ2ME;
import pasa.cbentley.framework.coredraw.src4.interfaces.IGraphics;
import pasa.cbentley.framework.coreui.j2me.ctx.CoreUiJ2MECtx;
import pasa.cbentley.framework.coreui.src4.engine.CanvasHostAbstract;
import pasa.cbentley.framework.coreui.src4.tech.ITechFeaturesUI;

/**
 * Basic bridge for classes that do not use GraphicsX
 * 
 * @author Charles-Philip
 *
 */
public class CanvasJ2ME extends CanvasHostAbstract {

   private RealCanvasJ2ME        c;

   private boolean               isFullscreen;

   protected final CoreUiJ2MECtx cuc;

   /**
    * Used by J2ME
    */
   public CanvasJ2ME(CoreUiJ2MECtx dd, ByteObject tech) {
      super(dd, tech);
      this.cuc = dd;
      //create the actual J2ME
      c = new RealCanvasJ2ME(this, dd);
      //we don't know the size of it do we?

   }

   public void canvasShow() {
      MIDlet midlet = cuc.getCoreDrawJ2MECtx().getMidlet();
      Display display = Display.getDisplay(midlet);
      display.setCurrent(c);
   }

   public void canvasHide() {
   }

   public Displayable getDisplayable() {
      return c;
   }

   public boolean setCanvasFeature(int feature, Object mode) {
      return false;
   }

   public boolean isShown() {
      return c.isShown();
   }

   /**
    * Path to icon in application package
    * @param string
    */
   public void setIcon(String string) {
   }

   public void setTitle(String string) {
   }

   public void icServiceRepaint() {
      c.serviceRepaints();
   }

   public void icRepaint(int x, int y, int w, int h) {
      c.repaint(x, y, w, h);
   }

   public int getICHeight() {
      return c.getHeight();
   }

   public int getICWidth() {
      return c.getWidth();
   }

   public void setICSize(int w, int h) {
      //impossible in j2me
   }

   public void serviceRepaints() {
      c.serviceRepaints();
   }

   protected void showNotify() {

   }

   public boolean setCanvasFeature(int feature, boolean mode) {
      if (feature == ITechFeaturesUI.SUP_ID_27_FULLSCREEN) {
         c.setFullScreenMode(mode);
         isFullscreen = mode;
         return true;
      }
      return false;
   }

   public boolean isCanvasFeatureEnabled(int feature) {
      if (feature == ITechFeaturesUI.SUP_ID_27_FULLSCREEN) {
         return isFullscreen;
      }
      return false;
   }

   public boolean isCanvasFeatureSupported(int feature) {
      return false;
   }

   public IGraphics getGraphics() {
      Graphics g = c.getMyGraphics();
      GraphicsJ2ME gm = new GraphicsJ2ME(g, cuc.getCoreDrawJ2MECtx());
      return gm;
   }

   public void flushGraphics() {
      c.flushGraphics();
   }

   public void icSetSize(int w, int h) {
      //not possible here
   }

   public void icSetXY(int x, int y) {
      //not possible here
   }

   public boolean updateSettings(ByteObject framePos) {
      // TODO Auto-generated method stub
      return false;
   }

   public ByteObject getSettings() {
      // TODO Auto-generated method stub
      return null;
   }

   public int getICY() {
      return 0;
   }

   public int getICX() {
      return 0;
   }

   public void setDefaultStartPosition() {
      //only one position.. fullscreen by default
   }

}
