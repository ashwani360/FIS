package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ProeprtyReader {
	
	public String value;
    public String fileName;
    Properties OR = null;
    public ProeprtyReader(String fileName) {
        this.fileName = fileName;
        //System.out.println(this.fileName);
        
}
   
     public String getdata(String Key){
    	 
    		 try {
 				OR = new Properties();
 				FileInputStream fs = new FileInputStream(
 						System.getProperty("user.dir") + "\\src\\Config\\"+this.fileName);
 				OR.load(fs);

 				value=OR.getProperty(Key);
 
 			} catch (Exception e) {
 				System.out.println("Error on intializing properties files");
 			}
    		 
    	
    	 return value;
     }
     
//   public static void main(String[] str) {
//	
//	   ProeprtyReader prpertyreader = new ProeprtyReader("Config.properties");
//       // System.out.println(".");
//        String value1 = prpertyreader.getdata("siteName");
//        System.out.println("Site Name : "+value1);
//        String value2 = prpertyreader.getdata("browser");
//        System.out.println("Brwoser Name : "+value2);
//        String value3 = prpertyreader.getdata("defaultUsername");
//        System.out.println("Username Name : "+value3);
//        String value4 = prpertyreader.getdata("defaultPassword");
//        System.out.println("Password : "+value4);
//}
}
