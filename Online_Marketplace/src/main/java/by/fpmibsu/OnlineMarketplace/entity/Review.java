package by.fpmibsu.OnlineMarketplace.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class Review implements Serializable {
    public Review() {
    }

    public Review(long ID_user_, long ID_product_, String review_) {
        this.ID_user_ = ID_user_;
        this.ID_product_ = ID_product_;
        this.review_ = review_;
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

    private long ID_user_;
    private long ID_product_;
    private String review_;
}
