
package DTO;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Student implements Serializable{
    private String idS;
    private String nameS;

    public Student(String idS, String nameS) {
        this.idS = idS;
        this.nameS = nameS;
    }

    public String getIdS() {
        return idS;
    }

    public void setIdS(String idS) {
        this.idS = idS;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) {
        this.nameS = nameS;
    }

    @Override
    public String toString() {
        return String.format("|%-20s|%-20s|\n", idS, nameS);
    }
}
