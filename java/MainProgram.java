import java.util.Scanner;
import java.sql.*;


public class MainProgram {

    public static void main(String[] args) {
        int run = 1;
        do {
            User user;
            try {
                user = Global.login();
                user.showMenu();
                user.receiveInput(Global.getUserInput("Something"));
            }
            catch (SQLException e){
                e.printStackTrace();
                run = Integer.parseInt(Global.getUserInput("Try again?\n0: no\n1: yes"));
            }

        } while (run != 0);

    }

}
