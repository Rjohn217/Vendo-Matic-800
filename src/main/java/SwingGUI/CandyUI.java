package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class CandyUI extends JFrame {

    //This red squiggle is meaningless, code runs fine
    private JPanel candyPanel;
    private JLabel candyLabel;

    private JPanel candyButtonPanel;
    private JButton firstCandyButton;
    private JButton secondCandyButton;
    private JButton thirdCandyButton;
    private JButton fourthCandyButton;

    CandyUI(VendingMachineEventListener vendingMachineEventListener) {


        setContentPane(candyPanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame candyFrame = new JFrame();
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
