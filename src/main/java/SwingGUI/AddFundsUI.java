package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFundsUI extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private JTextPane textPane1;
    private VendingMachineEventListener vendingMachineEventListener;

    public AddFundsUI(VendingMachineEventListener vendingMachineEventListener) {
        this.vendingMachineEventListener = vendingMachineEventListener;
        setContentPane(panel1);
        setTitle("Vendo-Matic 800: Add Funds");
        setSize(700, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame itemsFrame = new JFrame();
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int amountToFeed;
                while (true) {
                    try {
                        amountToFeed = Integer.parseInt(textPane1.getText());
                        break;
                    } catch (NumberFormatException ignored) {

                    }
                }
                vendingMachineEventListener.doFeed(amountToFeed * 100);
                MainFrame newMain = new MainFrame(vendingMachineEventListener);
                newMain.setContentPane(newMain.getMainPanel());
                newMain.setVisible(true);
                dispose();
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
