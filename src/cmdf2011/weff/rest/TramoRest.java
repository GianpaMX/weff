package cmdf2011.weff.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cmdf2011.weff.beans.Tramo;

import android.util.Log;

public class TramoRest extends GetJson {

	protected static final String TAG = "TramoRest";
	
	/**
	 * 
	 * 
	 * @return
	 */
	public static List<Tramo> findTramosAll(Integer limit){
		List<Tramo> list = new ArrayList<Tramo>();
        final String methodUrl = "Tramos/findTramosAll?x-presto-resultFormat=json&limit="+limit+"&x-p-anonymous=true";
        
        //TODO replace with presto
        //String result = queryRESTurl(baseUrl + methodUrl);
        String result = "{\"records\":{\"record\":[{\"tramo\":\"Eje 3 Norte - Av. Cuitlahuac - Cosmopolita\",\"id_tramo\":\"1\"},{\"tramo\":\"Eje 2 Norte - Av. Canal del Norte - 20 de Noviembre\",\"id_tramo\":\"2\"}]}}";
        
        try{
        		JSONObject json = new JSONObject(result);
        		JSONArray jsonArray = json.getJSONObject("records").getJSONArray("record");
        		Log.i(TAG, result);
        		
        		for (int i = 0; i < jsonArray.length(); i++) {
        			JSONObject pJson = jsonArray.getJSONObject(i);
        			list.add(new Tramo(pJson.getString("tramo"), pJson.getString("id_tramo")));
        		}
        }
        catch (JSONException e) {
                Log.e("JSON", "There was an error parsing the JSON", e);
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
}
