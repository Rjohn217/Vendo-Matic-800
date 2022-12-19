package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;
import com.techelevator.model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ChipCandyDrinkGum extends JFrame {


    public JPanel getTypePanel() {
        return typePanel;
    }

    private JPanel typePanel;
    private JLabel whatWouldYouLike;
    private JPanel titlePanel;
    private JPanel buttonPanelA;
    private JPanel buttonPanelB;
    private JPanel buttonPanelC;
    private JPanel buttonPanelD;
    private JButton mainButton;
    private JLabel balanceLabel;

    VendingMachineEventListener vendingMachineEventListener;

    ChipCandyDrinkGum(VendingMachineEventListener vendingMachineEventListener) {
        setContentPane(typePanel);
        setTitle("Vendo-Matic 800");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.vendingMachineEventListener = vendingMachineEventListener;

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                vendingMachineEventListener.exitProgram();
            }
        });

        Map<Character, List<Item>> itemsByRow = new TreeMap<>();

        //orders the map
        for (Item item : vendingMachineEventListener.getInventory().keySet()) {
            List<Item> currentItems = itemsByRow.get(item.getSlot().charAt(0));
            if (currentItems == null) {
                currentItems = new ArrayList<>();
            }
            currentItems.add(item);
            itemsByRow.put(item.getSlot().charAt(0), currentItems);
        }

        for (List<Item> rows : itemsByRow.values()) {
            for (Item item : rows) {
                JButton button = new JButton(item.getName() + " " + item.getCost());
                button.setPreferredSize(new Dimension(160, 30));
                button.setFont(new Font("DejaVuMonoSans", 1, 10));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        DialogBoxUI dialogBoxUI = new DialogBoxUI(vendingMachineEventListener, vendingMachineEventListener.doPurchase(item));
                        dispose();
                    }
                });
                if (item.getSlot().charAt(0) == 'A') {
                    buttonPanelA.add(button);
                } else if (item.getSlot().charAt(0) == 'B') {
                    buttonPanelB.add(button);
                } else if (item.getSlot().charAt(0) == 'C') {
                    buttonPanelC.add(button);
                } else if (item.getSlot().charAt(0) == 'D') {
                    buttonPanelD.add(button);
                }
            }
        }
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainFrame mainFrame = new MainFrame(vendingMachineEventListener);
                dispose();
            }
        });

        balanceLabel.setText("Balance: " + vendingMachineEventListener.getBalance());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        buttonPanelA = new JPanel();
        buttonPanelB = new JPanel();
        buttonPanelC = new JPanel();
        buttonPanelD = new JPanel();
    }
}


