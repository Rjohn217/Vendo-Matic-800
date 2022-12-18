package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class GumUI extends JFrame{
    private JPanel gumPanel;
    private JLabel gumLabel;
    private JPanel gumButtonPanel;
    private JButton firstGumButton;
    private JButton secondGumButton;
    private JButton thirdGumButton;
    private JButton fourthGumButton;

    GumUI(VendingMachineEventListener vendingMachineEventListener) {


        setContentPane(gumPanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame gumFrame = new JFrame();
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
