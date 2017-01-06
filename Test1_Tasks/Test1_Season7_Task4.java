
public class Test1_Season7_Task4 {

	public static void main(String[] args) {
		char[][] arr = { 
				//      1    2    3    4    5    6    7    8
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*' },
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' }, // 1
				{ '*', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x', '*' }, // 2
				{ '*', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', '*' }, // 3
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' }, // 4
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' }, // 5
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' }, // 6
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' }, // 7
				{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' }, // 8
				{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*' } };
		System.out.println(isKingThreatened(arr, 1, 8, 8, 1));

	}

	static boolean placeKnight(char[][] arr, int i, int j) {
		if (i < 1 || i > 8 || j < 1 || j > 8) {
			return false;
		}
		if (arr[i][j] == 'R') {
			return true;
		}
		if(arr[i][j] != ' '){
			return false;
		}
		arr[i][j] = 'K';
		return(
				placeKnight(arr, i - 1, j - 2)	||
				placeKnight(arr, i + 1, j - 2) 	||
				placeKnight(arr, i - 1, j + 2)	||
				placeKnight(arr, i + 1, j + 2)	||

				placeKnight(arr, i - 2, j - 1)	||
				placeKnight(arr, i + 2, j - 1)	||
				placeKnight(arr, i - 2, j + 1)	||
				placeKnight(arr, i + 2, j + 1)	
				);		
		
	}

	static boolean isKingThreatened(char[][] arr, int kingI, int kingJ, int knightI, int knightJ) {
		arr[kingI][kingJ] = 'R';
		
		return placeKnight(arr, knightI, knightJ);
		
	}
}
