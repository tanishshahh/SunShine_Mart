public class Bill_items {
    int bill_id;
    int pro_id;
    int pro_name;
    int qty;
    int purchase_price;
    int sales_price;
    int subtotal;

    public int getPro_name() {
        return pro_name;
    }

    public void setPro_name(int pro_name) {
        this.pro_name = pro_name;
    }

    public int getSales_price() {
        return sales_price;
    }

    public void setSales_price(int sales_price) {
        this.sales_price = sales_price;
    }



    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
