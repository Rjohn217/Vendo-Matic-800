package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;
import com.techelevator.model.InvalidTransactionException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InvalidTransactionUI extends JFrame {
    private JPanel panel1;
    private JLabel invalidTransactionMessage;
    private JButton okButton;

    public InvalidTransactionUI (VendingMachineEventListener vendingMachineEventListener, InvalidTransactionException invalidTransactionException) {
        setContentPane(panel1);
        setTitle("Vendo-Matic 800: Invalid Transaction");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame itemsFrame = new JFrame();
        setVisible(true);

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                vendingMachineEventListener.exitProgram();
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainFrame newMain = new MainFrame(vendingMachineEventListener);
                newMain.setContentPane(newMain.getMainPanel());
                newMain.setVisible(true);
                dispose();
            }
        });

        invalidTransactionMessage.setText(invalidTransactionException.getMessage());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        invalidTransactionMessage = new JLabel();
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
