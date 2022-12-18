package SwingGUI;

import javax.swing.*;

public class ChipsUI extends JFrame {
    private JPanel chipsPanel;
    private JLabel chipsLabel;
    private JPanel chipsButtonPanel;
    private JButton firstChipsButton;
    private JButton secondChipsButton;
    private JButton thirdChipsButton;
    private JButton fourthChipsButton;

    ChipsUI() {


        setContentPane(chipsPanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame chipsFrame = new JFrame();
        setVisible(true);


    }
}
