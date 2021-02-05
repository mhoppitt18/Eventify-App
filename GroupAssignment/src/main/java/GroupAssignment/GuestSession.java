package GroupAssignment;

public class GuestSession {
    private static GuestSession instance;

    private static int guestID;
    private static String access_code;
    private static String email_address;
    private static String fname;
    private static String lname;
    private static int adminID;

    
    
 

    public GuestSession(int guestID, String access_code) {
        this.guestID = guestID;
        this.access_code = access_code;
    }

    public static int getGuestID() {
        return guestID;
    }

    public static String getAccessCode() {
        return access_code;
    }

    public static String getEmailAddress() {
        return email_address;
    }

    public static String getFname() {
        return fname;
    }

    public static String getLname() {
        return lname;
    }

    public static GuestSession getInstance(int guestID, String access_code) {
        if(instance == null) {
            instance = new GuestSession(guestID, access_code);
        }
        return instance;
    }
    
    public static int getAdminID() {
        return adminID;
   
    }
    public static void cleanGuestSession() {
        access_code = "";
        email_address = "";
        fname = "";
        lname = "";
    }

    @Override
    public String toString() {
        return "GuestSession{" +
                "guestID='" + guestID +
                "access_code='" + access_code +
                "email_address='" + email_address +
                "fname='" + fname +
                "lname='" + lname +
                "adminID='" + adminID +
                '}';
    }
}
