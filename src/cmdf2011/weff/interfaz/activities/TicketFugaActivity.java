package cmdf2011.weff.interfaz.activities;

import cmdf2011.weff.exceptions.PrestoNoSirveException;
import cmdf2011.weff.rest.LugarFisicoRest;
import cmdf2011.weff.rest.PrioridadRest;
import cmdf2011.weff.rest.SentidoRest;
import cmdf2011.weff.rest.TramoRest;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class TicketFugaActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticket_fuga_agua);
		
		Spinner s;
		ArrayAdapter adapter;
		
		try {
			s = (Spinner) findViewById(R.id.prioridadSpinner);
			adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, (PrioridadRest.cachedData() == null ? PrioridadRest.findPrioridadAll(10) : PrioridadRest.cachedData()).toArray());
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			s.setAdapter(adapter);
	
			s = (Spinner) findViewById(R.id.lugarFisicoSppiner);
			adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, (LugarFisicoRest.cachedData() == null ? LugarFisicoRest.findLugarFisicoAll(10) : LugarFisicoRest.cachedData()).toArray());
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			s.setAdapter(adapter);
	
			s = (Spinner) findViewById(R.id.sentidoSpinner);
			adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, (SentidoRest.cachedData() == null ? SentidoRest.findSentidoAll(10) : SentidoRest.cachedData()).toArray());
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			s.setAdapter(adapter);
	
			AutoCompleteTextView a = (AutoCompleteTextView) findViewById(R.id.tramoAutoComplete);
			adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, (TramoRest.cachedData() == null ? TramoRest.findTramosAll(10) : TramoRest.cachedData()).toArray());
			a.setAdapter(adapter);
		} catch (PrestoNoSirveException e) {
			Toast.makeText(this, e.getMessage(), 15);
			finish();
		}
		
	}

	public void cancelar(View v) {
		finish();
	}
	
	public void enviarTicket(View v){
		finish();
		
		StringBuffer text = new StringBuffer("Se ha dado de alta la fuga de agua, con los siguientes datos: ");
		int duration = Toast.LENGTH_LONG;

		Spinner s = (Spinner) findViewById(R.id.prioridadSpinner);
		text.append("Prioridad: " + s.getSelectedItem().toString() + ", ");
		
		s = (Spinner) findViewById(R.id.lugarFisicoSppiner);
		text.append("Lugar: " + s.getSelectedItem().toString() + ", ");
		
		s = (Spinner) findViewById(R.id.sentidoSpinner);
		text.append("Sentido: " + s.getSelectedItem().toString() + ", ");

		AutoCompleteTextView a = (AutoCompleteTextView) findViewById(R.id.tramoAutoComplete);
		text.append("Tramo: " + a.getText().toString() + ".");
		
		Toast toast = Toast.makeText(v.getContext(), text, duration);
		toast.show();
	}
	
}
