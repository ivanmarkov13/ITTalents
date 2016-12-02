import java.text.DecimalFormat;
import java.util.Scanner;

public class Task_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("Въведете брой редове:");
		int rows = sc.nextInt();
		while(rows < 1){
			System.out.println("Броят на редовете трябва да е положителен!");
			System.out.println("Въведете отново:");
			rows = sc.nextInt();
		}
		
		System.out.println("Въведете брой колони");
		int columns = sc.nextInt();
		while(columns < 1){
			System.out.println("Броят на колоните трябва да е положителен!");
			System.out.println("Въведете отново:");
			columns = sc.nextInt();
		}
		
		double[][] arr2d = new double[rows][columns];
		
		double sum = 0;
		
		System.out.println("Въведете масива:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("елемент [" + i + "][" + j + "]");
				arr2d[i][j] = sc.nextDouble();
				sum += arr2d[i][j];
			}
		}
		
		System.out.println("сумата на всички елементи от масива е: " + sum);
		System.out.println("ср. аритметично на елементите от масива е: " + df.format(sum/(rows * columns)));
	}

}
