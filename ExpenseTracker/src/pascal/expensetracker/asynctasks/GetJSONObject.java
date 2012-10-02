package pascal.expensetracker.asynctasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pascal.expensetracker.connection.JSONParser;
import pascal.expensetracker.objects.JoinedExpenses;
import android.os.AsyncTask;

public class GetJSONObject extends AsyncTask<String, Void, ArrayList<Map<String, String>>> {
	public static final String TAG_EXPENSES 	= "expenses";	
	public static final String TAG_EXPENSE 		= "expense";
	public static final String TAG_EXPENSEID 	= "EXPENSEID";
	public static final String TAG_EXPENSEDATE 	= "EXPENSEDATE";
	public static final String TAG_EXPENSECOST 	= "EXPENSECOST";
	public static final String TAG_SHOPNAME 	= "SHOPNAME";
	public static final String TAG_COUNTRYNAME 	= "COUNTRYNAME";
	public static final String TAG_COUNTRYSHORT = "COUNTRYSHORT";
	public static final String TAG_PERSONNAME	= "PERSONNAME";	
	
	public JSONArray JSONArrayExpenses = null;
	public JSONObject jo = null;

	public JSONParser jParser = new JSONParser();
	public JSONObject json = null;
	public ArrayList<Map<String, String>> ejList = new ArrayList<Map<String, String>>();
	
	protected ArrayList<Map<String, String>> doInBackground(String... urls) {
		for (String url : urls) {
			url = url + "rest/joinedexpenses";
	        
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
//	                    HashMap<String, String> map = new HashMap<String, String>();
	     
	                    // adding each child node to HashMap key => value
//	                    map.put(TAG_EXPENSEID, je.getEXPENSEID());
//	                    map.put(TAG_EXPENSEDATE, je.getEXPENSEDATE());
//	                    map.put(TAG_EXPENSECOST, je.getEXPENSECOST());
//	                    map.put(TAG_SHOPNAME, je.getSHOPNAME());
	     
	                    ejList.add(putData(je.getEXPENSEID(),je.getEXPENSEDATE(),je.getEXPENSECOST(),je.getSHOPNAME(),je.getCOUNTRYNAME(),je.getCOUNTRYSHORT(),je.getPERSONNAME()));
	    		    }
	    		} catch (JSONException e) {
	    		    e.printStackTrace();
	    		}	    	  
		}
//		System.out.println("wowo: " +ejList.size());
	  	return ejList;
	}

	  private HashMap<String, String> putData(String id, String date, String cost, String shopname, String countryname, String countryshort, String personname) {
	    HashMap<String, String> item = new HashMap<String, String>();
	    item.put(TAG_EXPENSEID, id);
	    item.put(TAG_EXPENSEDATE, date);
	    item.put(TAG_EXPENSECOST, cost);
	    item.put(TAG_SHOPNAME, shopname);
	    item.put(TAG_COUNTRYNAME, countryname);
	    item.put(TAG_COUNTRYSHORT, countryshort);
	    item.put(TAG_PERSONNAME, personname);
	    return item;
	  }
}
