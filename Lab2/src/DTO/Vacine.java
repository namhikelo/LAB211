
package DTO;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Vacine implements Serializable{
    private String vID;
    private String vName;

    public Vacine() {
    }

    public Vacine(String vID, String vName) {
        this.vID = vID;
        this.vName = vName;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    @Override
    public String toString() {
        return String.format("|%-20s|%-20s|\n", vID, vName);
    }
}
