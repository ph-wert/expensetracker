package pascal.expensetracker.asynctasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pascal.expensetracker.R;
import pascal.expensetracker.connection.JSONParser;
import pascal.expensetracker.objects.Persons;
import android.os.AsyncTask;

public class GetMyDataGenericAsyncTask  extends AsyncTask<Persons, Void, ArrayList<Map<String, String>>>{

	public ArrayList<Map<String, String>> ejList = new ArrayList<Map<String, String>>();
	
	@Override
	protected ArrayList<Map<String, String>> doInBackground(Persons... params) {
		for (Persons param : params) {
			Persons o = param;
			System.out.println("generic object: " +o.getName());
			String url = R.string.host_url + o.getUrl_path();
	        
			// Creating JSON Parser instance
	    	  JSONParser jParser = new JSONParser();
	    	   
	    	  // getting JSON string from URL
	    	  JSONObject json = jParser.getJSONFromUrl(url);
	    	  try {
	    		  // Getting Array of JoinedExpenses
	    		  JSONArray JSONArrayExpenses = json.getJSONArray(Persons.TAG_PERSONS);
	    		 
	    		  System.out.println("Länge Persons: " +JSONArrayExpenses.length());
	    		    // looping through All Contacts
	    		    for(int i = 0; i < JSONArrayExpenses.length(); i++){
	    		        JSONObject es = JSONArrayExpenses.getJSONObject(i);
	    		        JSONObject e = es.getJSONObject(Persons.TAG_PERSON);
	    		        Persons p = new Persons();
	    		        
	    		        p.setPERSONID(e.getString(o.getPERSONID()));
	    		        p.setPERSONNAME(e.getString(o.getTAG_PERSONNAME()));
	    		        
//	    		        je.OutputValuesJE(je);
	    		        
	    		     // creating new HashMap
                    HashMap<String, String> map = new HashMap<String, String>();
	     
//	                    // adding each child node to HashMap key => value
//	                    map.put(TAG_EXPENSEID, je.getEXPENSEID());
//	                    map.put(TAG_EXPENSEDATE, je.getEXPENSEDATE());
//	                    map.put(TAG_EXPENSECOST, je.getEXPENSECOST());
//	                    map.put(TAG_SHOPNAME, je.getSHOPNAME());
	     
	                    ejList.add(putData(p.getPERSONID(), p.getPERSONNAME()));
	    		    }
	    		} catch (JSONException e) {
	    		    e.printStackTrace();
	    		}	    	  
		}
//		System.out.println("wowo: " +ejList.size());
		
		return ejList;
	}
private HashMap<String, String> putData(String id, String personname) {
    HashMap<String, String> item = new HashMap<String, String>();
    item.put(Persons.TAG_PERSONID, id);
    item.put(Persons.TAG_PERSONNAME, personname);
    return item;
  }
}
