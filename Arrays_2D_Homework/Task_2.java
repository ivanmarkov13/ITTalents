import java.util.Scanner;

public class Task_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Въведете размерност на масива:");
		int n = sc.nextInt();
		
		while(n < 1){
			System.out.println("Размерността трябва да е положителна:");
			System.out.println("Моля, въведете отново:");
			n = sc.nextInt();
		}
		
		int[][] arr2d = new int[n][n];
		
		System.out.println("Въведете масива:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("елемент [" + i + "][" + j + "]:");
				arr2d[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Главен диагонал:");
		for(int i = 0, j = 0; i < arr2d.length; i++, j++){
			System.out.print(arr2d[i][j] + " ");
		}
		
		System.out.println();
		
		System.out.println("Обратен диагонал:");
		for(int i = 0, j = arr2d.length - 1; i < arr2d.length; i++, j--){
			System.out.print(arr2d[i][j] + " ");
		}
		
		System.out.println();
		
	}

}
