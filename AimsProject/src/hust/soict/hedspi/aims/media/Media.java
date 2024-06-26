package hust.soict.hedspi.aims.media;

import java.util.Comparator;

import hust.soict.hedspi.aims.exception.PlayerException;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	
	private static int nbMedia = 0;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
			new MediaComparatorByCostTitle();
	
	
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public int getId() {
		return id;
	}
	
	
	public Media(String title) {
		this.title = title;
		this.dateAdded = LocalDate.now();
		nbMedia++;
		this.id = nbMedia;
	}
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbMedia++;
		this.id = nbMedia;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Media) {
			return ((Media)o).getId() == this.id;
		}
		return false;
		
	}
	
	public String toString() {
		return "Media" + " - " + this.title + " - " + this.category + ": " + this.cost + " $"; 
	}

	
	public boolean isMatch(String title) {
		String[] tokens = title.split(" ", 0);
		for (String token : tokens) {
			if (this.getTitle().contains(token)) {
				return true;
			}
		}
		return false;
	}
	
	public int compareTo(Media d) {
		int titleDiff = this.getTitle().compareTo(d.getTitle());
		if (titleDiff != 0) {
			return titleDiff;
		} else {
			return this.getCategory().compareTo(d.getCategory());
		}
	}

	public abstract StringBuffer play() throws PlayerException;

	public boolean filterProperty(String filter, String type) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else {
    		if (type == "title") {
    			if (this.getTitle().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    				return true;
    			}
    		} else if (type == "id") {
    			if(Integer.toString(this.getId()).toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    				return true;
    			}
    		}
        }
        return false;
	}
}