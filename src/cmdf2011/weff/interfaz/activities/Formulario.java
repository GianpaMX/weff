package cmdf2011.weff.interfaz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.*;


public class Formulario extends Activity  implements View.OnClickListener { 
	
	
	private final int SECONDARY_ACTIVITY_REQUEST_CODE=0;
	private Button boton;
	private TextView tv;
	private Button bEnviar;
	//private TextView tv2;

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.formulario);
	        
	        tv = (TextView)findViewById(R.id.tv_la_valor);
	        tv.setText("Sin valor incial");
	       
	        boton = (Button)findViewById(R.id.boton);
	        boton.setOnClickListener(this);
	        
	        bEnviar = (Button)findViewById(R.id.bEnviar);
	        bEnviar.setOnClickListener(this);
	        
	    }

	@Override
	
	    public void onClick(View view){
	    	if(view == boton){
	            Intent intent = new Intent(getApplicationContext(),Camara2Activity.class);
	            //carga el intent y agrega el valor
	            intent.putExtra("unValor","elValor");
	            //Carga la actividad secundaria
	            startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
	        }else
	        	if(view == bEnviar){
	        		Intent ie = new Intent(getApplicationContext(), MenuPrincipal.class);
	        		startActivity(ie);
	        	}
	    
	}
	

	 @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
	        super.onActivityResult(requestCode, resultCode, intent);
	        Bundle extras = intent.getExtras();
	        tv.setText(extras != null ? extras.getString("latitud"):"regresado Nada");
	      //  tv2.setText(extras != null ? extras.getString("longitud"):"regresado Nada");
	    }

	

}
