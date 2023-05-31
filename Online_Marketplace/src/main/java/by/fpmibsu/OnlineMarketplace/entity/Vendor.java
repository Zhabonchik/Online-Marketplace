package by.fpmibsu.OnlineMarketplace.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class Vendor implements Serializable {
    public Vendor() {
    }

    public Vendor(long ID_vendor_, String login_, String password_, String name_, String surname_, String contacts_, long ID_image_) {
        this.ID_vendor_ = ID_vendor_;
        this.login_ = login_;
        this.password_ = password_;
        this.name_ = name_;
        this.surname_ = surname_;
        this.contacts_ = contacts_;
        this.ID_image_ = ID_image_;
    }

    public long getID_vendor_() {
        return ID_vendor_;
    }

    public void setID_vendor_(long ID_vendor_) {
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

    public long getID_image_() {
        return ID_image_;
    }

    public void setID_image_(long ID_image_) {
        this.ID_image_ = ID_image_;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "ID_vendor_=" + ID_vendor_ +
                ", login_='" + login_ + '\'' +
                ", password_='" + password_ + '\'' +
                ", name_='" + name_ + '\'' +
                ", surname_='" + surname_ + '\'' +
                ", contacts_='" + contacts_ + '\'' +
                ", ID_image_=" + ID_image_ +
                '}';
    }

    private long ID_vendor_;
    private String login_;
    private String password_;
    private String name_;
    private String surname_;
    private String contacts_;
    private long ID_image_;
}
