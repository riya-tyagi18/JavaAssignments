import java.sql.*;

public class RestaurantDAO {

    public static void insertRestaurant(int id, String name, String address) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO Restaurant VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, address);

            ps.executeUpdate();
            System.out.println("Restaurant Added!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewRestaurants() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM Restaurant";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteRestaurant(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM Restaurant WHERE Id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Deleted!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}