package pascal.expensetracker.gui.tabs;

import pascal.expensetracker.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

//import com.andy.R;

/**
 * @author mwho
 *
 */
public class Tab3Fragment extends Fragment {
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
            // may still be created from its saved state, but there is
            // no reason to try to create its view hierarchy because it
            // won't be displayed.  Note this is not needed -- we could
            // just run the code below, where we would create and return
            // the view hierarchy; it would just never be used.
            return null;
        }
        LinearLayout theLayout = (LinearLayout) inflater.inflate(R.layout.tab_frag3_layout, container, false);
 
        /** Creating an array adapter to store the list of countries **/
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, values);
 
        /** Setting the list adapter for the ListFragment */
//        setListAdapter(adapter);	
 
        
        
        
//		RestClient.connect("http://www.phwert.host-ed.me/expensetracker/rest/joinedexpenses");
//		Tab3AsyncTask test = new Tab3AsyncTask(); 
//		test.execute(theLayout);
		
		final ListView listView = (ListView) theLayout.findViewById(R.id.list_view);

    	
    	// First paramenter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, values);

		// Assign adapter to ListView
		listView.setAdapter(adapter);

  
		return theLayout;
	}

	private void setListAdapter(ArrayAdapter<String> adapter) {
		// TODO Auto-generated method stub
		
	}
}
