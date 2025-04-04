package json.com.validate_email;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\validate_email\\file.json";
		
		try {
			List<String> email = JsonReader.getField(filePath);
			for(int i=0;i<email.size();i++) {
				String accessEmail = email.get(i);
				boolean valid = ValidateEmail.isValid(accessEmail);
				if(valid) {
					System.out.println(accessEmail +": valid");
				}
				else {
					System.out.println(accessEmail +": Not Valid");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
