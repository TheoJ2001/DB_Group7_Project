import java.sql.*;
public class Admin extends User{
    Menu mode;
    Admin(String username, String password){
        super(username, password);
    }
    public void showMenu(Menu mode){
        switch (mode){
            case Products:
                break;
            case Suppliers:
                break;
            case Discounts:
                break;
            default:

        }
    };

    public void showMenu(){
        showMenu(mode);
    }

    public void printSuppliers(){
        try{
            Connection con = Global.getDatabaseConnection();
            String QUERY = "SELECT * FROM \"supplier\"";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Phone number: " + rs.getString("phone_number"));
                System.out.print(", Address: " + rs.getString("address"));
                System.out.print(", City: " + rs.getString("city"));
                System.out.println(", Zip code: " + rs.getString("zipcode"));
                System.out.println("----------------------------------------------------------");
            }

            stmt.close();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    /*
    public String getProductInfo(){

    } //(admin and customer) // inputs (0):
    public String getSearchedProductInfo(){

    } //(admin and customer) //inputs (2): product name and/or supplier name
    public String orderHistorySingleCustomer(){

    } //(admin and customer) // inputs (1): user.id (när en customer är inloggad så fylls denna input automatisk)
    public String discountStatus(){

    } //(admin and customer) // inputs(2): product name and supplier name
    public void deleteOrder(int id){

    } //(admin and customer) inputs (1): order.id
*/
}
