package sortdrink_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SoftDrinkList{
    Scanner sc = new Scanner(System.in);
    private final ArrayList<Softdrink> listemp = new ArrayList<>();

    public SoftDrinkList() {
        super();
    }
    
    public double InputValid() {
        boolean cont = true;
        double n = 0;
        do {
            try {
                n = Double.parseDouble(sc.nextLine());
                cont = false;
            } catch (NumberFormatException e) {
                System.out.println("\tRequired right format!");
                System.out.print("\tEnter again: ");
            }
        } while (cont == true);
        return n;
    }
    
    public int find(String aCode){
        for (int i = 0; i < listemp.size(); i++) {
            if (aCode.equals(listemp.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }
    
    public void add(){
        Integer time = 0;                              
        try{
            do{
                String newName, newMake,newCode,newCompany;
                Double newVolume, newPrice;
                System.out.println("Enter the code: ");
                newCode = sc.nextLine().toUpperCase();
                System.out.print("Enter the softdrink's name: ");
                newName = sc.nextLine().toUpperCase();
                System.out.print("Enter where softdrink made: ");
                newMake = sc.nextLine().toUpperCase();
                System.out.print("Enter volume (ml) of softdrink: ");
                newVolume=InputValid();
                System.out.print("Enter price (VND) of softdrink: ");
                newPrice=InputValid();
                System.out.print("Enter the company: ");
                newCompany = sc.nextLine();
                listemp.add(new Softdrink(newCode,newName, newMake, newVolume, newPrice, newCompany));
                System.out.println("\tNew softdrink had been added.");
                time++;
            }while(time < 4);
        } catch(Exception e){
            System.out.println("Invalid Format!");  
        }         
    }
    
    public void update(){
        String updateName;
        if (listemp.isEmpty()){
            System.out.println("EMPTY list");
            return;
        }
        System.out.println("Enter the employee's code want to update: ");
        updateName = sc.nextLine().toUpperCase();
        int pos = find(updateName);
        if (pos < 0){
            System.out.println("This employee does not existed.");
        }   else {
            String newName,newCode,newMake;
            double newVolume, newPrice;
                System.out.println("Enter the code: ");
                newCode = sc.nextLine().toUpperCase();
                listemp.get(pos).setCode(newCode);
                System.out.print("Enter the softdrink's name: ");
                newName = sc.nextLine().toUpperCase();
                listemp.get(pos).setName(newName);
                System.out.print("Enter where softdrink made: ");
                newMake = sc.nextLine().toUpperCase();
                listemp.get(pos).setMake(newMake);
                System.out.print("Enter volume (ml) of softdrink: ");
                newVolume=InputValid();
                listemp.get(pos).setVolume(newVolume);
                System.out.print("Enter price (VND) of softdrink: ");
                newPrice=InputValid();
                listemp.get(pos).setPrice(newPrice);
                System.out.println("The softdrink: "+ updateName + " was updated.");
        }
    }
    
    public void getHighprice(){
        Collections.sort(listemp, new Comparator<Softdrink>() {
            @Override
            public int compare(Softdrink o1, Softdrink o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        });
        System.out.println("-----LIST -----");
        for (Softdrink x : listemp){
            System.out.println(x.toString());
        }
    }

    public void printAscending(){
        if(listemp.size()<0){
            System.out.println("The List is Empty!!");
        }else{
            Collections.sort(listemp);
            listemp.forEach((x) -> {
                System.out.println(x);
            });
        }
    }
    
    public int remove(){
        String newCompany;
        int pos;
        System.out.println("Enter the company to remove : ");
        newCompany = sc.nextLine().toUpperCase();
        pos = find(newCompany);
        if (pos >=0){
            listemp.remove(pos);
            System.out.println("Removed");
        } else {
            System.out.println("Code is not exist");
            return 0;
        }
        return 1;
    }
}
