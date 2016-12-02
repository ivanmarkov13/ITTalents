import java.util.Scanner;

public class Task_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr2d = new int[6][6];
		
		System.out.println("Enter the array:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("element [" + i + "][" + j + "]");
				arr2d[i][j] = sc.nextInt();
			}
		}
		
		int sum = 0;
		int sumSum = 0;
		
		for(int i = 1; i < arr2d.length; i += 2){
			for(int j = 0; j < arr2d[i].length; j++){
				sum += arr2d[i][j];
				if(j < arr2d[i].length - 1){
					System.out.print(arr2d[i][j] + ", ");
				}
				else{
					System.out.print(arr2d[i][j]);
				}
			}
			System.out.println(" sum " + sum);
			sumSum += sum;
			sum = 0;
		}
		
		System.out.println("Sum of elements " + sumSum);
	}

}
