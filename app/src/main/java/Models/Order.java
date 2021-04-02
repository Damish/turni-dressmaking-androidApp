package Models;

public class Order {

    String id;
    String customerName;
    String date;
    int item1Price;
    int item2Price;
    int item3Price;
    int item4Price;
    int item5Price;
    int total;
    int discount;

    public Order() {
    }

    public Order(String id, String customerName, String date, int item1Price, int item2Price, int item3Price, int item4Price, int item5Price, int total, int discount) {
        this.id = id;
        this.customerName = customerName;
        this.date = date;
        this.item1Price = item1Price;
        this.item2Price = item2Price;
        this.item3Price = item3Price;
        this.item4Price = item4Price;
        this.item5Price = item5Price;
        this.total = total;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getItem1Price() {
        return item1Price;
    }

    public void setItem1Price(int item1Price) {
        this.item1Price = item1Price;
    }

    public int getItem2Price() {
        return item2Price;
    }

    public void setItem2Price(int item2Price) {
        this.item2Price = item2Price;
    }

    public int getItem3Price() {
        return item3Price;
    }

    public void setItem3Price(int item3Price) {
        this.item3Price = item3Price;
    }

    public int getItem4Price() {
        return item4Price;
    }

    public void setItem4Price(int item4Price) {
        this.item4Price = item4Price;
    }

    public int getItem5Price() {
        return item5Price;
    }

    public void setItem5Price(int item5Price) {
        this.item5Price = item5Price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}