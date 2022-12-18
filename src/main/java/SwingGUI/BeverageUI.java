package SwingGUI;

import javax.swing.*;

public class BeverageUI extends JFrame {
    private JPanel beveragePanel;
    private JLabel beverageLabel;
    private JPanel beverageButtonPanel;
    private JButton firstBeverageButton;
    private JButton secondBeverageButton;
    private JButton thirdBeverageButton;
    private JButton fourthBeverageButton;

    BeverageUI () {


        setContentPane(beveragePanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame beverageFrame = new JFrame();
        setVisible(true);


    }
}
