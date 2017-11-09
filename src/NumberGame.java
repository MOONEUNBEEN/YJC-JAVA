
import java.util.*;

public class NumberGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int answer = 59;
		int guest;
		int count = 0;
		
		do {
			System.out.println("What is the correct answer?");
			guest = input.nextInt();
			count++;
			
			if (guest < answer) {
				System.out.println("The present integer is low.");
			}
			if (guest > answer) {
				System.out.println("The present integer is high.");
			}
		} while (guest != answer);
		System.out.printf("Congratulations! Number of attempts: %d", count);
	}

}
