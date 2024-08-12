package hospital_management_system.controllers;

import hospital_management_system.models.SupplyManagement;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class SupplyManagementController {
    private SupplyManagement model;
    private JPanel panel;
    private JTextField supplyIDInput;
    private JTextField supplyNameInput;
    private JSpinner supplyStockQuantityInput;
    private JSpinner supplyMinimumStockInput;
    private JSpinner supplyMaximumStockInput;
    private JTextArea supplierInformationInput;
    private JFormattedTextField supplyExpiryDateInput;

    public SupplyManagementController(
        JPanel panel,
        JTextField supplyIDInput,
        JTextField supplyNameInput,
        JSpinner supplyStockQuantityInput,
        JSpinner supplyMinimumStockInput,
        JSpinner supplyMaximumStockInput,
        JTextArea supplierInformationInput,
        JFormattedTextField supplyExpiryDateInput
    ) {
        this.panel = panel;
        this.supplyIDInput = supplyIDInput;
        this.supplyNameInput = supplyNameInput;
        this.supplyStockQuantityInput = supplyStockQuantityInput;
        this.supplyMinimumStockInput = supplyMinimumStockInput;
        this.supplyMaximumStockInput = supplyMaximumStockInput;
        this.supplierInformationInput = supplierInformationInput;
        this.supplyExpiryDateInput = supplyExpiryDateInput;

        this.model = new SupplyManagement(
            panel,
            supplyIDInput,
            supplyNameInput,
            supplyStockQuantityInput,
            supplyMinimumStockInput,
            supplyMaximumStockInput,
            supplierInformationInput,
            supplyExpiryDateInput
        );
    }

    public void handleSaveButtonActionPerformed(ActionEvent evt) {
        if (model.save()) {
            SupplyManagement.setNewSupplyID(supplyIDInput); // Reset the new supply ID
        }
    }

    public void handleClearButtonActionPerformed(ActionEvent evt) {
        model.clear(supplyNameInput, supplyStockQuantityInput, supplyMinimumStockInput, supplyMaximumStockInput, supplierInformationInput, supplyExpiryDateInput);
    }
}
