package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
		
		JPanel directoryPanel = super.createSubPanel("Director");
		JPanel lengthPanel = super.createSubPanel("Length");
		
		super.centerPanel.add(directoryPanel, BorderLayout.CENTER);
		super.centerPanel.add(lengthPanel, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add DVD");
		
	}
	
	private class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String title=null, category=null, director=null;
			float cost = 0f; int length = 0;
			for(JTextField tf: tfs) {
				if(tf.getName().equals("Title")) {
					title = tf.getText();
				}
				else if(tf.getName().equals("Cost")) {
					cost = Float.parseFloat(tf.getText());
				}
				else if(tf.getName().equals("Category")) {
					category = tf.getText();
				}
				else if(tf.getName().equals("Director")) {
					System.out.println(tf.getText());
					director = tf.getText();
				}
				else if(tf.getName().equals("Length")) {
					length = Integer.parseInt(tf.getText());
				}	
			}
			
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
			store.addMedia(dvd);
		}
	}

}