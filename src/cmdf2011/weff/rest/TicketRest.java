package cmdf2011.weff.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cmdf2011.weff.beans.Ticket;
import cmdf2011.weff.beans.Via;
import cmdf2011.weff.exceptions.PrestoNoSirveException;

import android.util.Log;

public class TicketRest extends GetJson {
	protected static List<Ticket> cache;

	protected static final String TAG = "TcketsRest";

	/**
	 * 
	 * 
	 * @return
	 * @throws PrestoNoSirveException
	 */
	public static List<Ticket> findTiketsWhereIdCiudadanoEquals(Integer idCiudadano, Integer limit) throws PrestoNoSirveException {
		List<Ticket> list = new ArrayList<Ticket>();
		final String methodUrl = "Tickets3/findTiketsWhereIdCiudadanoEquals?x-presto-resultFormat=json&limit="
				+ limit + "&idCiudadano=" + idCiudadano + "&x-p-anonymous=true";

		// TODO replace with presto
		String result = queryRESTurl(baseUrl + methodUrl);
		// String result =
		// "{\"records\":{\"record\":[{\"y_calle\":\"bvnbv\",\"asunto\":\"bache\",\"punto_referencia\":\"asdsa\",\"id_sentido\":\"1\",\"fecha_ingreso\":\"2011-10-20 17:43:15.773\",\"descripcion\":\"6666 seis again six\",\"id_prioridad\":\"1\",\"entre_calle\":\"gsdfsdf\",\"foto_inicial\":\"\",\"id_tramo\":\"1\",\"id_etapa\":\"1\",\"id_area\":\"1\",\"id_lugar\":\"1\",\"latitud\":\"666.0\",\"longitud\":\"666666.0\",\"id_motivo\":\"1\",\"id_tipo\":\"1\",\"id_via\":\"1\",\"id_ciudadano\":\"1\",\"id_ticket\":\"35\"},{\"y_calle\":\"bvnbv\",\"asunto\":\"bache\",\"punto_referencia\":\"asdsa\",\"id_sentido\":\"1\",\"fecha_ingreso\":\"2011-10-20 17:43:29.413\",\"descripcion\":\"6666 seis again six\",\"id_prioridad\":\"1\",\"entre_calle\":\"gsdfsdf\",\"foto_inicial\":\"\",\"id_tramo\":\"1\",\"id_etapa\":\"1\",\"id_area\":\"1\",\"id_lugar\":\"1\",\"latitud\":\"666.0\",\"longitud\":\"666666.0\",\"id_motivo\":\"1\",\"id_tipo\":\"1\",\"id_via\":\"1\",\"id_ciudadano\":\"1\",\"id_ticket\":\"36\"},{\"y_calle\":\"bvnbv\",\"asunto\":\"bache\",\"punto_referencia\":\"asdsa\",\"id_sentido\":\"1\",\"fecha_ingreso\":\"2011-10-20 17:43:34.917\",\"descripcion\":\"6666 seis again six\",\"id_prioridad\":\"1\",\"entre_calle\":\"gsdfsdf\",\"foto_inicial\":\"\",\"id_tramo\":\"1\",\"id_etapa\":\"1\",\"id_area\":\"1\",\"id_lugar\":\"1\",\"latitud\":\"666.0\",\"longitud\":\"666666.0\",\"id_motivo\":\"1\",\"id_tipo\":\"1\",\"id_via\":\"1\",\"id_ciudadano\":\"1\",\"id_ticket\":\"37\"},{\"y_calle\":\"bvnbv\",\"asunto\":\"bache\",\"punto_referencia\":\"asdsa\",\"id_sentido\":\"1\",\"fecha_ingreso\":\"2011-10-20 17:49:46.807\",\"descripcion\":\"\",\"id_prioridad\":\"1\",\"entre_calle\":\"gsdfsdf\",\"foto_inicial\":\"\",\"id_tramo\":\"1\",\"id_etapa\":\"1\",\"id_area\":\"1\",\"id_lugar\":\"1\",\"latitud\":\"0.0\",\"longitud\":\"0.0\",\"id_motivo\":\"1\",\"id_tipo\":\"1\",\"id_via\":\"1\",\"id_ciudadano\":\"1\",\"id_ticket\":\"38\"},{\"y_calle\":\"bvnbv\",\"asunto\":\"bache\",\"punto_referencia\":\"asdsa\",\"id_sentido\":\"1\",\"fecha_ingreso\":\"2011-10-20 17:49:46.977\",\"descripcion\":\"\",\"id_prioridad\":\"1\",\"entre_calle\":\"gsdfsdf\",\"foto_inicial\":\"\",\"id_tramo\":\"1\",\"id_etapa\":\"1\",\"id_area\":\"1\",\"id_lugar\":\"1\",\"latitud\":\"0.0\",\"longitud\":\"0.0\",\"id_motivo\":\"1\",\"id_tipo\":\"1\",\"id_via\":\"1\",\"id_ciudadano\":\"1\",\"id_ticket\":\"39\"},{\"y_calle\":\"bvnbv\",\"asunto\":\"bache\",\"punto_referencia\":\"asdsa\",\"id_sentido\":\"1\",\"fecha_ingreso\":\"2011-10-20 17:52:26.807\",\"descripcion\":\"6666 seis again six\",\"id_prioridad\":\"1\",\"entre_calle\":\"gsdfsdf\",\"foto_inicial\":\"\",\"id_tramo\":\"1\",\"id_etapa\":\"1\",\"id_area\":\"1\",\"id_lugar\":\"1\",\"latitud\":\"666.0\",\"longitud\":\"666666.0\",\"id_motivo\":\"1\",\"id_tipo\":\"1\",\"id_via\":\"1\",\"id_ciudadano\":\"1\",\"id_ticket\":\"40\"},{\"y_calle\":\"bvnbv\",\"asunto\":\"bache\",\"punto_referencia\":\"asdsa\",\"id_sentido\":\"1\",\"fecha_ingreso\":\"2011-10-20 20:26:08.46\",\"descripcion\":\"9999  99 9 99 9\",\"id_prioridad\":\"1\",\"entre_calle\":\"gsdfsdf\",\"foto_inicial\":\"\",\"id_tramo\":\"1\",\"id_etapa\":\"1\",\"id_area\":\"1\",\"id_lugar\":\"1\",\"latitud\":\"999.0\",\"longitud\":\"999.0\",\"id_motivo\":\"1\",\"id_tipo\":\"1\",\"id_via\":\"1\",\"id_ciudadano\":\"1\",\"id_ticket\":\"41\"},{\"y_calle\":\"bvnbv\",\"asunto\":\"bache\",\"punto_referencia\":\"asdsa\",\"id_sentido\":\"1\",\"fecha_ingreso\":\"2011-10-20 21:03:09.157\",\"descripcion\":\"10 - con foto\",\"id_prioridad\":\"1\",\"entre_calle\":\"gsdfsdf\",\"foto_inicial\":\"\",\"id_tramo\":\"1\",\"id_etapa\":\"1\",\"id_area\":\"1\",\"id_lugar\":\"1\",\"latitud\":\"10.0\",\"longitud\":\"10.0\",\"id_motivo\":\"1\",\"id_tipo\":\"1\",\"id_via\":\"1\",\"id_ciudadano\":\"1\",\"id_ticket\":\"46\"}]}}";

		try {
			JSONObject json = new JSONObject(result);
			JSONArray jsonArray = json.getJSONObject("records").getJSONArray(
					"record");
			Log.i(TAG, result);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject pJson = jsonArray.getJSONObject(i);
				Ticket ticket = new Ticket();
				ticket.setAsunto(pJson.getString("asunto"));
				ticket.setDescripcion(pJson.getString("descripcion"));
				ticket.setEntre_calle(pJson.getString("entre_calle"));
				ticket.setFecha_ingreso(pJson.getString("fecha_ingreso"));
				ticket.setId_area(pJson.getString("id_area"));
				ticket.setId_ciudadano(pJson.getString("id_ciudadano"));
				ticket.setId_etapa(pJson.getString("id_etapa"));
				ticket.setId_lugar(pJson.getString("id_lugar"));
				ticket.setId_motivo(pJson.getString("id_motivo"));
				ticket.setId_prioridad(pJson.getString("id_prioridad"));
				ticket.setId_sentido(pJson.getString("id_sentido"));
				ticket.setId_ticket(pJson.getString("id_ticket"));
				ticket.setId_tipo(pJson.getString("id_tipo"));
				ticket.setId_tramo(pJson.getString("id_tramo"));
				ticket.setId_via(pJson.getString("id_via"));
				ticket.setLatitud(pJson.getString("latitud"));
				ticket.setLongitud(pJson.getString("longitud"));
				ticket.setPunto_referencia(pJson.getString("punto_referencia"));
				ticket.setY_calle(pJson.getString("y_calle"));

				list.add(ticket);
			}
		} catch (JSONException e) {
			Log.e("JSON", "There was an error parsing the JSON", e);
			throw new PrestoNoSirveException("Error al obtener los datos");
		}

		return TicketRest.cache = list;
	}

	public static List cachedData() {
		return TicketRest.cache;
	}

}
