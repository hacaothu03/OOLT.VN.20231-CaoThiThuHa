package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.*;
import java.util.*;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        }
        else if (itemsOrdered.contains(media)) {
            System.out.println("Already in cart");
        }
        else {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.size() == 0) {
            System.out.println("What the hell are you trying to remove?");
        }
        else {
            if (itemsOrdered.remove(media)) {
                System.out.println(media.getTitle() + "The media has been removed");
            }
            else {
                System.out.println("Is the media even in the cart?");
            }
        }
    }

    public float totalCost() {
        float totalCost = 0.0f;

        for (int i=0; i<itemsOrdered.size(); ++i) {
            totalCost += itemsOrdered.get(i).getCost();
        }

        return totalCost;
    }

    public void printOrderedItems() {
        System.out.println("********************* CART *********************");
        System.out.println("Ordered Items:");

        for (int i=0; i<itemsOrdered.size(); ++i) {
            Media a = itemsOrdered.get(i);
            System.out.printf("%d. DVD - %s - %s: %.2f $\n", i+1, a.getTitle(), a.getCategory(), a.getCost());
        }

        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("************************************************");
    }

    public void searchById(int id) {
        System.out.printf("Search Results for discs with ID %d\n", id);
        for (int i = 0; i < itemsOrdered.size(); ++i) {
            Media a = itemsOrdered.get(i);
            if (a.getId() == id) {
                System.out.printf("%d: DVD - %s - %s: %.2f $\n", a.getId(), a.getTitle(), a.getCategory(), a.getCost());
            }
        }
    }

    public void searchByTitle(String title) {
        System.out.printf("Search Results for discs with title \"%s\"\n", title);
        for (int i = 0; i < itemsOrdered.size(); ++i) {
            Media a = itemsOrdered.get(i);
            if (a.getTitle().equals(title)) {
                System.out.printf("%d: DVD - %s - %s: %.2f $\n", a.getId(), a.getTitle(), a.getCategory(), a.getCost());
            }
        }
    }

    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }

    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }

    public Media searchToRemove(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void empty() {
    }

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1) {
		// TODO Auto-generated method stub
		
	}
}