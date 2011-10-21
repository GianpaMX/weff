package cmdf2011.weff.interfaz.activities;

import cmdf2011.weff.rest.TicketRest;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ConsultaTicketsRegistradosActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.consulta_tickets_registrados);
		
		
		ListView l = (ListView) findViewById(R.id.ticketsListView);
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, TicketRest.findTiketsWhereIdCiudadanoEquals(1, 10).toArray());
		l.setAdapter(adapter);
	}
	
	public void seleccionarTicket(View v) {
		Toast.makeText(v.getContext(), "blah", 10).show();
	}
}
