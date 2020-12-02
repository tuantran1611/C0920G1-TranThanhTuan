package on_tap_1.models;

public abstract class Product {
    private int idProduct;
    private String productCode;
    private String productName;
    private String price;
    private String amount;
    private String producer;

    public Product() {
    }

    public Product(int idProduct, String productCode, String productName, String price, String amount, String producer) {
        this.idProduct = idProduct;
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.producer = producer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
