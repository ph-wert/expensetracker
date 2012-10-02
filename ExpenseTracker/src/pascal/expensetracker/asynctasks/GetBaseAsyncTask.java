package pascal.expensetracker.asynctasks;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pascal.expensetracker.connection.JSONParser;
import android.os.AsyncTask;

public abstract class GetBaseAsyncTask<T> extends AsyncTask<String, Void, ArrayList<T>> {
	
	public interface OnRequestFinishedListener<T> {
		public void onFinished(ArrayList<T> result);
	}
	
	private OnRequestFinishedListener<T> listener;

	public GetBaseAsyncTask(OnRequestFinishedListener<T> listener) {
		this.listener = listener;
	}
	
	protected abstract String getRequestURLSuffix();
	
	protected abstract String getCollectionTag();
	
	protected abstract T createObject(JSONObject json) throws JSONException;

	@Override
	protected ArrayList<T> doInBackground(String... urls) {
		if (urls.length != 1) {
			throw new IllegalStateException("Only one URL allowed...");
		}
		String url = urls[0];

		ArrayList<T> result = new ArrayList<T>();
		url = url + getRequestURLSuffix();

		// Creating JSON Parser instance
		JSONParser jParser = new JSONParser();

		// getting JSON string from URL
		JSONObject json = jParser.getJSONFromUrl(url);
		try {
			// Getting Array of JoinedExpenses
			
			JSONArray JSONArray = json.getJSONArray(getCollectionTag());

			System.out.println("Länge JoinedShops: " + JSONArray.length());
			// looping through All Contacts
			for (int i = 0; i < JSONArray.length(); i++) {
				JSONObject os = JSONArray.getJSONObject(i);
				result.add(createObject(os));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	protected void onPostExecute(ArrayList<T> result) {
		this.listener.onFinished(result);
	}

}
