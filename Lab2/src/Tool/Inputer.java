
package Tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import DTO.VacineList;
/**
 *
 * @author Admin
 */
public class Inputer {
    public static Scanner sc = new Scanner(System.in);
    public static int checkInputLimit (String msg, int a, int b){
        while (true) {            
            try {
                System.out.println(msg);
                int result = Integer.parseInt(sc.nextLine().trim().toLowerCase());
                if (result < a || result > b){
                    throw new NumberFormatException();
                }   
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + a + ", " + b + "]");
                System.out.println("Enter again: ");
            }
        }
    }    
    
    public static String inputString (String msg, String errmsg){
        String id;
        while (true) {            
            System.out.print(msg);
            id = sc.nextLine().toUpperCase().trim();
            if (id.length() == 0 || id.isEmpty() || id.isBlank()){
                System.out.println(errmsg);
            } else {
                return id;
            }
        }
    }
    
    public static String inputVaccineID(String msg, VacineList vaclist){
        String data;
        do {            
            System.out.println(msg);
            vaclist.disPlayAll();
            data= sc.nextLine().trim().toLowerCase();
            if (!vaclist.checkId(data)) 
                System.out.println("Vaccine not exist !");
        } while (!vaclist.checkId(data));
        return data;  
    }    
    
    public static Date getDate (String msg, String errmsg, String format){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date;
        df.setLenient(false);
        while (true) {            
            try {
                System.out.println(msg);
                date = sc.nextLine();
                df.parse(date);
                return df.parse(date);
            } catch (ParseException e) {
                System.out.println(errmsg);
            }      
        }
    }
   
    public static long Checkday(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        long Checkday = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        return Checkday; 
   }    
}
