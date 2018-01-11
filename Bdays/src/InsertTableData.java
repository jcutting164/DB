import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertTableData
{
  public void addData()
  {
	// add data of birthday that is not the current day
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:people.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      Scanner scan = new Scanner(System.in);
      System.out.println("Name?");
      String name = scan.nextLine();
      name = '"'+name+'"';
      System.out.println(name);
      System.out.println("Birthday? (DD/MM/YYYY)");
      String bday = scan.nextLine();
      bday = '"'+bday+'"';
      System.out.println(bday);


      

      
      String sql = "INSERT INTO INFO (BIRTHDAY, NAME) " +
                   "VALUES ("+bday+", "+name+")"; 
      stmt.executeUpdate(sql);



      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
  
  
  
  
  
  
  public void addDataTD()
  {
	// add data of birthday that is not the current day
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:people.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      Scanner scan = new Scanner(System.in);
      System.out.println("Name?");
      String name = scan.nextLine();
      name = '"'+name+'"';
      System.out.println(name);

      // getting date for today, we need DD/MM/YYYY
      
      Time time = new Time();
      String bday = time.getDate();
      bday = '"'+bday+'"';

      
      String sql = "INSERT INTO INFO (BIRTHDAY, NAME) " +
                   "VALUES ("+bday+", "+name+")"; 
      stmt.executeUpdate(sql);



      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
  
  public void findPeople()
  {
	// finding people based on birthday
	// actual command:  SELECT * FROM INFO WHERE BIRTHDAY ==bday
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:people.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter birthday");
      String bday = scan.nextLine();
      bday = '"'+bday+'"';

     

      
      //String sql = "SELECT * FROM INFO WHERE BIRTHDAY=="+bday;
      String sql ="SELECT * FROM INFO WHERE BIRTHDAY=="+bday;
      ResultSet test = stmt.executeQuery(sql);
      
      while(test.next()){
    	  String str1 = test.getString(2);
    	  System.out.println(str1);
      }


      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Check successful");
  }
  
  
  public void checkBday()
  {
	// finding people based on birthday
	// actual command:  SELECT * FROM INFO WHERE BIRTHDAY ==bday
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:people.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      
      // get current date
     
      Time time = new Time();
      String currentDate = time.getShortDate();
      
      
      String sql ="SELECT * FROM INFO WHERE BIRTHDAY";
      ResultSet test = stmt.executeQuery(sql);
      String[] temp;
      while(test.next()){
    	  String str2 = test.getString(2);
    	  String str1 = test.getString(1);
    	  temp = str1.split("/");
    	  str1 = temp[0]+ "/" + temp[1];
    	  if(str1.equals(currentDate)){
    		  System.out.println(str2);
    	  }
      }
      


      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Check successful");
  }
  
  
  
}
