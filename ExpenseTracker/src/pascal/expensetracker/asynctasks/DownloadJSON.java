package pascal.expensetracker.asynctasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pascal.expensetracker.CustomApplication;
import pascal.expensetracker.connection.JSONParser;
import pascal.expensetracker.objects.JoinedExpenses;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListAdapter;
public class DownloadJSON extends AsyncTask<String, Void, Void> {
     
	
	public static final String TAG_EXPENSES 		= "expenses";	
	private static final String TAG_EXPENSE 		= "expense";
	private static final String TAG_EXPENSEID 		= "EXPENSEID";
	private static final String TAG_EXPENSEDATE 	= "EXPENSEDATE";
	private static final String TAG_EXPENSECOST 	= "EXPENSECOST";
	private static final String TAG_SHOPNAME 		= "SHOPNAME";
	private static final String TAG_COUNTRYNAME 	= "COUNTRYNAME";
	private static final String TAG_COUNTRYSHORT 	= "COUNTRYSHORT";
	private static final String TAG_PERSONNAME 		= "PERSONNAME";	
	
	JSONArray JSONArrayExpenses = null;
	
	Dialog progress = null;
	
	protected Void doInBackground(String... urls) {
		for (String url : urls) {
			// Hashmap for ListView
			url = url + "rest/joinedexpenses";
	        ArrayList<HashMap<String, String>> joinedExpenseList = new ArrayList<HashMap<String, String>>();

			// Creating JSON Parser instance
	    	  JSONParser jParser = new JSONParser();
	    	   
	    	  // getting JSON string from URL
	    	  JSONObject json = jParser.getJSONFromUrl(url);
	    	  try {
	    		  // Getting Array of JoinedExpenses
	    		  JSONArrayExpenses = json.getJSONArray(TAG_EXPENSES);
	    		 
	    		  System.out.println("Länge JoinedExpenses: " +JSONArrayExpenses.length());
	    		    // looping through All Contacts
	    		    for(int i = 0; i < JSONArrayExpenses.length(); i++){
	    		        JSONObject es = JSONArrayExpenses.getJSONObject(i);
	    		        JSONObject e = es.getJSONObject(TAG_EXPENSE);
	    		        JoinedExpenses je = new JoinedExpenses();
	    		        
	    		        je.setEXPENSEID(e.getString(TAG_EXPENSEID));
	    		        je.setEXPENSEDATE(e.getString(TAG_EXPENSEDATE));
	    		        je.setEXPENSECOST(e.getString(TAG_EXPENSECOST));
	    		        je.setSHOPNAME(e.getString(TAG_SHOPNAME));
	    		        je.setCOUNTRYNAME(e.getString(TAG_COUNTRYNAME));
	    		        je.setCOUNTRYSHORT(e.getString(TAG_COUNTRYSHORT));
	    		        je.setPERSONNAME(e.getString(TAG_PERSONNAME));
	    		        
	    		        je.OutputValuesJE(je);
	    		        
	    		     // creating new HashMap
	                    HashMap<String, String> map = new HashMap<String, String>();
	     
	                    // adding each child node to HashMap key => value
	                    map.put(TAG_EXPENSEID, je.getEXPENSEID());
	                    map.put(TAG_EXPENSEDATE, je.getEXPENSEDATE());
	                    map.put(TAG_EXPENSECOST, je.getEXPENSECOST());
	                    map.put(TAG_SHOPNAME, je.getSHOPNAME());
	     
	                    
	                    // adding HashList to ArrayList
	                    joinedExpenseList.add(map);
	    		    }
	    		} catch (JSONException e) {
	    		    e.printStackTrace();
	    		}	    	  
	    }
		return null;
    }

    @Override
    protected void onPreExecute() {
	}
    protected void onProgressUpdate(Integer... values) 
    {
    	ProgressDialog dialog = ProgressDialog.show(CustomApplication.getCustomAppContext(), "", "Loading. Please wait...", true);
    	
    }
    
    protected void onPostExecute() {
    }

  }