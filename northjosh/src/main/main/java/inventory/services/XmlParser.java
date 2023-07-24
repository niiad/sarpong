package inventory.services;

import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.DocumentBuilder; 
import org.w3c.dom.Document; 

/**
 * Helper class to parse XML files
 * @author gaut2172
 *
 */
public class XmlParser {

	
	// FIXME make sure to handle if returns null
	public static Document parseDocument(String path) {
		Document doc = null;
		
		try {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();
        doc = docBuilder.parse(path);
        doc.getDocumentElement().normalize();
        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return doc;
	}
	
}
