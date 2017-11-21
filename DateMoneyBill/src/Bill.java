
/**
 * @author Samuel L. Peoples, 1527650
 * Bill constructor class
 */
public class Bill {
	private Money amount = new Money();
	private Date dueDate = new Date();
	private Date paidDate = new Date();
	private String originator;
	/**
	 * empty constructor
	 */
	public Bill(){
		this.amount.setMoney(0, 0);
		this.dueDate.setDate(1, 1, 2024);
		this.originator = "Originator";
	}
	
	/**
	 * Constructor for bill
	 * @param am, amount
	 * @param due, due date
	 * @param orig, originator
	 */
	public Bill(Money am, Date due, String orig) {
		this.amount.setMoney(am.getDollars(), am.getCents());
		this.dueDate.setDate(due.getMonth(), due.getDay(), due.getYear());
		this.originator = orig;
	}

	/**
	 * Copy Construtor
	 * @param other, copy to this
	 */
	public Bill(Bill other) {
		this.amount.setMoney(other.getAmount().getDollars(), other.getAmount().getCents());
		this.dueDate.setDate(other.getDueDate().getMonth(), other.getDueDate().getDay(), other.getDueDate().getYear());
		this.originator = other.getOriginator();
	}
	
	/**
	 * getter for amount
	 * @return this amount
	 */
	public Money getAmount(){
		return this.amount;
	}
	
	/**
	 * getter for due date
	 * @return this due date
	 */
	public Date getDueDate(){
		return this.dueDate;
	}
	
	/**
	 * getter for originator
	 * @return this originator
	 */
	public String getOriginator(){
		return this.originator;
	}
	
	/**
	 * Boolean for whether a bill is paid
	 * @return true if paid
	 */
	public boolean isPaid(){
		if(this.paidDate.getDay() > 0 && this.paidDate.getMonth() > 0 && this.paidDate.getYear() > 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Setter for date paid
	 * @param datePaid, what date to set the bill paid to
	 * @return true if the paid date was updated.
	 */
	public boolean setPaid(Date datePaid){
		if(this.isPaid()||datePaid.getYear() > this.dueDate.getYear()||
				datePaid.getMonth() > this.dueDate.getMonth() &&datePaid.getYear() >= this.dueDate.getYear()||
				datePaid.getDay() > this.dueDate.getDay()&&datePaid.getYear() >= this.dueDate.getYear() &&datePaid.getMonth() >= this.dueDate.getMonth())
			return false;
		else{
			this.paidDate = datePaid;
			return true;
		}
	}
	
	/**
	 * setter for due date
	 * @param nextDate, date to change the due date to
	 * @return true if due date was updated
	 */
	public boolean setDueDate(Date nextDate){
		if(this.isPaid()||this.paidDate.getDay() > 0 && this.paidDate.getMonth() > 0 && this.paidDate.getYear() > 0)
			return false;
		else{
			this.dueDate = nextDate;
			return true;
		}
	}
	
	/**
	 * setter for amount
	 * @param am, amount to set to
	 * @return, true if amount was updated
	 */
	public boolean setAmount(Money am){
		if(this.isPaid()||this.paidDate.getDay() > 0 && this.paidDate.getMonth() > 0 && this.paidDate.getYear() > 0)
			return false;
		else{
			this.amount = am;
			return true;
		}
	}
	
	/**
	 * setter for originator
	 * @param orig, string to set originator to
	 */
	public void setOriginator(String orig){
		this.originator = orig;
	}
	
	/** toString method
	 * @return appropriate string realted to status
	 */
	public String toString(){
		if(this.isPaid())
			return "Amount due: "+this.amount.toString()+", by "+this.dueDate.toString()+", by "+this.originator +"; Paid on: "+this.paidDate;
		else
			return "Amount due: "+this.amount.toString()+", by "+this.dueDate.toString()+", by "+this.originator+"; Balance is outstanding.";
	}
	
	/**
	 * equals method
	 * @param other, what to compare to this
	 * @return true if elements are equivalent
	 */
	public boolean equals(Bill other){
		if(this.amount == other.getAmount() && this.dueDate == other.getDueDate() && this.originator == other.getOriginator() && this.paidDate == other.paidDate)
			return true;
		else
			return false;
	}
}