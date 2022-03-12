package user;
import inputs.GetInput;
import inputs.God;
public class User {

	public static void main(String[] args) {
		System.out.println("hffkjhoiuhfs");
		GetInput getInput=new God(null, null, null, null, null, null, null);
		int option = 0;
		
		while (true) {
			option = getInput.getInput();
			try {
				switch(option) 
				{
					
					case 1:
						
						break;
						
					case 2:
						getInput.registerValitation();
						break;
						
					default:
						
						break;
					
				
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}

}
