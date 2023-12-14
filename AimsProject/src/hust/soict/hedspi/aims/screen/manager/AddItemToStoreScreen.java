package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.store.Store;

// Abstract class for screens to add items to the store
public abstract class AddItemToStoreScreen extends JFrame {
    Store store;
    JPanel centerPanel;
    JButton btnAdd;
    ArrayList<JTextField> tfs = new ArrayList<JTextField>();
    // Constructor taking a Store instance
    public AddItemToStoreScreen(Store store) {
        // Initialize store
        this.store = store;
        
        setSize(1024, 768);
        setLayout(new BorderLayout());
        
        // Add menu bar at the top
        add(createMenuBar(), BorderLayout.NORTH);
        
        // Create panel for the 'Add' button
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAdd = new JButton("Add");
        btnPanel.add(btnAdd);
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // Add button panel at the bottom
        add(btnPanel, BorderLayout.SOUTH);
        
        // Create and add the center panel with input fields
        centerPanel = createCenter();
        add(centerPanel, BorderLayout.CENTER);
        
        // Set frame location and make it visible
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // Create a sub-panel with a label and text field for a specific item attribute
    JPanel createSubPanel(String text) {
        JPanel subPanel = new JPanel(new FlowLayout());
        JTextField tf = new JTextField(50);
        tf.setName(text);
        tfs.add(tf);
        JLabel lbTextField = new JLabel(text);
        
        subPanel.add(lbTextField);
        subPanel.add(tf);
        subPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        return subPanel;
    }
    
    // Create the center panel with sub-panels for input fields
    JPanel createCenter() {
        JPanel centerPanel = new JPanel(new GridLayout(7, 1, 4, 4));
        
        JPanel titlePanel = createSubPanel("Title");
        JPanel categoryPanel = createSubPanel("Category");
        JPanel costPanel = createSubPanel("Cost");
        
        centerPanel.add(titlePanel);
        centerPanel.add(categoryPanel);
        centerPanel.add(costPanel);
        
        return centerPanel;
    }
    
    // Create the menu bar with the 'View store' option
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);
        viewStoreMenu.addActionListener(new btnMenuListener());
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        
        return menuBar;
    }
    
    // ActionListener for the 'View store' menu option
    private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open the Store Manager screen and close the current screen
            new StoreManagerScreen(store);
            dispose();
        }
    }
}
