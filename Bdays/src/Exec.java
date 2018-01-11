import java.util.Scanner;


public class Exec {
	public static void main(String [] args){
		InsertTableData obj = new InsertTableData();
		Time time = new Time();
		Scanner scan = new Scanner(System.in);
		String command = "";
		String command2 = "";
		
		while(!command.equals("exit")){
			System.out.println("Enter your command... use exit to exit");
			command = scan.nextLine();
			if(command.equals("add new data")){
				obj.addData();
			}
		} 
		obj.findPeople();
		time.getShortDate();
		obj.checkBday();
	}
}
