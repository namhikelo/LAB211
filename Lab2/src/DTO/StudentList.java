
package DTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class StudentList {
    public ArrayList<Student> listS = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);
    private String currentPath = System.getProperty("user.dir");
    public void loadStudentFromFile (String fName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(currentPath + "\\"+ fName)));
            String line;
            while ((line = br.readLine()) != null){
                String [] parts = line.split(",");
                String idStudent = parts[0];
                String nameStudent = parts[1];
                listS.add(new Student(idStudent.trim(), nameStudent.toLowerCase().trim()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Student findId (String Id){
        Id = Id.trim().toUpperCase();
        for (int i = 0; i < listS.size(); i++) {
            if(listS.get(i).getIdS().equals(Id)){
                return listS.get(i);
            }
        }
        return null;
    }
  
    public boolean checkId(String code){
        code = code.trim().toUpperCase();
        return findId(code) != null;
    }
    
    public boolean checkName(String name){
        for(Student x : listS){
            if(x.getNameS().trim().toLowerCase().equals(name.toLowerCase().trim())){
                return true;
            }
        }
        return false;
    }
    
    public void printStudentList(){
        System.out.println(String.format("|%-20s|%-20s|\n", "IdStudent " , "Name Student "));
        for (Student x : listS) {
            System.out.println(x.toString());
        }
        System.out.println("Total: " + listS.size() + " item(s).");
    }
}
