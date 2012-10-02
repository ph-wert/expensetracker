package pascal.expensetracker.objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Persons {

	public static String TAG_PERSON = "person";	// JSON Structure
	public static String TAG_PERSONS = "persons";	// JSON Structure
	public static String TAG_PERSONID = "PERSONID";
	public static String TAG_PERSONNAME = "PERSONNAME";
	public String PERSONID;
	public String PERSONNAME;
	public static String url_path = "rest/persons";
	
	public Persons() {
		// TODO Auto-generated constructor stub
		url_path = "rest/persons";
	}

	public static void main(String[] args) {
	}

	public String getName() {
		return "Persons";
	}
	public String getTAG_PERSON() {
		return TAG_PERSON;
	}

	public void setTAG_PERSON(String tAG_PERSON) {
		TAG_PERSON = tAG_PERSON;
	}

	public String getTAG_PERSONS() {
		return TAG_PERSONS;
	}

	public void setTAG_PERSONS(String tAG_PERSONS) {
		TAG_PERSONS = tAG_PERSONS;
	}
	public String getTAG_PERSONID() {
		return TAG_PERSONID;
	}

	public void setTAG_PERSONID(String tAG_PERSONID) {
		TAG_PERSONID = tAG_PERSONID;
	}

	public String getTAG_PERSONNAME() {
		return TAG_PERSONNAME;
	}

	public void setTAG_PERSONNAME(String tAG_PERSONNAME) {
		TAG_PERSONNAME = tAG_PERSONNAME;
	}

	public String getPERSONID() {
		return PERSONID;
	}

	public void setPERSONID(String pERSONID) {
		PERSONID = pERSONID;
	}

	public String getPERSONNAME() {
		return PERSONNAME;
	}

	public void setPERSONNAME(String pERSONNAME) {
		PERSONNAME = pERSONNAME;
	}

	public String getUrl_path() {
		return url_path;
	}

	public void setUrl_path(String url_path) {
		this.url_path = url_path;
	}

	public static Persons deserialize(JSONObject json) throws JSONException {
		Persons p = new Persons();
		
		JSONObject o = json.getJSONObject(TAG_PERSON);
		
		p.setPERSONID(o.getString(TAG_PERSONID));
		p.setPERSONNAME(o.getString(TAG_PERSONNAME));
		// TODO other fields..
		
		return p;
	}
	
	@Override
	public String toString() {
		return this.getPERSONNAME();
	}
}
