package pasa.cbentley.framework.core.ui.j2me.engine;

import pasa.cbentley.framework.core.ui.j2me.ctx.CoreUiJ2meCtx;
import pasa.cbentley.framework.core.ui.src4.engine.GesturesAbstract;
import pasa.cbentley.framework.core.ui.src4.interfaces.IHostGestures;

public class GesturesJ2me extends GesturesAbstract implements IHostGestures {

   public GesturesJ2me(CoreUiJ2meCtx jcac) {
      super(jcac);
   }

   public void enableGesture(int flag) {
   }

   public void disableGesture(int flag) {
   }

   public boolean isGestureSupported(int flag) {
      return false;
   }

}
