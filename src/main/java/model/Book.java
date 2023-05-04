package model;

public class Book {

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    private Author author;
    private int id;
    private String image;
    private String name;
    private String EditionName;
    private int EditionYear;
    private String ProductType;
    private int page;
    private String ISBN;
    private int price;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditionName() {
        return EditionName;
    }

    public void setEditionName(String editionName) {
        EditionName = editionName;
    }

    public int getEditionYear() {
        return EditionYear;
    }

    public void setEditionYear(int editionYear) {
        EditionYear = editionYear;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }
}
