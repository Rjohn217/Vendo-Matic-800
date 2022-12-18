package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountBalanceUI extends JFrame {


    private JPanel accountBalancePanel;
    private JPanel balancePanel;
    private JLabel balanceLabel;
    private JButton button1;

    private VendingMachineEventListener vendingMachineEventListener;

    public AccountBalanceUI(VendingMachineEventListener vendingMachineEventListener) {
        this.vendingMachineEventListener = vendingMachineEventListener;
        setContentPane(accountBalancePanel);
        setTitle("Vendo-Matic 800: Account Balance");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame itemsFrame = new JFrame();
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainFrame newMain = new MainFrame(vendingMachineEventListener);
                newMain.setContentPane(newMain.getMainPanel());
                newMain.setVisible(true);
                dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        balanceLabel = new JLabel(vendingMachineEventListener.getBalance());
    }

    public JPanel getAccountBalancePanel() {
        return accountBalancePanel;
    }
}
