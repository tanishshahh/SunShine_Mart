import java.sql.*;


public class Crud {

//=================Product==============
    public void insertProduct(Product p) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("insert into public.Product values(?,?,?,?,?,?)");

        ps.setInt(1, p.getPro_id());
        ps.setString(2, p.getPro_name());
        ps.setInt(3,p.getPurcahse_price());
        ps.setInt(4,p.getSales_price());
        ps.setInt(5, p.getPro_qty());
        ps.setInt(6,p.getVendor_id());

        ps.executeUpdate();
        System.out.println("Product Inserted");
        con.close();
    }

    public void updateProduct(Product p) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("update public.Product set pro_name=?,purchse_price=?,sales_price=?,pro_qty=?,vendor_id=? where pro_id=?");

        ps.setString(1, p.getPro_name());
        ps.setInt(2,p.getPurcahse_price());
        ps.setInt(3,p.getSales_price());
        ps.setInt(4, p.getPro_qty());
        ps.setInt(5,p.getVendor_id());
        ps.setInt(6, p.getPro_id());

        ps.executeUpdate();
        System.out.println("Product Updated");
    }

    public void deleteProduct(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("delete from public.Product where pro_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Product Deleted");
    }

    public void viewProducts() throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from public.Product");
        while (rs.next()) {

            System.out.println("Product ID: " + rs.getInt(1));
            System.out.println("Product Name: " + rs.getString(2));
            System.out.println("Purchase Price: "+rs.getInt(3));
            System.out.println("Sales Price: "+rs.getInt(4));
            System.out.println("Product Quantity: " + rs.getInt(5));
            System.out.println("Product Vendor Id:"+ rs.getInt(6));
            System.out.println("---------------------------");
        }
    }

    public void searchProduct(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("select * from public.Product where pro_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Product ID: " + rs.getInt(1));
            System.out.println("Product Name: " + rs.getString(2));
            System.out.println("Product Quantity: " + rs.getInt(3));
        }
    }

}
