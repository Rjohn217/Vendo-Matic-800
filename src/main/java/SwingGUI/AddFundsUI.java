package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddFundsUI extends JFrame {
    private JPanel panel1;
    private JButton button1;
    private JTextPane textPane1;
    private JLabel instructions;

    public AddFundsUI(VendingMachineEventListener vendingMachineEventListener) {
        setContentPane(panel1);
        setTitle("Vendo-Matic 800");
        setSize(700, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                dispose();
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
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
