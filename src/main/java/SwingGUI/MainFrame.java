package SwingGUI;


import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JTextArea welcomeToVendoMatic;
    private JButton purchaseItemsButton;
    private JButton accountBalanceButton;
    private JButton addFundsButton;
    private JButton listItemsButton;
    private JButton giveChange;
    private VendingMachineEventListener vendingMachineEventListener;


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
                ChipCandyDrinkGum frame2 = new ChipCandyDrinkGum(vendingMachineEventListener);
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
        addFundsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddFundsUI addFundsUI = new AddFundsUI(vendingMachineEventListener);
                addFundsUI.setContentPane(addFundsUI.getPanel1());
                addFundsUI.setVisible(true);
                dispose();
            }
        });
        giveChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vendingMachineEventListener.doGiveChange();
            }
        });

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                vendingMachineEventListener.exitProgram();
            }
        });

        listItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Inventory inventoryUI = new Inventory(vendingMachineEventListener);
                inventoryUI.setContentPane(inventoryUI.getInventoryPanel());
                inventoryUI.setVisible(true);
                dispose();
            }
        });
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
}