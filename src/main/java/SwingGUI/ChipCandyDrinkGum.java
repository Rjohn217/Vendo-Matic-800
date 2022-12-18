package SwingGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChipCandyDrinkGum extends JFrame {


    public JPanel getTypePanel() {
        return typePanel;
    }

    private JPanel typePanel;
    private JLabel whatWouldYouLike;
    private JButton candyButton;
    private JButton chipsButton;
    private JButton gumButton;
    private JButton beverageButton;
    private JPanel titlePanel;
    private JPanel buttonPanel;


    ChipCandyDrinkGum() {


        setContentPane(typePanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame itemsFrame = new JFrame();
        setVisible(true);



        candyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e != null && e.getActionCommand().equals("Candy")) {
                    CandyUI candy = new CandyUI();
                    setVisible(true);


                    dispose();
                }

            }
        } );

        chipsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e != null && e.getActionCommand().equals("Chips")) {
                    ChipsUI chips = new ChipsUI();
                    setVisible(true);


                    dispose();
                }

            }
        } );

        beverageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e != null && e.getActionCommand().equals("Beverage")) {
                    BeverageUI beverage = new BeverageUI();
                    setVisible(true);


                    dispose();
                }

            }
        } );

        gumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e != null && e.getActionCommand().equals("Gum")) {
                    GumUI gum = new GumUI();
                    setVisible(true);


                    dispose();
                }

            }
        } );

    }
}


