package product;

public class Smartphone extends Product {
    private String producer;

    public Smartphone (int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer (String producer) {
        this.producer = producer;
    }
    public boolean matches(Product product, String search) {
        if (super.matches(product, search)){
            return true;
        }
        return getProducer().contains(search);
    }

}
