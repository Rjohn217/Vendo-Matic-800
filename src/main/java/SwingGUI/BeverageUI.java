package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class BeverageUI extends JFrame {
    private JPanel beveragePanel;
    private JLabel beverageLabel;
    private JPanel beverageButtonPanel;
    private JButton firstBeverageButton;
    private JButton secondBeverageButton;
    private JButton thirdBeverageButton;
    private JButton fourthBeverageButton;

    BeverageUI (VendingMachineEventListener vendingMachineEventListener) {


        setContentPane(beveragePanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame beverageFrame = new JFrame();
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
