package by.fpmibsu.OnlineMarketplace.entity;

public class Vendor {

    public Vendor(int ID_vendor_, String login_, String password_, String name_, String surname_, String contacts_, int ID_image_) {
        this.ID_vendor_ = ID_vendor_;
        this.login_ = login_;
        this.password_ = password_;
        this.name_ = name_;
        this.surname_ = surname_;
        this.contacts_ = contacts_;
        this.ID_image_ = ID_image_;
    }

    public int getID_vendor_() {
        return ID_vendor_;
    }

    public void setID_vendor_(int ID_vendor_) {
        this.ID_vendor_ = ID_vendor_;
    }

    public String getLogin_() {
        return login_;
    }

    public void setLogin_(String login_) {
        this.login_ = login_;
    }

    public String getPassword_() {
        return password_;
    }

    public void setPassword_(String password_) {
        this.password_ = password_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getSurname_() {
        return surname_;
    }

    public void setSurname_(String surname_) {
        this.surname_ = surname_;
    }

    public String getContacts_() {
        return contacts_;
    }

    public void setContacts_(String contacts_) {
        this.contacts_ = contacts_;
    }

    public int getID_image_() {
        return ID_image_;
    }

    public void setID_image_(int ID_image_) {
        this.ID_image_ = ID_image_;
    }

    private int ID_vendor_;
    private String login_;
    private String password_;
    private String name_;
    private String surname_;
    private String contacts_;
    private int ID_image_;
}