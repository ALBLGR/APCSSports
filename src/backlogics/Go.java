package backlogics;
import java.util.*;
public class Go {

	public static void main(String[] args) {
		Run run = new Run();
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("Welcome to Sports Office.\n  Please enter what you want to do......");
			System.out.println("[1] Add a student\t[2] Add an instrument\n[3] Check-in    \t[4]Check-out\n[5] List Students");
			System.out.println("[0] Exit");
			switch(scan.nextLine()){
				case("0"):{
					System.exit(0);
					break;
				}
				case("1"):{
					System.out.println("Enter name [enter] moobile [enter] gender [enter] organization [enter] ID [enter]");
					run.addStudent(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
					break;
				}
				case("2"):{
					System.out.println("Enter instrument type [enter] ID [enter]");
					run.addInst(scan.nextLine(), scan.nextLine());
					break;
				}
				case("3"):{
					System.out.println("Enter ID [enter] health [enter]");
					run.checkIn(scan.nextLine(), scan.nextInt());
					break;
				}
				case("4"):{
					System.out.println("Enter ID [enter] Instrument Type [enter]");
					run.checkOut(scan.nextLine(), scan.nextLine());
					break;
				}
				case("5"):{
					run.listStudents();
					break;
				}
				default:{
					System.out.println("Please retry!");
				}
			}
			
		}
	}

}
