package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else {
            System.out.println("The cart is full, cannot add disc");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
            for (int i = 0; i < dvdList.length; ++i) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("The disc has been added");
            }
        }
        else {
            System.out.println("The cart is full, cannot add disc");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            itemsOrdered[qtyOrdered + 1] = dvd2;
            qtyOrdered += 2;
            System.out.println("The disc has been added");
        }
        else {
            System.out.println("The cart is full, cannot add disc");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        DigitalVideoDisc itemsOrderedRemoved[] = new DigitalVideoDisc[qtyOrdered - 1];
        int j = 0;
        for (int i = 0; i < qtyOrdered; ++i) {
            if (itemsOrdered[i] != disc) {
                itemsOrderedRemoved[j] = itemsOrdered[i];
                j++;
            }
        }
        qtyOrdered--;
        itemsOrdered = itemsOrderedRemoved;
        System.out.println("The disc has been removed");
    }

    public float totalCost() {
        float totalCost = 0.0f;

        for (int i=0; i<qtyOrdered; ++i) {
            totalCost += itemsOrdered[i].getCost();
        }

        return totalCost;
    }

    public void printOrderedItems() {
        System.out.println("********************* CART *********************");
        System.out.println("Ordered Items:");

        for (int i=0; i<qtyOrdered; ++i) {
            DigitalVideoDisc a = itemsOrdered[i];
            System.out.printf("%d. DVD - %s - %s - %s - %s: %.2f $\n", i+1, a.getTitle(), a.getCategory(), a.getDirector(), a.getLength(), a.getCost());
        }

        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("************************************************");
    }

    public void searchById(int id) {
        System.out.printf("Search Results for discs with ID %d\n", id);
        for (int i = 0; i < qtyOrdered; ++i) {
            DigitalVideoDisc a = itemsOrdered[i];
            if (a.getId() == id) {
                System.out.printf("%d: DVD - %s - %s - %s - %s: %.2f $\n", a.getId(), a.getTitle(), a.getCategory(), a.getDirector(), a.getLength(), a.getCost());
            }
        }
    }

    public void searchByTitle(String title) {
        System.out.printf("Search Results for discs with title \"%s\"\n", title);
        for (int i = 0; i < qtyOrdered; ++i) {
            DigitalVideoDisc a = itemsOrdered[i];
            if (a.getTitle().equals(title)) {
                System.out.printf("%d: DVD - %s - %s - %s - %s: %.2f $\n", a.getId(), a.getTitle(), a.getCategory(), a.getDirector(), a.getLength(), a.getCost());
            }
        }
    }

    public void displayCart() {
        System.out.println("********************* CART *********************");
        System.out.println("Cart Contents:");

        if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
        } else {
            for (int i = 0; i < qtyOrdered; ++i) {
                DigitalVideoDisc disc = itemsOrdered[i];
                System.out.printf("%d. DVD - %s - %s - %s - %s: %.2f $\n", i + 1, disc.getTitle(), disc.getCategory(), disc.getDirector(), disc.getLength(), disc.getCost());
            }

            System.out.printf("Total cost: %.2f $\n", totalCost());
        }

        System.out.println("************************************************");
    }

}