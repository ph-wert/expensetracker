package pascal.expensetracker.objects;


public class Expense {
	
	private Persons person;
	private JoinedShops shop;
	
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

	public Expense(Persons person, JoinedShops shop) {
		super();
		this.person = person;
		this.shop = shop;
	}

}
