package cmdf2011.weff.interfaz.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CiudadanoRegistroActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ciudadano_registro);
	}
	
	public void botonCancelar(View v) {
		finish();
	}

	public void botonRegistro(View v) {
		showToastMessage("El registro no funciona");
	}

	private void showToastMessage(String msg) {
		Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
		toast.show();
	}
}
