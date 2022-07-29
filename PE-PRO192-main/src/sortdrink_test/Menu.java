package sortdrink_test;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    ArrayList menuList = new ArrayList<>();
    
    public Menu() {
    }
    
    public void addItem(String s){
        menuList.add(s);
    }

    public int getChoice(){
        int choice;
        for(int i = 0; i < menuList.size(); i++){
            System.out.println("[" + (i+1) + "]" + menuList.get(i));
        }
        System.out.println("Input choice");
        return in.nextInt();
    }
}
