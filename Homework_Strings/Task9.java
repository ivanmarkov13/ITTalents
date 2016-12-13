import java.util.Scanner;

public class Task9 {
	/**
	 * Ideq: cheta daden String ot konzolata. Sled tova go obhojdam simvol po simvol, i ako tekushtiqt simvol e 
	 * chislo, go dolepqm kum drug StringBuilder. Kogato prochete dadeno chislo, kum StringBuilder-a dolepqm
	 * ",". Taka v kraq imam edin StringBuilder s vsichki chisla ot purviq String, zaedno s tehniq znak.
	 * Posle pravq purviq String da sochi kum nov, koito da e sushtiq kato StringBuilder-a. Taka veche izpolzvam
	 * funkciqta split() za purvonachalniq String, i poluchavam masiv ot String-ove, razdeleni sus zapetaq,
	 * elementite na koito sa vsushtnost chisla.
	 * Nakraq vseki element ot tozi masiv go prevrushtam v chislo i go zapazvam v nov masiv, veche ot int.
	 * (edin simvol predstavlqva chislo, ako poredniq mu nomer ot ASCII tablicata mu e mejdu 48 i 57)
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string:");
		String str1 = sc.nextLine();
		
		StringBuilder str2 = new StringBuilder();
		
		for(int i = 0; i < str1.length(); i++){
			if(i > 0 && str1.charAt(i-1) > 47 && str1.charAt(i-1) < 58 && !(str1.charAt(i) > 47 && str1.charAt(i) < 58)){
				str2.append(',');
			}
			if(str1.charAt(i) > 47 && str1.charAt(i) < 58){
				str2.append(str1.charAt(i));
			}
			else
			if(str1.charAt(i) == '-' && str1.charAt(i+1) != '-'){
				str2.append(str1.charAt(i));
			}
			
			
		}
		
		str1 = new String(str2);
		
		String[] numString = str1.split(",");
		
		int[] numbers = new int[numString.length];
		
		for(int i = 0; i < numString.length; i++){
			int num = 0;
			int power = 1;
			for(int j = numString[i].length() - 1; j >= 0; j--){
				if(numString[i].charAt(j) == '-'){
					continue;
				}
				num += ((numString[i].charAt(j) - 48) * power);
				power *= 10;
			}
			if(numString[i].charAt(0) == '-'){
				num = -num;
			}
			numbers[i] = num;
		}
		
		int sum = 0;
		for(int i = 0; i < numbers.length; i++){
			System.out.println(numbers[i]);
			sum += numbers[i];
		}
		System.out.println("The sum is: " + sum);
 
	}

}
