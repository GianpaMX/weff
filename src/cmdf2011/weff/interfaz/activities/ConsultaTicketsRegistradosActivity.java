package cmdf2011.weff.interfaz.activities;

import java.util.List;

import cmdf2011.weff.exceptions.PrestoNoSirveException;
import cmdf2011.weff.rest.TicketRest;
import cmdf2011.weff.beans.Ticket;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ConsultaTicketsRegistradosActivity extends Activity implements Runnable {
	private ProgressDialog pd;
	private List<Ticket> tickets;
	ArrayAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.consulta_tickets_registrados);
		
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        pd = ProgressDialog.show(this, "Esperando..", "Esperando datos del servidor", true, false);
        
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void seleccionarTicket(View v) {
		Toast.makeText(v.getContext(), "blah", 10).show();
	}
	
	public void run() {
		try {
			tickets = TicketRest.findTiketsWhereIdCiudadanoEquals(1, 1000);
		} catch(PrestoNoSirveException e) {
			tickets = null;
			Toast.makeText(this, e.getMessage(), 10).show();
		}
		handler.sendEmptyMessage(0);
	}
	
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	ListView l = (ListView) findViewById(R.id.ticketsListView);
        	
        	if(tickets == null) return;
        	for (Object t : tickets) adapter.add(t);
			l.setAdapter(adapter);
			
			pd.dismiss();
        }
    };
}
