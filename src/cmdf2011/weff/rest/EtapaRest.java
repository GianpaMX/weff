package cmdf2011.weff.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cmdf2011.weff.beans.Etapa;

import android.util.Log;

public class EtapaRest extends GetJson {

	protected static final String TAG = "EtapaRest";
	
	/**
	 * 
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findEtapaAll(Integer limit){
		List list = new ArrayList();
        final String methodUrl = "Etapa/findEtapaAll?x-presto-resultFormat=json&limit="+limit+"&x-p-anonymous=true";
        
        //TODO replace with presto
        //String result = queryRESTurl(baseUrl + methodUrl);
        String result = "{\"records\":{\"record\":[{\"etapa\":\"Ingreso\",\"id_etapa\":\"1\"},{\"etapa\":\"Supervision\",\"id_etapa\":\"2\"},{\"etapa\":\"Operación\",\"id_etapa\":\"3\"},{\"etapa\":\"Finalizado\",\"id_etapa\":\"4\"}]}}";
        
        try{
        		JSONObject json = new JSONObject(result);
        		JSONArray jsonArray = json.getJSONObject("records").getJSONArray("record");
        		Log.i(TAG, result);
        		
        		for (int i = 0; i < jsonArray.length(); i++) {
        			JSONObject pJson = jsonArray.getJSONObject(i);
        			list.add(new Etapa(pJson.getString("etapa"), pJson.getString("id_etapa")));
        		}
        }
        catch (JSONException e) {
                Log.e("JSON", "There was an error parsing the JSON", e);
        }
        
		return list;
	}
	
}