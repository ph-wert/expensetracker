package pascal.expensetracker.gui.tabs;

import pascal.expensetracker.R;
import android.util.DisplayMetrics;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
		LinearLayout theLayout = (LinearLayout) inflater.inflate(R.layout.tab_frag2_layout, container, false);
		 
//		RestClient.connect("http://www.phwert.host-ed.me/expensetracker/rest/joinedexpenses");
//		GetJsonAsyncTask test = new GetJsonAsyncTask(); 
//		test.readWebpage(getView(), getString(R.string.host_url));
//		String url =  "http://chart.apis.google.com/chart?cht=p3&chs=500x200&chd=e:TNTNTNGa&chts=000000,16&chtt=A+Better+Web&chl=Hello|Hi|anas|Explorer&chco=FF5533,237745,9011D3,335423&chdl=SAP|Mozilla|Google|Microsoft";
		String url = "http://savedbythegoog.appspot.com/?id=273800f50bc140cc8c9dc061d85b923ec3472e44";
		
        DisplayMetrics dm = new DisplayMetrics();
     //   getWindowManager().getDefaultDisplay().getMetrics(dm);
		TextView textView = (TextView) theLayout.findViewById(R.id.textView);
		textView.setText("Height: "+dm.heightPixels + " Width: " +dm.widthPixels +url);
		
		WebView mCharView = (WebView) theLayout.findViewById(R.id.webViewChart);
        mCharView.loadUrl(url);

		return theLayout;
	}
}
