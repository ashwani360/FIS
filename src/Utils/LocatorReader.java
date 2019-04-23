package Utils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class LocatorReader {

    public Document doc;
    public String fileName;

    public LocatorReader(String fileName) {
              this.fileName = fileName;
              //System.out.println(this.fileName);
              
    }

    public String getData(String locator) {
              SAXReader reader = new SAXReader();
               try {
                      doc = reader.read("src\\Locaters\\"+fileName);
                     
              } catch (DocumentException e) {
                      e.printStackTrace();
             }
            String data = doc.selectSingleNode("//" + locator.replace('.', '/')).getText();                                 
            return data;
    }

//    public static void main(String[] str) {
//    	 //URL location = Test.class.getProtectionDomain().getCodeSource().getLocation();
//         //System.out.println(location.getFile());
//    	//File parentFolder = new File(getParent());
//            LocatorReader readXml = new LocatorReader("Header.xml");
//           // System.out.println(".");
//            String locator1 = readXml.getData("menu.home");
//            System.out.println("Home : "+locator1);
//            String locator2 = readXml.getData("menu.sales");
//            System.out.println("Sales  : "+locator2);
//            String locator3 = readXml.getData("menu.userstiing.logout");
//            System.out.println("LogOut  : "+locator3);
//    }
} 