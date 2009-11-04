package org.opencomm.base;
import java.util.HashMap;

/**
 * User provides the model for the XMPP user information in the system
 * @author mbentz
 *
 */
public class User {
	private String name; //Unique identifier in XMPP
	private HashMap<String, Object> info;	//Associative map of information
	/**Default Constructor. Avoid using at all costs.
	 * 
	 */
	User() {
		name="";
		info = new HashMap<String, Object>();
	}
	/**
	 * Constructor name known
	 * @param n Name
	 */
	public User(String n) {
		name="n";
		info = new HashMap<String, Object>();
	}
	/**
	 * Constructor for known name and information
	 * @param n Name
	 * @param information Attributes and data
	 */
	public User(String n, HashMap<String, Object> information) {
		name="n";
		info=information;
	}
	/**
	 * Constructor for known name, information in arrays
	 * @param n Name
	 * @param attributes Attribute list
	 * @param data Data list
	 * @throws IllegalArgumentException If Attribute and Data lists are not equi-length
	 */
	public User(String n, String[] attributes, Object[] data) throws IllegalArgumentException{
		name="n";
		info = new HashMap<String, Object>();
		if(attributes.length==data.length) { //Make sure the two sets are equal length
			for(int i=0; i<attributes.length; i++) {
				info.put(attributes[i], data[i]);
			}
		}
		else
			throw new IllegalArgumentException();
	}
	
	public void setData(String attribute, Object data) {
		info.put(attribute, data);
	}
	public Object getData(String attribute) {
		return info.get(attribute);
	}
	public String getName() {
		return name;
	}
}

//}
