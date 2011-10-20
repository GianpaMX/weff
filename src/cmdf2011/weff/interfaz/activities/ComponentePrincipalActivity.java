package cmdf2011.weff.interfaz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ComponentePrincipalActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio);
		
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
}
