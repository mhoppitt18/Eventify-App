package GroupAssignment;

public class AdminSession {
    private static AdminSession instance;

    private static int adminID;
    private static String username;
    private static String password;
    
    private AdminSession() {
        
    }

    public AdminSession(int adminID, String username, String password) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
    }

    public static AdminSession getInstance(int adminID, String username, String password) {
        if(instance == null) {
            instance = new AdminSession(adminID, username, password);
        }
        return instance;
    }
    
    public static int getAdminID() {
        return adminID;
    }

    public static String getUsername() {
        return username;
    }
    
    public static String getPassword() {
        return password;
    }

    public static void cleanAdminSession() {
        //adminID = 2;
        username = "";
        password = "";
    }

    @Override
    public String toString() {
        return "AdminSession{" +
                "adminID='" + adminID +
                "username='" + username +
                "password='" + password +
                '}';
    }
    
    
}