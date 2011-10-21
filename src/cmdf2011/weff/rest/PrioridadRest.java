package cmdf2011.weff.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cmdf2011.weff.beans.Prioridad;
import cmdf2011.weff.exceptions.PrestoNoSirveException;

import android.util.Log;

public class PrioridadRest extends GetJson {
	protected static List<Prioridad> cache;

	protected static final String TAG = "PrioridadRest";

	/**
	 * @example
	 * 
	 *          JSONArray nameArray = json.names(); JSONArray valArray =
	 *          json.toJSONArray(nameArray);
	 * 
	 * 
	 * @return
	 */
	public static List<Prioridad> findPrioridadAll(Integer limit) throws PrestoNoSirveException {
		List<Prioridad> list = new ArrayList<Prioridad>();
		final String methodUrl = "Prioridad/findPrioridadAll?x-presto-resultFormat=json&limit="
				+ limit + "&x-p-anonymous=true";

		String result = queryRESTurl(baseUrl + methodUrl);
	    if( null == result ){
	    	result = "{\"records\":{\"record\":[{\"prioridad\":\"Programado\",\"id_prioridad\":\"1\"},{\"prioridad\":\"Urgente\",\"id_prioridad\":\"2\"}]}}";
	    }

		try {
			JSONObject json = new JSONObject(result);
			JSONArray jsonArray = json.getJSONObject("records").getJSONArray(
					"record");
			Log.i(TAG, result);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject pJson = jsonArray.getJSONObject(i);
				list.add(new Prioridad(pJson.getString("prioridad"), pJson
						.getString("id_prioridad")));
			}
		} catch (JSONException e) {
			Log.e("JSON", "There was an error parsing the JSON", e);
			throw new PrestoNoSirveException("Error al obtener las Prioridades. " + e.getMessage());
		}

		return PrioridadRest.cache = list;
	}

	public static List<Prioridad> cachedData() {
		return PrioridadRest.cache;
	}

}
