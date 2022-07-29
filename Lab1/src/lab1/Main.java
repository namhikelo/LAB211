package lab1;
import java.util.Scanner;
/**
 *
 * @author Kelo
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int Menu (){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Welcome to Food Management - @ 2021 by <Se150923- Student Phan Hoàng Nam >");
        System.out.println("1.  Add a new food");
        System.out.println("2.  Search a food by name");
        System.out.println("3.  Remove the food by ID");
        System.out.println("4.  Print the food list in the descending order of expired date");
        System.out.println("5.  Save file and Print");
        System.out.println("6.  Quit");
        int choice = Input.checkInputLimit("Enter your choice: ", 1, 6);        
        return choice;
    }
    public static void main(String[] args) {
        FoodManager list = new FoodManager();
        while (true) {            
            int choice = Menu();
            switch(choice){
                case 1:
                    System.out.println("--------------------------------------------------------------------------");
                    list.addFood();
                    break;
                    
                case 2:
                    System.out.println("--------------------------------------------------------------------------");
                    list.searchByName();
                    break;
                    
                case 3:
                    System.out.println("--------------------------------------------------------------------------");
                    list.remove();
                    break;
                    
                case 4:
                    System.out.println("--------------------------------------------------------------------------");
                    list.sort();
                    break;
                    
                case 5:
                    System.out.println("--------------------------------------------------------------------------");
                    String fileName = Input.inputString("Enter file name: ", "Input Invalid!");
                    list.saveFile(fileName);
                    break;
                    
                case 6:
                    return;
            }
        }
    }
}
