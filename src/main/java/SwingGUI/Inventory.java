package SwingGUI;

import com.techelevator.controller.VendingMachineEventListener;
import com.techelevator.model.InventoryReader;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class Inventory {

    InventoryReader inventory = new InventoryReader();
    String[] inventorylist;
    private JPanel inventoryPanel;
    private JPanel listInventory;

    public Inventory(VendingMachineEventListener vendingMachineEventListener) {
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