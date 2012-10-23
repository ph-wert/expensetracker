package pascal.expensetracker.objects;


public class Expense {
	
	private String person;
	private String shop;
	private String expensedate;
	private String expense;
	private String currency;
	
	public Expense() {
		this.person = null;
		this.shop = null;
		this.expense = null;
		this.expensedate = null;
		this.currency = null;
	}
	
	public Expense(String person, String shop, String expensedate, String expense, String currency) {
		super();
		this.person = person;
		this.shop = shop;
		this.expense = expense;
		this.expensedate = expensedate;
		this.currency = currency;
	}
	
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(String expensedate) {
		this.expensedate = expensedate;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
