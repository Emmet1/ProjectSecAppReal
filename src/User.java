import java.util.Set;

public class User {
   // This is a private field that stores the user's username.
private String username;

// This is a private field that stores the user's password.
private String password;

// This is a private field that stores the user's roles.
private Set<String> roles;

// This is a constructor that initializes the User object with a username, password, and roles.
public User(String username, String password, Set<String> roles) {
    this.username = username;
    this.password = password;
    this.roles = roles;
}

// This is a getter method that returns the user's username.
public String getUsername() {
    return username;
}

// This is a getter method that returns the user's password.
public String getPassword() {
    return password;
}

// This is a getter method that returns the user's roles.
public Set<String> getRoles() {
    return roles;
}

}
