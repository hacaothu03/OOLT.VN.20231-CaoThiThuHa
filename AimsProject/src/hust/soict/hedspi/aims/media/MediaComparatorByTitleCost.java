package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        if (media1.getTitle().compareTo(media2.getTitle()) < 0) {
            return -1;
        }
        else if (media1.getTitle().compareTo(media2.getTitle()) > 0) {
            return 1;
        }
        else {
            if (media1.getCost() < media2.getCost()) {
                return -1;
            }
            else if (media1.getCost() > media2.getCost()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}