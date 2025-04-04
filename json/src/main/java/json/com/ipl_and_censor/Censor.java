package json.com.ipl_and_censor;

public class Censor {
	public static String censorData(String data) {
		String[] dataArray  = data.split(" ");
		dataArray[dataArray.length-1]= "***";
		return String.join(" ", dataArray);
	}
}
