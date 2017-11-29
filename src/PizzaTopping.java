import java.util.Scanner;

public class PizzaTopping {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] toppings = {"Pepperoni", "Mushrooms", "Onions", "Sausage", "Bacon"};
		int[] menuCount = new int[5];
		int choicedMenu, selectedMenuCnt;
		
		while (true) {
			System.out.print("Please toppings choice:");
			for (int i=0; i<toppings.length; i++) {
				System.out.print(" " + (i+1));
				System.out.print("." + toppings[i]);
			}
			System.out.print(" 0.end");
			System.out.println();
			
			choicedMenu = scan.nextInt();
			
			if (choicedMenu <= 0) break;
			
			System.out.print("quantity: ");
			selectedMenuCnt = scan.nextInt();
			
			menuCount[choicedMenu-1] += selectedMenuCnt;
		}
		
		System.out.println("your's choiced toppings is..");
		for (int i=0; i<toppings.length; i++) {
			System.out.print(toppings[i]);
			System.out.print(" toppings: ");
			System.out.println(menuCount[i]);
		}
	}

}
