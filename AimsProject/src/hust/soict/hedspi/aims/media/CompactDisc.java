package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track is already in the list");
            return;
        }
        else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track is in the list, removing");
            tracks.remove(track);
        }
        else {
            return;
        }
    }

    @Override
    public int getLength() {
        int length = 0;

        for (int i=0; i<tracks.size(); ++i) {
            length += tracks.get(i).getLength();
        }

        return length;
    }

    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (int i=0; i<tracks.size(); ++i) {
            tracks.get(i).play();
        }
    }
    @Override
    public String toString() {
        return "CD: " + this.getTitle() + " - Category: " + this.getCategory() + " - Artist: " + this.getArtist() + " - Cost: " + this.getCost() + "$";
    }
}