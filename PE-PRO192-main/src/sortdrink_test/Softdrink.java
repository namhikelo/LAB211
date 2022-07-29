package sortdrink_test;

public class Softdrink implements Comparable<Softdrink>{
    private String code;
    private String name;
    private String make;
    private double volume;
    private double price;
    private String company;

    public Softdrink() {
    }

    public Softdrink(String code, String name, String make, double volume, double price, String company) {
        this.code = code;
        this.name = name;
        this.make = make;
        this.volume = volume;
        this.price = price;
        this.company = company;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
    return "Code: "+ code+ " - " +"Name: " + name + " - " + "Make: " + make + " - " + "Volume: " + volume + " - " + "Price: " + price+" - " +"Company: "+company ;
    }

    @Override
    public int compareTo(Softdrink o) {
        Softdrink lap = (Softdrink) o;
        if (this.volume > lap.getVolume()) {
            return 1;
        } else if (this.volume == lap.getVolume()) {
            if (this.price > lap.getPrice()) {
                return 1;
            } else if (this.price == lap.getPrice()) {
                return 0;
            } else {
                return -1;
            }
        }
        else return -1;
    }
    
}
