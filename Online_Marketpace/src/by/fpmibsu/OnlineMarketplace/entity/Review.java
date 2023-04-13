package by.fpmibsu.OnlineMarketplace.entity;

public class Review {
    public Review() {
    }

    public Review(int ID_user_, int ID_product_, String review_) {
        this.ID_user_ = ID_user_;
        this.ID_product_ = ID_product_;
        this.review_ = review_;
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

    public String getReview_() {
        return review_;
    }

    public void setReview_(String review_) {
        this.review_ = review_;
    }

    @Override
    public String toString() {
        return "Review{" +
                "ID_user_=" + ID_user_ +
                ", ID_product_=" + ID_product_ +
                ", review_='" + review_ + '\'' +
                '}';
    }

    private int ID_user_;
    private int ID_product_;
    private String review_;
}
