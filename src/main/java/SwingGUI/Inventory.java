package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;
import com.techelevator.model.Item;

import javax.swing.*;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
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
        setTitle("Vendo-Matic 800");
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

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table1.doLayout();


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
        table1.getColumnModel().getColumn(0).setPreferredWidth(27);
        table1.getColumnModel().getColumn(1).setPreferredWidth(1);
        table1.getColumnModel().getColumn(2).setPreferredWidth(2);
        table1.getColumnModel().getColumn(3).setPreferredWidth(5);
        table1.getColumnModel().getColumn(4).setPreferredWidth(5);
        table1.doLayout();
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


