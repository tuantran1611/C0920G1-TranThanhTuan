package case_study_module_2.models;

public class ExtraService {
    private String nameExtraService;
    private String unit;
    private String price;

    public ExtraService(String nameExtraService, String unit, String price) {
        this.nameExtraService = nameExtraService;
        this.unit = unit;
        this.price = price;
    }

    public ExtraService() {
    }

    public String getNameExtraService() {
        return nameExtraService;
    }

    public void setNameExtraService(String nameExtraService) {
        this.nameExtraService = nameExtraService;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ExtraService{" +
                "nameExtraService='" + nameExtraService + '\'' +
                ", unit='" + unit + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
