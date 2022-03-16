package jobHiring;

import java.util.Scanner;

public class LoginInPuts{
	public static void main(String... args) {
		Scanner sc	=	new Scanner (System.in);
		int n	=	0;
		n	=sc.nextInt();
		int[] arr	=	new int[n]; 
		for (int i=0;i<n;i++) {
			arr[i]=i+1;
			//arr[0]=0;
			System.out.println(arr[i]);
		}
	}
}