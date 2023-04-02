import java.util.UUID;

public class SessionManager {
  // This is a static method that generates a unique session ID using the UUID class.
public static String generateSessionId() {
    return UUID.randomUUID().toString();
}
}

