package lab1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Kelo
 */
public class FoodManager {
    public static ArrayList<Food> listemp = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    String newId, newName, newType;     int newPlace;   float newWeight;   Date newDate;

    public FoodManager() {
        super();
    }
    
    public Food findId(String Id){
        Id = Id.trim().toLowerCase();
        for (int i = 0; i < listemp.size(); i++) {
            if(listemp.get(i).getId().equals(Id)){
                return listemp.get(i);
            }
        }
        return null;
    }
    
    public boolean checkId(String code){
        code = code.trim().toLowerCase();
        return findId(code) !=null;
    }
    
    public void addFood(){
        boolean codeDupplicated ;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        do {            
            newId = Input.inputString("Input Food's ID: ", "ID not null !! Please try again. ");
            codeDupplicated = checkId(newId);
            if (codeDupplicated){
                System.err.println("ID is dupplicated !!");
            }
        } while (codeDupplicated == true);
        
        newName = Input.inputString("Input Food's Name: ", "Name not null !! Please try again. ");
        newWeight = Input.checkFloat("Input Food's weight: [1 -> 1000 Kg ]");
        newType = Input.inputString("Input Food's type: ", "Type not null !! Please try again. ");
        newPlace = Input.checkInputLimit("Place: (1: Freezer ; 2: Freezer Door; 3 : Regular) : ", 1, 3);
        
        while (true) {           
            newDate = Input.getDate("Input Food's expired date: (dd-MM-yyyy) ", "Date not null !! Please try again and Focus format(Not null or Not Special characters).", "dd-MM-yyyy");
            if (!Input.checkDate(newDate)) {
                System.out.println("Error!! The expired date >  " + df.format(newDate)+ "  Please try again!!");
            } else {
                break;
            }
        }
        
        listemp.add(new Food (newId, newName, newWeight, newType, newPlace , newDate));
        System.out.println("-----------Add Successfully!!-----------");
        System.out.println("----------------------------------------");
        if(Input.getYesNo()){
            addFood();
        }
    }
    
    public void sort(){
        if (listemp.isEmpty()){
            System.out.println("The list is empty !!!");
        }
        Collections.sort(listemp, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
            if (o1.getExpireddate()== null || o2.getExpireddate()== null)
                    return 0;
            return o2.getExpireddate().compareTo(o1.getExpireddate());
            }
        });
        for (Food x : listemp) {
            System.out.println(x.toString());
        }        
    }
    
    public void remove (){
        if (listemp.isEmpty()){
            System.out.println("The list is empty !!!");
        } else {
            String code = Input.inputString("Input ID to remove: ", "Not null or Wrong format !! Please try again. ");
            Food st = findId(code);
            if (st == null){
                System.out.println("The ID doesn't exist !!!");
            } else {
                while (true) {                    
                    String warning = Input.inputString("Are you sure to remove?__Please input (Y/N)", "Not null or Wrong format !! Please try again. ");
                    if (warning.equalsIgnoreCase("Y")){
                        listemp.remove(st);
                        System.out.println("Success");
                        break;
                    }else if (warning.equalsIgnoreCase("N"))
                        break;
                }
            }
        }
    }
    
    public void searchByName (){
         int s = 0;     String code;
        if (listemp.isEmpty()){
            System.out.println("The list is empty !!!");
        } else {
            code = Input.inputString("Input Food's Name: ", "Not null !! Please try again. ");
            for (Food food : listemp) {
                    if (food.getName().toLowerCase().contains(code.toLowerCase())){
                    food.printf();
                    s++;
                }
            }   
            if (s ==0){
                System.out.println("This food does not exist!");
            }
        }
        if (Input.getYesNo()){
            searchByName();
        }
    }
    
    public void saveFile(String FileName){
        if (listemp.isEmpty()){
            System.out.println("The list is empty !!!");
        }
        try {
            FileWriter fw = new FileWriter(FileName);
            BufferedWriter bw = new BufferedWriter(fw); 
            for (Food food : listemp) {
                bw.write(food.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Save successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }
}
