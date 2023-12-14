package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
	private static Store store;
	JPanel centerPanel;
	
	public StoreManagerScreen(Store store) {
		this.store = store;

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		centerPanel = createCenter();
		cp.add(centerPanel, BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStoreMenu = new JMenuItem("View store");
		menu.add(viewStoreMenu);
		viewStoreMenu.addActionListener(new btnMenuListener());
		
		JMenu smUpdateStore = new JMenu("Update store");
		JMenuItem addBookMenu = new JMenuItem("Add Book");
		JMenuItem addCDMenu = new JMenuItem("Add CD");
		JMenuItem addDVDMenu = new JMenuItem("Add DVD");
		
		smUpdateStore.add(addBookMenu);
		smUpdateStore.add(addCDMenu);
		smUpdateStore.add(addDVDMenu);
		menu.add(smUpdateStore);
		
		addBookMenu.addActionListener(new btnMenuListener());
		addDVDMenu.addActionListener(new btnMenuListener());
		addCDMenu.addActionListener(new btnMenuListener());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0; i<mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	private class btnMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen(store);
			} else if (command.equals("Add Book")) {
				new AddBookToStoreScreen(store);
			} else if (command.equals("Add CD")) {
				new AddCompactDiscToStoreScreen(store);
			} else if (command.equals("View Store")) {
				new StoreManagerScreen(store);
			}
			dispose();
		}
	}
	
	public static void main(String[] args) {
	    store = new Store();

	    store.addMedia(new CompactDisc("Suivre le soleil", "L'amour", 8.5f, 30, "James", "Maire"));
	    store.addMedia(new CompactDisc("Last Christmas", "Xmas", 10f, 100, "John", "Wham"));
	    store.addMedia(new CompactDisc("Under", "Love", 10f, 90, "Hayaa", "Mike"));
	    store.addMedia(new Book("Harry Potter and Philosopher's Stone (2001)", "JK. Rowling", 5f, 50));
	    store.addMedia(new Book("Harry Potter and Chamber of Secrets (2002)", "JK. Rowling", 5f, 60));
	    store.addMedia(new Book("Harry Potter and Prisoner of Azkaban (2004)", "JK. Rowling", 5f, 70));
	    store.addMedia(new Book("Harry Potter and the Goblet of Fire (2006)", "JK. Rowling", 5f, 80));
	    store.addMedia(new DigitalVideoDisc("How You Like That","Love", "BLACKPINK",40, 50f));
	    store.addMedia(new DigitalVideoDisc("Gone", "Love", "Teddy", 20, 30f));

	    new StoreManagerScreen(store);
	}

}