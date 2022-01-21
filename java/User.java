import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class User{
    private String username;
    private String password;
    String lastInput;
    User(){
        this(null, null);
    }
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public abstract void showMenu();
    public void receiveInput(String input){
        lastInput = input;
    }
}
