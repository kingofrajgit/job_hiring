package getIoInTxt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadDemo {

	public static void main(String[] args) throws FileNotFoundException {
		 try {
		File obj = new File("E:\\studentsData.txt"); 
		Scanner sc= new Scanner(obj);

		while(sc.hasNextLine()) {
		String str =sc.nextLine();
			
			System.out.println(str);
		}
		 }catch(Exception e){
			 
		 }


}
}