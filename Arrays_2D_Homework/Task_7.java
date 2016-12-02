import java.util.Scanner;

public class Task_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][]  arr2d = new int[6][6];
		System.out.println("Enter the array:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("element [" + i + "][" + j + "]:");
				arr2d[i][j] = sc.nextInt();
			}
		}
		
		int sum = 0;
		int sumSum = 0;
		
		for(int i = 0, j = 0; i < arr2d.length; j++){
			if((i + j) % 2 == 0){
				System.out.print(arr2d[i][j] + " ");
				sum += arr2d[i][j];
			}
			
			if (j == 5){
				i++;
				j = -1;
				System.out.println(", sum of the elements of this row: " + sum);
				sumSum += sum;
				sum = 0;
			}
		}
		
		System.out.println("Sum of the elements: " + sumSum);

	}

}
