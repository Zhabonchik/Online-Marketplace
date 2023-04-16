package by.fpmibsu.OnlineMarketplace.entity;

public class User {
    public User() {
    }

    public User(long ID_user_, Role role_, String login_, String password_, String name_, String surname_, String contacts_, int ID_image_) {
        this.ID_user_ = ID_user_;
        this.role_ = role_;
        this.login_ = login_;
        this.password_ = password_;
        this.name_ = name_;
        this.surname_ = surname_;
        this.contacts_ = contacts_;
        this.ID_image_ = ID_image_;
    }

    public long getID_user_() {
        return ID_user_;
    }

    public void setID_user_(long ID_user_) {
        this.ID_user_ = ID_user_;
    }

    public Role getRole_() {
        return role_;
    }

    public void setRole_(Role role_) {
        this.role_ = role_;
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
    public boolean correctPassword(String password){
        return password.equals(this.password_);
    }

    private long ID_user_;
    private Role role_;
    private String login_;
    private String password_;
    private String name_;
    private String surname_;
    private String contacts_;
    private long ID_image_;
}
