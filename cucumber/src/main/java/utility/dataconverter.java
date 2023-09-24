package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class dataconverter {

	public static String generatepayload(String filename) throws IOException
	{
		String filepath = "C:\\Users\\jhans\\Documents\\workspace-spring-tool-suite-4-4.19.1.RELEASE\\cucumber\\src\\main\\resources\\"+filename;
		
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
	
}
