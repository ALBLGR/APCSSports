package backlogics;
import java.util.*;

public class Order {

	private Student user;
	private Instrument inst;
	private Calendar checkout;
	
	Order(Student stu, Instrument ins){		// an order is placed by a student for some instrument
		user = stu;
		inst = ins;
		checkout = Calendar.getInstance();	//get the time of placing the order
	}
	
	
	public Student getStudent(){
		return user;
	}
	
	public Instrument getInst(){
		return inst;
	}
	public Calendar getCalendar(){
		return checkout;
	}
        @Override
       public String toString(){
           return "Order \r\n\t"+user.toString()+"\r\n\t" + "Instrument\t "+ inst.type + inst.id + checkout.toString();
       }
}
