import java.text.DecimalFormat;
import java.util.Scanner;

public class Task_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("�������� ���� ������:");
		int rows = sc.nextInt();
		while(rows < 1){
			System.out.println("����� �� �������� ������ �� � �����������!");
			System.out.println("�������� ������:");
			rows = sc.nextInt();
		}
		
		System.out.println("�������� ���� ������");
		int columns = sc.nextInt();
		while(columns < 1){
			System.out.println("����� �� �������� ������ �� � �����������!");
			System.out.println("�������� ������:");
			columns = sc.nextInt();
		}
		
		double[][] arr2d = new double[rows][columns];
		
		double sum = 0;
		
		System.out.println("�������� ������:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("������� [" + i + "][" + j + "]");
				arr2d[i][j] = sc.nextDouble();
				sum += arr2d[i][j];
			}
		}
		
		System.out.println("������ �� ������ �������� �� ������ �: " + sum);
		System.out.println("��. ����������� �� ���������� �� ������ �: " + df.format(sum/(rows * columns)));
	}

}
