package json.com.validate_email;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class JsonReader {
	public static List<String> getField(String filePath) {
		Gson gson = new Gson();
		List<String>email = new ArrayList<>();
		try(FileReader fileReader = new FileReader(filePath)){
			User[]users = gson.fromJson(fileReader, User[].class);
			//json data parson to user object
			for(User user :users) {
				if(user!=null && user.getEmail()!=null) {
					email.add(user.getEmail());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
}
