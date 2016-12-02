import java.util.Scanner;

public class Task_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][]  arr2d = new int[6][6];
		System.out.println("Въведете масива:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("елемент [" + i + "][" + j + "]:");
				arr2d[i][j] = sc.nextInt();
			}
		}
		
		int sum = 0;
		int sumSum = 0;
		
		for(int i = 0, j = 0; i < arr2d.length; j++){
			/*if(j > 5){
				j = 0;
				i++;
			}*/
			
			if((i + j) % 2 == 0){
				System.out.print(arr2d[i][j] + " ");
				sum += arr2d[i][j];
			}
			
			if (j == 5){
				i++;
				j = -1;
				System.out.println(", сума на елементите за реда: " + sum);
				sumSum += sum;
				sum = 0;
			}
		}
		
		System.out.println("Сума на елементите: " + sumSum);

	}

}
