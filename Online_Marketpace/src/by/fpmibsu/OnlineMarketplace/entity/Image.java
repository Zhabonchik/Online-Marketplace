package by.fpmibsu.OnlineMarketplace.entity;

public class Image {
    public Image(int ID_image_, String link_) {
        this.ID_image_ = ID_image_;
        this.link_ = link_;
    }

    public int getID_image_() {
        return ID_image_;
    }

    public void setID_image_(int ID_image_) {
        this.ID_image_ = ID_image_;
    }

    public String getLink_() {
        return link_;
    }

    public void setLink_(String link_) {
        this.link_ = link_;
    }

    private int ID_image_;
    private String link_;
}
