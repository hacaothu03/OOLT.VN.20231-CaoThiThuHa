package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

class DvdWrapper {
    DigitalVideoDisc obj;

    DvdWrapper(DigitalVideoDisc disc) {
        this.obj = disc;
    }
}

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        DvdWrapper jungle = new DvdWrapper(jungleDVD);
        DvdWrapper cinderella = new DvdWrapper(cinderellaDVD);

        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        swap(jungle, cinderella);

        jungleDVD = jungle.obj;
        cinderellaDVD = cinderella.obj;

        // changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(DvdWrapper o1, DvdWrapper o2) {
        DigitalVideoDisc tmp = o1.obj;
        o1.obj = o2.obj;
        o2.obj = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
