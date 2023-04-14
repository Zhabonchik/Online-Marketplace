package by.fpmibsu.OnlineMarketplace.entity;

public class Order {
    public Order() {
    }

    public Order(long ID_user_, long ID_product_, long ID_vendor_, String payment_method_, String delivery_date_, String delivery_method_, String comments_) {
        this.ID_user_ = ID_user_;
        this.ID_product_ = ID_product_;
        this.ID_vendor_ = ID_vendor_;
        this.payment_method_ = payment_method_;
        this.delivery_date_ = delivery_date_;
        this.delivery_method_ = delivery_method_;
        this.comments_ = comments_;
    }

    public long getID_user_() {
        return ID_user_;
    }

    public void setID_user_(long ID_user_) {
        this.ID_user_ = ID_user_;
    }

    public long getID_product_() {
        return ID_product_;
    }

    public void setID_product_(long ID_product_) {
        this.ID_product_ = ID_product_;
    }

    public long getID_vendor_() {
        return ID_vendor_;
    }

    public void setID_vendor_(long ID_vendor_) {
        this.ID_vendor_ = ID_vendor_;
    }

    public String getPayment_method_() {
        return payment_method_;
    }

    public void setPayment_method_(String payment_method_) {
        this.payment_method_ = payment_method_;
    }

    public String getDelivery_date_() {
        return delivery_date_;
    }

    public void setDelivery_date_(String delivery_date_) {
        this.delivery_date_ = delivery_date_;
    }

    public String getDelivery_method_() {
        return delivery_method_;
    }

    public void setDelivery_method_(String delivery_method_) {
        this.delivery_method_ = delivery_method_;
    }

    public String getComments_() {
        return comments_;
    }

    public void setComments_(String comments_) {
        this.comments_ = comments_;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID_user_=" + ID_user_ +
                ", ID_product_=" + ID_product_ +
                ", ID_vendor_=" + ID_vendor_ +
                ", payment_method_='" + payment_method_ + '\'' +
                ", delivery_date_='" + delivery_date_ + '\'' +
                ", delivery_method_='" + delivery_method_ + '\'' +
                ", comments_='" + comments_ + '\'' +
                '}';
    }

    private long ID_user_;
    private long ID_product_;
    private long ID_vendor_;
    private String payment_method_;
    private String delivery_date_;
    private String delivery_method_;
    private String comments_;
}
