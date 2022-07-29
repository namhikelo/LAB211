
package DTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Injection implements Serializable{
    public String injectionId = "";
    public String studentId = "";
    public String firstPlace = "";
    public String secondPlace = "";
    public String vaccineId = "";
    public Date date1st   ;
    public Date date2nd;

    public Injection() {
        super();
    }

    public Injection(String injectionId, String studentId, String firstPlace, String secondPlace, String vaccineId, Date date1st, Date date2nd) {
        this.injectionId = injectionId;
        this.studentId = studentId;
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.vaccineId = vaccineId;
        this.date1st = date1st;
        this.date2nd = date2nd;
    }

    public String getInjectionId() {
        return injectionId;
    }

    public void setInjectionId(String injectionId) {
        this.injectionId = injectionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Date getDate1st() {
        return date1st;
    }

    public void setDate1st(Date date1st) {
        this.date1st = date1st;
    }

    public Date getDate2nd() {
        return date2nd;
    }

    public void setDate2nd(Date date2nd) {
        this.date2nd = date2nd;
    }

    
    
    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date2ndDose = "";
        if(date2nd != null){
            date2ndDose = df.format(date2nd);
        }
        return String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", injectionId, studentId, getNameVaccine(vaccineId.toUpperCase()), firstPlace, df.format(date1st), secondPlace, date2ndDose);
    }
    
    public String getNameVaccine(String Namevaccine){
        switch(Namevaccine){
            case "COVID-V001":
                return "AstraZeneca";
                
            case "COVID-V002":
                return "Gam-COVID-Vac";
                
            case "COVID-V003":
                return "Vero Cell";
                
            case "COVID-V004":
                return "Comirnaty";   
                
            case "COVID-V005":
                return "Spikevax";
                
            case "COVID-V006":
                return "Janssen";    
        }
        return null;
    }
}
