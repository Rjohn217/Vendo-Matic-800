package SwingGUI;

import javax.swing.*;

public class CandyUI extends JFrame {

    //This red squiggle is meaningless, code runs fine
    public JPanel candyPanel;
    private JLabel candyLabel;

    private JPanel candyButtonPanel;
    private JButton firstCandyButton;
    private JButton secondCandyButton;
    private JButton thirdCandyButton;
    private JButton fourthCandyButton;

    CandyUI() {


        setContentPane(candyPanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame candyFrame = new JFrame();
        setVisible(true);


    }

}
