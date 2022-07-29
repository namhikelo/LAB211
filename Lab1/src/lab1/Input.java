package lab1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Kelo
 */
public class Input {
    public static Scanner sc = new Scanner(System.in);
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    
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
    
    public static float checkFloat (String msg){
        while (true) {            
            try {
                System.out.println(msg);
                float result = Float.parseFloat(sc.nextLine().trim());
                if (result <= 0){
                    System.out.println("Number cannot be less than 0 !!!");
                    throw new NumberFormatException();
                }else if (result > 1000){
                    System.out.println("Number so big: "+ result + "> 1000  ");
                    throw new NumberFormatException();
                } 
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please try again and Focus format(Weight Not null or Not Special characters).");
            }
        }
    }
    
    public static String inputString (String msg, String errmsg){
        String id;
        while (true) {            
            System.out.print(msg);
            id = sc.nextLine().toLowerCase().toUpperCase().trim();
            if (id.length() == 0 || id.isEmpty() || id.isBlank()){
                System.out.print(errmsg);
            } else {
                return id;
            }
        }
    }
    
    public static boolean getYesNo(){
        while (true) {            
            String result = inputString("Do you want to try again!! (Y/N)", "Please try again and Focus format");
            if (result.equalsIgnoreCase("Y".toLowerCase())) {
                return true;
            } else if (result.equalsIgnoreCase("N".toLowerCase())){
                return false;
            } 
            System.out.println("Please Input: ");  
        }
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
    
    public static boolean checkDate (Date date){
        SimpleDateFormat df =new SimpleDateFormat(DATE_FORMAT);
        String DateString = df.format(date); // Dinh dang kieu date thanh kieu string
        String DateNow = df.format(new Date());
        if (DateString.equals(DateNow)){
            return true;
        }
        return !date.before(new Date());
    }
}
