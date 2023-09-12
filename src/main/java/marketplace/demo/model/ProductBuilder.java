package marketplace.demo.model;

public final class ProductBuilder implements ProductBuilderRequiredName, ProductBuilderRequiredPrice {
    private String name;
    private String price;
    private String description;

    private ProductBuilder() {
    }

    public static ProductBuilderRequiredName with() {
        return new ProductBuilder();
    }

    @Override
    public ProductBuilderRequiredPrice name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductBuilder price(String price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Product build() {
        return new Product(name, price, description);
    }
}