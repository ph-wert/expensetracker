package pascal.expensetracker.gui.tabs;

import pascal.expensetracker.R;
import pascal.expensetracker.asynctasks.HttpPostAsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.andy.R;

/**
 * @author mwho
 *
 */
public class Tab4Fragment extends Fragment {
	/** (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
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
        LinearLayout theLayout = (LinearLayout) inflater.inflate(R.layout.tab_frag4_layout, container, false);

        final EditText eingabefeld = (EditText) theLayout.findViewById(R.id.eingabefeld);
        final Button knopf = (Button) theLayout.findViewById(R.id.knopf);
        final TextView textausgabe = (TextView) theLayout.findViewById(R.id.textausgabe);

        knopf.setOnClickListener(new View.OnClickListener() {
        	 public void onClick(View v) {
        		 HttpPostAsyncTask atask = new HttpPostAsyncTask();
        		 atask.execute(new String[] { getString(R.string.host_url) });
        		 
//                 // Check Login
                 String username = eingabefeld.getText().toString();
//                 String password = etPassword.getText().toString();
//                  
//                 if(username.equals("guest") && password.equals("guest")){
//                     lblResult.setText("Login successful.");
//                 } else {
//                     lblResult.setText("Login failed. Username and/or password doesn't match.");
//                 }
        		 System.out.println(username);
        		 textausgabe.setText(username);
        	 }
         });

        textausgabe.setText("Test");
//        System.out.println(textausgabe.getText());
		return theLayout;
	}

	private TextView findViewById(int textausgabe) {
		// TODO Auto-generated method stub
		return null;
	}
}
