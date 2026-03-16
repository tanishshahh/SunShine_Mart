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
        ps.setInt(4, 0); // Temporary 0
        ps.setInt(5, 0); // Temporary 0
        ps.setInt(6, 0);
        ps.setInt(7, 0);
        ps.executeUpdate();


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

        double finalGrandTotal=updateFinalBillAmount(bd,runningTotal);
        con.close();
        System.out.println("\nComplete Purchase Saved! Grand Total: " + finalGrandTotal);
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
        ps.setInt(4, 0);
        ps.setInt(5, 0);
        ps.setInt(6, 0);
        ps.setInt(7, 0);
        ps.executeUpdate();

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

        double finalGrandTotal=updateFinalBillAmount(bd,runningTotal);
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


    public int updateFinalBillAmount(Bill_details bd, int runningTotal) throws Exception {
        Connection con = DBConnection.getPostgresConnection();

        int taxAmount = (runningTotal * bd.getTax()) / 100;
        int discountAmount = (runningTotal * bd.getDiscount()) / 100;
        int finalGrandTotal = runningTotal + taxAmount - discountAmount;

        PreparedStatement psUpdate = con.prepareStatement("UPDATE public.\"Bill_details\" SET tax = ?, discount = ?, total_amount = ?, final_bill = ? WHERE bill_id = ?");
        psUpdate.setInt(1, taxAmount);
        psUpdate.setInt(2, discountAmount);
        psUpdate.setInt(3, runningTotal);
        psUpdate.setInt(4, finalGrandTotal);
        psUpdate.setInt(5, bd.getBill_id());
        psUpdate.executeUpdate();

        con.close();
        return finalGrandTotal;
    }

    //=========================Reports==========================
    /*
    1) low stock
    2) profit in that sale
    3)daily sales
    4) sales according to date
     */

    // ================= REPORTS =================

    // 1. Low Stock Report
    public void lowStock() throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        Statement st = con.createStatement();
        System.out.println("\n--- LOW STOCK ALERT REPORT ---");
        ResultSet rs = st.executeQuery("SELECT pro_id, pro_name, pro_qty FROM public.\"Product\" WHERE pro_qty < 10 ORDER BY pro_qty ASC");

        boolean hasLowStock = false;
        while (rs.next()) {
            hasLowStock = true;
            System.out.println("Product ID: " + rs.getInt("pro_id") +
                    " | Name: " + rs.getString("pro_name") +
                    " | Current Qty: " + rs.getInt("pro_qty") + "  <-- REORDER NEEDED");
        }
        if (!hasLowStock) {
            System.out.println("All product stocks are 10 or more!");
        }
        System.out.println("------------------------------");
        con.close();
    }

    public void profitForDate(String dateString) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement(
                "SELECT bd.bill_id, SUM((bi.sales_price - bi.purchase_price) * bi.qty) AS bill_profit " +
                        "FROM public.\"Bill_details\" bd " +
                        "JOIN public.\"Bill_items\" bi ON bd.bill_id = bi.bill_id " +
                        "WHERE bd.bill_date = ? AND bd.cust_id IS NOT NULL " +
                        "GROUP BY bd.bill_id " +
                        "ORDER BY bd.bill_id ASC"
        );

        ps.setDate(1, java.sql.Date.valueOf(dateString));
        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- PROFIT REPORT FOR DATE: " + dateString + " ---");
        int totalDailyProfit = 0;
        boolean hasSales = false;

        while(rs.next()) {
            hasSales = true;
            int billProfit = rs.getInt("bill_profit");
            totalDailyProfit += billProfit; // Keep a running total for the whole day

            System.out.println("Bill ID: " + rs.getInt("bill_id") +
                    " | Profit for this Bill: Rs." + billProfit);
        }

        if (!hasSales) {
            System.out.println("No sales/profit found for this date.");
        }

        System.out.println("=========================================");
        System.out.println("TOTAL PROFIT FOR THE DAY: Rs." + totalDailyProfit);
        System.out.println("=========================================");
        con.close();
    }

    public void dailySalesSummary(String dateString) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement(
                "SELECT COUNT(bill_id) as total_bills, SUM(tax) as total_tax, SUM(discount) as total_discount, SUM(final_bill) as total_revenue " +
                        "FROM public.\"Bill_details\" " +
                        "WHERE cust_id IS NOT NULL AND bill_date = ?"
        );

        ps.setDate(1, java.sql.Date.valueOf(dateString));
        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- SALES SUMMARY FOR: " + dateString + " ---");
        if(rs.next() && rs.getInt("total_bills") > 0) {
            System.out.println("Total Bills Generated: " + rs.getInt("total_bills"));
            System.out.println("Total Tax Collected:   " + rs.getInt("total_tax"));
            System.out.println("Total Discounts Given: " + rs.getInt("total_discount"));
            System.out.println("TOTAL REVENUE:         Rs." + rs.getInt("total_revenue"));
        } else {
            System.out.println("No sales found for this date.");
        }
        System.out.println("----------------------------------------");
        con.close();
    }

    public void salesByDateRange(String startDate, String endDate) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement(
                "SELECT bd.bill_id, c.cust_name, bd.bill_date, bd.total_amount, bd.tax, bd.discount, bd.final_bill " +
                        "FROM public.\"Bill_details\" bd " +
                        "JOIN public.\"Customer\" c ON bd.cust_id = c.cust_id " +
                        "WHERE bd.bill_date BETWEEN ? AND ? " +
                        "ORDER BY bd.bill_date ASC"
        );

        ps.setDate(1, java.sql.Date.valueOf(startDate));
        ps.setDate(2, java.sql.Date.valueOf(endDate));

        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- DETAILED SALES FROM " + startDate + " TO " + endDate + " ---");
        boolean hasRecords = false;

        while(rs.next()) {
            hasRecords = true;
            System.out.println("Date: " + rs.getDate("bill_date") +
                    " | Bill ID: " + rs.getInt("bill_id") +
                    " | Customer: " + rs.getString("cust_name") +
                    " | Final Bill: " + rs.getInt("final_bill"));
        }

        if (!hasRecords) {
            System.out.println("No sales found during this time period.");
        }
        System.out.println("---------------------------------------------------------");
        con.close();
    }
    /*
1) report : enter product name, get all bills where that product is.
2) report: enter date , get all products sold (group by) in desc, get the final amount of that product sold and also profit earned.
3) report: enter date , get all products sold (group by), get the final amount of that product sold and also profit earned in desc.
 */
    public void bills_byProducts(String productname) throws Exception {
        Connection con=DBConnection.getPostgresConnection();
        PreparedStatement ps=con.prepareStatement("select bd.bill_id, bd.bill_date, bi.qty, bi.sales_price, bi.subtotal \n" +
                "from public.\"Bill_details\" bd \n" +
                "join public.\"Bill_items\" bi on bd.bill_id = bi.bill_id \n" +
                "join public.\"Product\" p on bi.pro_id = p.pro_id \n" +
                "where p.pro_name ilike ? and bd.cust_id is not null \n" +
                "ORDER BY bd.bill_date, bd.bill_id desc");

        ps.setString(1,productname);
        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- Bills containing product: "+productname+" ---");
        boolean hasRecords=false;
        while(rs.next()){
            hasRecords =true;
            System.out.println("Date: "+rs.getDate("bill_date")+
                    " | Bill ID: "+ rs.getInt("bill_id")+
                    " | Qty Bought: "+ rs.getInt("qty") +
                    " | Price: Rs." +rs.getInt("sales_price") +
                    " | Subtotal: Rs."+ rs.getInt("subtotal"));
        }
        if (!hasRecords) {
            System.out.println("No sales found for this product.");
        }
        System.out.println("--------------------------------------------------");
        con.close();
    }

    public void report_procuct_sold(String startdate,String enddate) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement("select p.pro_name, sum(bi.qty) as total_qty, \n" +
                "       sum(bi.subtotal) as total_amount, \n" +
                "       sum((bi.sales_price - bi.purchase_price)*bi.qty) as total_profit \n" +
                "from public.\"Bill_items\" bi \n" +
                "join public.\"Product\" p on bi.pro_id = p.pro_id \n" +
                "join public.\"Bill_details\" bd on bi.bill_id = bd.bill_id \n" +
                "where bd.bill_date between ? and ? and bd.cust_id is not null \n" +
                "group by p.pro_name \n" +
                "order by total_qty desc;");

        ps.setDate(1, java.sql.Date.valueOf(startdate));
        ps.setDate(2, java.sql.Date.valueOf(enddate));
        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- Bills contining highest products sold ---");
        System.out.println("From: "+startdate+ " to "+enddate);
        boolean hasRecords=false;
        while(rs.next()){
            hasRecords =true;
            System.out.println("Product name: "+rs.getString("pro_name")+
                    " | Total qty: "+ rs.getInt("qty")+
                    " | Total Amount: "+ rs.getInt("subtotal") +
                    " | Total Profit" +rs.getInt("total_profit"));
        }
        if (!hasRecords) {
            System.out.println("No sales found for this product.");
        }
        System.out.println("--------------------------------------------------");
        con.close();
    }

    public void report_highest_profit_product(String startdate,String enddate) throws Exception {
        Connection con = DBConnection.getPostgresConnection();
        PreparedStatement ps = con.prepareStatement(
                "select p.pro_name, sum(bi.qty) as total_qty, \n" +
                        "       sum(bi.subtotal) as total_amount, \n" +
                        "       sum((bi.sales_price - bi.purchase_price)*bi.qty) as total_profit \n" +
                        "from public.\"Bill_items\" bi \n" +
                        "join public.\"Product\" p on bi.pro_id = p.pro_id \n" +
                        "join public.\"Bill_details\" bd on bi.bill_id = bd.bill_id \n" +
                        "where bd.bill_date between ? and ? and bd.cust_id is not null \n" +
                        "group by p.pro_name \n" +
                        "order by total_profit desc;"
        );

        ps.setDate(1, java.sql.Date.valueOf(startdate));
        ps.setDate(2, java.sql.Date.valueOf(enddate));
        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- Products with highest profits earned ---");
        System.out.println("From: " + startdate + " to " + enddate);
        boolean hasRecords = false;

        while(rs.next()){
            hasRecords = true;
            System.out.println("Product name: " + rs.getString("pro_name") +
                    " | Total qty: " + rs.getInt("total_qty") +
                    " | Total Amount: " + rs.getInt("total_amount") +
                    " | Total Profit: " + rs.getInt("total_profit"));
        }

        if (!hasRecords) {
            System.out.println("No sales found for this time period.");
        }
        System.out.println("--------------------------------------------------");
        con.close();
    }
}

