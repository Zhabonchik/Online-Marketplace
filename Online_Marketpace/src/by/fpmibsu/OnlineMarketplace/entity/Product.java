package by.fpmibsu.OnlineMarketplace.entity;
public class Product {
    public Product() {
    }

    public Product(long ID_product_, String name_, String description_, long ID_image_) {
        this.ID_product_ = ID_product_;
        this.name_ = name_.trim();
        this.description_ = description_.trim();
        this.ID_image_ = ID_image_;
    }

    public long getID_product_() {
        return ID_product_;
    }

    public void setID_product_(long ID_product_) {
        this.ID_product_ = ID_product_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_.trim();
    }

    public String getDescription_() {
        return description_;
    }

    public void setDescription_(String description_) {
        this.description_ = description_.trim();
    }

    public long getID_image_() {
        return ID_image_;
    }

    public void setID_image_(long ID_image_) {
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

    protected long ID_product_;
    protected String name_;
    protected String description_;
    protected long ID_image_;
}
