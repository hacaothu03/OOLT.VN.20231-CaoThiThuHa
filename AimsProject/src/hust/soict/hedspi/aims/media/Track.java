package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Object o) {
        if (o instanceof Track) {
            Track oTrack = (Track) o;
            if (oTrack.getTitle() == this.title && oTrack.getLength() == this.length) {
                return true;
            }
            return false;
        }
        return false;
    }
}