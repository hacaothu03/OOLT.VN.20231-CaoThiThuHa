package hust.soict.hedspi.swing;
import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {

    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    // Constructor to setup the GUI components and event handlers
    public AWTAccumulator() {
        setLayout(new GridLayout(2,2));

        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TfInputListener());

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);

        // Xử lý sự kiện đóng cửa sổ
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    private class TfInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == tfInput) {
                try {
                    int numberIn = Integer.parseInt(tfInput.getText());
                    sum += numberIn;
                    tfInput.setText("");
                    tfOutput.setText(Integer.toString(sum));
                } catch (NumberFormatException ex) {
                    // Xử lý nếu người dùng nhập không phải là số
                    tfInput.setText("Invalid input");
                }
            }
        }
    }
}
