package vn.codegym.model;

public class Product {
    private int id;
    private String nameProduct;
    private double priceProduct;
    private String descriptionProduct;
    private String producer;

    public Product(int id, String nameProduct, double priceProduct, String descriptionProduct, String producer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.producer = producer;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
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
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
