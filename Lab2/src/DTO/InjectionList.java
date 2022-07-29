
package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import Tool.Inputer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class InjectionList implements Serializable{
    public static ArrayList<Injection> Listemp = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    
    String newInjectionID = "",newStudentID ="", newFirstPlace ="", newSecondPlace = "", newVaccineID="";
    Date newDate1st, newDate2nd ;

    VacineList vac = new VacineList(); // Goi class co bien la vac
    StudentList stu = new StudentList();
    
    public InjectionList(String vaccineFileName, String studentFileName) {
        vac.loadVaccineFromFile(vaccineFileName);
        stu.loadStudentFromFile(studentFileName);
        //để tạo đường dẫn mặc định cho 2 cái file
    }
    
    public Injection findByStudentId (String Id){
        Id = Id.trim().toUpperCase();
        for (int i = 0; i < Listemp.size(); i++) {
            if(Listemp.get(i).getStudentId().equals(Id)){
                return Listemp.get(i);
            }
        }
        return null;
    } 

    public int findInjectionId (String Id){
        Id = Id.trim();
        for (int i =0; i <Listemp.size(); i++){
            if (Listemp.get(i).getInjectionId().equals(Id))
                return i;
        }
        return -1;
    }
    
    public boolean isIDDuplicated(String id) {
        return findInjectionId(id) != -1; // trung 
    }
    
    public void addInjection(){
        do {            
            newInjectionID = Inputer.inputString("Input InjectionID: ", "Not null !! Please try again.");
            if (isIDDuplicated(newInjectionID)) {
                System.err.println("InjectionID is dupplicated !!");
            }
        } while (isIDDuplicated(newInjectionID));
                
        newVaccineID = Inputer.inputVaccineID("Input VaccineID: ", this.vac);       
        do{
            newStudentID = Inputer.inputString("Input StudentID: ", "Not null !! Please try again.");
            if(!stu.checkId(newStudentID)){
                System.out.println("StudentID does not exist !!");
            } else if(findByStudentId(newStudentID) != null){
                System.out.println("This student has became antivaxxer");
            } else{
                break;
            }
        }while(true);
        newFirstPlace = Inputer.inputString("Input FirstPlace: ", "Not null !! Please try again.");        
        newDate1st = Inputer.getDate("Input Date1st: (dd-MM-yyyy) ", "Date not null !! Please try again and Focus format(Not null or Not Special characters).", "dd-MM-yyyy");         
        Listemp.add(new Injection(newInjectionID, newStudentID, newFirstPlace, newSecondPlace, newVaccineID, newDate1st, newDate2nd));        
        System.out.println("-----------Add Successfully!!-----------");
        System.out.println("----------------------------------------");
    }

    public void disPlayALl(String fname){
        StudentList list = new StudentList();
        list.loadStudentFromFile("ListStudent.dat");
        list.printStudentList();        
    }
    
    public void searchByStudentID(){
        int s = 0;
        if(Listemp.isEmpty()){
            System.out.println("Null!! Nothing to search");
        }else {
            String id = Inputer.inputString("Input the student ID: ", "Input invalid !");
            for (Injection x : Listemp) {
                if (x.getStudentId().equals(id)) {
                    System.out.println(printFormat());
                    System.out.println(x.toString());
                    s++;
                    return;
                }
            }
            if (s ==0){
                System.out.println("This ID Student does not exist!");
            }
        }  
    }        
    
    public void remove(){
        int pos;
        if(Listemp.isEmpty()){
            System.out.println("The list is empty !!!");
        } else {
            newInjectionID = Inputer.inputString("Input ID to remove: ", "Not null or Wrong format !! Please try again. ");
            pos = findInjectionId(newInjectionID);
            if(pos == -1){
                System.out.println("The ID doesn't exist !!!");
            } else {
                while (true) {                    
                    String warning = Inputer.inputString("Are you sure to remove?__Please input (Y/N)", "Not null or Wrong format !! Please try again. ");
                    if (warning.equalsIgnoreCase("Y")){
                        Listemp.remove(pos);
                        System.out.println("Success");
                        break;
                    }else if (warning.equalsIgnoreCase("N"))
                        break;
                }
            }
        }            
    }        
    
    public Injection SearchtoUpdate(String Id){
        if (Listemp.isEmpty()){
            return null;
        }
        
        for (int i = 0; i < Listemp.size(); i++) {
            if (Listemp.get(i).getInjectionId().equalsIgnoreCase(Id))
                return Listemp.get(i);
        }
        return null;
    }
    
    public void update(){
        String id;
        String secondInjPlace;
        Date secondInjDate;
        Injection x;
        if (Listemp.isEmpty()){
            System.out.println("The list injection is empty! Nothing to update.");
            return;
        }
        id = Inputer.inputString("Input ID injection to update: ", "Not null!! Please try again");       
        x = SearchtoUpdate(id);     
        if (x == null){
            System.out.println("Injection does not exist");
        } else if (x.date1st !=null && x.date2nd !=null) {
            System.out.println("Have 2 Injection !!");
            System.out.println("Can't to update ");
        } else {
            secondInjPlace = Inputer.inputString("Input Second Place: ", "Not null !! Please try again.");            
            long date2Valid = 0;
            do {                 
                secondInjDate = Inputer.getDate("Input Date2nd: (dd-MM-yyyy) ", "Date not null !! Please try again and Focus format(Not null or Not Special characters).", "dd-MM-yyyy");
                date2Valid  = Inputer.Checkday(x.getDate1st(), secondInjDate);
                if (date2Valid < 28 || date2Valid > 84) {
                    System.out.println("The second dose of vaccine must be given 4 to 12 weeks after the first injection!!");
                    System.out.println("Please try again.");
                }
            } while (date2Valid < 28 || date2Valid > 84);
            
            x.setSecondPlace(secondInjPlace);
            x.setDate2nd(secondInjDate);
            System.out.println("The injection information is updated successfully!");            
        }            
    }
        
    public void savetoFile(){
        if(Listemp.isEmpty()){
            System.out.println("Null");
        }else{ 
            System.out.println("Type in Name of file : ");
            String filename = sc.nextLine().trim();
            try {
                File f = new File(filename);
                FileWriter fw = new FileWriter(f);
                fw.write(printFormat());
                for (Injection e : Listemp) {
                    fw.write(e.toString());
                }
                System.out.println("Save successfull!");
                fw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public String printFormat(){
        return String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "InjectionID " , "StudentID " , "Vaccine Name ", "firstPlace ", "date1st ", "secondPlace ", "date2st ");  
    }
}
