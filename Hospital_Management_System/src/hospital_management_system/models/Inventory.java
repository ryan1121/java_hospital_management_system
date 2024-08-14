package hospital_management_system.models;
import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import java.sql.SQLException;

import javax.swing.*;

public class Inventory {
    private String inventoryID;
    private String itemName;
    private int stockQuantity;
    private int maximumStock;
    private int minimumStock;
    private String supplierInformation;
    private String expiryDate;

    public Inventory(
        JTextField inventoryIDTextField,
        JTextField itemNameTextField,
        JSpinner stockQuantitySpinner,
        JSpinner maximumStockSpinner,
        JSpinner minimumStockSpinner,
        JTextArea supplierInformationTextArea,
        JFormattedTextField expiryDateFormattedTextField
    ) {
        this.inventoryID = inventoryIDTextField.getText();
        this.itemName = itemNameTextField.getText();
        this.stockQuantity = (int) stockQuantitySpinner.getValue();
        this.maximumStock = (int) maximumStockSpinner.getValue();
        this.minimumStock = (int) minimumStockSpinner.getValue();
        this.supplierInformation = supplierInformationTextArea.getText();
        this.expiryDate = DateTimeUtils.formatDate(expiryDateFormattedTextField.getText());
    }

    public boolean save() {
        System.out.println("Check name: " + itemName);
        System.out.println("Check ID: " + inventoryID);
        if (inventoryID == null || inventoryID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You MUST enter inventory ID!!");
            return false;
        } else if (itemName == null || itemName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You MUST enter item name!!");
            return false;
        } else {
            MysqlConnect db = new MysqlConnect();
            String[] inventoryValues = {inventoryID, itemName, String.valueOf(stockQuantity), String.valueOf(maximumStock), String.valueOf(minimumStock), supplierInformation, expiryDate};
    
            try {
                boolean saveResult = db.saveData("InventoryManagement", "InventoryID, ItemName, InventoryStockQuantity, InventoryMaximumStock, InventoryMinimumStock, SupplierInformation, InventoryExpirydate", inventoryValues);
                if (saveResult) {
                    JOptionPane.showMessageDialog(null, "Data saved successfully!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Data saved unsuccessfully!");
                    return false;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public void clear(JTextField itemNameTextField, JSpinner stockQuantitySpinner, JSpinner maximumStockSpinner, JSpinner minimumStockSpinner, JTextArea supplierInformationTextArea, JFormattedTextField expiryDateFormattedTextField) {
        itemNameTextField.setText("");
        stockQuantitySpinner.setValue(0);
        maximumStockSpinner.setValue(0);
        minimumStockSpinner.setValue(0);
        supplierInformationTextArea.setText("");
        expiryDateFormattedTextField.setText("");
    }

    public static String setNewInventoryID(JTextField inventoryIDTextField) {
        MysqlConnect db = new MysqlConnect();
        String newInventoryID = db.generateNewId("InventoryManagement", "INM");
        inventoryIDTextField.setText(newInventoryID);
        return newInventoryID;
    }

    // Getters and Setters
    public String getInventoryID() { return inventoryID; }
    public void setInventoryID(String inventoryID) { this.inventoryID = inventoryID; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public int getMaximumStock() { return maximumStock; }
    public void setMaximumStock(int maximumStock) { this.maximumStock = maximumStock; }

    public int getMinimumStock() { return minimumStock; }
    public void setMinimumStock(int minimumStock) { this.minimumStock = minimumStock; }

    public String getSupplierInformation() { return supplierInformation; }
    public void setSupplierInformation(String supplierInformation) { this.supplierInformation = supplierInformation; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
}
