package cmdf2011.weff.interfaz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipal extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuprincipal);
	}

	public void reportarFuga(View v) {
		Intent i = new Intent(v.getContext(), TicketFugaActivity.class);
		startActivity(i);
	}
	
	public void consultarTicketsIngresados(View v) {
		Intent i = new Intent(v.getContext(), ConsultaTicketsRegistradosActivity.class);
		startActivity(i);
	}

}
