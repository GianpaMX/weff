package cmdf2011.weff.interfaz.activities;

import cmdf2011.weff.interfaz.activities.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GpsActivity extends Activity implements LocationListener{
	private double geo_latitud;
	private double geo_longitud;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		if (mlocManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
			mlocManager.requestLocationUpdates(
					LocationManager.NETWORK_PROVIDER, 100, 10, this);
		}

		
	}

	public double getGeo_latitud() {
		return geo_latitud;
	}

	public void setGeo_latitud(double geo_latitud) {
		this.geo_latitud = geo_latitud;
	}

	public double getGeo_longitud() {
		return geo_longitud;
	}

	public void setGeo_longitud(double geo_longitud) {
		this.geo_longitud = geo_longitud;
	}

	@Override
	public void onLocationChanged(Location location){
		// create a new intent...
				Intent intent = new Intent();
				intent.putExtra("latitud", new Double(location.getLatitude()).toString());
				intent.putExtra("longitud", new Double(location.getLongitude()).toString());

				setResult(RESULT_OK, intent);
				finish();
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}
}
