package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;
import com.techelevator.model.Item;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory extends JFrame {

    private JPanel inventoryPanel;
    private JPanel listInventory;
    private JTable table1;
    private JButton main;
    List<String> inventory;

    VendingMachineEventListener vendingMachineEventListener;

    public Inventory(VendingMachineEventListener vendingMachineEventListener) {
        setContentPane(inventoryPanel);
        setTitle("Vendo-Matic 800: List Inventory");
        setSize(700,700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.vendingMachineEventListener = vendingMachineEventListener;
        inventory = new ArrayList<>();
        for (Map.Entry<Item, Integer> itemEntry : vendingMachineEventListener.getInventory().entrySet()) {
            inventory.add(
                    itemEntry.getKey().getName() + "|" +
                    itemEntry.getKey().getSlot() + "|" +
                    itemEntry.getKey().getCost() + "|" +
                    itemEntry.getKey().getType() + "|" +
                    itemEntry.getValue()
            );
        }



        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                vendingMachineEventListener.exitProgram();
            }
        });
        main.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainFrame newMain = new MainFrame(vendingMachineEventListener);
                newMain.setContentPane(newMain.getMainPanel());
                newMain.setVisible(true);
                dispose();
            }
        });
    }

    public JPanel getInventoryPanel() {
        return inventoryPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        table1 = new JTable(new InventoryModel());
    }

    private class InventoryModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 16;
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return inventory.get(row).split("\\|")[col];
        }
    }
}


