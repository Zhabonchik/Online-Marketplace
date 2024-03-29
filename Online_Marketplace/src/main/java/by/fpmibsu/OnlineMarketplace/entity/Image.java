package by.fpmibsu.OnlineMarketplace.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class Image implements Serializable {
    public Image() {
    }

    public Image(long ID_image_, String link_) {
        this.ID_image_ = ID_image_;
        this.link_ = link_;
    }

    public long getID_image_() {
        return ID_image_;
    }

    public void setID_image_(long ID_image_) {
        this.ID_image_ = ID_image_;
    }

    public String getLink_() {
        return link_;
    }

    public void setLink_(String link_) {
        this.link_ = link_;
    }

    @Override
    public String toString() {
        return "Image{" +
                "ID_image_=" + ID_image_ +
                ", link_='" + link_ + '\'' +
                '}';
    }

    private long ID_image_;
    private String link_;
}
