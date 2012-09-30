package pascal.expensetracker.gui.tabs;

import pascal.expensetracker.R;
import pascal.expensetracker.asynctasks.DownloadJSON;
import pascal.expensetracker.asynctasks.GetJsonAsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * @author mwho
 *
 */
public class Tab2Fragment extends Fragment {
	/** (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
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
		 
//		RestClient.connect("http://www.phwert.host-ed.me/expensetracker/rest/joinedexpenses");
//		GetJsonAsyncTask test = new GetJsonAsyncTask(); 
//		test.readWebpage(getView(), getString(R.string.host_url));
		
		DownloadJSON task = new DownloadJSON();
		task.execute(new String[] { getString(R.string.host_url) });
	    
		return theLayout;
	}
}
