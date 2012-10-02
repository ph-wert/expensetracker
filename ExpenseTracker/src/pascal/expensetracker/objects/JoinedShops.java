package pascal.expensetracker.objects;

import org.json.JSONException;
import org.json.JSONObject;

public class JoinedShops {
	public static final String TAG_SHOPS 		= "shops";	
	public static final String TAG_SHOP 		= "shop";
	public static final String TAG_SHOPID 		= "SHOPID";
	public static final String TAG_SHOPNAME 	= "SHOPNAME";
	public static final String TAG_COUNTRYID 	= "COUNTRYID";
	public static final String TAG_COUNTRYNAME	= "COUNTRYNAME";
	public static final String TAG_COUNTRYSHORT	= "COUNTRYSHORT";
	
	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCountryshort() {
		return countryshort;
	}

	public void setCountryshort(String countryshort) {
		this.countryshort = countryshort;
	}

	public String shopid;
	public String shopname;
	public String countryid;
	public String countryname;
	public String countryshort;
	
	public JoinedShops() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", this.shopname, this.countryshort);
	}

	public static JoinedShops deserialize(JSONObject os) throws JSONException {
        JoinedShops js = new JoinedShops();
        
        JSONObject o = os.getJSONObject(TAG_SHOP);
        js.setShopid(o.getString(TAG_SHOPID));
        js.setShopname(o.getString(TAG_SHOPNAME));
        js.setCountryid(o.getString(TAG_COUNTRYID));
        js.setCountryname(o.getString(TAG_COUNTRYNAME));
        js.setCountryshort(o.getString(TAG_COUNTRYSHORT));
        
        return js;
	}

}
