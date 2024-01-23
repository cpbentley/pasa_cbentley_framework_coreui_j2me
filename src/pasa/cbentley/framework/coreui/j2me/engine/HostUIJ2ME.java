package pasa.cbentley.framework.coreui.j2me.engine;

import pasa.cbentley.framework.coreui.j2me.ctx.CoreUiJ2MECtx;
import pasa.cbentley.framework.coreui.src4.engine.HostUIAbstract;

public class HostUIJ2ME extends HostUIAbstract {

   public HostUIJ2ME(CoreUiJ2MECtx cuc) {
      super(cuc);
   }

   public boolean enableFeature(int featureID, boolean b) {
      // TODO Auto-generated method stub
      return false;
   }

   public boolean enableFeatureFactory(int featureID, boolean b) {
      // TODO Auto-generated method stub
      return false;
   }

   public float getHostFloat(int dataID) {
      // TODO Auto-generated method stub
      return 0;
   }

   public int getHostInt(int dataID) {
      // TODO Auto-generated method stub
      return 0;
   }

   public Object getHostObject(int dataID) {
      // TODO Auto-generated method stub
      return null;
   }

   public String getHostString(int dataID) {
      // TODO Auto-generated method stub
      return null;
   }

   public boolean hasFeatureSupport(int supportID) {
      // TODO Auto-generated method stub
      return false;
   }

   public boolean isFeatureEnabled(int featureID) {
      // TODO Auto-generated method stub
      return false;
   }

}
