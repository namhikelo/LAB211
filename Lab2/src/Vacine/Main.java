package Vacine;
import Tool.Inputer;
import DTO.InjectionList;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int Menu(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Welcome to Covid-19 Vaccine Management - @ 2021 by <Se150923- Student Phan Hoàng Nam >");
        System.out.println("1.  Show informationa all student prepare to inject.");
        System.out.println("2.  Add student's vaccine injection information ");
        System.out.println("3.  Update the information of students' vaccine injection. ");
        System.out.println("4.  Delete student's vaccine injection information.");
        System.out.println("5.  Search for the injection information by using studentID.");
        System.out.println("6.  Save to file.");
        System.out.println("7.  Quit!!.");
        int choice = Inputer.checkInputLimit("Enter your choice: ", 1, 7);
        return choice;
    }
    
    public static void main(String[] args) {
        InjectionList list = new InjectionList("Vaccine.dat","ListStudent.dat");
        while (true) {            
            int choice = Menu();
            switch (choice){
                case 1:
                    System.out.println("--------------------------------------------------------------------------");
                    list.disPlayALl("ListStudent.dat");
                    break;
                    
                case 2:
                    System.out.println("--------------------------------------------------------------------------");
                    list.addInjection();
                    break;
                
                case 3:
                    System.out.println("--------------------------------------------------------------------------");
                    list.update();
                    break;
                    
                case 4:
                    System.out.println("--------------------------------------------------------------------------");
                    list.remove();
                    break;
                    
                case 5:
                    System.out.println("--------------------------------------------------------------------------");
                    list.searchByStudentID();
                    break;
                
                case 6:
                    System.out.println("--------------------------------------------------------------------------");
                    list.savetoFile();
                    break;  
                    
                case 7:
                    return;
            }
        }
    }
}