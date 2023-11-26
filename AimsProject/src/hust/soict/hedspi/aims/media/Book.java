package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title) {
        super(title);
    }
    public Book(String title, String category) {
        super(title, category);
    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            return;
        }
        else {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
        else {
            return;
        }
    }
    
    @Override
    public String toString() {
        return "Book: " + this.getTitle() + " - Category: " + this.getCategory() + " - Cost: " + this.getCost() + "$";
    }
}