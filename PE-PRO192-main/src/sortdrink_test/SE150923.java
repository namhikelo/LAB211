package sortdrink_test;

public class SE150923 {
    public static void main(String[] args) {
       Menu menu = new Menu();  
       int choice;
        menu.addItem("Add the least 4 new soft drink");
        menu.addItem("Printing our items with the highest unit price");
        menu.addItem("Update a soft drink based on a name inputted");
        menu.addItem("Print the list in ascending order based on volumes then prices.");
        menu.addItem("Delete soft drinks of  company entered by user.");
        SoftDrinkList list = new SoftDrinkList();
        do {
            choice =menu.getChoice();
            switch(choice){
                case 1: 
                    list.add();
                    break;
                case 2:
                    list.getHighprice();
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.printAscending();
                    break;
                case 5:
                    list.remove();
                    break;
            }
        }while (choice >0 && choice <7);
    }   
}
