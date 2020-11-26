package on_tap.models;

public class ProductExport extends Product {
    private String countryExport;
    private String priceExport;

    public ProductExport(String countryExport, String priceExport) {
        this.countryExport = countryExport;
        this.priceExport = priceExport;
    }

    public ProductExport(int id, String idProduct, String nameProduct, String priceProduct, String amount, String producer, String countryExport, String priceExport) {
        super(id, idProduct, nameProduct, priceProduct, amount, producer);
        this.countryExport = countryExport;
        this.priceExport = priceExport;
    }

    public String getCountryExport() {
        return countryExport;
    }

    public void setCountryExport(String countryExport) {
        this.countryExport = countryExport;
    }

    public String getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(String priceExport) {
        this.priceExport = priceExport;
    }


    @Override
    public void showInfo() {
        System.out.println(super.toString() + this.toString());
    }

    @Override
    public String toString() {
        return "ProductExport{" +
                "countryExport='" + countryExport + '\'' +
                ", priceExport='" + priceExport + '\'' +
                '}';
    }
}
