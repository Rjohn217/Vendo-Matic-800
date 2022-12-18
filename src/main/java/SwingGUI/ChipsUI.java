package SwingGUI;

import com.techelevator.controller.VendingMachineController;
import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class ChipsUI extends JFrame {
    private JPanel chipsPanel;
    private JLabel chipsLabel;
    private JPanel chipsButtonPanel;
    private JButton firstChipsButton;
    private JButton secondChipsButton;
    private JButton thirdChipsButton;
    private JButton fourthChipsButton;

    ChipsUI(VendingMachineEventListener vendingMachineEventListener) {


        setContentPane(chipsPanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame chipsFrame = new JFrame();
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
    }
}
