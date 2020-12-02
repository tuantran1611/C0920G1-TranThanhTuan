package on_tap_1.models;

public class ProductExport extends Product {
    private String priceExport;
    private String countryEntry;

    public ProductExport() {
    }

    public ProductExport(int idProduct, String productCode, String productName, String price, String amount,
                         String producer, String priceExport, String countryEntry) {
        super(idProduct, productCode, productName, price, amount, producer);
        this.priceExport = priceExport;
        this.countryEntry = countryEntry;
    }

    public String getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(String priceExport) {
        this.priceExport = priceExport;
    }

    public String getCountryEntry() {
        return countryEntry;
    }

    public void setCountryEntry(String countryEntry) {
        this.countryEntry = countryEntry;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ProductExport{" +
                "priceExport='" + priceExport + '\'' +
                ", countryEntry='" + countryEntry + '\'' +
                '}';
    }
}
