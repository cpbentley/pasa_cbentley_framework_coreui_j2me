package pasa.cbentley.framework.coreui.j2me.ctx;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.interfaces.IExecutor;
import pasa.cbentley.framework.coredraw.j2me.ctx.CoreDrawJ2MECtx;
import pasa.cbentley.framework.coreui.j2me.engine.CanvasJ2ME;
import pasa.cbentley.framework.coreui.j2me.engine.J2MEExecutor;
import pasa.cbentley.framework.coreui.j2me.engine.J2MEGestures;
import pasa.cbentley.framework.coreui.j2me.engine.KeyMapJ2ME;
import pasa.cbentley.framework.coreui.src4.ctx.CoreUiCtx;
import pasa.cbentley.framework.coreui.src4.ctx.IConfigCoreUI;
import pasa.cbentley.framework.coreui.src4.engine.CanvasHostAbstract;
import pasa.cbentley.framework.coreui.src4.engine.KeyMapAbstract;
import pasa.cbentley.framework.coreui.src4.engine.WrapperAbstract;
import pasa.cbentley.framework.coreui.src4.interfaces.ICanvasOwner;
import pasa.cbentley.framework.coreui.src4.interfaces.IHostGestures;
import pasa.cbentley.framework.coreui.src4.interfaces.IHostUI;
import pasa.cbentley.framework.coreui.src4.tech.IBOCanvasHost;

public class CoreUiJ2MECtx extends CoreUiCtx {

   public static final int         CTX_ID = 485;

   protected final CoreDrawJ2MECtx cdc;

   protected final J2MEExecutor    executor;

   private J2MEGestures            j2meges;

   private KeyMapJ2ME              keyMap;

   /**
    * Core UI deals with file connections for drag and drop so we need a {@link CoreIO5Ctx}
    * @param cdc
    * @param sc
    * @param cio5c
    */
   public CoreUiJ2MECtx(CoreDrawJ2MECtx cdc, IConfigCoreUI configUI) {
      super(configUI, cdc);
      this.cdc = cdc;
      executor = new J2MEExecutor(this);
      j2meges = new J2MEGestures(this);
      keyMap = new KeyMapJ2ME(uc);
   }

   protected void applySettings(ByteObject settingsNew, ByteObject settingsOld) {
      // TODO Auto-generated method stub

   }

   /**
    * {@link IBOCanvasHost}
    */
   public CanvasHostAbstract createCanvasClass(WrapperAbstract wrapper, ByteObject canvasTech) {
      CanvasJ2ME canvasHost = new CanvasJ2ME(this, canvasTech);
      return canvasHost;
   }

   public ICanvasOwner createCanvasOwnerDefault() {
      return null;
   }

   public CoreDrawJ2MECtx getCoreDrawJ2MECtx() {
      return cdc;
   }

   public IExecutor getExecutor() {
      return executor;
   }

   public IHostGestures getHostGestures() {
      return j2meges;
   }

   public int getHostInt(int id) {
      // TODO Auto-generated method stub
      return 0;
   }

   public Thread getJ2MEUIThread() {
      return null;
   }

   public KeyMapAbstract getKeyMap() {
      return keyMap;
   }

   public int getModuleID() {
      return CTX_ID;
   }

   public void runGUI(Runnable run) {
      MIDlet midlet = cdc.getMidlet();
      Display display = Display.getDisplay(midlet);
      display.callSerially(run);
   }

   public IHostUI getHostUI() {
      // TODO Auto-generated method stub
      return null;
   }

}
