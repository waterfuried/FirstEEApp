public class Product {
    private final int id;
    private final String title;
    private final Float price;

    public Product(int id, String title, Float price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public Float getPrice() { return price; }

    static Float randomNumber(int min, int max) {
        return min + (float)Math.random() * (max - min);
    }
}