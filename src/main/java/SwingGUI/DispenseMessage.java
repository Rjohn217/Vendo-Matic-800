package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DispenseMessage extends JFrame {
    private JButton okButton;
    private JLabel dispenseMessageLabel;
    private JPanel dispensePanel;

    public DispenseMessage(VendingMachineEventListener vendingMachineEventListener, String message) {

        setContentPane(dispensePanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        dispenseMessageLabel.setText(message);

        okButton.addActionListener(new ActionListener() {
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
        dispenseMessageLabel = new JLabel();
    }

    public JPanel getDispensePanel() {
        return dispensePanel;
    }
}
