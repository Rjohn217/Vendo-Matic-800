package SwingGUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

        public JPanel mainPanel;
        public JTextArea welcomeToVendoMatic;
        public JButton purchaseItemsButton;
        public JButton viewInventoryButton;
        public JButton accountBalanceButton;
        public JButton addFundsButton;

        public MainFrame() {
            setContentPane(mainPanel);
            setTitle("Vendo-Matic 800");
            setSize(700,700);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

            purchaseItemsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e != null && e.getActionCommand().equals("Purchase Items")) {
                        ChipCandyDrinkGum frame2 = new ChipCandyDrinkGum();
                        frame2.setContentPane(frame2.typePanel);
                        frame2.setVisible(true);


                        dispose();
                    }

                }
            } );

            
        }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }
    }
