package cmdf2011.weff.interfaz.activities;

import cmdf2011.weff.FillCacheThread;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ComponentePrincipalActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio);
		
		FillCacheThread fillCacheThread = new FillCacheThread(getApplicationContext());
		fillCacheThread.start();

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
				
				EditText editText = (EditText) findViewById(R.id.etClave);
				boolean acceso = editText.getText().length()>0?true:false;
				
				AlertDialog alertDialog = new AlertDialog.Builder(ComponentePrincipalActivity.this).create();
    			alertDialog.setTitle("Advertencia");
    			alertDialog.setMessage("Usuario no válido");
    			alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
    	             public void onClick(DialogInterface dialog, int which) {
    	                     return;
    	             }
    	         });
    			
    			if(acceso == true){
    				Intent myIntent = new Intent(view.getContext(),
    						MenuPrincipal.class);
    				startActivityForResult(myIntent, 0);
                }
                else{
                	alertDialog.show();
                }	
			}
		}); // fin del setOnclickListener
	}
	
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		finish();
	}
	
}
