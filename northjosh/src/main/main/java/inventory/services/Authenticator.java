package inventory.services;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import inventory.models.User;

/**
 * Authentication class for logging into the business logic layer of this system
 * @author gaut2172
 *
 */
public class Authenticator {
	
	// FIXME: Encrypt and decrypt the xml file
	
	/**
	 * Authenticate user login by reading XML file of user credentials
	 * @param username - user input to be checked
	 * @param password - user input to be checked
	 * @return true only if username and password match a user in the XML file
	 */
	public User authenticate(String username, String password) {
		User authenticatedUser = null;

		try {
			NodeList nodeList = this.getNodesFromDomDoc(XmlParser.parseDocument("C:\\Users\\gaut2\\InventoryFiles\\creds.xml"));
			
			// loop thru each node in list, comparing it to user input
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				// if current node is an Element object
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					
					// if current element matches user's username and password, authenticate
					if (eElement.getElementsByTagName("username").item(0).getTextContent().equals(username) &&
							eElement.getElementsByTagName("pwd").item(0).getTextContent().equals(password)) {
						authenticatedUser = new User(username, password);
						break;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return authenticatedUser;
	}
	
	/**
	 * Retrieves NodeList object of users from the parsed XML document
	 * @param doc - parsed xml document
	 * @return the NodeList of users
	 */
	private NodeList getNodesFromDomDoc(Document doc) {
		NodeList nodeList = null;
		
		try {
			nodeList = doc.getElementsByTagName("user");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return nodeList;
	}
	

}
