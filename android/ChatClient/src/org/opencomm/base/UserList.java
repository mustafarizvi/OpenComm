/**
 * 
 */
package org.opencomm.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Iterator;
import java.lang.IllegalArgumentException;

/**
 * @author mbentz
 *	userList is the base class for handling all lists of users
 */
public class UserList extends HashMap<String, Object> {

	/**
	 * Needed for HashMap extension
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public UserList() {
		super();
	}

	/**
	 * @param map
	 */
	public UserList(Map map) {
		super(map);
		// TODO Auto-generated constructor stub
	}
	public UserList(Collection<String> userNames, Collection<User> users) throws Exception {
		Iterator<String> n_itr = userNames.iterator();
		Iterator u_itr = users.iterator();
		try {
			while(n_itr.hasNext()) {
				String name = n_itr.next();
				Object user = u_itr.next();
				this.put(name, user);
			}
		}
		catch(Exception e) {
		}
	}
	/**
	 * put overloads HashMap put by checking if duplicates exist
	 * @param userName the key
	 * @param u the value
	 * @throws DuplicateElementException If the key or value already exsists
	 */
	public void put(String userName, User u) throws DuplicateElementException{
		if(this.hasNoDuplicates(userName, u)) {
			super.put(userName, u);
		}
		else
			throw new DuplicateEntryException();
	}
	public boolean hasNoDuplicates(String userName, User u) {
		return !(this.containsKey(userName)&&this.containsValue(u));
	}
	

}
