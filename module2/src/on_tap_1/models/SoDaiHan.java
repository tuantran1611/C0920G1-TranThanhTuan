package on_tap_1.models;

public class SoDaiHan extends Product {
    private String priceImport;
    private String provinceImport;
    private String taxImport;

    public SoDaiHan() {
    }

    public SoDaiHan(int idProduct, String productCode, String productName, String price, String amount,
                    String producer, String priceImport, String provinceImport, String taxImport) {
        super(idProduct, productCode, productName, price, amount, producer);
        this.priceImport = priceImport;
        this.provinceImport = provinceImport;
        this.taxImport = taxImport;
    }

    public String getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(String priceImport) {
        this.priceImport = priceImport;
    }

    public String getProvinceImport() {
        return provinceImport;
    }

    public void setProvinceImport(String provinceImport) {
        this.provinceImport = provinceImport;
    }

    public String getTaxImport() {
        return taxImport;
    }

    public void setTaxImport(String taxImport) {
        this.taxImport = taxImport;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ProductImport{" +
                "priceImport='" + priceImport + '\'' +
                ", provinceImport='" + provinceImport + '\'' +
                ", taxImport='" + taxImport + '\'' +
                '}';
    }
}
