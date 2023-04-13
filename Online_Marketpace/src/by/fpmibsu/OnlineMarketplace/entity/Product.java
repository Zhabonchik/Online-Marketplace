package by.fpmibsu.OnlineMarketplace.entity;
public class Product {
    public Product() {
    }

    public Product(int ID_product_, int name_, String description_, int ID_image_) {
        this.ID_product_ = ID_product_;
        this.name_ = name_;
        this.description_ = description_;
        this.ID_image_ = ID_image_;
    }

    public int getID_product_() {
        return ID_product_;
    }

    public void setID_product_(int ID_product_) {
        this.ID_product_ = ID_product_;
    }

    public int getName_() {
        return name_;
    }

    public void setName_(int name_) {
        this.name_ = name_;
    }

    public String getDescription_() {
        return description_;
    }

    public void setDescription_(String description_) {
        this.description_ = description_;
    }

    public int getID_image_() {
        return ID_image_;
    }

    public void setID_image_(int ID_image_) {
        this.ID_image_ = ID_image_;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID_product_=" + ID_product_ +
                ", name_=" + name_ +
                ", description_='" + description_ + '\'' +
                ", ID_image_=" + ID_image_ +
                '}';
    }

    protected int ID_product_;
    protected int name_;
    protected String description_;
    protected int ID_image_;
}
