package GroupAssignment;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;

public class Database {

    public static Connection sharedConnection;
    public static final String TABLE_NAME_FOR_ADMIN = "ADMIN";
    public static final String TABLE_NAME_FOR_GUEST = "GUEST";
    public static final String TABLE_NAME_FOR_EVENT = "EVENT";
    public static final String TABLE_NAME_FOR_INVITATION = "INVITATION";
    public static final String TABLE_NAME_FOR_RSVP = "RSVP";
    public static final String TABLE_NAME_FOR_RUNSHEET = "RUNSHEET";

    public static void openConnection() {
        boolean wasThisMethodSuccessful = false;
        try {
            Database.sharedConnection = DriverManager.getConnection("jdbc:sqlite:Eventify.db");
            wasThisMethodSuccessful = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void createAdminTable() {
        openConnection();
        PreparedStatement smt;
        PreparedStatement insert;
        ResultSet rs;
        try {
            DatabaseMetaData dbmd = sharedConnection.getMetaData();
            rs = dbmd.getTables(null, null, Database.TABLE_NAME_FOR_ADMIN, null);
            // Check if the table exists
            if (!rs.next()) {
                smt = sharedConnection.prepareStatement("CREATE TABLE " + Database.TABLE_NAME_FOR_ADMIN + " ("
                    + "adminID INTEGER PRIMARY KEY AUTOINCREMENT"
                    + ", username TEXT NOT NULL"
                    + ", password TEXT NOT NULL"
                    + ");");
                smt.execute();
                
                insert = sharedConnection.prepareStatement("INSERT INTO " + Database.TABLE_NAME_FOR_ADMIN + "(adminID, username, password)"    
                    + " VALUES (100001,'admin1','password1'), "
                    + "(100002,'admin2','password2'), "
                    + "(100003,'admin3','password3'), "
                    + "(100004,'admin4','password4'), "
                    + "(100005,'admin5','password5');");
                insert.execute();
                sharedConnection.close();
            } else {
                System.out.println("ADMIN table exists");
                sharedConnection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void createGuestTable() {
        openConnection();
        PreparedStatement smt;
        PreparedStatement insert;
        ResultSet rs;
        try {
            DatabaseMetaData dbmd = sharedConnection.getMetaData();
            rs = dbmd.getTables(null, null, Database.TABLE_NAME_FOR_GUEST, null);
            // Check if the table exists
            if (!rs.next()) {
                smt = sharedConnection.prepareStatement("CREATE TABLE " + Database.TABLE_NAME_FOR_GUEST + " ("
                    + "guestID INTEGER PRIMARY KEY AUTOINCREMENT"
                    + ", access_code TEXT NOT NULL"
                    + ", email_address TEXT NOT NULL"
                    + ", fname TEXT NOT NULL"
                    + ", lname TEXT NOT NULL"
                    + ", adminID INTEGER FOREIGN_KEY REFERENCES admin(adminID)"
                    + ");");
                smt.execute();
                
                insert = sharedConnection.prepareStatement("INSERT INTO " + Database.TABLE_NAME_FOR_GUEST + " (guestID, access_code, email_address, fname, lname, adminID)"    
                    + " VALUES (200001,'ElizaDarvall4583','edarvs82@gmail.com','Eliza','Darvall',100001), "
                    + "(200002,'AnnaJames1028','jamesy15@optusnet.com.au','Anna','James',100001), "
                    + "(200003,'LoganBurgmann0282','logzzz5@yahoo.com','Logan','Burgmann',100002), "
                    + "(200004,'MichaelEmbry9083','mick.embry1978@outlook.com','Michael','Embry',100002), "
                    + "(200005,'SeanOConnor4898','oconnor00@yahoo.com','Sean','O''Connor',100002), "
                    + "(200006, 'RachelGreen5928','rachel.green@gmail.com', 'Rachel', 'Green', 100003), "
                    + "(200007, 'RossGeller2395','rossGeller@NYC.com', 'Ross', 'Geller', 100004), "
                    + "(200008, 'JakePerolta5940','JakePerolt99a@NYPD.com', 'Jake', 'Perolta', 100004), "
                    + "(200009, 'AmySantiago2395','amySantiago99@NYPD.com', 'Amy', 'Santiago', 100005), "
                    + "(200010, 'RossGeller2395','rossGeller@NYC.com', 'Ross', 'Geller', 100005), "
                    + "(200011, 'JoeExotic3048','JoeExotic911@Prison.com', 'Joe', 'Exotic', 100001), "
                    + "(200012, 'CaroleBaskin4930','CaroleBaskin@BigCatRescue.com', 'Carole', 'Baskin', 100001), "
                    + "(200013, 'GeorgeLucas8643','GeorgeLucas@starWears.com', 'George', 'Lucas', 100005), "
                    + "(200014, 'MarthaSmith0293','msmith74@gmail.com', 'Martha', 'Smith', 100001), "
                    + "(200015, 'CarlStewart2263','stewartcarl@gmail.com','Carl','Stewart', 100001), "
                    + "(200016, 'MartinField9173','fieldyms9@optusnet.com','Martin','Field', 100001), "
                    + "(200017, 'ConnorPine1524','connor.pine93@gmail.com','Connor','Pine', 100001), "
                    + "(200018, 'MarkScali8294','scalim1963@outlook.com','Mark','Scali', 100001), "
                    + "(200019, 'RuthCamp6482','ruthycamp18@yahoo.com','Ruth','Camp',100002), "
                    + "(200020, 'JulietPink1830','julietpk@gmail.com','Juliet','Pink',100002), "
                    + "(200021, 'RhondaLim4924','limrhonda@gmail.com','Rhonda','Lim',100002), "
                    + "(200022, 'JohnathonCast4627','johnathon.cast22@yahoo.com','Johnathon','Cast',100002), "
                    + "(200023, 'TammieRennell0173','rennelltmy00@outlook.com','Tammie','Rennell',100002), "
                    + "(200024, 'GarethHawking7482','ghawking@gmail.com', 'Gareth', 'Hawking', 100003), "
                    + "(200025, 'EldonSimon8820','esimon1@gmail.com', 'Eldon', 'Simon', 100003), "
                    + "(200026, 'GeoffAllen3626','allengeoff92@yahoo.com', 'Geoff', 'Allen', 100003), "
                    + "(200027, 'JenniferPeres2810','jennyperes@gmail.com', 'Jennifer', 'Peres', 100003), "
                    + "(200028, 'MiriamSalt3729','miriam29381@gmail.com', 'Miriam', 'Salt', 100003), "
                    + "(200029, 'LeoBunts2810','lbunts99@outlook.com', 'Leo', 'Bunts', 100003), "
                    + "(200030, 'CooperMolesworth2629','coopsm91723@gmail.com', 'Cooper', 'Molesworth', 100003), "
                    + "(200031, 'LucindaFabinyi1722','lucinda.fabinyil@outlook.com', 'Lucinda', 'Fabinyi', 100003), "
                    + "(200032, 'RileyVasey3847','rileyv52@gmail.com', 'Riley', 'Vasey', 100004), "
                    + "(200033, 'IsabelMarquet4829','issymarquet9@outlook.com', 'Isabel', 'Marquet', 100004), "
                    + "(200034, 'DominicDedman2834','dominic.dedman@outlook.com', 'Dominic', 'Dedman', 100004), "
                    + "(200035, 'AlexisHanran3749','alexishanran29429@gmail.com', 'Alexis', 'Hanran', 100004), "
                    + "(200036, 'DanielKingston4829','kingstond@gmail.com', 'Daniel', 'Kingston', 100004), "
                    + "(200037, 'StephanieDitter3515','stephanie.ditter@gmail.com', 'Stephanie', 'Ditter', 100005), "
                    + "(200038, 'JaydenDelphrat9473','jaydendelph2811@outlook.com', 'Jayden', 'Delphrat', 100005), "
                    + "(200039, 'AngelinaTheodore2241','angelina272@gmail.com', 'Angelina', 'Theodore', 100005), "
                    + "(200040, 'LillianKyte2111','kytelilly2@gmail.com', 'Lillian', 'Kyte', 100005), "
                    + "(200041, 'CallumWaylen0685','callumwaylen38@gmail.com', 'Callum', 'Waylen', 100005), "
                    + "(200042, 'EveKirke4758','kirkeeve@outlook.com', 'Eve', 'Kirke', 100005)"
                    + ";");
                insert.execute();
                sharedConnection.close();
            } else {
                System.out.println("GUEST table exists");
                sharedConnection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void createEventTable() {
        openConnection();
        PreparedStatement smt;
        PreparedStatement insert;
        ResultSet rs;
        try {
            DatabaseMetaData dbmd = sharedConnection.getMetaData();
            rs = dbmd.getTables(null, null, Database.TABLE_NAME_FOR_EVENT, null);
            // Check if the table exists
            if (!rs.next()) {
                smt = sharedConnection.prepareStatement("CREATE TABLE " + Database.TABLE_NAME_FOR_EVENT + " ("
                    + "eventID INTEGER PRIMARY KEY AUTOINCREMENT"
                    + ", event_location TEXT NOT NULL"
                    + ", event_title TEXT NOT NULL"
                    + ", event_date DATETIME DEFAULT CURRENT_DATE"
                    + ", event_time INTEGER NOT NULL"
                    + ", adminID INTEGER FOREIGN_KEY REFERENCES ADMIN(adminID)"
                    + ");");
                smt.execute();
                
                insert = sharedConnection.prepareStatement("INSERT INTO " + Database.TABLE_NAME_FOR_EVENT + " (eventID, event_location, event_title, event_date, event_time, adminID)"    
                    + " VALUES (300001,'Big Banana','Gatho at the Big Banana','2020-01-21 00:00:00.0' ,1630,100001), "
                    + "(300002,'Sydney Harbour','Tom & Sally''s Wedding','2020-03-16 00:00:00.0',1200,100002), "
                    + "(300003,'Manly Beach','Surfing Lessons','2020-02-01 00:00:00.0',0600,100003), "
                    + "(300004,'Ayers Rock','Sunrise Hike','2020-04-18 00:00:00.0',0530,100004), "
                    + "(300005,'Gold Coast','Rock Concert', '2020-12-01 00:00:00.0',2000,100005), "
                    + "(300006,'Sutherland','Mike''s 21st Birthday','2020-02-13 00:00:00.0' ,1900,100001), "
                    + "(300007,'Bankstown','Office Fun Run','2020-03-01 00:00:00.0' ,1200,100001), "
                    + "(300008,'Newcastle','Trivia Night','2020-02-15 00:00:00.0' ,1800,100001), "
                    + "(300009,'Sydney Boys HS','Muck Up Day 2020','2020-02-27 00:00:00.0',0900,100002), "
                    + "(300010,'Royal Melbourne GC','2020 Presentation Dinner','2020-03-02 00:00:00.0',1800,100002), "
                    + "(300011,'Office Level 2','Office Talent Quest','2020-01-19 00:00:00.0',0900,100002), "
                    + "(300012,'Sydney','Fundraiser Raffle','2020-04-06 00:00:00.0',1700,100003), "
                    + "(300013,'The Office','Office Karaoke Night','2020-02-22 00:00:00.0',1900,100003), "
                    + "(300014,'My House','Star Wars Marathon','2020-04-09 00:00:00.0',1400,100004), "
                    + "(300015,'Liverpool GC','Golf Charity Day', '2020-05-08 00:00:00.0',0700,100005), "
                    + "(300016,'Bondi Beach','NSW Open Triathlon', '2020-01-17 00:00:00.0',0600,100005)"
                    + ";");
                insert.execute();
                sharedConnection.close();
            } else {
                System.out.println("EVENT table exists");
                sharedConnection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void createInvitationTable() {
        openConnection();
        PreparedStatement smt;
        PreparedStatement insert;
        ResultSet rs;
        try {
            DatabaseMetaData dbmd = sharedConnection.getMetaData();
            rs = dbmd.getTables(null, null, Database.TABLE_NAME_FOR_INVITATION, null);
            // Check if the table exists
            if (!rs.next()) {
                smt = sharedConnection.prepareStatement("CREATE TABLE " + Database.TABLE_NAME_FOR_INVITATION + " ("
                    + "invitationID INTEGER PRIMARY KEY AUTOINCREMENT"
                    + ", eventID INTEGER FOREIGN_KEY REFERENCES event(eventID)"
                    + ", guestID INTEGER FOREIGN_KEY REFERENCES guest(guestID)"
                    + ", adminID INTEGER FOREIGN_KEY REFERENCES admin(adminID)"
                    + ");");
                smt.execute();
                
                insert = sharedConnection.prepareStatement("INSERT INTO " + Database.TABLE_NAME_FOR_INVITATION + " (invitationID, eventID, guestID, adminID)"    
                    + " VALUES (400001,300001,200001,100001), "
                    + "(400002,300001,200002,100001), "
                    + "(400003,300002,200003,100002), "
                    + "(400004,300002,200004,100002), "
                    + "(400005,300002,200005,100002), "
                    + "(400006,300003,200006,100003), "
                    + "(400007,300004,200007,100004), "
                    + "(400008,300004,200008,100004), "
                    + "(400009,300005,200009,100005), "
                    + "(400010,300005,200010,100005), "
                    + "(400011,300001,200011,100001), "
                    + "(400012,300001,200012,100001), "
                    + "(400013,300005,200013,100005), "
                    + "(400014,300006,200016,100001), "
                    + "(400015,300006,200018,100001), "
                    + "(400016,300006,200002,100001), "
                    + "(400017,300007,200001,100001), "
                    + "(400018,300007,200014,100001), "
                    + "(400019,300008,200016,100001), "
                    + "(400020,300008,200001,100001), "
                    + "(400021,300008,200002,100001), "
                    + "(400022,300008,200015,100001), "
                    + "(400023,300009,200003,100002), "
                    + "(400024,300009,200005,100002), "
                    + "(400025,300009,200020,100002), "
                    + "(400026,300010,200004,100002), "
                    + "(400027,300010,200019,100002), "
                    + "(400028,300010,200022,100002), "
                    + "(400029,300011,200003,100002), "
                    + "(400030,300011,200020,100002), "
                    + "(400031,300011,200023,100002), "
                    + "(400032,300012,200025,100003), "
                    + "(400033,300012,200028,100003), "
                    + "(400034,300012,200031,100003), "
                    + "(400035,300013,200026,100003), "
                    + "(400036,300013,200029,100003), "
                    + "(400037,300014,200007,100004), "
                    + "(400038,300014,200034,100004), "
                    + "(400039,300015,200037,100005), "
                    + "(400040,300015,200039,100005), "
                    + "(400041,300015,200042,100005), "
                    + "(400042,300011,200003,100002), "
                    + "(400043,300016,200040,100005), "
                    + "(400044,300016,200041,100005)"
                    + ";");
                insert.execute();
                sharedConnection.close();
            } else {
                System.out.println("INVITATION table exists");
                sharedConnection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void createRSVPTable() {
        openConnection();
        PreparedStatement smt;
        PreparedStatement insert;
        ResultSet rs;
        try {
            DatabaseMetaData dbmd = sharedConnection.getMetaData();
            rs = dbmd.getTables(null, null, Database.TABLE_NAME_FOR_RSVP, null);
            // Check if the table exists
            if (!rs.next()) {
                smt = sharedConnection.prepareStatement("CREATE TABLE " + Database.TABLE_NAME_FOR_RSVP + " ("
                    + "rsvpID INTEGER PRIMARY KEY AUTOINCREMENT"
                    + ", decision TEXT DEFAULT 'Pending'"
                    + ", dietary_notes TEXT DEFAULT 'None'"
                    + ", rsvp_date DATETIME DEFAULT CURRENT_DATE"
                    + ", invitationID INTEGER FOREIGN_KEY REFERENCES invitation(invitationID)"
                    + ");");
                smt.execute();
                
                insert = sharedConnection.prepareStatement("INSERT INTO " + Database.TABLE_NAME_FOR_RSVP + " (rsvpID, decision, dietary_notes, rsvp_date, invitationID)"    
                    + " VALUES (500001, 'Yes' ,'Vegetarian','2020-01-15 00:00:00.0',400001), "
                    + "(500002, 'No','None','2020-01-14 00:00:00.0',400002), "
                    + "(500003, 'Yes','Nut allergy','2020-02-20 00:00:00.0',400003), "
                    + "(500004,'No','None','2020-02-19 00:00:00.0',400004), "
                    + "(500005,'No','None','2020-02-18 00:00:00.0',400005), "
                    + "(500006, 'Yes','Lactose intollerant','2020-02-20 00:00:00.0',400006), "
                    + "(500007,'No','None','2020-01-15 00:00:00.0',400007), "
                    + "(500008, 'Yes','None','2020-03-15 00:00:00.0',400008), "
                    + "(500009,'Yes','Vegan','2020-04-14 00:00:00.0',400009), "
                    + "(500010,'Yes' ,'Lactose intollerant','2020-01-02 00:00:00.0',400010), "
                    + "(500011,'No','None','2020-01-01 00:00:00.0',400011),"
                    + "(500012,'Yes' ,'Lactose intollerant','2020-01-20 00:00:00.0',400012), "
                    + "(500013,'Pending' ,'None','2020-02-09 00:00:00.0',400013), "
                    + "(500014,'Yes' ,'None','2020-02-01 00:00:00.0',400014), "
                    + "(500015,'Yes' ,'Vegan','2020-01-30 00:00:00.0',400015), "
                    + "(500016,'No' ,'None','2020-02-03 00:00:00.0',400016), "
                    + "(500017,'Yes' ,'None','2020-02-28 00:00:00.0',400017), "
                    + "(500018,'Yes' ,'Nut allergy','2020-02-15 00:00:00.0',400018), "
                    + "(500019,'Pending' ,'None','2020-02-13 00:00:00.0',400019), "
                    + "(500020,'Yes' ,'None','2020-02-09 00:00:00.0',400020), "
                    + "(500021,'Yes' ,'None','2020-02-08 00:00:00.0',400021), "
                    + "(500022,'Yes' ,'None','2020-02-12 00:00:00.0',400022), "
                    + "(500023,'Yes' ,'None','2020-01-30 00:00:00.0',400023), "
                    + "(500024,'Pending' ,'None','2020-02-03 00:00:00.0',400024), "
                    + "(500025,'Yes' ,'None','2020-02-09 00:00:00.0',400025), "
                    + "(500026,'No' ,'None','2020-03-01 00:00:00.0',400026), "
                    + "(500027,'Yes' ,'Lactose intollerant','2020-02-09 00:00:00.0',400027), "
                    + "(500028,'Yes' ,'Nut allergy','2020-02-28 00:00:00.0',400028), "
                    + "(500029,'Yes' ,'Nut allergy','2020-01-07 00:00:00.0',400029), "
                    + "(500030,'Pending' ,'None','2020-01-11 00:00:00.0',400030), "
                    + "(500031,'Yes' ,'None','2020-01-05 00:00:00.0',400031), "
                    + "(500032,'Yes' ,'None','2020-03-27 00:00:00.0',400032), "
                    + "(500033,'Yes' ,'None','2020-03-13 00:00:00.0',400033), "
                    + "(500034,'No' ,'None','2020-03-28 00:00:00.0',400034), "
                    + "(500035,'Yes' ,'Nut allergy','2020-02-17 00:00:00.0',400035), "
                    + "(500036,'Yes' ,'None','2020-02-09 00:00:00.0',400036), "
                    + "(500037,'Yes' ,'None','2020-04-03 00:00:00.0',400037), "
                    + "(500038,'Yes' ,'None','2020-04-01 00:00:00.0',400038), "
                    + "(500039,'No' ,'None','2020-04-28 00:00:00.0',400039), "
                    + "(500040,'Yes' ,'None','2020-04-22 00:00:00.0',400040), "
                    + "(500041,'Yes' ,'Vegetarian','2020-04-06 00:00:00.0',400041), "
                    + "(500042,'Yes' ,'Vegetarian','2020-01-06 00:00:00.0',400042), "
                    + "(500043,'No' ,'None','2020-01-12 00:00:00.0',400043), "
                    + "(500044,'Yes' ,'None','2020-01-09 00:00:00.0',400044)"
                    + ";");
                insert.execute();
                sharedConnection.close();
            } else {
                System.out.println("RSVP table exists");
                sharedConnection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void createRunsheetTable() {
        openConnection();
        PreparedStatement smt;
        PreparedStatement insert;
        ResultSet rs;
        try {
            DatabaseMetaData dbmd = sharedConnection.getMetaData();
            rs = dbmd.getTables(null, null, Database.TABLE_NAME_FOR_RUNSHEET, null);
            // Check if the table exists
            if (!rs.next()) {
                smt = sharedConnection.prepareStatement("CREATE TABLE " + Database.TABLE_NAME_FOR_RUNSHEET + " ("
                    + "runsheetID INTEGER PRIMARY KEY AUTOINCREMENT"
                    + ", eventID INTEGER FOREIGN_KEY REFERENCES EVENT(eventID)"
                    + ", activity TEXT NOT NULL"
                    + ", activity_time INTEGER NOT NULL"
                    + ");");
                smt.execute();
                
                insert = sharedConnection.prepareStatement("INSERT INTO " + Database.TABLE_NAME_FOR_RUNSHEET + " (runsheetID, eventID, activity, activity_time)"    
                    + " VALUES (600001, 300001,'Meet at Coffs Harbour',1630), "
                    + "(600002, 300001,'Look at Big Banana' ,1640), "
                    + "(600003, 300001,'Take pictures' ,1645), "
                    + "(600004, 300001,'Have a drink inside' ,1655), "
                    + "(600005, 300001,'Leave Coffs Harbour', 1830), "
                    + "(600006, 300002,'Gather inside the church', 1200), "
                    + "(600007, 300002,'Wedding ceremony starts', 1230), "
                    + "(600008, 300002,'Wedding ceremony ends',1330), "
                    + "(600009, 300002,'Wedding reception starts',1600), "
                    + "(600010, 300002,'Dinner served',1800), "
                    + "(600011, 300002,'Dancing',1900), "
                    + "(600012, 300002,'Wedding reception ends' ,2000), "
                    + "(600013, 300003,'Meet at South Steyne' ,0600), "
                    + "(600014, 300003,'Swimming' ,0700), "
                    + "(600015, 300003,'Breakfast on the beach' ,0800), "
                    + "(600016, 300003,'More swimming' ,0845), "
                    + "(600017, 300003,'Event ends' ,1000), "
                    + "(600018, 300004,'Fly to Ayers Rock',0300), "
                    + "(600019, 300004,'Meet at the rock''s base', 0600), "
                    + "(600020, 300004,'Take pictures', 0630), "
                    + "(600021, 300004,'Learn about history', 0700), "
                    + "(600022, 300004,'Event ends', 0900), "
                    + "(600023, 300005,'Gates open' ,2000),"
                    + "(600024, 300005,'Queen set' ,2030),"
                    + "(600025, 300005,'ACDC set' ,2100),"
                    + "(600026, 300005,'Cold Chisel set' ,2130),"
                    + "(600027, 300005,'Celine Dion set',2200),"
                    + "(600028, 300005,'Concert ends',2230),"
                    + "(600029, 300006,'Guests are welcome',1900),"
                    + "(600030, 300006,'Music starts',1910),"
                    + "(600031, 300006,'Sing happy birthday',2000),"
                    + "(600032, 300006,'Cutting the cake',2010),"
                    + "(600033, 300006,'Party ends',2300),"
                    + "(600034, 300007,'Gather in the parking lot',1200),"
                    + "(600035, 300007,'Track is explained',1210),"
                    + "(600036, 300007,'Maps are distributed',1220),"
                    + "(600037, 300007,'Run starts',1230),"
                    + "(600038, 300007,'Run ends',1400),"
                    + "(600039, 300008,'Doors open',1800),"
                    + "(600040, 300008,'Lucky door prizes commence',1815),"
                    + "(600041, 300008,'Round 1 and 2',1830),"
                    + "(600042, 300008,'Dinner',1900),"
                    + "(600043, 300008,'Round 3 and 4',1945),"
                    + "(600044, 300008,'Winners announced',2030),"
                    + "(600045, 300008,'Trivia night ends',2100),"
                    + "(600046, 300009,'School starts',0900),"
                    + "(600047, 300009,'Bring cow into library',1000),"
                    + "(600048, 300009,'Trash principal''s car',1100),"
                    + "(600049, 300009,'Spray paint classroom walls',1200),"
                    + "(600050, 300009,'School ends',1500),"
                    + "(600051, 300010,'Doors open',1800),"
                    + "(600052, 300010,'Welcoming by General Manager',1830),"
                    + "(600053, 300010,'Ladies prizes',1900),"
                    + "(600054, 300010,'Dinner is served',1930),"
                    + "(600055, 300010,'Men''s prizes',2000),"
                    + "(600056, 300010,'Dessert is served',2030),"
                    + "(600057, 300010,'Performance by comedian',2035),"
                    + "(600058, 300010,'Presentation ends',2200),"
                    + "(600059, 300011,'Talent quest begins',0900),"
                    + "(600060, 300011,'Singing acts',0930),"
                    + "(600061, 300011,'Dancing acts',1030),"
                    + "(600062, 300011,'Magic acts',1130),"
                    + "(600063, 300011,'Comedy acts',1230),"
                    + "(600064, 300011,'Winner announced',1400),"
                    + "(600065, 300012,'Event begins',1700),"
                    + "(600066, 300012,'Charity information',1730),"
                    + "(600067, 300012,'Raffle starts',1800),"
                    + "(600068, 300012,'Raffle ends',1930),"
                    + "(600069, 300013,'Karaoke begins',1900),"
                    + "(600070, 300013,'Drinks',2000),"
                    + "(600071, 300013,'More karaoke',2030),"
                    + "(600072, 300013,'Move to a bar',2130),"
                    + "(600073, 300013,'Event ends',2300),"
                    + "(600074, 300014,'Marathon begins',1400),"
                    + "(600075, 300014,'Watch first two movies',1415),"
                    + "(600076, 300014,'Make more popcorn',1700),"
                    + "(600077, 300014,'Watch three more movies',1730),"
                    + "(600078, 300014,'Marathon ends',2200),"
                    + "(600079, 300015,'Registration outside pro shop',0700),"
                    + "(600080, 300015,'Breakfast available in the cafe',0730),"
                    + "(600081, 300015,'Shotgun start',0800),"
                    + "(600082, 300015,'Golf finishes',1200),"
                    + "(600083, 300015,'Drinks at the clubhouse bar',1230),"
                    + "(600084, 300015,'Winners announced',1300),"
                    + "(600085, 300015,'Event ends',1600),"
                    + "(600086, 300016,'Registration starts',0600),"
                    + "(600087, 300016,'Under 18''s start',0700),"
                    + "(600088, 300016,'Under 21''s start',0730),"
                    + "(600089, 300016,'Open division starts',0800),"
                    + "(600090, 300016,'Races end',1200),"
                    + "(600091, 300016,'Winners announced',1230),"
                    + "(600092, 300016,'Event ends',0700)"
                    + ";");
                insert.execute();
                sharedConnection.close();
                
            } else {
                System.out.println("RUNSHEET table exists");
                sharedConnection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean adminTryLogin(String username, String password) {
        //Admin current = new Admin(adminID, username, password);
        boolean loginSuccessful = false;
        try {
            openConnection();
            PreparedStatement ps = sharedConnection.prepareStatement("SELECT * FROM ADMIN WHERE username = ? AND password = ?;");
            //ps.setInt(1, adminID);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loginSuccessful = true;
                
                AdminSession newAdmin = new AdminSession(returnAdminInt(username,password), username, password);
                newAdmin = AdminSession.getInstance(returnAdminInt(username,password), username, password);
            }
            rs.close();
            sharedConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginSuccessful;
    }
    
    public static int returnAdminInt (String username, String password) throws SQLException {
        openConnection();
        PreparedStatement admin = sharedConnection.prepareStatement("SELECT adminID FROM ADMIN WHERE username = ? AND password = ?;");
                admin.setString(1, username);
                admin.setString(2, password);
                ResultSet adminrs = admin.executeQuery();
                long adminID = adminrs.getLong(1);
                int adminInt = (int)adminID;
                sharedConnection.close();
                return adminInt;
    }
    
    public static int returnGuestInt (String access_code) throws SQLException {
        openConnection();
        PreparedStatement guest = sharedConnection.prepareStatement("SELECT guestID FROM GUEST WHERE access_code = ?;");
                guest.setString(1, access_code);
                ResultSet guestrs = guest.executeQuery();
                long guestID = guestrs.getLong(1);
                int guestInt = (int)guestID;
                
                sharedConnection.close();
                return guestInt;
                
                
    }

    
    public boolean guestTryLogin(String access_code) {
        boolean loginSuccessful = false;
        try {
            openConnection();
            PreparedStatement ps = sharedConnection.prepareStatement("SELECT access_code FROM GUEST WHERE access_code = ?;");
            ps.setString(1, access_code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loginSuccessful = true;
                
                GuestSession newGuest = new GuestSession(returnGuestInt(access_code), access_code);
                newGuest = GuestSession.getInstance(returnGuestInt(access_code), access_code);
                
            }
            rs.close();
            sharedConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginSuccessful;
    }
    
    public ArrayList<Event> returnAdminEventTable(int adminID) {
        ArrayList<Event> events = new ArrayList<>();
        try {
            Database.openConnection();
            String sqlString = "SELECT * FROM " + Database.TABLE_NAME_FOR_EVENT
                    + " WHERE adminID = ?";
            PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
            psmt.setInt(1, adminID);
            ResultSet rs;
            rs = psmt.executeQuery();
            while(rs.next()) {
                events.add(new Event(rs.getInt("eventID"), rs.getString("event_location"), 
                rs.getString("event_title"), rs.getDate("event_date").toLocalDate(), 
                rs.getInt("event_time"), rs.getInt("adminID")));
            }
            rs.close();
            sharedConnection.close();
        //Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return events;
        }
    }
    
        public Event returnAdminEventView(String eventTitle) {
            Event selected = null;
        try {
            Database.openConnection();
            String sqlString = "SELECT * FROM " + Database.TABLE_NAME_FOR_EVENT
                    + " WHERE event_title = ?";
            PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
            psmt.setString(1, eventTitle);
            ResultSet rs;
            rs = psmt.executeQuery();
            while(rs.next()) {
                selected = new Event(rs.getInt("eventID"), rs.getString("event_location"), 
               rs.getString("event_title"), rs.getDate("event_date").toLocalDate(), 
                rs.getInt("event_time"), rs.getInt("adminID"));
                
            }
            rs.close();
            sharedConnection.close();
        //Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return selected;
    }
        
    
        public ArrayList<Guest> returnAdminGuestTable(int adminID) {
        ArrayList<Guest> guests = new ArrayList<>();
        
        try {
            Database.openConnection();
            String sqlString = "SELECT * FROM " + Database.TABLE_NAME_FOR_GUEST
                    +" WHERE adminID = ?";
            PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
            psmt.setInt(1, adminID);
            ResultSet rs;
            rs = psmt.executeQuery();
            while(rs.next()) {
                guests.add(new Guest(rs.getInt("guestID"), rs.getString("access_code"),
                        rs.getString("email_address"), rs.getString("fname"), 
                        rs.getString("lname"), rs.getInt("adminID")));
            }
            rs.close();
            sharedConnection.close();
        //Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return guests;
        }
    }
        
        public void updateAdminGuestTable(Guest selected) {      
        try {
            Database.openConnection();
            String sqlString = "UPDATE " + Database.TABLE_NAME_FOR_GUEST + " SET fname = '" + selected.getfname() +"', "
                    + "lname = '" + selected.getlname() + "', email_address = '" + selected.getemail_address() + "' WHERE guestID = " + selected.getguestID() + ";";
            PreparedStatement psmt;
            psmt = sharedConnection.prepareStatement(sqlString);
            psmt.executeUpdate();
            psmt.close();
            sharedConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
        
        public void updateEventView(Event update) {      
            try {
                Database.openConnection();
                String sqlString = "UPDATE " + Database.TABLE_NAME_FOR_EVENT + " SET event_title = '" + update.getevent_title() +"', "
                    + "event_location = '" + update.getevent_location() + "', event_time = " + update.getevent_time() 
                    + ", event_date = '" + update.getevent_date() + " 00:00:00.00' WHERE eventID = " + update.geteventID() + ";";
            PreparedStatement psmt;
            psmt = sharedConnection.prepareStatement(sqlString);
            psmt.executeUpdate();
            psmt.close();
            sharedConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
        
    public void deleteEventView(int eventID) {      
        try {
            Database.openConnection();
            String sqlString = "DELETE FROM " + Database.TABLE_NAME_FOR_EVENT + " WHERE eventID = " + eventID;
            PreparedStatement psmt;
            psmt = sharedConnection.prepareStatement(sqlString);
            psmt.executeUpdate();
            psmt.close();
            sharedConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

       public ArrayList<RSVP> returnAdminEventRSVP(int eventID) {
        ArrayList<RSVP> rsvp = new ArrayList<>();
        
        try {
            Database.openConnection();
            String sqlString = "SELECT rsvpID, decision, dietary_notes, rsvp_date, INVITATION.invitationID, GUEST.fname, GUEST.lname FROM " + Database.TABLE_NAME_FOR_RSVP
                    + " INNER JOIN " + Database.TABLE_NAME_FOR_INVITATION + " ON RSVP.invitationID = INVITATION.invitationID INNER JOIN " + Database.TABLE_NAME_FOR_GUEST + 
                    " ON GUEST.guestID = INVITATION.guestID WHERE INVITATION.eventID = ?";
            PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
            psmt.setInt(1, eventID);
            ResultSet rs;
            rs = psmt.executeQuery();
            while(rs.next()) {
                rsvp.add(new RSVP(rs.getInt("rsvpID"), rs.getString("decision"), rs.getString("dietary_notes"), rs.getDate("rsvp_date").toLocalDate(),
                        rs.getInt("invitationID"), rs.getString("fname"), rs.getString("lname")));
            }
            rs.close();
            sharedConnection.close();
        //Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return rsvp;
        }
    }

    boolean adminWelcomeText(Label welcomeLabel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertIntoEvent(Event newEvent) throws SQLException {      
        Database.openConnection();
            String sqlString = "INSERT INTO " + Database.TABLE_NAME_FOR_EVENT + " (event_location, event_title,"
                + "event_date, event_time, adminID) VALUES('" + newEvent.getevent_location()
                + "' , '" + newEvent.getevent_title() + "' , '" + newEvent.getevent_date() + " 00:00:00.00' , " + newEvent.getevent_time()
                + " , " + newEvent.getadminID() + ");";
        PreparedStatement psmt;
        psmt = sharedConnection.prepareStatement(sqlString);
        psmt.executeUpdate();
        psmt.close();
        sharedConnection.close();

    }

    public void insertIntoRunsheet(Runsheet eventRunsheet) throws SQLException {      
        Database.openConnection();
            String sqlString = "INSERT INTO " + Database.TABLE_NAME_FOR_RUNSHEET + " (eventID, activity, activity_time)"
                + " VALUES(" + eventRunsheet.geteventID() + " , '" + eventRunsheet.getactivity()
                + "' , " + eventRunsheet.getactivity_time() + ");";
        PreparedStatement psmt;
        psmt = sharedConnection.prepareStatement(sqlString);
        psmt.executeUpdate();
        psmt.close();
        sharedConnection.close();
    }
    
    public ArrayList<Runsheet> returnEventRunsheetTable(int eventID) {
        ArrayList<Runsheet> runsheet = new ArrayList<>();
        try {
            Database.openConnection();
            String sqlString = "SELECT * FROM " + Database.TABLE_NAME_FOR_RUNSHEET
                    + " WHERE eventID = ? ORDER BY activity_time ASC;";
            PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
            psmt.setInt(1, eventID);
            ResultSet rs;
            rs = psmt.executeQuery();
            while(rs.next()) {
                runsheet.add(new Runsheet(rs.getInt("runsheetID"),rs.getInt("eventID"), rs.getString("activity"), 
                rs.getInt("activity_time")));
            }
            rs.close();
            sharedConnection.close();
        //Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return runsheet;
        }
    }
    
    
    
    public void updateRunsheetTable(Runsheet selected) {      
        try {
            Database.openConnection();
            String sqlString = "UPDATE " + Database.TABLE_NAME_FOR_RUNSHEET + " SET activity = '" + selected.getactivity() +"', "
                    + "activity_time = " + selected.getactivity_time() + " WHERE runsheetID = " + selected.getrunsheetID() + ";";
            PreparedStatement psmt;
            psmt = sharedConnection.prepareStatement(sqlString);
            psmt.executeUpdate();
            psmt.close();
            sharedConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void insertIntoInvitation(int guestID, int eventID, int adminID) throws SQLException {      
        Database.openConnection();
            String sqlString = "INSERT INTO " + Database.TABLE_NAME_FOR_INVITATION + " (eventID, guestID, adminID)"
                + " VALUES(? , ? , ? );";
        PreparedStatement psmt;      
        psmt = sharedConnection.prepareStatement(sqlString);
        psmt.setInt(1, eventID);
        psmt.setInt(2, guestID);
        psmt.setInt(3, adminID);
        psmt.executeUpdate();
        psmt.close();
        sharedConnection.close();

    }

    public ArrayList<GuestEventRSVP> returnGuestEventTable(int guestID) {
        ArrayList<GuestEventRSVP> events = new ArrayList<>();
        try {
            Database.openConnection();
            String sqlString = "SELECT rsvpID, username, event_title, event_date, event_time, event_location,"
                    + "decision, rsvp_date, dietary_notes FROM " + Database.TABLE_NAME_FOR_EVENT + " e INNER JOIN "
                    + Database.TABLE_NAME_FOR_INVITATION + " i ON e.eventID = i.eventID INNER JOIN " 
                    + Database.TABLE_NAME_FOR_RSVP + " r ON r.invitationID = i.invitationID INNER JOIN "
                    + Database.TABLE_NAME_FOR_ADMIN + " a ON a.adminID = i.adminID WHERE i.guestID = ?;";
            PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
            psmt.setInt(1,guestID);
            ResultSet rs;
            rs = psmt.executeQuery();
            while(rs.next()) {
                events.add(new GuestEventRSVP(rs.getInt("rsvpID"),rs.getString("username"), rs.getString("event_location"),
                rs.getString("event_title"),rs.getDate("event_date").toLocalDate(), rs.getInt("event_time"), 
                rs.getString("decision"),rs.getString("dietary_notes"),
                rs.getDate("rsvp_date").toLocalDate()));
                
            }
            rs.close();
            sharedConnection.close();
        //Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return events;
        }
    }

    public void insertIntoRSVP(int invitationID) throws SQLException {      
        Database.openConnection();
            String sqlString = "INSERT INTO " + Database.TABLE_NAME_FOR_RSVP + " (invitationID, decision, dietary_notes, rsvp_date)"
                + " VALUES(" + invitationID + ", 'Pending', 'None', '0000-00-00 00:00:00.00' );";
        PreparedStatement psmt;
        psmt = sharedConnection.prepareStatement(sqlString);
        psmt.executeUpdate();
        psmt.close();
        sharedConnection.close();

    } 

    public int returnInvitationID(int guestID, int eventID, int adminID) {
        int invitationID = 0;
        try {
            Database.openConnection();
            String sqlString = "SELECT invitationID FROM " + Database.TABLE_NAME_FOR_INVITATION
                    + " WHERE guestID = ? AND adminID = ? AND eventID = ?;";
            PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
            psmt.setInt(1, guestID);
            psmt.setInt(2, adminID);
            psmt.setInt(3, eventID);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()) {
                invitationID = rs.getInt("invitationID");
            }
            rs.close();
            sharedConnection.close();
          } catch (SQLException e) {
            e.printStackTrace();
        }
        return invitationID;
    }
    
    public ArrayList<Guest> returnEventGuests(int eventID) {
        ArrayList<Guest> guests = new ArrayList<>();    
            try {
                Database.openConnection();
                String sqlString = "SELECT g.guestID, g.fname, g.lname FROM " + Database.TABLE_NAME_FOR_GUEST
                    + " g INNER JOIN " + Database.TABLE_NAME_FOR_INVITATION + " i ON g.guestID = i.guestID "
                    + " WHERE i.eventID = ?;";
                PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
                psmt.setInt(1, eventID);
                ResultSet rs;
                rs = psmt.executeQuery();
                while(rs.next()) {
                    Guest guest = new Guest();
                    guest.setguestID(rs.getInt("guestID"));
                    guest.setfname(rs.getString("fname"));
                    guest.setlname(rs.getString("lname"));
                    guests.add(guest);
                }
                rs.close();
                sharedConnection.close();
                return guests;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return guests;
    } 
    
        public RSVP returnGuestRSVP(int guestID, int eventID) throws SQLException {
            RSVP guestRSVP = new RSVP();
            Database.openConnection();
            String sqlString = "SELECT rsvpID, decision, INVITATION.invitationID, dietary_notes FROM " + Database.TABLE_NAME_FOR_RSVP
                    + " INNER JOIN " + Database.TABLE_NAME_FOR_INVITATION
                    + " ON RSVP.invitationID = INVITATION.invitationID WHERE INVITATION.eventID= ?"
                    + " AND INVITATION.guestID = ?;";
            PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
            psmt.setInt(1, eventID);
            psmt.setInt(2, guestID);
            ResultSet rs;
            rs = psmt.executeQuery();
            guestRSVP.setrsvpID(rs.getInt("rsvpID"));
            guestRSVP.setdecision(rs.getString("decision"));
            guestRSVP.setinvitationID(rs.getInt("invitationID"));
            guestRSVP.setdietary_requirements(rs.getString("dietary_notes"));
            rs.close();
            sharedConnection.close();
        //Database.closeConnection();
        return guestRSVP;
    }
        
    public void deleteInvitation(int invitationID) {      
        try {
            Database.openConnection();
            String sqlString = "DELETE FROM " + Database.TABLE_NAME_FOR_INVITATION + " WHERE invitationID = " + invitationID
            + ";";
            PreparedStatement psmt;
            psmt = sharedConnection.prepareStatement(sqlString);
            psmt.executeUpdate();
            psmt.close();
            sharedConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void deleteRSVP(int invitationID) {      
        try {
            Database.openConnection();
            String sqlString = "DELETE FROM " + Database.TABLE_NAME_FOR_RSVP + " WHERE invitationID = " + invitationID
            + ";";
            PreparedStatement psmt;
            psmt = sharedConnection.prepareStatement(sqlString);
            psmt.executeUpdate();
            psmt.close();
            sharedConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public void updateGuestRSVP(int invitationID, String decision, String notes) throws SQLException{      
        Database.openConnection();
        String date = "DATETIME('now')";
        String sqlString = "UPDATE " + Database.TABLE_NAME_FOR_RSVP + " SET decision = '" + decision + "' , "
                + " dietary_notes = '" + notes + "', rsvp_date = strftime('%Y-%m-%d %H:%M:%f', 'now') WHERE invitationID = " + invitationID + ";";
        PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
        psmt.executeUpdate();
        psmt.close();
        sharedConnection.close();

    }
    
    public static int returnGuestAdminInt (int guestID) {
        int adminInt = 0;
        try {
            openConnection();
            PreparedStatement admin = sharedConnection.prepareStatement("SELECT adminID FROM GUEST WHERE guestID = ?;");
                admin.setInt(1, guestID);
                ResultSet adminrs = admin.executeQuery();
                long adminID = adminrs.getLong(1);
                adminInt = (int)adminID;
                sharedConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return adminInt;
    }
    
    public int returnRunsheetID(String activity, int time, int eventID) {
        int runsheetID = 0;
        try {
            Database.openConnection();
            String sqlString = "SELECT runsheetID FROM " + Database.TABLE_NAME_FOR_RUNSHEET
                    + " WHERE activity = ? AND activity_time = ? AND eventID = ?;";
            PreparedStatement psmt = sharedConnection.prepareStatement(sqlString);
            psmt.setString(1, activity);
            psmt.setInt(2, time);
            psmt.setInt(3, eventID);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()) {
                runsheetID = rs.getInt("runsheetID");
            }
            rs.close();
            sharedConnection.close();
          } catch (SQLException e) {
            e.printStackTrace();
        }
        return runsheetID;
    }

   
    
    public void inesrtIntoGuest(Guest guest) throws SQLException {      
        Database.openConnection();
            String sqlString = "INSERT INTO " + Database.TABLE_NAME_FOR_GUEST + " (fname, lname, access_code, email_address, adminID)"
                + " VALUES(? , ? , ? , ? , ?);";        
        PreparedStatement psmt;
        psmt = sharedConnection.prepareStatement(sqlString);
        psmt.setString(1,guest.getfname());
        psmt.setString(2,guest.getlname());
        psmt.setString(3,guest.getaccess_code());
        psmt.setString(4,guest.getemail_address());
        psmt.setInt(5,guest.getadminID());
        psmt.executeUpdate();
        psmt.close();
        sharedConnection.close();

    }
    
    public void deleteRunsheet(int runsheetID) {      
        try {
            Database.openConnection();
            String sqlString = "DELETE FROM " + Database.TABLE_NAME_FOR_RUNSHEET + " WHERE runsheetID = " + runsheetID
            + ";";
            PreparedStatement psmt;
            psmt = sharedConnection.prepareStatement(sqlString);
            psmt.executeUpdate();
            psmt.close();
            sharedConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void deleteGuest (int guestID) {      
        try {
            Database.openConnection();
            String sqlString = "DELETE FROM " + Database.TABLE_NAME_FOR_GUEST + " WHERE guestID = " + guestID
            + ";";
            PreparedStatement psmt;
            psmt = sharedConnection.prepareStatement(sqlString);
            psmt.executeUpdate();
            psmt.close();
            sharedConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    
}


