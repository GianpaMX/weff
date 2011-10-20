package cmdf2011.weff.interfaz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {
	
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.splash);
	      
	      Thread splashThread = new Thread() {
	          @Override
	          public void run() {
	             try {
	                int waited = 0;
	                while (waited < 500) {
	                   sleep(100);
	                   waited += 100;
	                }
	             } catch (InterruptedException e) {
	                // do nothing
	             } finally {
	                finish();
	                Intent i = new Intent();
	                i.setClassName("cmdf2011.weff.interfaz.activities","cmdf2011.weff.interfaz.activities.ComponentePrincipalActivity");
	                startActivity(i);
	             }
	          }
	       };
	       splashThread.start();
	   }
}
