package SwingGUI;


import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JTextArea welcomeToVendoMatic;
    private JButton purchaseItemsButton;
    private JButton accountBalanceButton;
    private JButton addFundsButton;
    private JButton listItemsButton;


    public MainFrame(VendingMachineEventListener vendingMachineEventListener) {
        setContentPane(mainPanel);
        setTitle("Vendo-Matic 800");
        setSize(700, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        purchaseItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChipCandyDrinkGum frame2 = new ChipCandyDrinkGum();
                frame2.setContentPane(frame2.getTypePanel());
                frame2.setVisible(true);
                dispose();
            }
        });


        accountBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AccountBalanceUI accountBalanceUI = new AccountBalanceUI(vendingMachineEventListener);
                accountBalanceUI.setContentPane(accountBalanceUI.getAccountBalancePanel());
                accountBalanceUI.setVisible(true);
                dispose();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
