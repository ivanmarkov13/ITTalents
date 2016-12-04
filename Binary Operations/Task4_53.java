import java.util.Scanner;

public class Task4_53 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		num >>= 4;
		
		boolean iSOne = (num & 1) == 1;
		
		System.out.println(iSOne);

	}

}
