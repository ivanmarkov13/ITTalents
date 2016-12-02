import java.util.Scanner;

public class Task_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Брой редове:");
		int rows = sc.nextInt();
		while(rows < 1){
			System.out.println("Броят на редовете трябва да е положителен!");
			System.out.println("Въведете отново:");
			rows = sc.nextInt();
		}
		
		System.out.println("Брой колони:");
		int cols = sc.nextInt();
		while(cols < 1){
			System.out.println("Броят на колоните трябва да е положителен!");
			System.out.println("Въведете отново:");
			cols = sc.nextInt();
		}
		
		int[][] arr2d = new int[rows][cols];
		
		System.out.println("Въведете масива:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("елемент [" + i + "][" + j + "]:");
				arr2d[i][j] = sc.nextInt();
			}
		}
		
		int[][] arr2d90 = new int[cols][rows];
		
		for(int i = 0; i < arr2d90.length; i++){
			for(int j = 0; j < arr2d90[i].length; j++){
				arr2d90[i][j] = arr2d[rows - 1 - j][i];
			}
		}
		
		System.out.println("Новият масив е :");
		for(int i = 0; i < arr2d90.length; i++){
			for(int j = 0; j < arr2d90[i].length; j++){
				System.out.print(arr2d90[i][j] + " ");
			}
			System.out.println();
		}

	}

}
