package model;

public class Book {
    private int id;
    private String image;
    private String name;
    private String author;
    private String EditionName;
    private int EditionYear;
    private int page;
    private String ISBN;
    private int price;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
}
