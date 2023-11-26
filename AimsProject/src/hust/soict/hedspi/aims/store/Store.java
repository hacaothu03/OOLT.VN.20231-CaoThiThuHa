package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.*;
import java.util.*;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

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

	public void addDVD(DigitalVideoDisc dvd2) {
		// TODO Auto-generated method stub
		
	}
}
