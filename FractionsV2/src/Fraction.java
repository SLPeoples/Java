/**
 * @author Samuel L. Peoples, 1527650
 * Fractions V2 Fraction constructor class
 *
 */
public class Fraction {
	//Numerator and denominator are initialized as 0/1 to catch some exceptions
	int numerator=0;
	int denominator=1;
	//empty main
	public static void main(String[] args) {}
	public void fraction(){}
	public void fraction(int num, int den){
		this.numerator = num;
		this.denominator = den;
	}
	/**
	 * Compares 'this' fraction to 'other' fraction
	 * @param other, type Fraction
	 * @return true, if the fractions are equivalent.
	 */
	public boolean equals(Fraction other){
		
		if(reduceFraction(this.numerator, this.denominator).equals(reduceFraction(other.numerator, other.denominator)))
			return true;
		else
			return false;
	}
	
	/**
	 * Reduces the fraction to check equivalence
	 * @param num, numerator of fraction
	 * @param den, denominator of fraction
	 * @return the reduced fraction
	 */
	private String reduceFraction(int num, int den) {
	    int gcm = this.gcm(num, den);
	    return (num / gcm) + "/" + (den / gcm);
	}
	
	/**
	 * Determines the GCM
	 * @param num, numerator of fraction
	 * @param den, denominator of fraction
	 * @return gcm, integer value
	 */
	private int gcm(int num, int den) {
	    return den == 0 ? num : gcm(den, num % den);
	}
	
	@Override
	/**
	 * Overrides the inherited toString to meet local requirements
	 * @return the string representation of the reduced fraction.
	 */
	public String toString(){
		return reduceFraction(numerator, denominator);
	}
	
	/**
	 * @return numerator, current numerator
	 */
	int getNumerator(){
		return this.numerator;
	}
	
	/**
	 * @return denominator, current denominator
	 */
	int getDenominator(){
		return this.denominator;
	}
	
	/**
	 * Sets num to the current fraction's numerator
	 * @param num, new numerator 
	 */
	void setNumerator(int num){
		this.numerator = num;
	}
	
	/**
	 * Sets den to the current fraction's denominator
	 * @param den, new denominator
	 */
	void setDenominator(int den){
		this.denominator = den;
	}

}
