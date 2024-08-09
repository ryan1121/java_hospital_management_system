package hospital_management_system.models;
import hospital_management_system.MysqlConnect;
import hospital_management_system.utils.DateTimeUtils;

import java.sql.SQLException;

import javax.swing.*;

public class SupplyManagement {
    private JPanel panel;
    private String supplyID;
    private String supplyCode;
    private String supplyName;
    private int supplyStockQuantity;
    private int supplyMinimumStock;
    private int supplyMaximumStock;
    private String supplierInformation;
    private String supplyExpiryDate;

    public SupplyManagement(
        JPanel panel,
        JTextField supplyIDInput,
        JTextField supplyNameInput,
        JTextField supplyCodeInput,
        JSpinner supplyStockQuantityInput,
        JSpinner supplyMinimumStockInput,
        JSpinner supplyMaximumStockInput,
        JTextArea supplierInformationInput,
        JFormattedTextField supplyExpiryDateInput
    ) {
        this.panel = panel;
        this.supplyID = supplyIDInput.getText();
        this.supplyName = supplyNameInput.getText();
        System.out.println("    Check ID 1:" + supplyID);

        System.out.println("    Check NAME 1:" + supplyName);
        this.supplyCode = supplyCodeInput.getText();
        this.supplyStockQuantity = (Integer) supplyStockQuantityInput.getValue();
        this.supplyMinimumStock = (Integer) supplyMinimumStockInput.getValue();
        this.supplyMaximumStock = (Integer) supplyMaximumStockInput.getValue();
        this.supplierInformation = supplierInformationInput.getText();
        this.supplyExpiryDate = DateTimeUtils.formatDate(supplyExpiryDateInput.getText());
    }

    public boolean save() {
        System.out.println("    Check ID 2:" + supplyID);

        System.out.println("    Check NAME 2:" + supplyName);

        if (supplyID == null || supplyID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter supply ID !!");
            return false;
        } else if (supplyName == null || supplyName.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter supply name !!");
            return false;
        } else if (supplyCode == null || supplyCode.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter supply code !!");
            return false;
        } else {
            MysqlConnect db = new MysqlConnect();
            String[] supplyValues = {supplyID, supplyName, supplyCode, String.valueOf(supplyStockQuantity), String.valueOf(supplyMinimumStock), String.valueOf(supplyMaximumStock), supplierInformation, supplyExpiryDate};

            try {
                boolean saveResult = db.saveData("MedicalSupplyManagement", "SupplyID, SupplyName, SupplyCode, SupplyStockQuantity, SupplyMinimumStock, SupplyMaximumStock, SupplierInformation, SupplyExpiryDate", supplyValues);

                if (saveResult) {
                    JOptionPane.showMessageDialog(panel, "Medical supply data saved successfully!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(panel, "Failed to save medical supply data!");
                    return false;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(panel, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public void clear(JTextField supplyNameInput, JTextField supplyCodeInput, JSpinner supplyStockQuantityInput, JSpinner supplyMinimumStockInput, JSpinner supplyMaximumStockInput, JTextArea supplierInformationInput, JFormattedTextField supplyExpiryDateInput) {
        supplyNameInput.setText("");
        supplyCodeInput.setText("");
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
    public String getSupplyID() { return supplyID; }
    public void setSupplyID(String supplyID) { this.supplyID = supplyID; }
    
    public String getSupplyName() { return supplyName; }
    public void setSupplyName(String supplyName) { this.supplyName = supplyName; }
    
    public String getSupplyCode() { return supplyCode; }
    public void setSupplyCode(String supplyCode) { this.supplyCode = supplyCode; }
    
    public int getSupplyStockQuantity() { return supplyStockQuantity; }
    public void setSupplyStockQuantity(int supplyStockQuantity) { this.supplyStockQuantity = supplyStockQuantity; }
    
    public int getSupplyMinimumStock() { return supplyMinimumStock; }
    public void setSupplyMinimumStock(int supplyMinimumStock) { this.supplyMinimumStock = supplyMinimumStock; }
    
    public int getSupplyMaximumStock() { return supplyMaximumStock; }
    public void setSupplyMaximumStock(int supplyMaximumStock) { this.supplyMaximumStock = supplyMaximumStock; }

    public String getSupplierInformation() { return supplierInformation; }
    public void setSupplierInformation(String supplierInformation) { this.supplierInformation = supplierInformation; }
    
    public String getSupplyExpiryDate() { return supplyExpiryDate; }
    public void setSupplyExpiryDate(String supplyExpiryDate) { this.supplyExpiryDate = supplyExpiryDate; }
}
