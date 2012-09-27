package pascal.expensetracker.asynctasks;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

public class GetJsonAsyncTask extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     }

	  public void readWebpage(View view, String url) {
	    DownloadJSON task = new DownloadJSON();
//	    String url = "http://www.phwert.host-ed.me/expensetracker/rest/joinedexpenses";
	    task.execute(new String[] { url });

	  }
}
