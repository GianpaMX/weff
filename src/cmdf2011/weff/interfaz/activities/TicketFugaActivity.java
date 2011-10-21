package cmdf2011.weff.interfaz.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Spinner;

public class TicketFugaActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticket_fuga_agua);
		
//		Spinner s = (Spinner) findViewById(R.id.prioridadSpinner);
		
	}

	public void cancelar(View v) {
		finish();
	}
}
