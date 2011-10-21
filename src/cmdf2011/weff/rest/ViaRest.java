package cmdf2011.weff.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cmdf2011.weff.beans.Via;

import android.util.Log;

public class ViaRest extends GetJson {

	protected static final String TAG = "ViaRest";
	
	/**
	 * 
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findViaCaptacionAll(Integer limit){
		List list = new ArrayList();
        final String methodUrl = "ViaCaptacion/findViaCaptacionAll?x-presto-resultFormat=json&limit="+limit+"&x-p-anonymous=true";
        
        //TODO replace with presto
        //String result = queryRESTurl(baseUrl + methodUrl);
        String result = "{\"records\":{\"record\":[{\"id_via\":\"1\",\"via_captacion\":\"Call center\"},{\"id_via\":\"2\",\"via_captacion\":\"Correo electronico\"},{\"id_via\":\"3\",\"via_captacion\":\"En persona\"},{\"id_via\":\"4\",\"via_captacion\":\"Escrito\"},{\"id_via\":\"5\",\"via_captacion\":\"Prensa\"},{\"id_via\":\"6\",\"via_captacion\":\"Pagina Web\"},{\"id_via\":\"7\",\"via_captacion\":\"Radio\"},{\"id_via\":\"8\",\"via_captacion\":\"Redes Sociales\"},{\"id_via\":\"9\",\"via_captacion\":\"TV\"}]}}";
        
        try{
        		JSONObject json = new JSONObject(result);
        		JSONArray jsonArray = json.getJSONObject("records").getJSONArray("record");
        		Log.i(TAG, result);
        		
        		for (int i = 0; i < jsonArray.length(); i++) {
        			JSONObject pJson = jsonArray.getJSONObject(i);
        			list.add(new Via(pJson.getString("via_captacion"), pJson.getString("id_via")));
        		}
        }
        catch (JSONException e) {
                Log.e("JSON", "There was an error parsing the JSON", e);
        }
        
		return list;
	}
	
}
