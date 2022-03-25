package jobHiring;

//inputs
import logic.UsersInput;

public class Main {

	public static void main(String[] args) throws Exception {
		UsersInput obj = new UsersInput();
		int a = obj.chosePrefernce();
		if(a == 1) {
			 a = obj.choseUser();
			switch(a) {
				case 1 :
					obj.validationCheckInput();
					break;
				case 2 :
					obj.loginCheck();
					break;
			}
		}
		else {
			a = obj.choseCompanys();
			switch(a) {
				case 1 :
					obj.companyInputValidationCheck();
					break;
				case 2 :
					obj.loginCheckCompany();
					break;
				
			}
			
		}
	}

}
