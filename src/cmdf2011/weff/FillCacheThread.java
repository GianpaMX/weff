package cmdf2011.weff;
import cmdf2011.weff.exceptions.PrestoNoSirveException;
import cmdf2011.weff.rest.LugarFisicoRest;
import cmdf2011.weff.rest.PrioridadRest;
import cmdf2011.weff.rest.SentidoRest;
import cmdf2011.weff.rest.TramoRest;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;


public class FillCacheThread extends Thread {
	private static Boolean finished = false;
	
	private Context c;
	public FillCacheThread(Context context) {
		c = context;
	}
	
	public static Boolean hasFinished() {
		return FillCacheThread.finished;
	}
	
	@Override
	public void run() {
		FillCacheThread.finished = false;
		try {
			PrioridadRest.findPrioridadAll(100);
		} catch (PrestoNoSirveException e) {
			handler.sendMessage(handler.obtainMessage(0, e));
		}
		try {
			LugarFisicoRest.findLugarFisicoAll(100);
		} catch (PrestoNoSirveException e) {
			handler.sendMessage(handler.obtainMessage(0, e));
		}
		try {
			SentidoRest.findSentidoAll(100);
		} catch (PrestoNoSirveException e) {
			handler.sendMessage(handler.obtainMessage(0, e));
		}
		try {
			TramoRest.findTramosAll(100);
		} catch (PrestoNoSirveException e) {
			handler.sendMessage(handler.obtainMessage(0, e));
		}
		
		FillCacheThread.finished = true;
	}
	
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	if(msg.obj != null) {
        		Exception e = (Exception) msg.obj;
        		Toast.makeText(c, e.getMessage(), 15).show();
        	}
        }
    };
}
