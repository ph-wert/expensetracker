package pascal.expensetracker.asynctasks;

import org.json.JSONException;
import org.json.JSONObject;

import pascal.expensetracker.objects.Persons;

public class GetPersonAsyncTask extends GetBaseAsyncTask<Persons> {

	public static final String TAG_PERSONS = "persons";
	
	public GetPersonAsyncTask(
			GetBaseAsyncTask.OnRequestFinishedListener<Persons> listener) {
		super(listener);
	}

	@Override
	protected String getRequestURLSuffix() {
		return "rest/persons";
	}

	@Override
	protected String getCollectionTag() {
		return TAG_PERSONS;
	}

	@Override
	protected Persons createObject(JSONObject json) throws JSONException {
		return Persons.deserialize(json);
	}

}
