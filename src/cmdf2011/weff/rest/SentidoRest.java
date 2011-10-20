package cmdf2011.weff.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cmdf2011.weff.beans.Sentido;

import android.util.Log;

public class SentidoRest extends GetJson {

	protected static final String TAG = "SentidoRest";
	
	/**
	 * 
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findSentidoAll(Integer limit){
		List list = new ArrayList();
        final String methodUrl = "Sentido/findSentidoAll?x-presto-resultFormat=json&limit="+limit+"&x-p-anonymous=true";
        
        //TODO replace with presto
        //String result = queryRESTurl(baseUrl + methodUrl);
        String result = "{\"records\":{\"record\":[{\"id_sentido\":\"1\",\"sentido\":\"Ambos\"},{\"id_sentido\":\"2\",\"sentido\":\"Nte-Sur\"},{\"id_sentido\":\"3\",\"sentido\":\"Sur-Nte\"},{\"id_sentido\":\"4\",\"sentido\":\"Pte-Ote\"},{\"id_sentido\":\"5\",\"sentido\":\"Ote-Pte\"}]}}";
        
        try{
        		JSONObject json = new JSONObject(result);
        		JSONArray jsonArray = json.getJSONObject("records").getJSONArray("record");
        		Log.i(TAG, result);
        		
        		for (int i = 0; i < jsonArray.length(); i++) {
        			JSONObject pJson = jsonArray.getJSONObject(i);
        			list.add(new Sentido(pJson.getString("sentido"), pJson.getString("id_sentido")));
        		}
        }
        catch (JSONException e) {
                Log.e("JSON", "There was an error parsing the JSON", e);
        }
        
		return list;
	}
	
}
