package cmdf2011.weff.interfaz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EstadoFuga extends Activity {
	
	/** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.estado_fuga);
	      
	      Button b_regresar = (Button) findViewById(R.id.b_estado_fuga_1);
	      b_regresar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), MenuPrincipal.class);
				startActivity(i);
			}
		});
	   }

}
