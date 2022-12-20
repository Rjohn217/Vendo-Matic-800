package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogBoxUI extends JFrame {
    private JButton ok;
    private JLabel dialog;
    private JPanel dialogPanel;

    public DialogBoxUI(VendingMachineEventListener vendingMachineEventListener, String message) {
        setContentPane(dialogPanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainFrame newMain = new MainFrame(vendingMachineEventListener);
                dispose();
            }
        });

        dialog.setText(message);

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

    private void createUIComponents() {
        // TODO: place custom component creation code here
        dialog = new JLabel();
    }
}
