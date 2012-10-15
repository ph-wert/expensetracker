package pascal.expensetracker.objects;


public class Expense {
	
	private Persons person;
	private JoinedShops shop;
	private String expensedate;
	private String expense;
	
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
	
	public Persons getPerson() {
		return person;
	}

	public void setPerson(Persons person) {
		this.person = person;
	}

	public JoinedShops getShop() {
		return shop;
	}

	public void setShop(JoinedShops shop) {
		this.shop = shop;
	}

	public Expense(Persons person, JoinedShops shop, String expensedate, String expense) {
		super();
		this.person = person;
		this.shop = shop;
		this.expense = expense;
		this.expensedate = expensedate;
	}

}
