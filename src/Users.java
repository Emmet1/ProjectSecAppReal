import java.util.ArrayList;

/**
 *
 * @author Emmet
 */
public class Users {
    public static ArrayList<String> usernames = new ArrayList<String>();
    public static ArrayList<String> passwords = new ArrayList<String>();

    public void addusers(String u, String p){
        usernames.add(u);
        passwords.add(p);
    }
    public  ArrayList getUserNames()
    {
        return usernames;
    }
    public ArrayList getPasswords()
    {
        return passwords;
    }


}

