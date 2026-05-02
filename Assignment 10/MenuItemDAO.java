import java.sql.*;

public class MenuItemDAO {

    public static void insertItem(int id, String name, double price, int resId) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO MenuItem VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, resId);

            ps.executeUpdate();
            System.out.println("Menu Item Added!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewItems() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM MenuItem";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getDouble(3) + " " +
                        rs.getInt(4));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updatePrice(int id, double price) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE MenuItem SET price=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, price);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Updated!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteItem(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM MenuItem WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Deleted!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}