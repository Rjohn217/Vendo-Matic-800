package SwingGUI;

import javax.swing.*;

public class GumUI extends JFrame{
    private JPanel gumPanel;
    private JLabel gumLabel;
    private JPanel gumButtonPanel;
    private JButton firstGumButton;
    private JButton secondGumButton;
    private JButton thirdGumButton;
    private JButton fourthGumButton;

    GumUI() {


        setContentPane(gumPanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame gumFrame = new JFrame();
        setVisible(true);


    }
}
