package backlogics;
import java.util.*;
public class Run {

	private List<Student> students;
	private List<Order> orders;
	private List<Instrument> insts;
	private Scanner input;
	
	public Run(){
		students = new ArrayList<>();
		orders = new ArrayList<>();
		insts = new ArrayList<>();
                input = new Scanner(System.in);
	}
	
	public boolean authenticate(){
		System.out.println("This action require privilege to continue.\nEnter Admin Password");
                String password = input.nextLine();
                return "admin888".equals(password);
	}

	public void addStudent(String name, String mobile, String gender, String org, String id){
		students.add(new Student(name, mobile, gender, org, id));
	}
	
	public Student findStudent(String id){
		for(int i=0; i<students.size(); i++){
			if (id.equals(students.get(i).getId()));
			return students.get(i);
		}
		return null;
	}
	
	public String[] checkOut(String id, String insType){
		Student stu = findStudent(id);
		if(stu == null){
			System.out.println("Student not exist");
			return new String []{"-1","Student not exist"};		//Student not exist
		}
		if(stu.getCredit()<60){
			System.out.println("Insufficient credit");
			return new String[]{"-2","Insufficient credit"};		//Insufficient credit
		}
		if(stu.getStack().size()>3){
			System.out.println("Too many orders");
			return new String[]{"-3","Too many orders"};		//Too many orders 
		}
		int i=0;
		boolean hasFound = false;
		Instrument ins = null;
		while(i<insts.size()){
			if (insts.get(i).getType() == null ? insType == null : insts.get(i).getType().equals(insType)){
				hasFound = true;
				ins = insts.get(i);
			}
                    i++;
		}
		if(!hasFound){
			System.out.println("Insufficient instruments");
			return new String[]{"-4","Insufficient instruments"};		//Insufficient instruments
		}
		Order order = new Order(stu, ins);		//new order
		stu.getStack().add(order);				//add order to student stack
		orders.add(order);						//add order to system global stack
		System.out.println("OK");
		return new String[]{"0","OK"};
	}
	

	public String[] checkIn(String id, int health){
		Order order = null;
		for(int i=0;i<orders.size();i++){
			if(orders.get(i).getInst().getId().equals(id)){
				order = orders.get(i);
				System.out.print("i");
				break;
			}
		}
		if (order == null){
			System.out.println("Order not found");
			return new String[]{"-1","Cannot find the order"};			//Cannot find the order
		}
		Calendar checkout = order.getCalendar();
		checkout.add(Calendar.HOUR, 24);
                if (checkout.compareTo(Calendar.getInstance())<0){ // If the checkout time +24 hrs < now time => time out!
			order.getStudent().modifyCredit(-3);
			order.getStudent().getStack().remove(order);
			order.getInst().modifyHealth(order.getInst().getHealth()-health);
			orders.remove(order);
			System.out.println("Timeout!");
			return new String[]{"1","Completed with warning of timeout"};		//Completed with warning of timeout
		}
		order.getStudent().getStack().remove(order);
		order.getInst().modifyHealth(order.getInst().getHealth()-health); //Whenever the inst is damaged, take the same credit value damage to the user
		orders.remove(order);
		System.out.println("OK");
		return new String[]{"0", "OK"};			//Completed successfully.
	}
	
	public void addInst(String type, String id){
		insts.add(new Instrument(type, id));		//Add available instruments
	}

	public void listStudents(){
            for(int i=0;i<students.size();i++){
                System.out.println(students.get(i).toString());
            }
	}
        
    public String runStatistics(){
            String str="";
            for(int i=0;i<students.size();i++){
                str+= (students.get(i).toString()+"\r\n");
            }
            str+="\r\n\r\n";
            for(int i=0;i<insts.size();i++){
                str+= (insts.get(i).toString()+"\r\n");
            }
            str+="\r\n\r\n";
            for(int i=0;i<orders.size();i++){
                str+= (orders.get(i).toString()+"\r\n");
            }
            return str;
        }

}
