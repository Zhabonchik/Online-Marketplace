package by.fpmibsu.OnlineMarketplace.entity;

public class Catalog {
    public Catalog(int ID_vendor_, int ID_product_, String category_, double price_, int number_in_stock_) {
        this.ID_vendor_ = ID_vendor_;
        this.ID_product_ = ID_product_;
        this.category_ = category_;
        this.price_ = price_;
        this.number_in_stock_ = number_in_stock_;
    }

    public int getID_vendor_() {
        return ID_vendor_;
    }

    public void setID_vendor_(int ID_vendor_) {
        this.ID_vendor_ = ID_vendor_;
    }

    public int getID_product_() {
        return ID_product_;
    }

    public void setID_product_(int ID_product_) {
        this.ID_product_ = ID_product_;
    }

    public String getCategory_() {
        return category_;
    }

    public void setCategory_(String category_) {
        this.category_ = category_;
    }

    public double getPrice_() {
        return price_;
    }

    public void setPrice_(double price_) {
        this.price_ = price_;
    }

    public int getNumber_in_stock_() {
        return number_in_stock_;
    }

    public void setNumber_in_stock_(int number_in_stock_) {
        this.number_in_stock_ = number_in_stock_;
    }

    private int ID_vendor_;
    private int ID_product_;
    private String category_;
    private double price_;
    private int number_in_stock_;
}