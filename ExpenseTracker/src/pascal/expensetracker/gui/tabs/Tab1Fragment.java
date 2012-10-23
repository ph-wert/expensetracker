package pascal.expensetracker.gui.tabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import pascal.expensetracker.R;
import pascal.expensetracker.asynctasks.GetBaseAsyncTask;
import pascal.expensetracker.asynctasks.GetBaseAsyncTask.OnRequestFinishedListener;
import pascal.expensetracker.asynctasks.GetJoinedShopsAsyncTask;
import pascal.expensetracker.asynctasks.GetPersonAsyncTask;
import pascal.expensetracker.asynctasks.HttpPostAsyncTask;
import pascal.expensetracker.objects.Expense;
import pascal.expensetracker.objects.JoinedShops;
import pascal.expensetracker.objects.Persons;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * @author mwho
 * 
 */
public class Tab1Fragment extends Fragment {

	private static Expense selectedExpense = new Expense();

//		private void onButtonClicked() {
//			if (selectedPerson == null || selectedShop == null) {
//				Toast.makeText(getActivity(), "First select your items!",
//						Toast.LENGTH_LONG).show();
//				return;
//			}
//	
//			Expense currentExpense = new Expense();
//	
//			// todo rest request so save currentexpense...
//		}

	final static public Expense getExpense() {
		return selectedExpense;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 *      android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			// We have different layouts, and in one of them this
			// fragment's containing frame doesn't exist. The fragment
			// may still be created from its saved state, but there is
			// no reason to try to create its view hierarchy because it
			// won't be displayed. Note this is not needed -- we could
			// just run the code below, where we would create and return
			// the view hierarchy; it would just never be used.
			return null;
		}
		LinearLayout theLayout = (LinearLayout) inflater.inflate(R.layout.tab_frag1_layout, container, false);

		final DatePicker expenseDate = (DatePicker) theLayout.findViewById(R.id.expenseDatePicker);
		expenseDate.init(2012, 10, 16, new OnDateChangedListener() {
			public void onDateChanged(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
				// Notify the user.
				System.out.println("TOUCHED:" +year +"/" +dayOfMonth  +"/" +monthOfYear );
				selectedExpense.setExpensedate(year +"-" +(monthOfYear+1) +"-" +dayOfMonth) ;
			}
		});

		final EditText expenseCost = (EditText) theLayout.findViewById(R.id.expenseCost);
		expenseCost.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				selectedExpense.setExpense(s.toString());
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				System.out.println("beforetextchanged");

			}

			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				//				selectedCost.
				//				System.out.println(selectedCost);
				System.out.println("aftertextchanged");

			}
		});

		GetBaseAsyncTask<JoinedShops> task1 = new GetJoinedShopsAsyncTask(
				new OnRequestFinishedListener<JoinedShops>() {

					public void onFinished(ArrayList<JoinedShops> result) {
						Spinner spinner = (Spinner) getView().findViewById(
								R.id.spinner_shops);

						spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

							public void onItemSelected(AdapterView<?> spinnerList, View view, int position, long id) {
								JoinedShops shop = (JoinedShops) spinnerList
										.getItemAtPosition(position);
								// save this shop to a local variable... to use
								// it later for the rest request
								Toast.makeText(getActivity(), shop.toString(),
										Toast.LENGTH_LONG).show();
								selectedExpense.setShop(shop.getShopid());
								selectedExpense.setCurrency(shop.getCurrency());
							}

							public void onNothingSelected(AdapterView<?> arg0) {
								// no operation
							}
						});

						ArrayAdapter<JoinedShops> dataAdapterShops = new ArrayAdapter<JoinedShops>(
								getActivity(),
								android.R.layout.simple_spinner_item, result);
						dataAdapterShops
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						spinner.setAdapter(dataAdapterShops);
					}
				});
		task1.execute(new String[] { getString(R.string.host_url) });

		GetBaseAsyncTask<Persons> task2 = new GetPersonAsyncTask(
				new OnRequestFinishedListener<Persons>() {
					public void onFinished(ArrayList<Persons> result) {
						Spinner spinner = (Spinner) getView().findViewById(
								R.id.spinner_persons);

						spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

							public void onItemSelected(
									AdapterView<?> spinnerList, View view,
									int position, long id) {
								Persons person = (Persons) spinnerList
										.getItemAtPosition(position);
								// save this shop to a local variable... to use
								// it later for the rest request
								Toast.makeText(getActivity(),
										person.toString(), Toast.LENGTH_LONG)
										.show();
								selectedExpense.setPerson(person.getPERSONID());
							}

							public void onNothingSelected(AdapterView<?> arg0) {
								// no operation
							}
						});

						ArrayAdapter<Persons> dataAdapterShops = new ArrayAdapter<Persons>(
								getActivity(),
								android.R.layout.simple_spinner_item, result);
						dataAdapterShops
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						spinner.setAdapter(dataAdapterShops);
					}
				});
		task2.execute(new String[] { getString(R.string.host_url) });

		final Button buttonaddexpense = (Button) theLayout.findViewById(R.id.buttonaddexpense);
		buttonaddexpense.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				System.out.println("date =" +selectedExpense.getExpensedate());
				System.out.println("expense =" +selectedExpense.getExpense());
				System.out.println("person =" +selectedExpense.getPerson());
				System.out.println("shop =" +selectedExpense.getShop());
				Toast.makeText(getActivity(), "Eingabe:" +selectedExpense.getShop() +" - " 
						+selectedExpense.getPerson() +" - " 
						+selectedExpense.getExpensedate() +" - " 
						+selectedExpense.getExpense() +" " 
						+selectedExpense.getCurrency(), Toast.LENGTH_LONG).show();

				if (selectedExpense.getExpense() != null) {
					System.out.println("Schreibe!");
					HttpPostAsyncTask atask = new HttpPostAsyncTask();
					atask.execute(new String[] { getString(R.string.host_url) });
					expenseCost.setText("");
				}
			}
		});

		return theLayout;
		}

	}
