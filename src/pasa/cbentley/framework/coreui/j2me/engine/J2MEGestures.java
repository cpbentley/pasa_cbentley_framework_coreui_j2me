package pasa.cbentley.framework.coreui.j2me.engine;

import pasa.cbentley.framework.coreui.j2me.ctx.CoreUiJ2MECtx;
import pasa.cbentley.framework.coreui.src4.engine.AbstractGestures;
import pasa.cbentley.framework.coreui.src4.interfaces.IHostGestures;

public class J2MEGestures extends AbstractGestures implements IHostGestures {

   public J2MEGestures(CoreUiJ2MECtx jcac) {
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
