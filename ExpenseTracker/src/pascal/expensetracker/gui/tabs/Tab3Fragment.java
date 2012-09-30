package pascal.expensetracker.gui.tabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import pascal.expensetracker.R;
import pascal.expensetracker.asynctasks.GetJSONObject;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

//import com.andy.R;

/**
 * @author mwho
 *
 */
public class Tab3Fragment extends Fragment {
	
	public String url = "http://www.phwert.host-ed.me/expensetracker/rest/joinedexpenses";
	
	public static final String TAG_EXPENSES 	= "expenses";	
	public static final String TAG_EXPENSE 		= "expense";
	public static final String TAG_EXPENSEID 	= "EXPENSEID";
	public static final String TAG_EXPENSEDATE 	= "EXPENSEDATE";
	public static final String TAG_EXPENSECOST 	= "EXPENSECOST";
	public static final String TAG_SHOPNAME 	= "SHOPNAME";
	public static final String TAG_COUNTRYNAME 	= "COUNTRYNAME";
	public static final String TAG_COUNTRYSHORT = "COUNTRYSHORT";
	public static final String TAG_PERSONNAME	= "PERSONNAME";	
//	
//	public JSONArray JSONArrayExpenses = null;
//	public JSONObject jo = null;
//	public GetJSONObject jsonObject = new GetJSONObject();
	public ArrayList<Map<String, String>> joinedExpenseList = null;
	/** (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */	
	public String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
			  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
			  "Linux", "OS/2", "SAPOS" };
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (container == null) {
            // We have different layouts, and in one of them this
            // fragment's containing frame doesn't exist.  The fragment
            // may still be created from its saved state, but the	re is
            // no reason to try to create its view hierarchy because it
            // won't be displayed.  Note this is not needed -- we could
            // just run the code below, where we would create and return
            // the view hierarchy; it would just never be used.
            return null;
        }
        LinearLayout theLayout = (LinearLayout) inflater.inflate(R.layout.tab_frag3_layout, container, false);
 
    	ArrayList<HashMap<String, String>> expensesJoinedList = new ArrayList<HashMap<String, String>>();
	    
    	GetJSONObject getjo = new GetJSONObject();
    	getjo.execute(new String[] { getString(R.string.host_url) });
		final ListView listView = (ListView) theLayout.findViewById(R.id.list_view);
    	
    	try {
			ArrayList<Map<String, String>> joinedExpenseList = getjo.get();
	
        String[] from = { TAG_EXPENSEID, TAG_EXPENSEDATE, TAG_EXPENSECOST, TAG_SHOPNAME, TAG_COUNTRYNAME, TAG_COUNTRYSHORT, TAG_PERSONNAME };
        int[] to = { R.id.expenseid, R.id.expensedate, R.id.expensecost, R.id.shopname, R.id.countryname, R.id.countryshort, R.id.personname };
//	    System.out.println("dkdkd -" + joinedExpenseList.size());
        SimpleAdapter adapter = new SimpleAdapter(inflater.getContext(), joinedExpenseList, R.layout.list_row, from, to);
		//  
        listView.setAdapter(adapter);
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

    	
    	// First paramenter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.list_row, R.id.expenseid, values);

		// Assign adapter to ListView
//		listView.setAdapter(adapter);
		return theLayout;
	}
}
