package cmdf2011.weff.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cmdf2011.weff.beans.Ciudadano;
import cmdf2011.weff.beans.Prioridad;

import android.util.Log;

public class CiudadanoRest extends GetJson {

	protected static final String TAG = "CiudadanoRest";
	
	/**
	 * @example
	 * 
	 * 	JSONArray nameArray = json.names();
     *  JSONArray valArray = json.toJSONArray(nameArray);
     *  
	 * 
	 * @return
	 */
	public static List<Ciudadano> findCiudadanosAll(Integer limit){
		List<Ciudadano> list = new ArrayList<Ciudadano>();
        final String methodUrl = "Ciudadano/findCiudadanosAll?x-presto-resultFormat=json&limit="+limit+"&x-p-anonymous=true";
        
         
        
        String result = queryRESTurl(baseUrl + methodUrl);
        
        try{
        		JSONObject json = new JSONObject(result);
        		JSONArray jsonArray = json.getJSONObject("records").getJSONArray("record");
        		Log.i(TAG, result);
        		
        		for (int i = 0; i < jsonArray.length(); i++) {
        			JSONObject pJson = jsonArray.getJSONObject(i);
        			list.add(new Ciudadano(
        					pJson.getString("nombre"), 
        					pJson.getString("paterno"), 
        					pJson.getString("materno"), 
        					pJson.getString("sexo"), 
        					pJson.getString("telefono"), 
        					pJson.getString("celular"), 
        					pJson.getString("calle"), 
        					"",
        					"",
        					pJson.getString("colonia"), 
        					pJson.getString("cp"), 
        					pJson.getString("delegacion")
        					));
        		}
        }
        catch (JSONException e) {
                Log.e("JSON", "There was an error parsing the JSON", e);
        }
        
		return list;
	}
	
}
