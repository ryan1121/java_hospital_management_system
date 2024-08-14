package hospital_management_system.controllers;

import hospital_management_system.models.Inventory;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.*;

public class InventoryController {
    private Inventory model;
    private JPanel panel;
    private JTextField invIDInput;
    private JTextField itemNameInput;
    private JSpinner stockQtyInput;
    private JSpinner maxStockInput;
    private JSpinner minStockInput;
    private JTextArea supplierInfoInput;
    private JFormattedTextField expiryDateInput;

    public InventoryController(
        JPanel panel,
        JTextField invIDInput,
        JTextField itemNameInput,
        JSpinner stockQtyInput,
        JSpinner maxStockInput,
        JSpinner minStockInput,
        JTextArea supplierInfoInput,
        JFormattedTextField expiryDateInput
    ) {
        this.panel = panel;
        this.invIDInput = invIDInput;
        this.itemNameInput = itemNameInput;
        this.stockQtyInput = stockQtyInput;
        this.maxStockInput = maxStockInput;
        this.minStockInput = minStockInput;
        this.supplierInfoInput = supplierInfoInput;
        this.expiryDateInput = expiryDateInput;
        this.model = new Inventory(
            invIDInput, 
            itemNameInput, 
            stockQtyInput, 
            maxStockInput, 
            minStockInput, 
            supplierInfoInput, 
            expiryDateInput
        );
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        this.model = new Inventory(
            invIDInput, 
            itemNameInput, 
            stockQtyInput, 
            maxStockInput, 
            minStockInput, 
            supplierInfoInput, 
            expiryDateInput
        );
        
        if (model.save()) {
            Inventory.setNewInventoryID(invIDInput);  // Reset the new inventory ID
        } else {
            JOptionPane.showMessageDialog(panel, "Data saved unsuccessfully!");
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(itemNameInput, stockQtyInput, maxStockInput, minStockInput, supplierInfoInput, expiryDateInput);
        Inventory.setNewInventoryID(invIDInput); // Ensure the inventoryID is updated
    }
}
