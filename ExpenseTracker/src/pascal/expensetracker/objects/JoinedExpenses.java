package pascal.expensetracker.objects;

public class JoinedExpenses {

	String EXPENSEID;
	String EXPENSEDATE;
	String EXPENSECOST;
	String SHOPNAME;
	String COUNTRYNAME;
	String COUNTRYSHORT;
	String PERSONNAME;

	public JoinedExpenses() {
		// TODO Auto-generated constructor stub
	}

	public void OutputValuesJE(JoinedExpenses je) {
		System.out.println("---------------------------");
		System.out.println(je.getEXPENSEID());
		System.out.println(je.getEXPENSEDATE());
		System.out.println(je.getEXPENSECOST());
		System.out.println(je.getSHOPNAME());
		System.out.println(je.getCOUNTRYNAME());
		System.out.println(je.getCOUNTRYSHORT());
		System.out.println(je.getPERSONNAME());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String getEXPENSEID() {
		return EXPENSEID;
	}

	public void setEXPENSEID(String eXPENSEID) {
		EXPENSEID = eXPENSEID;
	}

	public String getEXPENSEDATE() {
		return EXPENSEDATE;
	}

	public void setEXPENSEDATE(String eXPENSEDATE) {
		EXPENSEDATE = eXPENSEDATE;
	}

	public String getEXPENSECOST() {
		return EXPENSECOST;
	}

	public void setEXPENSECOST(String eXPENSECOST) {
		EXPENSECOST = eXPENSECOST;
	}

	public String getSHOPNAME() {
		return SHOPNAME;
	}

	public void setSHOPNAME(String sHOPNAME) {
		SHOPNAME = sHOPNAME;
	}

	public String getCOUNTRYNAME() {
		return COUNTRYNAME;
	}

	public void setCOUNTRYNAME(String cOUNTRYNAME) {
		COUNTRYNAME = cOUNTRYNAME;
	}

	public String getCOUNTRYSHORT() {
		return COUNTRYSHORT;
	}

	public void setCOUNTRYSHORT(String cOUNTRYSHORT) {
		COUNTRYSHORT = cOUNTRYSHORT;
	}

	public String getPERSONNAME() {
		return PERSONNAME;
	}

	public void setPERSONNAME(String pERSONNAME) {
		PERSONNAME = pERSONNAME;
	}

}
