package cmdf2011.weff;

import com.sun.jersey.api.client.Client;

import android.app.Activity;
import android.os.Bundle;


public class CitizenRegisterActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citizen_register);
        
        Client c = Client.create();        
    }
}
