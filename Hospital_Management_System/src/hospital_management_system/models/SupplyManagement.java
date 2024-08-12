package hospital_management_system.models;
import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import java.sql.SQLException;

import javax.swing.*;

public class SupplyManagement {
    private JTextField supplyIDInput;
    private JTextField supplyNameInput;
    private JSpinner supplyStockQuantityInput;
    private JSpinner supplyMinimumStockInput;
    private JSpinner supplyMaximumStockInput;
    private JTextArea supplierInformationInput;
    private JFormattedTextField supplyExpiryDateInput;

    public SupplyManagement(
        JTextField supplyIDInput,
        JTextField supplyNameInput,
        JSpinner supplyStockQuantityInput,
        JSpinner supplyMinimumStockInput,
        JSpinner supplyMaximumStockInput,
        JTextArea supplierInformationInput,
        JFormattedTextField supplyExpiryDateInput
    ) {
        this.supplyIDInput = supplyIDInput;
        this.supplyNameInput = supplyNameInput;
        this.supplyStockQuantityInput = supplyStockQuantityInput;
        this.supplyMinimumStockInput = supplyMinimumStockInput;
        this.supplyMaximumStockInput = supplyMaximumStockInput;
        this.supplierInformationInput = supplierInformationInput;
        this.supplyExpiryDateInput = supplyExpiryDateInput;
    }

    public boolean save() {
        String supplyID = supplyIDInput.getText();
        String supplyName = supplyNameInput.getText();
        int supplyStockQuantity = (int) supplyStockQuantityInput.getValue();
        int supplyMinimumStock = (int) supplyMinimumStockInput.getValue();
        int supplyMaximumStock = (int) supplyMaximumStockInput.getValue();
        String supplierInformation = supplierInformationInput.getText();
        String supplyExpiryDate = DateTimeUtils.formatDate(supplyExpiryDateInput.getText());

        MysqlConnect db = new MysqlConnect();
        String[] supplyValues = {supplyID, supplyName, String.valueOf(supplyStockQuantity), String.valueOf(supplyMinimumStock), String.valueOf(supplyMaximumStock), supplierInformation, supplyExpiryDate};

        try {
            boolean saveResult = db.saveData("MedicalSupplyManagement", "SupplyID, SupplyName, SupplyStockQuantity, SupplyMinimumStock, SupplyMaximumStock, SupplierInformation, SupplyExpiryDate", supplyValues);
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

    public void clear(JTextField supplyNameInput,  JSpinner supplyStockQuantityInput, JSpinner supplyMinimumStockInput, JSpinner supplyMaximumStockInput, JTextArea supplierInformationInput, JFormattedTextField supplyExpiryDateInput) {
        supplyNameInput.setText("");
        supplyStockQuantityInput.setValue(0);
        supplyMinimumStockInput.setValue(0);
        supplyMaximumStockInput.setValue(0);
        supplierInformationInput.setText("");
        supplyExpiryDateInput.setText("");
    }

    public static String setNewSupplyID(JTextField supplyIDInput) {
        MysqlConnect db = new MysqlConnect();
        String newSupplyId = db.generateNewId("MedicalSupplyManagement", "SUP");
        supplyIDInput.setText(newSupplyId);
        return newSupplyId;
    }
    
    // Getters and setters 
    public String getSupplyID() { return supplyIDInput; }
    public void setSupplyID(String supplyIDInput) { this.supplyIDInput = supplyIDInput; }
    
    public String getSupplyName() { return supplyNameInput; }
    public void setSupplyName(String supplyNameInput) { this.supplyNameInput = supplyNameInput; }
    
    public int getSupplyStockQuantity() { return supplyStockQuantityInput; }
    public void setSupplyStockQuantity(int supplyStockQuantityInput) { this.supplyStockQuantityInput = supplyStockQuantityInput; }
    
    public int getSupplyMinimumStock() { return supplyMinimumStockInput; }
    public void setSupplyMinimumStock(int supplyMinimumStockInput) { this.supplyMinimumStockInput = supplyMinimumStockInput; }
    
    public int getSupplyMaximumStock() { return supplyMaximumStockInput; }
    public void setSupplyMaximumStock(int supplyMaximumStockInput) { this.supplyMaximumStockInput = supplyMaximumStockInput; }

    public String getSupplierInformation() { return supplierInformationInput; }
    public void setSupplierInformation(String supplierInformationInput) { this.supplierInformationInput = supplierInformationInput; }
    
    public String getSupplyExpiryDate() { return supplyExpiryDateInput; }
    public void setSupplyExpiryDate(String supplyExpiryDateInput) { this.supplyExpiryDateInput = supplyExpiryDateInput; }
}
