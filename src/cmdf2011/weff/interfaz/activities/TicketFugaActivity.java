package cmdf2011.weff.interfaz.activities;

import cmdf2011.weff.FillCacheThread;
import cmdf2011.weff.beans.LugarFisico;
import cmdf2011.weff.beans.Prioridad;
import cmdf2011.weff.beans.Sentido;
import cmdf2011.weff.beans.Ticket;
import cmdf2011.weff.beans.Tramo;
import cmdf2011.weff.rest.LugarFisicoRest;
import cmdf2011.weff.rest.PrioridadRest;
import cmdf2011.weff.rest.SentidoRest;
import cmdf2011.weff.rest.TicketRest;
import cmdf2011.weff.rest.TramoRest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TicketFugaActivity extends Activity implements Runnable {
	private ProgressDialog pd;
	protected Spinner s;
	protected ArrayAdapter adapter;
	
	private EditText et;
	private EditText et2;
	
	private Ticket ticket;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticket_fuga_agua);
		ticket = new Ticket();
		
		
		s = (Spinner) findViewById(R.id.prioridadSpinner);
		s.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				Prioridad p = (Prioridad) parent.getItemAtPosition(pos);
				ticket.setId_prioridad(p.getId_prioridad());
			}
			@Override public void onNothingSelected(AdapterView<?> arg0) {}
		});
		
		s = (Spinner) findViewById(R.id.lugarFisicoSppiner);
		s.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				LugarFisico p = (LugarFisico) parent.getItemAtPosition(pos);
				ticket.setId_lugar(p.getIdLugar());
			}
			@Override public void onNothingSelected(AdapterView<?> arg0) {}
		});
		
		s = (Spinner) findViewById(R.id.sentidoSpinner);
		s.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				Sentido p = (Sentido) parent.getItemAtPosition(pos);
				ticket.setId_sentido(p.getIdSentido());
			}
			@Override public void onNothingSelected(AdapterView<?> arg0) {}
		});
		
		AutoCompleteTextView a = (AutoCompleteTextView) findViewById(R.id.tramoAutoComplete);
		a.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				Tramo p = (Tramo) parent.getItemAtPosition(pos);
				ticket.setId_tramo(p.getIdTramo());
			}
			@Override public void onNothingSelected(AdapterView<?> arg0) {}
		});
		
		
        pd = ProgressDialog.show(this, "Esperando..", "Esperando datos del servidor", true, false);
        
        et = (EditText)findViewById(R.id.et_latitud);
        et.setText("0.0");
        et2 = (EditText)findViewById(R.id.et_longitud);
        et2.setText("0.0");
        
        Intent intent = new Intent(getApplicationContext(),GpsActivity.class);
        startActivityForResult(intent,0);
        
        
	}

	public void cancelar(View v) {
		finish();
	}
	
	public void enviarTicket(View v){		
		EditText t;
		t = (EditText) findViewById(R.id.asuntoText);
		ticket.setAsunto(t.getText().toString());

		t = (EditText) findViewById(R.id.descripcionText);
		ticket.setDescripcion(t.getText().toString());

		t = (EditText) findViewById(R.id.entreCalleText);
		ticket.setEntre_calle(t.getText().toString());

		t = (EditText) findViewById(R.id.yCalleText);
		ticket.setY_calle(t.getText().toString());

		t = (EditText) findViewById(R.id.puntoReferenciaText);
		ticket.setPunto_referencia(t.getText().toString());

        pd = ProgressDialog.show(this, "Enviando..", "Enviando datos del servidor", true, false);
		Thread enviarTicketThread = new Thread() {
			@Override
			public void run() {
				try {
					if(TicketRest.insertTikets(ticket))
						handler2.sendEmptyMessage(0);
					else
						throw new Exception("Error al enviar los datos al servidor");
				} catch (Exception e) {
					handler2.sendMessage(handler2.obtainMessage(0, e));
				}
			}
		};
		enviarTicketThread.start();
		
		return;
	}
	
	public void run() {
		int waited = 0;
		try {
			while (waited < 500) {
				Thread.sleep(1000);
				waited += 100;
				if(FillCacheThread.hasFinished()) {
					handler.sendEmptyMessage(0);
					return;
				}
			}
			throw new Exception("Tiempo de espera agotado");
		} catch (Exception e) {
			handler.sendMessage(handler.obtainMessage(0, e));
			return;
		}
	}
	
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	if(msg.obj != null) {
        		Exception e = (Exception) msg.obj;
        		Toast.makeText(getApplicationContext(), e.getMessage(), 15).show();
        		finish();
        		return;
        	}
			s = (Spinner) findViewById(R.id.prioridadSpinner);
			adapter = new ArrayAdapter<Prioridad>(getApplicationContext(), android.R.layout.simple_spinner_item, PrioridadRest.cachedData());
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			s.setAdapter(adapter);
			if(PrioridadRest.cachedData().size()>0) ticket.setId_prioridad(PrioridadRest.cachedData().get(0).getId_prioridad());
	
			s = (Spinner) findViewById(R.id.lugarFisicoSppiner);
			adapter = new ArrayAdapter<LugarFisico>(getApplicationContext(), android.R.layout.simple_spinner_item, LugarFisicoRest.cachedData());
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			s.setAdapter(adapter);
			if(LugarFisicoRest.cachedData().size()>0) ticket.setId_lugar(LugarFisicoRest.cachedData().get(0).getIdLugar());
	
			s = (Spinner) findViewById(R.id.sentidoSpinner);
			adapter = new ArrayAdapter<Sentido>(getApplicationContext(), android.R.layout.simple_spinner_item, SentidoRest.cachedData());
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			s.setAdapter(adapter);
			if(SentidoRest.cachedData().size()>0) ticket.setId_sentido(SentidoRest.cachedData().get(0).getIdSentido());
	
			AutoCompleteTextView a = (AutoCompleteTextView) findViewById(R.id.tramoAutoComplete);
			adapter = new ArrayAdapter<Tramo>(getApplicationContext(), android.R.layout.simple_spinner_item, TramoRest.cachedData());
			a.setAdapter(adapter);

			pd.dismiss();
        }
    };
    
    private Handler handler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	pd.dismiss();
        	
        	if(msg.obj != null) {
        		Exception e = (Exception) msg.obj;
        		
				AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext()).create();
    			alertDialog.setTitle("Error");
    			alertDialog.setMessage(e.getMessage());
    			alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
    				public void onClick(DialogInterface dialog, int which) {
    	            	 return;
    	            }
    	         });
        		return;
        	}
			Intent ie = new Intent(getApplicationContext(), Formulario.class);
			startActivity(ie);
        }
    };
	
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        Bundle extras = intent.getExtras();
        et.setText(extras != null ? extras.getString("latitud"):"regresado Nada");
        et2.setText(extras != null ? extras.getString("longitud"):"regresado Nada");
        
        Thread thread = new Thread(this);
		thread.start();
    }
}
