import java.util.*;
import java.sql.*;

// This is a private static list that contains User objects.
private static List<User> users = new ArrayList<>();

// This static block is used to add some example users with different roles to the users list.
static {
    users.add(new User("admin", "password", new HashSet<>(Arrays.asList("admin", "user"))));
    users.add(new User("user1", "password", new HashSet<>(Arrays.asList("user"))));
    users.add(new User("user2", "password", new HashSet<>(Arrays.asList("user"))));
}

// This is a static method that returns a User object given a username.
public static User getUser(String username) {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
        // Create a SQL query to select the user with the given username.
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Retrieve the user's password and roles from the ResultSet.
            String password = rs.getString("password");
            Set<String> roles = new HashSet<>(Arrays.asList(rs.getString("roles").split(",")));
            return new User(username, password, roles);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // If the user was not found, return null.
    return null;
}
