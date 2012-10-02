package pascal.expensetracker.asynctasks;

import org.json.JSONException;
import org.json.JSONObject;

import pascal.expensetracker.objects.JoinedShops;

public class GetJoinedShopsAsyncTask extends GetBaseAsyncTask<JoinedShops>{
	

	public GetJoinedShopsAsyncTask(
			GetBaseAsyncTask.OnRequestFinishedListener<JoinedShops> listener) {
		super(listener);
	}

	public static final String TAG_SHOPS = "shops";

	@Override
	protected String getRequestURLSuffix() {
		return "rest/joinedshops";
	}

	@Override
	protected String getCollectionTag() {
		return TAG_SHOPS;
	}

	@Override
	protected JoinedShops createObject(JSONObject json) throws JSONException {
		return JoinedShops.deserialize(json);
	}
}