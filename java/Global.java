import java.sql.*;
import java.util.Scanner;

public class Global {
    static Scanner scanner = new Scanner(System.in);
    public static String getUserInput(String msg) {

        if (msg != null)
            System.out.println(msg);

        return scanner.nextLine();

    }

    public static Connection getDatabaseConnection() throws SQLException{
        Connection con;
        String url = "jdbc:postgresql://localhost:5432/g7_store";
        String conID = "g7_store";
        String  conPWD = "zcj7erle";

        try{
            con = DriverManager.getConnection(url, conID, conPWD);
            System.out.println("Connection Established");
            return con;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public static User login() throws SQLException{
        User account;
        boolean admin = false;
        Connection con = Global.getDatabaseConnection();

        boolean access = false;
        String userId = "";
        String password = "";

        while (!access){
            try{
                String QUERY=" call user_login(? , ?)";
                CallableStatement ps = con.prepareCall(QUERY);
                userId = Global.getUserInput("Input username:");
                password = Global.getUserInput("Input password:");
                ps.setString(1,userId)  ;// it means we are setting value 5 at first index.
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                admin = rs.getBoolean("is_admin");
                access = true;
            }catch (SQLException e){
                e.printStackTrace();
            }catch (NullPointerException e){
                con = Global.getDatabaseConnection();
            }
        }
        con.close();

        if(admin){
            account = new Admin(userId, password);
        }
        else{
            account = new Customer(userId, password);
        }

        return account;

    }
}
