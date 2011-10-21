package cmdf2011.weff.interfaz.activities;

import java.util.List;

import cmdf2011.weff.beans.Prioridad;
import cmdf2011.weff.rest.PrioridadRest;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TicketFugaActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticket_fuga_agua);
		
		PrioridadRest prioridadRest = new PrioridadRest();
		
		
		Spinner s = (Spinner) findViewById(R.id.prioridadSpinner);
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		List<Prioridad> l = prioridadRest.findPrioridadAll(10);
		for (int i = 0; i < l.size(); i++) {
			adapter.add(l.get(i).toString());
		}
		s.setAdapter(adapter);
		
	}

	public void cancelar(View v) {
		finish();
	}
}
