package by.fpmibsu.OnlineMarketplace.entity;

public class Phone extends Product{
    public Phone() {
    }

    public Phone(long ID_product_, String name_, String description_, long ID_image_, String manufacturer_,
                 String operational_system_, int RAM_, int ROM_, int production_year_,
                 float screen_diagonal_, String screen_resolution_, int battery_capacity_,
                 String camera_megapixels_, float width_, float length_, float thickness_, float weight_) {
        super(ID_product_, name_, description_, ID_image_);
        this.manufacturer_ = manufacturer_.trim();
        this.operational_system_ = operational_system_.trim();
        this.RAM_ = RAM_;
        this.ROM_ = ROM_;
        this.production_year_ = production_year_;
        this.screen_diagonal_ = screen_diagonal_;
        this.screen_resolution_ = screen_resolution_.trim();
        this.battery_capacity_ = battery_capacity_;
        this.camera_megapixels_ = camera_megapixels_.trim();
        this.width_ = width_;
        this.length_ = length_;
        this.thickness_ = thickness_;
        this.weight_ = weight_;
    }

    public String getManufacturer_() {
        return manufacturer_;
    }

    public void setManufacturer_(String manufacturer_) {
        this.manufacturer_ = manufacturer_.trim();
    }

    public String getOperational_system_() {
        return operational_system_;
    }

    public void setOperational_system_(String operational_system_) {
        this.operational_system_ = operational_system_.trim();
    }

    public int getRAM_() {
        return RAM_;
    }

    public void setRAM_(int RAM_) {
        this.RAM_ = RAM_;
    }

    public int getROM_() {
        return ROM_;
    }

    public void setROM_(int ROM_) {
        this.ROM_ = ROM_;
    }

    public int getProduction_year_() {
        return production_year_;
    }

    public void setProduction_year_(int production_year_) {
        this.production_year_ = production_year_;
    }

    public float getScreen_diagonal_() {
        return screen_diagonal_;
    }

    public void setScreen_diagonal_(float screen_diagonal_) {
        this.screen_diagonal_ = screen_diagonal_;
    }

    public String getScreen_resolution_() {
        return screen_resolution_;
    }

    public void setScreen_resolution_(String screen_resolution_) {
        this.screen_resolution_ = screen_resolution_.trim();
    }

    public int getBattery_capacity_() {
        return battery_capacity_;
    }

    public void setBattery_capacity_(int battery_capacity_) {
        this.battery_capacity_ = battery_capacity_;
    }

    public String getCamera_megapixels_() {
        return camera_megapixels_;
    }

    public void setCamera_megapixels_(String camera_megapixels_) {
        this.camera_megapixels_ = camera_megapixels_.trim();
    }

    public float getWidth_() {
        return width_;
    }

    public void setWidth_(float width_) {
        this.width_ = width_;
    }

    public float getLength_() {
        return length_;
    }

    public void setLength_(float length_) {
        this.length_ = length_;
    }

    public float getThickness_() {
        return thickness_;
    }

    public void setThickness_(float sickness_) {
        this.thickness_ = sickness_;
    }

    public float getWeight_() {
        return weight_;
    }

    public void setWeight_(float weight_) {
        this.weight_ = weight_;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ID_product_=" + ID_product_ +
                ", name_=" + name_ +
                ", description_='" + description_ + '\'' +
                ", ID_image_=" + ID_image_ +
                ", manufacturer_='" + manufacturer_ + '\'' +
                ", operational_system_='" + operational_system_ + '\'' +
                ", RAM_=" + RAM_ +
                ", ROM_=" + ROM_ +
                ", production_year_=" + production_year_ +
                ", screen_diagonal_=" + screen_diagonal_ +
                ", screen_resolution_='" + screen_resolution_ + '\'' +
                ", battery_capacity_=" + battery_capacity_ +
                ", camera_megapixels_='" + camera_megapixels_ + '\'' +
                ", width_=" + width_ +
                ", length_=" + length_ +
                ", sickness_=" + thickness_ +
                ", weight_=" + weight_ +
                '}';
    }

    private String manufacturer_;
    private String operational_system_;
    private int RAM_;
    private int ROM_;
    private int production_year_;
    private float screen_diagonal_;
    private String screen_resolution_;
    private int battery_capacity_;
    private String camera_megapixels_;
    private float width_;
    private float length_;
    private float thickness_;
    private float weight_;
}
