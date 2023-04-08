package by.fpmibsu.OnlineMarketplace.entity;

public class Order {
    public Order(int ID_user_, int ID_product_, int ID_vendor_, String payment_method_, String delivery_date_, String delivery_method_, String comments_) {
        this.ID_user_ = ID_user_;
        this.ID_product_ = ID_product_;
        this.ID_vendor_ = ID_vendor_;
        this.payment_method_ = payment_method_;
        this.delivery_date_ = delivery_date_;
        this.delivery_method_ = delivery_method_;
        this.comments_ = comments_;
    }

    public int getID_user_() {
        return ID_user_;
    }

    public void setID_user_(int ID_user_) {
        this.ID_user_ = ID_user_;
    }

    public int getID_product_() {
        return ID_product_;
    }

    public void setID_product_(int ID_product_) {
        this.ID_product_ = ID_product_;
    }

    public int getID_vendor_() {
        return ID_vendor_;
    }

    public void setID_vendor_(int ID_vendor_) {
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

    private int ID_user_;
    private int ID_product_;
    private int ID_vendor_;
    private String payment_method_;
    private String delivery_date_;
    private String delivery_method_;
    private String comments_;
}
