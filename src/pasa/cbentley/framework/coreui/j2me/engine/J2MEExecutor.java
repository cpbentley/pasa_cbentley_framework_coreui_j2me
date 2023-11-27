package pasa.cbentley.framework.coreui.j2me.engine;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import pasa.cbentley.framework.coreui.j2me.ctx.CoreUiJ2MECtx;
import pasa.cbentley.framework.coreui.src4.engine.AbstractExecutor;

public class J2MEExecutor extends AbstractExecutor {

   protected final CoreUiJ2MECtx cumc;

   public J2MEExecutor(CoreUiJ2MECtx cuc) {
      super(cuc);
      cumc = cuc;
   }

   public void executeWorker(Runnable run) {
      throw new RuntimeException();
   }

   public void executeMainNow(Runnable run) {
      //we don't have this.. check if current thread
      if(Thread.currentThread() == cumc.getJ2MEUIThread()) {
         
      }
      throw new RuntimeException();
   }

   public void executeMainLater(Runnable run) {
      MIDlet midlet = cumc.getCoreDrawJ2MECtx().getMidlet();
      Display display = Display.getDisplay(midlet);
      display.callSerially(run);
   }

}
