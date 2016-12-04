import java.util.Scanner;

public class Task5_53 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int num3 = num1 ^ num2;
		
		int counter = 0;
		
		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;

		counter += num3 % 2;
		num3 /= 2;
		
		counter = 32 - counter;
		
		System.out.println("The same bits are: " + counter);
	}

}
