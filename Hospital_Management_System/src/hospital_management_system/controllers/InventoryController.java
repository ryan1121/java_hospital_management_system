import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InventoryController {
    private Inventory model;
    private JPanel InventoryManagement;
    private JTextField InventoryID_input;
    private JTextField ItemName_input;
    private JTextArea InventorySupplierInformation_input;
    private JSpinner InventoryStockQuantity_input;
    private JSpinner InventoryMinimunStock_input;
    private JSpinner InventoryMaximumStock_input;
    private JFormattedTextField InventoryExpirydate;
    private JButton inventory_save;
    private JButton inventory_clear;

    public InventoryController(
        JPanel inventoryManagement, 
        JTextField inventoryID_input, 
        JTextField itemName_input,
        JTextArea inventorySupplierInformation_input,
        JSpinner inventoryStockQuantity_input, 
        JSpinner inventoryMinimunStock_input,
        JSpinner inventoryMaximumStock_input, 
        JFormattedTextField inventoryExpirydate,
        JButton inventory_save, 
        JButton inventory_clear
    ) {
        this.InventoryManagement = inventoryManagement;
        this.InventoryID_input = inventoryID_input;
        this.ItemName_input = itemName_input;
        this.InventorySupplierInformation_input = inventorySupplierInformation_input;
        this.InventoryStockQuantity_input = inventoryStockQuantity_input;
        this.InventoryMinimunStock_input = inventoryMinimunStock_input;
        this.InventoryMaximumStock_input = inventoryMaximumStock_input;
        this.InventoryExpirydate = inventoryExpirydate;
        this.inventory_save = inventory_save;
        this.inventory_clear = inventory_clear;

        // Initialize the model
        this.model = new Inventory("", "", "", "", 0, 0, 0, null);

        // Add action listeners
        this.inventory_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInventory();
            }
        });

        this.inventory_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInventory();
            }
        });
    }

    // Save inventory data
    private void saveInventory() {
        model.setInventoryID(InventoryID_input.getText());
        model.setItemName(ItemName_input.getText());
        model.setSupplierInformation(InventorySupplierInformation_input.getText());
        model.setStockQuantity((int) InventoryStockQuantity_input.getValue());
        model.setMinimumStock((int) InventoryMinimunStock_input.getValue());
        model.setMaximumStock((int) InventoryMaximumStock_input.getValue());

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
            model.setExpiryDate(dateFormat.parse(InventoryExpirydate.getText()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Save the model data to the database
        model.save();
    }

    // Clear inventory fields
    private void clearInventory() {
        model.clear();
        InventoryID_input.setText("");
        ItemName_input.setText("");
        InventorySupplierInformation_input.setText("");
        InventoryStockQuantity_input.setValue(0);
        InventoryMinimunStock_input.setValue(0);
        InventoryMaximumStock_input.setValue(0);
        InventoryExpirydate.setText("");
    }
}
