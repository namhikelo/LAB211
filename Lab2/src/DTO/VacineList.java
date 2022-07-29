
package DTO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class VacineList {
    public static ArrayList<Vacine> listV = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    
    public void loadVaccineFromFile (String fName){
        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fName)));
            FileInputStream fileInputStream = new FileInputStream(fName); //Doc du lieu tinh theo byte
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream); // Nhan doc ky tu 
            BufferedReader br = new BufferedReader(inputStreamReader); // doc het dong co trong file
            String line;
            while ((line = br.readLine()) != null) {                
                String [] parts = line.split(",");
                String idVaccine = parts[0];
                String nameVaccine = parts[1];
                Vacine newVaccine = new Vacine(idVaccine.toUpperCase(), nameVaccine.toUpperCase());
                listV.add(newVaccine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void disPlayAll(){
        System.out.printf("|%-12s|%-13s|\n", "ID Vaccine " , "Name Vaccine ");
        for (Vacine a : listV) {
            System.out.println(a.toString());
        }
        System.out.println("Total: " + listV.size() + " item(s).");
    }
    
    public Vacine findId (String Id){
        Id = Id.trim().toUpperCase();
        for (int i = 0; i < listV.size(); i++) {
            if (listV.get(i).getvID().equals(Id)) {
                return listV.get(i);
            }
        }
        return null;
    }
    
    public boolean checkId(String code){
        code = code.trim().toUpperCase();
        return findId(code) !=null;
    }
}
