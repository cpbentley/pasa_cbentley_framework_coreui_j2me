package pasa.cbentley.framework.core.ui.j2me.ctx;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.draw.j2me.ctx.CoreDrawJ2meCtx;
import pasa.cbentley.framework.core.ui.j2me.engine.CanvasJ2me;
import pasa.cbentley.framework.core.ui.j2me.engine.GesturesJ2me;
import pasa.cbentley.framework.core.ui.j2me.engine.KeyMapJ2me;
import pasa.cbentley.framework.core.ui.src4.ctx.CoreUiCtx;
import pasa.cbentley.framework.core.ui.src4.ctx.IConfigCoreUi;
import pasa.cbentley.framework.core.ui.src4.engine.CanvasHostAbstract;
import pasa.cbentley.framework.core.ui.src4.engine.KeyMapAbstract;
import pasa.cbentley.framework.core.ui.src4.interfaces.IHostGestures;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.src4.tech.IBOCanvasHost;
import pasa.cbentley.framework.core.ui.src4.wrapper.WrapperAbstract;

public class CoreUiJ2meCtx extends CoreUiCtx {

   public static final int         CTX_ID = 485;

   protected final CoreDrawJ2meCtx cdc;

   private GesturesJ2me            j2meges;

   private KeyMapJ2me              keyMap;

   /**
    * Core UI deals with file connections for drag and drop so we need a {@link CoreIO5Ctx}
    * @param cdc
    * @param sc
    * @param cio5c
    */
   public CoreUiJ2meCtx(CoreDrawJ2meCtx cdc, IConfigCoreUi configUI) {
      super(configUI, cdc);
      this.cdc = cdc;
      j2meges = new GesturesJ2me(this);
      keyMap = new KeyMapJ2me(uc);
   }

   protected void applySettings(ByteObject settingsNew, ByteObject settingsOld) {

   }

   /**
    * {@link IBOCanvasHost}
    */
   public CanvasHostAbstract createCanvasHost(WrapperAbstract wrapper, ByteObject canvasTech) {
      CanvasJ2me canvasHost = new CanvasJ2me(this, canvasTech);
      return canvasHost;
   }

   public IWrapperManager createCanvasOwnerDefault() {
      return null;
   }

   public CoreDrawJ2meCtx getCoreDrawJ2MECtx() {
      return cdc;
   }

   public IHostGestures getHostGestures() {
      return j2meges;
   }

   public KeyMapAbstract getKeyMap() {
      return keyMap;
   }

   public int getModuleID() {
      return CTX_ID;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, CoreUiJ2meCtx.class, 84);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, CoreUiJ2meCtx.class, 84);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
