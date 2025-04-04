package json.com.validate_email;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TestingEmail {
	@Test
	public void testEmail() {
		String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\validate_email\\file.json";
		
		try {
			List<String> email = JsonReader.getField(filePath);
			for(int i=0;i<email.size();i++) {
				String accessEmail = email.get(i);
				boolean valid = ValidateEmail.isValid(accessEmail);
				if(valid) {
					assertEquals("ashu0318.be21@gmail.com",accessEmail);
				}
				else {
					assertEquals("23ashu32.noc",accessEmail);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
