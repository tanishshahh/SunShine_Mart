import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Crud crud = new Crud();
        int mainChoice;

        do {
            System.out.println("==============================");
            System.out.println("\t MART MANAGEMENT SYSTEM ");
            System.out.println("==============================");
            System.out.println("1. PRODUCT MENU");
            System.out.println("2. CUSTOMER MENU");
            System.out.println("3. VENDOR MENU");
            System.out.println("4. SALES");
            System.out.println("5. PURCHASE");
            System.out.println("6. REPORTS");
            System.out.println("7. EXIT");
            System.out.println("==============================");

            System.out.print("Select Category: ");
            mainChoice = sc.nextInt();

            switch (mainChoice) {
                // ================= PRODUCT MENU =================
                case 1:
                    int productChoice;
                    do {
                        System.out.println("\n=======================");
                        System.out.println("\t\tPRODUCT MENU ");
                        System.out.println("=======================");
                        System.out.println("1. INSERT PRODUCT");
                        System.out.println("2. UPDATE PRODUCT");
                        System.out.println("3. DELETE PRODUCT");
                        System.out.println("4. VIEW PRODUCTS");
                        System.out.println("5. SEARCH PRODUCT");
                        System.out.println("6. BACK");
                        System.out.println("=======================");
                        System.out.print("Select Option: ");
                        productChoice = sc.nextInt();

                        switch (productChoice) {
                            case 1:
                                String addProduct;
                                do {
                                    Product pInsert = new Product();
                                    System.out.print("Enter Product ID: ");
                                    pInsert.setPro_id(sc.nextInt());
                                    sc.nextLine(); // consume newline
                                    System.out.print("Enter Product Name: ");
                                    pInsert.setPro_name(sc.nextLine());
                                    System.out.print("Enter Purchase Price: ");
                                    pInsert.setPurcahse_price(sc.nextInt());
                                    System.out.print("Enter Sales Price: ");
                                    pInsert.setSales_price(sc.nextInt());
                                    System.out.print("Enter Product Quantity: ");
                                    pInsert.setPro_qty(sc.nextInt());
                                    System.out.print("Enter Vendor ID: ");
                                    pInsert.setVendor_id(sc.nextInt());

                                    crud.insertProduct(pInsert);

                                    System.out.print("Do you want to add another product? (y/n): ");
                                    addProduct = sc.next();
                                } while (addProduct.equalsIgnoreCase("y"));
                                break;
                            case 2:
                                Product pUpdate = new Product();
                                System.out.print("Enter Product ID to Update: ");
                                pUpdate.setPro_id(sc.nextInt());
                                sc.nextLine();
                                System.out.print("Enter New Product Name: ");
                                pUpdate.setPro_name(sc.nextLine());
                                System.out.print("Enter New Purchase Price: ");
                                pUpdate.setPurcahse_price(sc.nextInt());
                                System.out.print("Enter New Sales Price: ");
                                pUpdate.setSales_price(sc.nextInt());
                                System.out.print("Enter New Product Quantity: ");
                                pUpdate.setPro_qty(sc.nextInt());
                                System.out.print("Enter New Vendor ID: ");
                                pUpdate.setVendor_id(sc.nextInt());

                                crud.updateProduct(pUpdate);
                                break;
                            case 3:
                                System.out.print("Enter Product ID to Delete: ");
                                int deleteId = sc.nextInt();
                                crud.deleteProduct(deleteId);
                                break;
                            case 4:
                                System.out.println("\n--- All Products ---");
                                crud.viewProducts();
                                break;
                            case 5:
                                System.out.print("Enter Product ID to Search: ");
                                int searchId = sc.nextInt();
                                crud.searchProduct(searchId);
                                break;
                            case 6:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid input!");
                                break;
                        }
                    } while (productChoice != 6);
                    break;

                // ================= CUSTOMER MENU =================
                case 2:
                    int customerChoice;
                    do {
                        System.out.println("\n=======================");
                        System.out.println("\t\tCUSTOMER MENU ");
                        System.out.println("=======================");
                        System.out.println("1. INSERT CUSTOMER");
                        System.out.println("2. UPDATE CUSTOMER");
                        System.out.println("3. DELETE CUSTOMER");
                        System.out.println("4. VIEW CUSTOMERS");
                        System.out.println("5. SEARCH CUSTOMER");
                        System.out.println("6. BACK");
                        System.out.println("=======================");
                        System.out.print("Select Option: ");
                        customerChoice = sc.nextInt();

                        switch (customerChoice) {
                            case 1:
                                String addCustomer;
                                do {
                                    customer cInsert = new customer();
                                    System.out.print("Enter Customer ID: ");
                                    cInsert.setCust_id(sc.nextInt());
                                    sc.nextLine();
                                    System.out.print("Enter Customer Name: ");
                                    cInsert.setCust_name(sc.nextLine());
                                    System.out.print("Enter Customer Number: ");
                                    cInsert.setCust_number(sc.nextLine());
                                    System.out.print("Enter Customer Address: ");
                                    cInsert.setCust_address(sc.nextLine());
                                    System.out.print("Enter Customer Email: ");
                                    cInsert.setCust_email(sc.nextLine());

                                    crud.insertCustomer(cInsert);

                                    System.out.print("Do you want to add another customer? (y/n): ");
                                    addCustomer = sc.next();
                                } while (addCustomer.equalsIgnoreCase("y"));
                                break;
                            case 2:
                                customer cUpdate = new customer();
                                System.out.print("Enter Customer ID to Update: ");
                                cUpdate.setCust_id(sc.nextInt());
                                sc.nextLine();
                                System.out.print("Enter New Customer Name: ");
                                cUpdate.setCust_name(sc.nextLine());
                                System.out.print("Enter New Customer Number: ");
                                cUpdate.setCust_number(sc.nextLine());
                                System.out.print("Enter New Customer Address: ");
                                cUpdate.setCust_address(sc.nextLine());
                                System.out.print("Enter New Customer Email: ");
                                cUpdate.setCust_email(sc.nextLine());

                                crud.updateCustomer(cUpdate);
                                break;
                            case 3:
                                System.out.print("Enter Customer ID to Delete: ");
                                int delCustId = sc.nextInt();
                                crud.deleteCustomer(delCustId);
                                break;
                            case 4:
                                System.out.println("\n--- All Customers ---");
                                crud.viewCustomer();
                                break;
                            case 5:
                                System.out.print("Enter Customer ID to Search: ");
                                int searchCustId = sc.nextInt();
                                crud.searchCustomer(searchCustId);
                                break;
                            case 6:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid input!");
                                break;
                        }
                    } while (customerChoice != 6);
                    break;

                // ================= VENDOR MENU =================
                case 3:
                    int vendorChoice;
                    do {
                        System.out.println("\n=======================");
                        System.out.println("\t\tVENDOR MENU ");
                        System.out.println("=======================");
                        System.out.println("1. INSERT VENDOR");
                        System.out.println("2. UPDATE VENDOR");
                        System.out.println("3. DELETE VENDOR");
                        System.out.println("4. VIEW VENDORS");
                        System.out.println("5. SEARCH VENDOR");
                        System.out.println("6. BACK");
                        System.out.println("=======================");
                        System.out.print("Select Option: ");
                        vendorChoice = sc.nextInt();

                        switch (vendorChoice) {
                            case 1:
                                String addVendor;
                                do {
                                    Vendor vInsert = new Vendor();
                                    System.out.print("Enter Vendor ID: ");
                                    vInsert.setVendor_id(sc.nextInt());
                                    sc.nextLine();
                                    System.out.print("Enter Vendor Name: ");
                                    vInsert.setVendor_name(sc.nextLine());
                                    System.out.print("Enter Vendor Number: ");
                                    vInsert.setVendor_number(sc.nextLine());
                                    System.out.print("Enter Vendor Address: ");
                                    vInsert.setVendor_address(sc.nextLine());
                                    System.out.print("Enter Vendor Email: ");
                                    vInsert.setVendor_email(sc.nextLine());

                                    crud.insertVendor(vInsert);

                                    System.out.print("Do you want to add another vendor? (y/n): ");
                                    addVendor = sc.next();
                                } while (addVendor.equalsIgnoreCase("y"));
                                break;
                            case 2:
                                Vendor vUpdate = new Vendor();
                                System.out.print("Enter Vendor ID to Update: ");
                                vUpdate.setVendor_id(sc.nextInt());
                                sc.nextLine();
                                System.out.print("Enter New Vendor Name: ");
                                vUpdate.setVendor_name(sc.nextLine());
                                System.out.print("Enter New Vendor Number: ");
                                vUpdate.setVendor_number(sc.nextLine());
                                System.out.print("Enter New Vendor Address: ");
                                vUpdate.setVendor_address(sc.nextLine());
                                System.out.print("Enter New Vendor Email: ");
                                vUpdate.setVendor_email(sc.nextLine());

                                crud.updateVendor(vUpdate);
                                break;
                            case 3:
                                System.out.print("Enter Vendor ID to Delete: ");
                                int delVendId = sc.nextInt();
                                crud.deleteVendor(delVendId);
                                break;
                            case 4:
                                System.out.println("\n--- All Vendors ---");
                                crud.viewVendor();
                                break;
                            case 5:
                                System.out.print("Enter Vendor ID to Search: ");
                                int searchVendId = sc.nextInt();
                                crud.searchVendor(searchVendId);
                                break;
                            case 6:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid input!");
                                break;
                        }
                    } while (vendorChoice != 6);
                    break;

                // ================= SALES (CUSTOMER) MENU =================
                case 4:
                    int salesChoice;
                    do {
                        System.out.println("\n=======================");
                        System.out.println("\t  SALES MENU ");
                        System.out.println("=======================");
                        System.out.println("1. Create New Sale Bill");
                        System.out.println("2. View All Sales");
                        System.out.println("3. Search Sale by Customer ID");
                        System.out.println("4. Delete Sale Bill");
                        System.out.println("5. BACK");
                        System.out.println("=======================");
                        System.out.print("Select Option: ");
                        salesChoice = sc.nextInt();

                        switch (salesChoice) {
                            case 1:
                                Bill_details salesBd = new Bill_details();
                                System.out.print("Enter Bill ID: ");
                                salesBd.setBill_id(sc.nextInt());
                                System.out.print("Enter Customer ID: ");
                                salesBd.setCust_id(sc.nextInt());
                                sc.nextLine();
                                System.out.print("Enter Bill Date (YYYY-MM-DD): ");
                                salesBd.setBill_date(sc.nextLine());

                                System.out.print("Enter Discount Percentage (%): ");
                                salesBd.setDiscount(sc.nextInt());

                                salesBd.setTax(18);
                                salesBd.setFinal_bill(0);

                                crud.cust_insertBill(salesBd);

                                salesBd.setFinal_bill(0);
                                break;
                            case 2:
                                System.out.println("\n--- All Customer Sales ---");
                                crud.cust_viewDetails();
                                break;
                            case 3:
                                System.out.print("Enter Customer ID to search their bills: ");
                                crud.searchOrder_customer(sc.nextInt());
                                break;
                            case 4:
                                System.out.print("Enter Bill ID to delete: ");
                                crud.cust_deleteOrder(sc.nextInt());
                                break;
                            case 5:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid input!");
                                break;
                        }
                    } while (salesChoice != 5);
                    break;

                // ================= PURCHASE (VENDOR) MENU =================
                case 5:
                    int purchaseChoice;
                    do {
                        System.out.println("\n=======================");
                        System.out.println("\t PURCHASE MENU ");
                        System.out.println("=======================");
                        System.out.println("1. Create New Purchase Bill");
                        System.out.println("2. View All Purchases");
                        System.out.println("3. Search Purchase by Vendor ID");
                        System.out.println("4. BACK");
                        System.out.println("=======================");
                        System.out.print("Select Option: ");
                        purchaseChoice = sc.nextInt();

                        switch (purchaseChoice) {
                            case 1:
                                Bill_details purchBd = new Bill_details();
                                System.out.print("Enter Bill ID: ");
                                purchBd.setBill_id(sc.nextInt());
                                System.out.print("Enter Vendor ID: ");
                                purchBd.setVendor_id(sc.nextInt());
                                sc.nextLine();
                                System.out.print("Enter Bill Date (YYYY-MM-DD): ");
                                purchBd.setBill_date(sc.nextLine());

                                System.out.print("Enter Discount Percentage (%): ");
                                purchBd.setDiscount(sc.nextInt());

                                purchBd.setTax(18);
                                purchBd.setFinal_bill(0);

                                crud.vendor_insertBill(purchBd);
                                break;
                            case 2:
                                System.out.println("\n--- All Vendor Purchases ---");
                                crud.vendor_viewDetails();
                                break;
                            case 3:
                                System.out.print("Enter Vendor ID to search their bills: ");
                                crud.searchOrder_vendor(sc.nextInt());
                                break;
                            case 4:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid input!");
                                break;
                        }
                    } while (purchaseChoice != 4);
                    break;
                case 6:
                    int reportChoice;
                    do {
                        System.out.println("\n==============================");
                        System.out.println("\t REPORTS MENU ");
                        System.out.println("==============================");
                        System.out.println("1. Low Stock  Report");
                        System.out.println("2. Profit for a Specific Sale");
                        System.out.println("3. Daily Sales Summary");
                        System.out.println("4. Sales by Date Range (Start & End)");
                        System.out.println("5. Sales by Product");
                        System.out.println("6. Highest Selling Product");
                        System.out.println("7. Highest Profiting Products");
                        System.out.println("8. Back to Main Menu");
                        System.out.println("==============================");
                        System.out.print("Enter your choice: ");
                        reportChoice = sc.nextInt();

                        switch (reportChoice) {
                            case 1:
                                crud.lowStock();
                                break;

                            case 2:
                                System.out.print("Enter the Date (YYYY-MM-DD) to calculate profit: ");
                                String profitDate = sc.next();
                                crud.profitForDate(profitDate);
                                break;

                            case 3:
                                System.out.print("Enter Date (YYYY-MM-DD) for Sales Summary: ");
                                String summaryDate = sc.next();
                                crud.dailySalesSummary(summaryDate);
                                break;

                            case 4:
                                System.out.print("Enter Start Date (YYYY-MM-DD): ");
                                String startDate = sc.next();
                                System.out.print("Enter End Date (YYYY-MM-DD): ");
                                String endDate = sc.next();
                                crud.salesByDateRange(startDate, endDate);
                                break;
                            case 5:
                                System.out.println("Enter Product Name:");
                                String productname=sc.next();

                                crud.bills_byProducts(productname);
                                break;
                            case 6:
                                System.out.println("Enter Start Date:");
                                String startdate=sc.next();
                                System.out.println("Enter End Date:");
                                String enddate=sc.next();

                                crud.report_procuct_sold(startdate,enddate);
                                break;
                            case 7:
                                System.out.println("Enter Start Date:");
                                String startdate1=sc.next();
                                System.out.println("Enter End Date:");
                                String enddate1=sc.next();

                                crud.report_highest_profit_product(startdate1,enddate1);
                                break;


                            case 8:
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("Invalid Choice! Please enter a number between 1 and 5.");
                        }
                    } while (reportChoice != 5);
                    break;
                case 7:
                    System.out.println("Exiting Mart Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Input! Please select a valid option.");
                    break;
            }
        } while (mainChoice !=7);

        sc.close();
    }
}