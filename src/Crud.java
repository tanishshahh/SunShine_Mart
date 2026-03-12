import java.sql.*;


public class Crud {

    //=================Product==============
    public void insertProduct(Product p) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("insert into public.\"Product\" values(?,?,?,?,?,?)");

        ps.setInt(1, p.getPro_id());
        ps.setString(2, p.getPro_name());
        ps.setInt(3, p.getPurcahse_price());
        ps.setInt(4, p.getSales_price());
        ps.setInt(5, p.getPro_qty());
        ps.setInt(6, p.getVendor_id());

        ps.executeUpdate();
        System.out.println("Product Inserted");
        con.close();
    }

    public void updateProduct(Product p) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("update public.\"Product\" set pro_name=?,purchse_price=?,sales_price=?,pro_qty=?,vendor_id=? where pro_id=?");

        ps.setString(1, p.getPro_name());
        ps.setInt(2, p.getPurcahse_price());
        ps.setInt(3, p.getSales_price());
        ps.setInt(4, p.getPro_qty());
        ps.setInt(5, p.getVendor_id());
        ps.setInt(6, p.getPro_id());

        ps.executeUpdate();
        System.out.println("Product Updated");
        con.close();
    }

    public void deleteProduct(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("delete from public.\"Product\" where pro_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Product Deleted");
        con.close();
    }

    public void viewProducts() throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from public.\"Product\"");
        while (rs.next()) {

            System.out.println("Product ID: " + rs.getInt(1));
            System.out.println("Product Name: " + rs.getString(2));
            System.out.println("Purchase Price: " + rs.getInt(3));
            System.out.println("Sales Price: " + rs.getInt(4));
            System.out.println("Product Quantity: " + rs.getInt(5));
            System.out.println("Product Vendor Id:" + rs.getInt(6));
            System.out.println("---------------------------");

        }
        con.close();
    }

    public void searchProduct(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("select * from public.\"Product\" where pro_id=?");
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
        PreparedStatement ps = con.prepareStatement("insert into public.\"Customer\" values(?,?,?,?,?)");

        ps.setInt(1, c.getCust_id());
        ps.setString(2, c.getCust_name());
        ps.setString(3, c.getCust_number());
        ps.setString(4, c.getCust_address());
        ps.setString(5, c.getCust_email());

        ps.executeUpdate();
        System.out.println("Customer Inserted");
        con.close();
    }

    public void updateCustomer(customer c) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("update public.\"Customer\" set cust_name=?,cust_number=?,cust_address=?,cust_email=? where cust_id=?");

        ps.setString(1, c.getCust_name());
        ps.setString(2, c.getCust_number());
        ps.setString(3, c.getCust_address());
        ps.setString(4, c.getCust_email());
        ps.setInt(5, c.getCust_id());

        ps.executeUpdate();
        System.out.println("Customer Updated");
        con.close();
    }

    public void deleteCustomer(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("delete from public.\"Customer\" where cust_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Customer Deleted");
        con.close();
    }

    public void viewCustomer() throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from public.\"Customer\"");
        while (rs.next()) {

            System.out.println("Customer ID: " + rs.getInt(1));
            System.out.println("Customer Name: " + rs.getString(2));
            System.out.println("Customer Number: " + rs.getString(3));
            System.out.println("Customer Address" + rs.getString(4));
            System.out.println("Customer Email " + rs.getString(5));
            System.out.println("---------------------------");
        }
        con.close();
    }

    public void searchCustomer(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("select * from public.\"Customer\" where cust_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Customer ID: " + rs.getInt(1));
            System.out.println("Customer Name: " + rs.getString(2));
            System.out.println("Customer Number: " + rs.getString(3));
            System.out.println("Customer Address" + rs.getString(4));
            System.out.println("Customer Email " + rs.getString(5));
        }
        con.close();
    }

//================ Vendor==============

    public void insertVendor(Vendor v) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("insert into public.\"Vendor\" values(?,?,?,?,?)");

        ps.setInt(1, v.getVendor_id());
        ps.setString(2, v.getVendor_name());
        ps.setString(3, v.getVendor_number());
        ps.setString(4, v.getVendor_address());
        ps.setString(5, v.getVendor_email());

        ps.executeUpdate();
        System.out.println("Vendor Inserted");
        con.close();
    }

    public void updateVendor(Vendor v) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("update public.\"Vendor\" set vendor_name=?,vendor_number=?, vendor_address=?,vendor_email=? where vendor_id=?");

        ps.setString(1, v.getVendor_name());
        ps.setString(2, v.getVendor_number());
        ps.setString(3, v.getVendor_address());
        ps.setString(4, v.getVendor_email());
        ps.setInt(5, v.getVendor_id());

        ps.executeUpdate();
        System.out.println("Vendor Updated");
        con.close();
    }

    public void deleteVendor(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("delete from public.\"Vendor\" where vendor_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Vendor Deleted");
        con.close();
    }

    public void viewVendor() throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from public.\"Vendor\"");
        while (rs.next()) {

            System.out.println("Vendor ID: " + rs.getInt(1));
            System.out.println("Vendor Name: " + rs.getString(2));
            System.out.println("Vendor Number: " + rs.getString(3));
            System.out.println("Vendor Address" + rs.getString(4));
            System.out.println("Vendor Email " + rs.getString(5));
            System.out.println("---------------------------");
        }
        con.close();
    }

    public void searchVendor(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("select * from public.\"Vendor\" where vendor_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Vendor ID: " + rs.getInt(1));
            System.out.println("Vendor Name: " + rs.getString(2));
            System.out.println("Vendor Number: " + rs.getString(3));
            System.out.println("Vendor Address" + rs.getString(4));
            System.out.println("Vendor Email " + rs.getString(5));
            System.out.println("---------------------------");
        }
        con.close();
    }

    //==========Order=============
// --------------------------------Customer-------------------------

    public void cust_insertBill(Bill_details bd) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        PreparedStatement ps = con.prepareStatement("insert into public.\"Bill_details\" (bill_id, cust_id, bill_date, tax, discount, total_amount, final_bill) values(?,?,?,?,?,?,?)");
        ps.setInt(1, bd.getBill_id());
        ps.setInt(2, bd.getCust_id());
        ps.setDate(3, java.sql.Date.valueOf(bd.getBill_date()));
        ps.setInt(4, bd.getTax());
        ps.setInt(5, bd.getDiscount());
        ps.setInt(6, 0);
        ps.setInt(7, 0);
        ps.executeUpdate();
        System.out.println("Bill Details Initialized.");

        System.out.println("\n--- Available Products for Sale ---");
        Statement st = con.createStatement();
        ResultSet rsProd = st.executeQuery("SELECT * FROM public.\"Product\"");
        while (rsProd.next()) {
            System.out.println("ID: " + rsProd.getInt(1) + " | Name: " + rsProd.getString(2) + " | Sales Price: " + rsProd.getInt(4));
        }
        System.out.println("-----------------------------------");

        PreparedStatement ps2 = con.prepareStatement("insert into public.\"Bill_items\" (bill_id, pro_id, qty, purchase_price, sales_price, subtotal) values(?,?,?,?,?,?)");
        PreparedStatement fetchProd = con.prepareStatement("SELECT * FROM public.\"Product\" WHERE pro_id = ?");
        int runningTotal = 0;
        String choice;

        do {
            Bill_items bi = new Bill_items();
            bi.setBill_id(bd.getBill_id());
            System.out.print("Enter Product ID from the list above: ");
            int pId = sc.nextInt();
            bi.setPro_id(pId);

            fetchProd.setInt(1, pId);
            ResultSet rs = fetchProd.executeQuery();

            if (rs.next()) {
                bi.setPurchase_price(rs.getInt(3));
                bi.setSales_price(rs.getInt(4));
                System.out.println("--> Selected: " + rs.getString(2) + " | Price: " + bi.getSales_price());
            } else {
                System.out.println("Invalid Product ID! Please try again.");
            }

            System.out.print("Enter Quantity: ");
            bi.setQty(sc.nextInt());

            int subtotal = bi.getQty() * bi.getSales_price();
            bi.setSubtotal(subtotal);

            runningTotal += subtotal;

            ps2.setInt(1, bi.getBill_id());
            ps2.setInt(2, bi.getPro_id());
            ps2.setInt(3, bi.getQty());
            ps2.setInt(4, bi.getPurchase_price());
            ps2.setInt(5, bi.getSales_price());
            ps2.setInt(6, bi.getSubtotal());
            ps2.executeUpdate();

            decreaseStock(bi.getPro_id(), bi.getQty());
            System.out.println("Product Added. Item Subtotal: " + subtotal);
            System.out.print("Add another product? (y/n): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("y"));

        int finalGrandTotal = runningTotal + bd.getTax() - bd.getDiscount();
        PreparedStatement psUpdate = con.prepareStatement("UPDATE public.\"Bill_details\" SET final_bill = ?, total_amount = ? WHERE bill_id = ?");
        psUpdate.setInt(1, runningTotal);
        psUpdate.setInt(2, finalGrandTotal);
        psUpdate.setInt(3, bd.getBill_id());
        psUpdate.executeUpdate();

        con.close();
        System.out.println("\nComplete Sale Saved! Grand Total: " + finalGrandTotal);
    }


    public void cust_deleteOrder(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("delete from public.\"Bill_details\" where bill_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Order Deleted");
        con.close();
    }

    public void cust_viewDetails() throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT bi.bill_id, bd.bill_date, bd.cust_id, bi.pro_id, p.pro_name, bi.qty, bi.sales_price, bi.subtotal, bd.total_amount, bd.tax, bd.discount, bd.final_bill " +
                        "FROM public.\"Bill_details\" bd " +
                        "JOIN public.\"Bill_items\" bi ON bd.bill_id=bi.bill_id " +
                        "JOIN public.\"Customer\" c ON bd.cust_id=c.cust_id " +
                        "JOIN public.\"Product\" p ON bi.pro_id=p.pro_id " +
                        "ORDER BY bi.bill_id;"
        );

        int lastOrderId = 0;

        while (rs.next()) {
            int currentOrderId = rs.getInt("bill_id");

            if (currentOrderId != lastOrderId) {
                System.out.println("\nBill ID: " + currentOrderId);
                System.out.println("Bill Date: " + rs.getString("bill_date"));
                System.out.println("Customer ID: " + rs.getInt("cust_id"));
                System.out.println("Total Amount: " + rs.getInt("total_amount"));
                System.out.println("Tax: " + rs.getInt("tax"));
                System.out.println("Discount: " + rs.getInt("discount"));
                System.out.println("Final Bill: " + rs.getInt("final_bill"));
                System.out.println("Products:");
                lastOrderId = currentOrderId;
            }
            System.out.println(
                    "Product ID: " + rs.getInt("pro_id") +
                            " Name: " + rs.getString("pro_name") +
                            " Qty: " + rs.getInt("qty") +
                            " Price: " + rs.getInt("sales_price") +
                            " Subtotal: " + rs.getInt("subtotal")
            );
        }
        con.close();
    }

    public void searchOrder_customer(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement(
                "SELECT bi.bill_id, bi.pro_id, p.pro_name, bi.qty, bi.sales_price, bd.cust_id, bd.bill_date, bd.total_amount, bd.tax, bd.discount, bd.final_bill " +
                        "FROM public.\"Bill_items\" bi " +
                        "JOIN public.\"Bill_details\" bd ON bi.bill_id = bd.bill_id " +
                        "JOIN public.\"Product\" p ON bi.pro_id = p.pro_id " +
                        "WHERE bd.cust_id = ?"
        );

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println("Bill ID: " + rs.getInt("bill_id"));
            System.out.println("Product ID: " + rs.getInt("pro_id"));
            System.out.println("Product Name: " + rs.getString("pro_name"));
            System.out.println("Product Qty: " + rs.getInt("qty"));
            System.out.println("Product Price: " + rs.getInt("sales_price"));
            System.out.println("Customer ID: " + rs.getInt("cust_id"));
            System.out.println("Bill Date: " + rs.getString("bill_date"));
            System.out.println("Total Amount: " + rs.getInt("total_amount"));
            System.out.println("Tax: " + rs.getInt("tax"));
            System.out.println("Discount: " + rs.getInt("discount"));
            System.out.println("Final Bill: " + rs.getInt("final_bill"));
            System.out.println("---------------------------");
        }
        con.close();
    }

 //-----------------------------Vendor------------------------------

    public void vendor_insertBill(Bill_details bd) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        java.util.Scanner sc = new java.util.Scanner(System.in);

        PreparedStatement ps = con.prepareStatement("insert into public.\"Bill_details\" (bill_id, vendor_id, bill_date, tax, discount, total_amount, final_bill) values(?,?,?,?,?,?,?)");
        ps.setInt(1, bd.getBill_id());
        ps.setInt(2, bd.getVendor_id());
        ps.setDate(3, java.sql.Date.valueOf(bd.getBill_date()));
        ps.setInt(4, bd.getTax());
        ps.setInt(5, bd.getDiscount());
        ps.setInt(6, 0);
        ps.setInt(7, 0);
        ps.executeUpdate();
        System.out.println("Bill Details Initialized.");

        System.out.println("\n--- Available Products for Purchase ---");
        Statement st = con.createStatement();
        ResultSet rsProd = st.executeQuery("SELECT * FROM public.\"Product\"");
        while (rsProd.next()) {
            System.out.println("ID: " + rsProd.getInt(1) + " | Name: " + rsProd.getString(2) + " | Purchase Price: " + rsProd.getInt(3));
        }
        System.out.println("---------------------------------------");

        PreparedStatement ps2 = con.prepareStatement("insert into public.\"Bill_items\" (bill_id, pro_id, qty, purchase_price, subtotal) values(?,?,?,?,?)");
        PreparedStatement fetchProd = con.prepareStatement("SELECT * FROM public.\"Product\" WHERE pro_id = ?");
        int runningTotal = 0;
        String choice;

        do {
            Bill_items bi = new Bill_items();
            bi.setBill_id(bd.getBill_id());

            System.out.print("Enter Product ID from the list above: ");
            int pId = sc.nextInt();
            bi.setPro_id(pId);

            fetchProd.setInt(1, pId);
            ResultSet rs = fetchProd.executeQuery();

            if (rs.next()) {
                bi.setPurchase_price(rs.getInt(3));
                System.out.println(" Selected: " + rs.getString(2) + " | Purchase Price: " + bi.getPurchase_price());
            } else {
                System.out.println("Invalid Product ID! Please try again.");
            }

            System.out.print("Enter Quantity: ");
            bi.setQty(sc.nextInt());

            int subtotal = bi.getQty() * bi.getPurchase_price();
            bi.setSubtotal(subtotal);

            runningTotal += subtotal;

            ps2.setInt(1, bi.getBill_id());
            ps2.setInt(2, bi.getPro_id());
            ps2.setInt(3, bi.getQty());
            ps2.setInt(4, bi.getPurchase_price());
            ps2.setInt(5, bi.getSubtotal());
            ps2.executeUpdate();


            increaseStock(bi.getPro_id(), bi.getQty());
            System.out.println("Product Added. Item Subtotal: " + subtotal);
            System.out.print("Add another product? (y/n): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("y"));

        int finalGrandTotal = runningTotal + bd.getTax() - bd.getDiscount();
        PreparedStatement psUpdate = con.prepareStatement("UPDATE public.\"Bill_details\" SET final_bill = ?, total_amount = ? WHERE bill_id = ?");
        psUpdate.setInt(1, runningTotal);
        psUpdate.setInt(2, finalGrandTotal);
        psUpdate.setInt(3, bd.getBill_id());
        psUpdate.executeUpdate();

        con.close();
        System.out.println("\nComplete Purchase Saved! Grand Total: " + finalGrandTotal);
    }



    public void vendor_viewDetails() throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT bi.bill_id, bd.bill_date, bd.vendor_id, bi.pro_id, p.pro_name, bi.qty, bi.purchase_price, bi.subtotal, bd.total_amount, bd.tax, bd.discount, bd.final_bill " +
                        "FROM public.\"Bill_details\" bd " +
                        "JOIN public.\"Bill_items\" bi ON bd.bill_id=bi.bill_id " +
                        "JOIN public.\"Vendor\" v ON bd.vendor_id=v.vendor_id " +
                        "JOIN public.\"Product\" p ON bi.pro_id=p.pro_id " +
                        "ORDER BY bi.bill_id;"
        );

        int lastOrderId = 0;

        while (rs.next()) {
            int currentOrderId = rs.getInt("bill_id");

            if (currentOrderId != lastOrderId) {
                System.out.println("\nBill ID: " + currentOrderId);
                System.out.println("Bill Date: " + rs.getString("bill_date"));
                System.out.println("Vendor ID: " + rs.getInt("vendor_id"));
                System.out.println("Total Amount: " + rs.getInt("total_amount"));
                System.out.println("Tax: " + rs.getInt("tax"));
                System.out.println("Discount: " + rs.getInt("discount"));
                System.out.println("Final Bill: " + rs.getInt("final_bill"));
                System.out.println("Products:");
                lastOrderId = currentOrderId;
            }
            System.out.println(
                    "Product ID: " + rs.getInt("pro_id") +
                            " Name: " + rs.getString("pro_name") +
                            " Qty: " + rs.getInt("qty") +
                            " Price: " + rs.getInt("purchase_price") +
                            " Subtotal: " + rs.getInt("subtotal")
            );
        }
        con.close();
    }

    public void searchOrder_vendor(int id) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement(
                "SELECT bi.bill_id, bi.pro_id, p.pro_name, bi.qty, bi.purchase_price, bd.vendor_id, bd.bill_date, bd.total_amount, bd.tax, bd.discount, bd.final_bill " +
                        "FROM public.\"Bill_items\" bi " +
                        "JOIN public.\"Bill_details\" bd ON bi.bill_id = bd.bill_id " +
                        "JOIN public.\"Product\" p ON bi.pro_id = p.pro_id " +
                        "WHERE bd.vendor_id = ?"
        );

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println("Bill ID: " + rs.getInt("bill_id"));
            System.out.println("Product ID: " + rs.getInt("pro_id"));
            System.out.println("Product Name: " + rs.getString("pro_name"));
            System.out.println("Product Qty: " + rs.getInt("qty"));
            System.out.println("Product Price: " + rs.getInt("purchase_price"));
            System.out.println("Vendor ID: " + rs.getInt("vendor_id"));
            System.out.println("Bill Date: " + rs.getString("bill_date"));
            System.out.println("Total Amount: " + rs.getInt("total_amount"));
            System.out.println("Tax: " + rs.getInt("tax"));
            System.out.println("Discount: " + rs.getInt("discount"));
            System.out.println("Final Bill: " + rs.getInt("final_bill"));
            System.out.println("---------------------------");
        }
        con.close();
    }

    // ================= STOCK MANAGEMENT =================
    public void increaseStock(int proId, int qty) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE public.\"Product\" SET pro_qty = pro_qty + ? WHERE pro_id = ?");
        ps.setInt(1, qty);
        ps.setInt(2, proId);
        ps.executeUpdate();
        con.close();
    }

    public void decreaseStock(int proId, int qty) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE public.\"Product\" SET pro_qty = pro_qty - ? WHERE pro_id = ?");
        ps.setInt(1, qty);
        ps.setInt(2, proId);
        ps.executeUpdate();
        con.close();
    }
}

