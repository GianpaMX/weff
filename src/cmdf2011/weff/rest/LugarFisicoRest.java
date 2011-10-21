package cmdf2011.weff.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cmdf2011.weff.beans.LugarFisico;

import android.util.Log;

public class LugarFisicoRest extends GetJson {

	protected static final String TAG = "LugarFisicoRest";
	
	/**
	 * 
	 * 
	 * @return
	 */
	public static List<LugarFisico> findLugarFisicoAll(Integer limit){
		List<LugarFisico> list = new ArrayList<LugarFisico>();
        final String methodUrl = "LugarFisico/findLugarFisicoAll?x-presto-resultFormat=json&limit="+limit+"&x-p-anonymous=true";
        
        //TODO replace with presto
        //String result = queryRESTurl(baseUrl + methodUrl);
        String result = "{\"records\":{\"record\":[{\"id_lugar\":\"1\",\"lugar_fisico\":\"Arroyo Central\"},{\"id_lugar\":\"2\",\"lugar_fisico\":\"Arroyo Lateral\"},{\"id_lugar\":\"3\",\"lugar_fisico\":\"Banqueta\"},{\"id_lugar\":\"4\",\"lugar_fisico\":\"Camellon Central\"},{\"id_lugar\":\"5\",\"lugar_fisico\":\"Camellon Lateral\"},{\"id_lugar\":\"6\",\"lugar_fisico\":\"Puente Vehicular\"},{\"id_lugar\":\"7\",\"lugar_fisico\":\"Puente Peatonal\"},{\"id_lugar\":\"8\",\"lugar_fisico\":\"Bajo Puente\"}]}}";
        
        try{
        		JSONObject json = new JSONObject(result);
        		JSONArray jsonArray = json.getJSONObject("records").getJSONArray("record");
        		Log.i(TAG, result);
        		
        		for (int i = 0; i < jsonArray.length(); i++) {
        			JSONObject pJson = jsonArray.getJSONObject(i);
        			list.add(new LugarFisico(pJson.getString("lugar_fisico"), pJson.getString("id_lugar")));
        		}
        }
        catch (JSONException e) {
                Log.e("JSON", "There was an error parsing the JSON", e);
        }
        
		return list;
	}
	
}
