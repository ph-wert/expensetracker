package pascal.expensetracker.asynctasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import pascal.expensetracker.CustomApplication;
import pascal.expensetracker.gui.tabs.Tab1Fragment;
import pascal.expensetracker.objects.Expense;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class HttpPostAsyncTask extends AsyncTask<String, Void, String> {

	public Expense test = new Expense();
	public String ausgaben;

	protected String doInBackground(String... urls) {
		for (String url : urls) {
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url + "rest/addExpense");
			try {
				// IF currency is not CHF than calculate specific exchange rate for date and foreign currency
				if (test.getCurrency() != "CHF") {
					URL currency;
					currency = new URL("http://currencies.apps.grandtrunk.net/getrate/" 
							+test.getExpensedate() 
							+"/CHF/" 
							+test.getCurrency());
					BufferedReader in = new BufferedReader(new InputStreamReader(currency.openStream()));
					String inputLine;
					double exchangerate;
					double expense;
					double calculatedexpense;
					while ((inputLine = in.readLine()) != null) {
						exchangerate = Double.valueOf(inputLine).doubleValue();
						expense = Double.valueOf(ausgaben).doubleValue();
						calculatedexpense = expense/exchangerate;
						System.out.println("Wechselkurs: " +inputLine);
						test.setExpense(String.valueOf(calculatedexpense).toString());
					}
					in.close();
				}

				// Add your data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("expense_date", test.getExpensedate()));
				nameValuePairs.add(new BasicNameValuePair("expense_cost", test.getExpense()));
				nameValuePairs.add(new BasicNameValuePair("shop_id", test.getShop()));
				nameValuePairs.add(new BasicNameValuePair("person_id", test.getPerson()));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				System.out.println("DoInBack: " +test.getExpensedate() +" - " +test.getExpense() +" - " +test.getPerson() +" - " +test.getShop());  

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
	protected void onPreExecute() {
		// get expense Object and use & manipulate it in this activity
		test = Tab1Fragment.getExpense();
		ausgaben = test.getExpense();
		System.out.println("PRE: " +test.getExpensedate() +" - " +test.getExpense() +" - " +test.getPerson() +" - " +test.getShop());  
		
	}
	protected void onProgressUpdate(Integer... values) 
	{
		ProgressDialog dialog = ProgressDialog.show(CustomApplication.getCustomAppContext(), "", "Loading. Please wait...", true);

	}
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		test.setExpense(null);
		super.onPostExecute(result);

	}
	
	public String getLocalExpense() {
		return test.getExpense();
	}
}
