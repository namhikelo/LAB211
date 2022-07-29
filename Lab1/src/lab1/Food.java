/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Kelo
 */
public class Food {
    private String id;
    private String name;
    private float weight;
    private String type;
    private int place;
    private Date expireddate;

    public Food(String id, String name, float weight, String type, int place, Date expireddate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expireddate = expireddate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Date getExpireddate() {
        return expireddate;
    }

    public void setExpireddate(Date expireddate) {
        this.expireddate = expireddate;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-4s|\n", "ID " , "Name " , "Date ","Weight ","Type ", "Place ");
       return String.format("|%-10s|%-10s|%-10s|%-10s|%-10s|%-4s|\n", id, name, df.format(expireddate), weight, type, place);
    }
    
    public void printf(){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-4s|\n", "ID " , "Name " , "Date ","Weight ","Type ", "Place ");
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-4s|\n", id , name ,df.format(expireddate), weight,type, get(place));
        
        
    }

    public String get(int place){
        switch(place){
            
            case 1:
                return "Freezer";
                
            case 2:
                return "Freezer Door";
                
            case 3:
                return "Regular";
        }
        return null;
    }
    
}
