import java.text.DecimalFormat;
import java.util.Scanner;

public class Task_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("Enter number of rows:");
		int rows = sc.nextInt();
		while(rows < 1){
			System.out.println("The number of rows must be positive!");
			System.out.println("Enter again:");
			rows = sc.nextInt();
		}
		
		System.out.println("Enter number of columns");
		int columns = sc.nextInt();
		while(columns < 1){
			System.out.println("The number of columns must be positive");
			System.out.println("Enter again:");
			columns = sc.nextInt();
		}
		
		double[][] arr2d = new double[rows][columns];
		
		double sum = 0;
		
		System.out.println("Enter the array:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("element [" + i + "][" + j + "]");
				arr2d[i][j] = sc.nextDouble();
				sum += arr2d[i][j];
			}
		}
		
		System.out.println("the sum of all elements of the array is: " + sum);
		System.out.println("the average of all elements of the array is: " + df.format(sum/(rows * columns)));
	}

}
