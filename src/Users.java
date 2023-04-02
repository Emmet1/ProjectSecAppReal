import java.util.ArrayList;

/**
 * The Users class is used to store and manage user credentials.
 * It maintains two ArrayLists for storing usernames and passwords.
 *
 * @author Emmet
 */
public class Users {
    // An ArrayList to store usernames
    public static ArrayList<String> usernames = new ArrayList<String>();
    
    // An ArrayList to store passwords
    public static ArrayList<String> passwords = new ArrayList<String>();

    /**
     * Adds a new user to the system with the given username and password.
     * 
     * @param u the username
     * @param p the password
     */
    public void addusers(String u, String p){
        usernames.add(u);
        passwords.add(p);
    }
    
    /**
     * Returns the list of usernames.
     * 
     * @return an ArrayList containing all usernames
     */
    public ArrayList<String> getUserNames() {
        return usernames;
    }
    
    /**
     * Returns the list of passwords.
     * 
     * @return an ArrayList containing all passwords
     */
    public ArrayList<String> getPasswords() {
        return passwords;
    }
}
