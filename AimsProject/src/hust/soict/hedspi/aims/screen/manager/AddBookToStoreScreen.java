package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	public AddBookToStoreScreen(Store store) {
		super(store);
		
		JPanel length = super.createSubPanel("Length");
		
		super.centerPanel.add(length, BorderLayout.CENTER);


		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add Book");
	}
	
	private class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String title=null, category=null;
			float cost=0f;
			int length = 0;
			for (JTextField tf : tfs) {
				if (tf.getName().equals("Title")) {
					title = tf.getText();
				}
				else if (tf.getName().equals("Category")) {
					category = tf.getText();
				}
				else if (tf.getName().equals("Cost")) {
					cost = Float.parseFloat(tf.getText());
				}
				else if(tf.getName().equals("Length")) {
					length = Integer.parseInt(tf.getText());
				}
			}
//	public Book(String title, String category, float cost, int length) {

			Book b =  new Book(title, category, cost, length);
			store.addMedia(b);
		}
	}

}
