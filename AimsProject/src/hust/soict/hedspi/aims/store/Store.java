package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.*;
import java.util.*;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    
    // Remove media from the store
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("This media " + media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("This media " + media.getTitle() + " is not in the store!");
        }
    }

    // Add media from the store
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("This media " + media.getTitle() + " is already in the store!");
        } else {
            itemsInStore.add(media);
            System.out.println("This media " + media.getTitle() + " has been added to the store.");
        }
    }

    
    // Print the store
    public void printStore() {
        if (itemsInStore.size() == 0) {
            System.out.println("The store is empty!");
        } else {
            System.out.println("********************STORE INVENTORY********************");
            for (Media media : itemsInStore) {
                System.out.println(media);
            }
            System.out.println("********************************************************");
        }
    }

    public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }


		
	
    // Store test
    // Add DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.contains(dvd)) {
            System.out.println("This DVD " + dvd.getTitle() + " is already in the store!");
        } else {
            itemsInStore.add(dvd);
            System.out.println("This DVD " + dvd.getTitle() + " has been added to the store.");
        }
    }

}
