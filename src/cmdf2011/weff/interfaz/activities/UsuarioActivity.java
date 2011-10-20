package cmdf2011.weff.interfaz.activities;

import cmdf2011.weff.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class UsuarioActivity extends Activity{

	TextView tvTitulo;
	EditText etIdCiudadano, etPassCiudadano;
	Button bEntrar, bUsuarioNoRegistrado;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.usuario);
	}
	
	

}
