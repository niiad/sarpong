package inventory.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import inventory.models.User;

/**
 * Role based authorization control class
 * @author gaut2172
 *
 */
public class Authorizer {
	
	private HashMap<String, List<String>> users;
	private HashMap<String, List<Object>> userRoles;
	private final String PATH = "C:\\Users\\gaut2\\InventoryFiles\\RBAC.json";
	private JSONObject parsedJsonFile;
	
	
	
	/*
	 * The only constructor
	 */
	public Authorizer() {
		try {
			users = new HashMap<String, List<String>>();
			userRoles = new HashMap<String, List<Object>>();
			// work with JSON file that has user/role data, parse it into a JSONObject
			parsedJsonFile = JsonParser.readJson(PATH);
			users = getStoredUsers();
			userRoles = getStoredUserRoles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * This method authorizes the user who is trying to do some action 
	 * @param user - the user that has already logging in
	 * @param action - what the user is attempting
	 * @return - true if an only if the user has appropriate privilige
	 */
	public boolean IsAuthorized(User user, String action) {
		boolean isAuthorized = false;

		
		try {
			String role = users.get(user.GetUsername()).get(1);
			
			if (userRoles.containsKey(role)) {
				ArrayList<?> privilegesArray = (ArrayList<?>) userRoles.get(role).get(1);
			
				if (privilegesArray.contains(action)) {
					isAuthorized = true;
					System.out.println("Authorization successful.");
				}
				else {
					System.out.println("You are not authorized for that action.");
				}
			}
			else {
				System.out.println("You are not authorized for this action.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isAuthorized;
	}
	
	
	
	/**
	 * Retrieve users from file into memory
	 * @return - HashMap of valid users info
	 */
	private HashMap<String, List<String>> getStoredUsers() {
		HashMap<String, List<String>> users = new HashMap<String, List<String>>();
		
		try {
			// get array from JSONObject
			JSONArray usersArray = parsedJsonFile.getJSONArray("users");

			// for each user in file, save their data in key/value form of hashMap
			for (int i = 0; i < usersArray.length(); i++) {
				String key = usersArray.getJSONObject(i).getString("name");
				List<String> values = new ArrayList<String>();
				values.add(usersArray.getJSONObject(i).getString("id"));
				values.add(usersArray.getJSONObject(i).getString("role"));
				users.put(key, values);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	
	/**
	 * Retrieve stored user role data into memory
	 * @return - HashMap of valid roles and their priviliges
	 */
	private HashMap<String, List<Object>> getStoredUserRoles() {
		HashMap<String, List<Object>> roles = new HashMap<String, List<Object>>();
		
		try {
			// get array from JSONObject
			JSONArray rolesArray = parsedJsonFile.getJSONArray("userRoles");
			
			// for every userRole, store the id, name, and privileges into HashMap
			for (int i = 0; i < rolesArray.length(); i++) {
				
				// id
				String key = rolesArray.getJSONObject(i).getString("id");
				List<Object> values = new ArrayList<Object>();
				
				// name
				values.add(rolesArray.getJSONObject(i).getString("name"));
				
				// priviliges				
				List<String> privileges = new ArrayList<String>();
				JSONArray embeddedArray = rolesArray.getJSONObject(i).getJSONArray("privileges");
				// add every privilege in the nested list
				for (int j = 0; j < embeddedArray.length(); j++) {
					privileges.add(embeddedArray.getString(j));
				}
				values.add(privileges);
				roles.put(key, values);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return roles;
	}
	
	
}
