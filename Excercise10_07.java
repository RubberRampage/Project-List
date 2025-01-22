import java.util.*;
public class Excercise10_07 {
    private Account[] accounts;
    int id;
	public static void main(String[] args) {
		new Excercise10_07(); // annonymous object  
	}	
	public Excercise10_07() {
	    accounts = new Account[10];
	    for (int i=0; i<accounts.length; i++) {
	        accounts[i] = new Account();
	        accounts[i].setId(i);
	        accounts[i].setBalance(100);
	    }
	    
	    Scanner input = new Scanner(System.in);
	
		while (true) {
		    System.out.print("Enter an id: ");
		    id = input.nextInt();
		    if (id < 0 || id > 9) {
		        System.out.println("Please enter a correct id.");
		        continue;
		    }
		    else {
    		    int choice;
        		do {
        		    System.out.println("Main menu");
                    System.out.println("1: check balance");
                    System.out.println("2: withdraw");
                    System.out.println("3: deposit");
                    System.out.println("4: exit");
                    System.out.print("Enter a choice: ");
                    choice = input.nextInt();
        		} while (choice < 0 || choice > 4);
		    }
		}
	}
}