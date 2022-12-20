package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.*;

public class AddFundsUI extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private JTextPane textPane1;
    private JLabel instructions;
    private JLabel balanceLabel;

    public AddFundsUI(VendingMachineEventListener vendingMachineEventListener) {
        setContentPane(panel1);
        setTitle("Vendo-Matic 800");
        setSize(700, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        balanceLabel.setText("Balance: " + vendingMachineEventListener.getBalance());
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int amountToFeed;
                if (!textPane1.getText().isEmpty()) {
                    amountToFeed = Integer.parseInt(textPane1.getText());
                    vendingMachineEventListener.doFeed(amountToFeed * 100);
                }
                MainFrame newMain = new MainFrame(vendingMachineEventListener);
                dispose();
            }
        });
    }
}
