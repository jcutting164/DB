import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Time {
	public String getTime(){
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd:HH|mm|ss").format(Calendar.getInstance().getTime());
		String[] first = timeStamp.split(":");
		String clock = first[1];
		String[] time = clock.split("\\|");
		String actTime = time[0] + ":" + time[1] +"."+ time[2]+"";
		return actTime;
	}
	public String getDate(){
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd:HH|mm|ss").format(Calendar.getInstance().getTime());
		String[] second = timeStamp.split(":");
		String date = second[0];
		String[] time = date.split("/");
		String actDate = time[2] + ":" + time[1] +"."+ time[0]+"";
		return actDate;
	}
	
	public String getShortDate(){
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd:HH|mm|ss").format(Calendar.getInstance().getTime());
		String[] date = timeStamp.split(":");
		String temp = date[0];
		date = temp.split("/");
		String shortDate = date[2] + "/" + date[1];
		System.out.println("The current date is: "+shortDate);
		return shortDate;
	}
}
