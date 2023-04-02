import java.util.*;
import java.sql.*;

public class UserDatabase {
    private static List<User> users = new ArrayList<>();

    static {
        // Add some example users with different roles
        users.add(new User("admin", "password", new HashSet<>(Arrays.asList("admin", "user"))));
        users.add(new User("user1", "password", new HashSet<>(Arrays.asList("user"))));
        users.add(new User("user2", "password", new HashSet<>(Arrays.asList("user"))));
    }

    public static User getUser(String username) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String password = rs.getString("password");
                Set<String> roles = new HashSet<>(Arrays.asList(rs.getString("roles").split(",")));
                return new User(username, password, roles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
