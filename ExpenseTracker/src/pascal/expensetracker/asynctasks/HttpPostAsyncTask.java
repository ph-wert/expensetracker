package pascal.expensetracker.asynctasks;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

public class HttpPostAsyncTask extends AsyncTask<String, Void, String> {


	protected String doInBackground(String... urls) {

		for (String url : urls) {
			    // Create a new HttpClient and Post Header
			    HttpClient httpclient = new DefaultHttpClient();
			    HttpPost httppost = new HttpPost(url + "rest/addExpense");
			    try {
			        // Add your data
			        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			        nameValuePairs.add(new BasicNameValuePair("expense_date", "2099-12-30"));
			        nameValuePairs.add(new BasicNameValuePair("expense_cost", "99.99"));
			        nameValuePairs.add(new BasicNameValuePair("shop_id", "10"));
			        nameValuePairs.add(new BasicNameValuePair("person_id", "2"));
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			       
			        // Execute HTTP Post Request
			        HttpResponse response = httpclient.execute(httppost);
			        int responseCode = response.getStatusLine().getStatusCode();

			        System.out.println("HTTP Response: " +responseCode);
			    } catch (ClientProtocolException e) {
			        // TODO Auto-generated catch block
			    } catch (IOException e) {
			        // TODO Auto-generated catch block
			    }
		}
		String url = "url";
		return url;
	} 
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}
}
