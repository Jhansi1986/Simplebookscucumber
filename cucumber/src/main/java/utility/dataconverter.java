package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class dataconverter {

	public static String generatepayload(String filename) throws IOException
	{
		String filepath = "src\\main\\resources\\"+filename;
		
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
	
}
