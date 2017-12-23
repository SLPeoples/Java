import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * @author Samuel L. Peoples, 1527650
 * Student class. comparable and cloneable
 */
public class Student implements Serializable, Comparable<Student>, Cloneable {
	private double GPA;
	private String name;
	
	/**
	 * Constructor for studnets
	 * @param n, name string
	 * @param gpa, double GPA
	 */
	public Student(String n, double gpa) {
		name = n;
		GPA = gpa;
	}
	
	/**
	 * getter for GPA
	 * @return this gpa (controlled 2 decimal)
	 */
	public double getGPA(){
		return Math.floor(this.GPA*100)/100;
	}
	
	/**
	 * getter for name
	 * @return this name
	 */
	public String getName(){
		return this.name;
	}
	
	/** overrides native toString()
	 * @return this name, this gpa
	 */
	@Override
	public String toString(){
		return this.name+", "+this.getGPA();
	}
	
	/**
	 * setter for GPA
	 * @param gpa, double to set
	 */
	public void setGPA(double gpa){
		this.GPA = gpa;
	}
	
	/**
	 * Setter for name
	 * @param input, name to set
	 */
	public void setName(String input){
		this.name = input;
	}
	
	/**
	 * Student clone
	 * @return cloned student
	 */
	@Override
	public Student clone(){
		return new Student(this.name, this.GPA);
	}
	
	/** returns integer value of the difference, multiplied by 10.
	 * 3.9:4.0 = -1
	 * @return difference * 10 
	 */
	@Override
	public int compareTo(Student other) {
		return (int)((this.getGPA()-other.getGPA())*10);
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeObjectToFile();
		Student a = readObjectFromFile();
		if(a != null) {
			System.out.println(a.toString());
		}
		Student[] students = new Student[10];
		students[0] = new Student("A", 4);
		students[1] = new Student("B", 3.9);
		students[2] = new Student("C", 3.8);
		students[3] = new Student("D", 3.7);
		students[4] = new Student("E", 3.6);
		students[5] = new Student("F", 3.5);
		students[6] = new Student("G", 3.0);
		students[7] = new Student("H", 2.553);
		students[8] = new Student("I", 2.0);
		students[9] = new Student("J", 2.11);
		for(Student student: students)
			System.out.println(student.toString());
		System.out.println("4.0 compared to 3.9: "+students[0].compareTo(students[1]));
		System.out.println("3.9 compared to 4.0: "+students[1].compareTo(students[0]));
		System.out.println("2.0 compared to 4.0: "+students[8].compareTo(students[0]));
		System.out.println("4.0 compared to 4.0: "+students[0].compareTo(students[0]));
		System.out.println("4.0 compared to 2.11: "+students[0].compareTo(students[9]));
		
		
	}

	/**
	 * Provided from input file, no changes
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static Student readObjectFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.obj"));
		Student one = (Student) is.readObject();
	
		is.close();
		
		return one;
	}

	/**
	 * Provided from input file, no changes
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void writeObjectToFile() throws FileNotFoundException, IOException {
		Student nguyen = new Student("Nguyen", 3.5);

		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.obj"));
		os.writeObject(nguyen);
			
		os.close();		
	}

}