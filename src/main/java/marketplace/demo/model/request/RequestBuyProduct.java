package marketplace.demo.model.request;

public class RequestBuyProduct {
    public RequestBuyProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    private String nameProduct;
}
