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
        con.close();
    }

    public void deleteProduct(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("delete from public.Product where pro_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Product Deleted");
        con.close();
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
        con.close();
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
        con.close();
    }

    //===============Customer==================
    public void insertCustomer(customer c) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("insert into public.customer values(?,?,?,?,?)");

        ps.setInt(1, c.getCust_id());
        ps.setString(2, c.getCust_name());
        ps.setString(3, c.getCust_number());
        ps.setString(4,c.getCust_address());
        ps.setString(5,c.getCust_email());

        ps.executeUpdate();
        System.out.println("Customer Inserted");
        con.close();
    }

    public void updateCustomer(customer c) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("update public.customer set cust_name=?,cust_number=?,cust_address=?,cust_email=? where cust_id=?");

        ps.setString(1, c.getCust_name());
        ps.setString(2, c.getCust_number());
        ps.setString(3,c.getCust_address());
        ps.setString(4,c.getCust_email());
        ps.setInt(5, c.getCust_id());

        ps.executeUpdate();
        System.out.println("Customer Updated");
        con.close();
    }

    public void deleteCustomer(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("delete from public.customer where cust_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Customer Deleted");
        con.close();
    }

    public void viewCustomer() throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from public.customer");
        while (rs.next()) {

            System.out.println("Customer ID: " + rs.getInt(1));
            System.out.println("Customer Name: " + rs.getString(2));
            System.out.println("Customer Number: "+rs.getString(3));
            System.out.println("Customer Address"+rs.getString(4));
            System.out.println("Customer Email " + rs.getString(5));
            System.out.println("---------------------------");
        }
        con.close();
    }

    public void searchCustomer(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("select * from public.customer where cust_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Customer ID: " + rs.getInt(1));
            System.out.println("Customer Name: " + rs.getString(2));
            System.out.println("Customer Number: "+rs.getString(3));
            System.out.println("Customer Address"+rs.getString(4));
            System.out.println("Customer Email " + rs.getString(5));
        }
        con.close();
    }

//================ Vendor==============

    public void insertVendor(Vendor v) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("insert into public.Vendor values(?,?,?,?,?)");

        ps.setInt(1, v.getVendor_id());
        ps.setString(2, v.getVendor_name());
        ps.setString(3, v.getVendor_number());
        ps.setString(4,v.getVendor_address());
        ps.setString(5,v.getVendor_email());

        ps.executeUpdate();
        System.out.println("Vendor Inserted");
        con.close();
    }

    public void updateVendor(Vendor v) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("update public.Vendor set vendor_name=?,vendor_number=?, vendor_address=?,vendor_email=? where vendor_id=?");

        ps.setString(1, v.getVendor_name());
        ps.setString(2, v.getVendor_number());
        ps.setString(3,v.getVendor_address());
        ps.setString(4, v.getVendor_email());
        ps.setInt(5, v.getVendor_id());

        ps.executeUpdate();
        System.out.println("Vendor Updated");
        con.close();
    }

    public void deleteVendor(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("delete from public.Vendor where vendor_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Vendor Deleted");
        con.close();
    }

    public void viewVendor() throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from public.Vendor");
        while (rs.next()) {

            System.out.println("Vendor ID: " + rs.getInt(1));
            System.out.println("Vendor Name: " + rs.getString(2));
            System.out.println("Vendor Number: "+rs.getString(3));
            System.out.println("Vendor Address"+rs.getString(4));
            System.out.println("Vendor Email " + rs.getString(5));
            System.out.println("---------------------------");
        }
        con.close();
    }

    public void searchVendor(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps =con.prepareStatement("select * from public.Vendor where vendor_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Vendor ID: " + rs.getInt(1));
            System.out.println("Vendor Name: " + rs.getString(2));
            System.out.println("Vendor Number: "+rs.getString(3));
            System.out.println("Vendor Address"+rs.getString(4));
            System.out.println("Vendor Email " + rs.getString(5));
            System.out.println("---------------------------");
        }
        con.close();
    }

}
