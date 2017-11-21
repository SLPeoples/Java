
public class Commission extends Hourly{
	private double totSales;
	private double comission;
	public Commission(){
		super();
	}
	public Commission(String name, String address, int phone, int socSec, double hourly, double commission){
		super(name, address, phone, socSec, hourly);
		this.comission = commission;
	}
	public void addSales(double sales){
		this.totSales+=sales;
	}
	public double pay(){
		double re = super.pay()+this.totSales*this.comission;
		this.totSales = 0;
		return re;
	}
	public String toString(){
		return super.toString()+", Total sales: "+this.totSales;
	}
}