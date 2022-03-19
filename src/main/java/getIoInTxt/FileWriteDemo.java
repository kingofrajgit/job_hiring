package getIoInTxt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteDemo {

	public static void main(String[] args) throws IOException {
		
		String name = "Naresh";
		String department = "MECH";
		int year = 2006;
		String folder="E:\\studentsData.txt";

		String studentDetails = name + "," + department + "," + year;

		byte[] content = studentDetails.getBytes();

		Path path = Paths.get(folder);

		Files.write(path, content);

	} 
}
