package automation.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utility {
	
	

	
	
	
	public static String getRandomEmail() {
	 
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    
	    StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append(generatedString).append("@gmail.com");
	 
	    System.out.println(stringBuilder.toString());
	    
	    return stringBuilder.toString();
	}
	
	public static void saveLineToCSV(String path, String line)
	{
		try {
			
		
		File file = new File(path);
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		pr.println(line);
		pr.flush();
		pr.close();
		br.close();
		fr.close();
		
		System.out.println("New user saved");
		
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static String getAlphaNumericString(int n) 
	    { 
	  
	        // chose a Character random from this String 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz"; 
	  
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    } 
	
	public static void takeScreenShot(WebDriver driver) throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String osName = System.getProperty("os.name");
		if(osName.contains("linux") || osName.contains("unix"))
		{
			FileUtils.copyFile(file, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + " .png"));
		} else {
			FileUtils.copyFile(file, new File(currentDir + "\screenshots\\" + System.currentTimeMillis() + " .png"));
		}
	}
	  
	
	
}

