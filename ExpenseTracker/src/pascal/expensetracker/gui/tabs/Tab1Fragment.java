package pascal.expensetracker.gui.tabs;

import java.util.ArrayList;
import java.util.List;

import pascal.expensetracker.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author mwho
 *
 */
public class Tab1Fragment extends Fragment {
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
		LinearLayout theLayout = (LinearLayout) inflater.inflate(R.layout.tab_frag1_layout, container, false);
		
		Spinner spinner1 = (Spinner) theLayout.findViewById(R.id.spinner_shops);
		List<String> list_shops = new ArrayList<String>();
		list_shops.add("list 1");
		list_shops.add("list 2");
		list_shops.add("list 3");
		ArrayAdapter<String> dataAdapterShops = new ArrayAdapter<String>(inflater.getContext(),
			android.R.layout.simple_spinner_item, list_shops);
		dataAdapterShops.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapterShops);
		
//		Spinner spinner2 = (Spinner) theLayout.findViewById(R.id.spinner_persons);
//		List<String> list_persons = new ArrayList<String>();
//		list_persons.add("list 1");
//		list_persons.add("list 2");
//		list_persons.add("list 3");
//		ArrayAdapter<String> dataAdapterPersons = new ArrayAdapter<String>(inflater.getContext(),
//			android.R.layout.simple_spinner_item, list_persons);
//		dataAdapterPersons.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		spinner2.setAdapter(dataAdapterPersons);
		
        final TextView valueTextView = (TextView) theLayout.findViewById( R.id.selected );
        Spinner s = (Spinner) theLayout.findViewById(R.id.spinner_persons);
        final MyData items[] = new MyData[3];
        items[0] = new MyData( "key1","value1" );
        items[1] = new MyData( "key2","value2" );
        items[2] = new MyData( "key3","value3" );
        ArrayAdapter<MyData> adapter = 
            new ArrayAdapter<MyData>( 
            		inflater.getContext(),
                android.R.layout.simple_spinner_item,
                items );
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(
            new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(
                        AdapterView<?> parent, 
                        View view, 
                        int position, 
                        long id) {
                    MyData d = items[position];
                    valueTextView.setText( d.getValue() );
                }

                public void onNothingSelected(AdapterView<?> parent) {
                }
            }
        );
		
		return theLayout;
	}
	
    class MyData {
        public MyData( String spinnerText, String value ) {
            this.spinnerText = spinnerText;
            this.value = value;
        }

        public String getSpinnerText() {
            return spinnerText;
        }

        public String getValue() {
            return value;
        }

        public String toString() {
            return spinnerText;
        }

        String spinnerText;
        String value;
    }
}
