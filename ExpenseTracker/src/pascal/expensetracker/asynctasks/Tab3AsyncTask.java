package pascal.expensetracker.asynctasks;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
public class Tab3AsyncTask extends AsyncTask<ArrayAdapter, Void, ArrayAdapter> {
     
	public ArrayAdapter adapter = null;
	
	@Override
    protected void onPreExecute() {
    	System.out.println("onpreexecute");
    }
    protected void onProgressUpdate(Integer... values) 
    {
    }
    
    @Override
    protected void onPostExecute(ArrayAdapter adapter) {
    	System.out.println("onpostexecute");
//		listView.setAdapter(adapter);
    }

	@Override
	protected ArrayAdapter doInBackground(ArrayAdapter... params) {
		// TODO Auto-generated method stub
		for (ArrayAdapter param : params) {
			adapter = param;		
		}
		return null;
	}
}