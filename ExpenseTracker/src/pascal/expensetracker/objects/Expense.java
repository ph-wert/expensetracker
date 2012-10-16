package pascal.expensetracker.objects;


public class Expense {
	
	private String person;
	private String shop;
	private String expensedate;
	private String expense;
	
	public Expense() {
	}
	
	public Expense(String person, String shop, String expensedate, String expense) {
		super();
		this.person = person;
		this.shop = shop;
		this.expense = expense;
		this.expensedate = expensedate;
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
}
