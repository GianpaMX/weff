package cmdf2011.weff.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cmdf2011.weff.beans.Prioridad;
import cmdf2011.weff.beans.Tramo;
import cmdf2011.weff.exceptions.PrestoNoSirveException;

import android.util.Log;

public class TramoRest extends GetJson {
	protected static List<Tramo> cache;

	protected static final String TAG = "TramoRest";
	
	/**
	 * 
	 * 
	 * @return
	 * @throws PrestoNoSirveException 
	 */
	public static List<Tramo> findTramosAll(Integer limit) throws PrestoNoSirveException{
		List<Tramo> list = new ArrayList<Tramo>();
        final String methodUrl = "Tramos/findTramosAll?x-presto-resultFormat=json&limit="+limit+"&x-p-anonymous=true";
        
        String result;
        if( Enviroment == "dev" ){
        	result = "{\"records\":{\"record\":[{\"tramo\":\"Eje 3 Norte - Av. Cuitlahuac - Cosmopolita\",\"id_tramo\":\"1\"},{\"tramo\":\"Eje 2 Norte - Av. Canal del Norte - 20 de Noviembre\",\"id_tramo\":\"2\"}]}}";
        }else{
        	result = queryRESTurl(baseUrl + methodUrl);
        }
        
        try{
        		JSONObject json = new JSONObject(result);
        		JSONArray jsonArray = json.getJSONObject("records").getJSONArray("record");
        		Log.i(TAG, result);
        		
        		for (int i = 0; i < jsonArray.length(); i++) {
        			JSONObject pJson = jsonArray.getJSONObject(i);
        			list.add(new Tramo(pJson.getString("tramo"), pJson.getString("id_tramo")));
        		}
        } catch (JSONException e) {
			Log.e("JSON", "There was an error parsing the JSON", e);
			throw new PrestoNoSirveException("Error al obtener los tramos. " + e.getMessage());
		}
        
		return list;
	}
	
	public Boolean insertTramos(String tramo, String idTramo){
		try{
			final String methodUrl = "Tramos/insertTramos?x-presto-resultFormat=json&idTramo="+idTramo+"&tramo="+tramo;
			queryRESTurl(methodUrl);
		}catch (Exception e) {
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}

	public static List cachedData() {
		return TramoRest.cache;
	}
}
