package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = 
			FXCollections.observableArrayList();
    public int addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() <  MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The media has been added to the cart");
			return 1;
		} else {
			throw new LimitExceededException("ERROR: The cart is almost full"); 
		}
	}
    
    public int addMedia(Media media1, Media media2) throws LimitExceededException {
		int countAdded = 0;
		try {
			countAdded += addMedia(media1);
			countAdded += addMedia(media2);
		} catch (LimitExceededException e) {
			throw e;
		}
		
		return countAdded;		
	}
	public int addMedia(ArrayList<Media> medias) throws LimitExceededException {
		int countAdded = 0;
		for (int i=0; i<medias.size(); i++) {
			try {
				countAdded += addMedia(medias.get(i));
			} catch (LimitExceededException e) {
				throw e;
			}
		}
		return countAdded;
	}
	
    public void removeMedia(Media media) {
        if (itemsOrdered.size() == 0) {
            System.out.println("What do you want to remove?");
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


	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public Media getChosenItem() {
		if (itemsOrdered.size() >= 5) {
			int index = (int)(Math.random() * itemsOrdered.size());
			Media chosenItem = itemsOrdered.get(index);
			System.out.println("The lucky item: " + chosenItem);
			
			removeMedia(chosenItem);
			System.out.println("The bill of this order is " + totalCost());
			
			return chosenItem;
		}
		return null;
	}
}