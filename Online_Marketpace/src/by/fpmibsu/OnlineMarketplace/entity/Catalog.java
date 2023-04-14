package by.fpmibsu.OnlineMarketplace.entity;

public class Catalog {
    public Catalog() {
    }

    public Catalog(long ID_vendor_, long ID_product_, String category_, double price_, long number_in_stock_) {
        this.ID_vendor_ = ID_vendor_;
        this.ID_product_ = ID_product_;
        this.category_ = category_;
        this.price_ = price_;
        this.number_in_stock_ = number_in_stock_;
    }

    public long getID_vendor_() {
        return ID_vendor_;
    }

    public void setID_vendor_(long ID_vendor_) {
        this.ID_vendor_ = ID_vendor_;
    }

    public long getID_product_() {
        return ID_product_;
    }

    public void setID_product_(long ID_product_) {
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

    public long getNumber_in_stock_() {
        return number_in_stock_;
    }

    public void setNumber_in_stock_(long number_in_stock_) {
        this.number_in_stock_ = number_in_stock_;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "ID_vendor_=" + ID_vendor_ +
                ", ID_product_=" + ID_product_ +
                ", category_='" + category_ + '\'' +
                ", price_=" + price_ +
                ", number_in_stock_=" + number_in_stock_ +
                '}';
    }

    private long ID_vendor_;
    private long ID_product_;
    private String category_;
    private double price_;
    private long number_in_stock_;
}
