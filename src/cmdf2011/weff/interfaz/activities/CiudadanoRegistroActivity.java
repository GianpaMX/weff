package cmdf2011.weff.interfaz.activities;

import cmdf2011.weff.R;
import cmdf2011.weff.R.id;
import cmdf2011.weff.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CiudadanoRegistroActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ciudadano_registro);
        
        Button b = (Button) findViewById(R.id.botonRegistro);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
    }
}
