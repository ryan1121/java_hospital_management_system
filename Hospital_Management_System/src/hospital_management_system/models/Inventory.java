package hospital_management_system.models;
import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import java.sql.SQLException;

import javax.swing.*;

public class Inventory {
    private JTextField inventoryID;
    private JTextField itemName;
    private JSpinner stockQuantity;
    private JSpinner maximumStock;
    private JSpinner minimumStock;
    private JTextArea supplierInformation;
    private JFormattedTextField expiryDate;

    public Inventory(
        JTextField inventoryID,
        JTextField itemName,
        JSpinner stockQuantity,
        JSpinner maximumStock,
        JSpinner minimumStock,
        JTextArea supplierInformation,
        JFormattedTextField expiryDate
    ) {
        this.inventoryID = inventoryID;
        this.itemName = itemName;
        this.stockQuantity = stockQuantity;
        this.maximumStock = maximumStock;
        this.minimumStock = minimumStock;
        this.supplierInformation = supplierInformation;
        this.expiryDate = expiryDate;
    }

    public boolean save() {
        String invID = inventoryID.getText();
        String name = itemName.getText();
        int stockQty = (int) stockQuantity.getValue();
        int maxStock = (int) maximumStock.getValue();
        int minStock = (int) minimumStock.getValue();
        String supplierInfo = supplierInformation.getText();
        String date = DateTimeUtils.formatDate(expiryDate.getText());

        MysqlConnect db = new MysqlConnect();
        String[] inventoryValues = {invID, name, String.valueOf(stockQty), String.valueOf(maxStock), String.valueOf(minStock), supplierInfo, date};

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

    public void clear(JTextField itemName,  JSpinner stockQuantity, JSpinner maximumStock, JSpinner minimumStock, JTextArea supplierInformation, JFormattedTextField expiryDate) {
        itemName.setText("");
        stockQuantity.setValue(0);
        maximumStock.setValue(0);
        minimumStock.setValue(0);
        supplierInformation.setText("");
        expiryDate.setText("");
    }

    
    public static String setNewInventoryID(JTextField inventoryID) {
        MysqlConnect db = new MysqlConnect();
        String newinventoryID = db.generateNewId("InventoryManagement", "INV");
        inventoryID.setText(newinventoryID);
        return newinventoryID;
    }

    // Getters and Setters
    public String getInventoryID() { return inventoryID; }
    public void setInventoryID(String inventoryID) { this.inventoryID = inventoryID; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getSupplierInformation() { return supplierInformation; }
    public void setSupplierInformation(String supplierInformation) { this.supplierInformation = supplierInformation; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public int getMinimumStock() { return minimumStock; }
    public void setMinimumStock(int minimumStock) { this.minimumStock = minimumStock; }

    public int getMaximumStock() { return maximumStock; }
    public void setMaximumStock(int maximumStock) { this.maximumStock = maximumStock; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
}
