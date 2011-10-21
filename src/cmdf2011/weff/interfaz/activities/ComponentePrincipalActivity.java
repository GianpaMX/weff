package cmdf2011.weff.interfaz.activities;

import cmdf2011.weff.exceptions.PrestoNoSirveException;
import cmdf2011.weff.rest.LugarFisicoRest;
import cmdf2011.weff.rest.PrioridadRest;
import cmdf2011.weff.rest.SentidoRest;
import cmdf2011.weff.rest.TramoRest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ComponentePrincipalActivity extends Activity implements Runnable {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio);
		
		Thread thread = new Thread(this);
		thread.start();
		
		TextView registrarse = (TextView) findViewById(R.id.tv_registro);
		SpannableString content = new SpannableString(registrarse.getText());
		content.setSpan(new UnderlineSpan(),0,content.length(),0);
		registrarse.setText(content);
		registrarse.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(),
						MenuPrincipal.class);
				startActivityForResult(myIntent, 0);
			}
		});

		Button boton = (Button) findViewById(R.id.boton);
		boton.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(),
						MenuPrincipal.class);
				startActivityForResult(myIntent, 0);
			}
		}); // fin del setOnclickListener
	}
	
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		finish();
	}



	@Override
	public void run() {
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
	}
	
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	if(msg.obj != null) {
        		Exception e = (Exception) msg.obj;
        		Toast.makeText(getApplicationContext(), e.getMessage(), 15).show();
        	}
        }
    };
}
