/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hospital_management_system.MysqlConnect;
import hospital_management_system.models.NurseAdmissionModel;
import hospital_management_system.utils.DateTimeUtils;

/**
 *
 * @author User
 */
public class NurseAdmissionController {
    private NurseAdmissionModel model;
    private JTextField Admission_ID1;
    private JTextField Admission_Date1;
    private JTextField Admitting_Staff_ID1;
    private JTextField Admission_Status1;
    private JTextField Admission_Notes1;
    private JTextField Reason1;
    private JTextField admission_Patient_ID;
    private JTextField Insurance_Details1;
    private JList<String> medical_equipment_need;

    public NurseAdmissionController(JTextField Admission_ID1, JTextField Admission_Date1, JTextField Admitting_Staff_ID1,
                                    JTextField Admission_Status1, JTextField Admission_Notes1, JTextField Reason1,
                                    JTextField admission_Patient_ID, JTextField Insurance_Details1, JList<String> medical_equipment_need) {
        this.Admission_ID1 = Admission_ID1;
        this.Admission_Date1 = Admission_Date1;
        this.Admitting_Staff_ID1 = Admitting_Staff_ID1;
        this.Admission_Status1 = Admission_Status1;
        this.Admission_Notes1 = Admission_Notes1;
        this.Reason1 = Reason1;
        this.admission_Patient_ID = admission_Patient_ID;
        this.Insurance_Details1 = Insurance_Details1;
        this.medical_equipment_need = medical_equipment_need;
    }

    public void handleSaveActionPerformed(ActionEvent evt) {
        String admissionID = Admission_ID1.getText();
        String formattedAdmissionDate = DateTimeUtils.formatDate(Admission_Date1.getText());
        String admittingStaffID = Admitting_Staff_ID1.getText();
        String admissionStatus = Admission_Status1.getText();
        String admissionNotes = Admission_Notes1.getText();
        String reason = Reason1.getText();
        String admissionPatientID = admission_Patient_ID.getText();
        String insuranceDetails = Insurance_Details1.getText();
        String selectedItems = String.join(",", medical_equipment_need.getSelectedValuesList());

        model = new NurseAdmissionModel(admissionID, formattedAdmissionDate, admittingStaffID, admissionStatus,
                admissionNotes, reason, admissionPatientID, insuranceDetails, selectedItems);

        if (model.save()) {
            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
            MysqlConnect db = new MysqlConnect();
            String newAdmissionId = db.generateNewId("Admission", "A");
            Admission_ID1.setText(newAdmissionId);
            Admission_Date1.setText("");
            Admission_Status1.setText("");
            Admission_Notes1.setText("");
            Reason1.setText("");
            admission_Patient_ID.setText("");
            Insurance_Details1.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Data insertion failed.");
        }
    }

    public void handleClearActionPerformed(ActionEvent evt) {
        Admission_Date1.setText("");
        Admission_Status1.setText("");
        Admission_Notes1.setText("");
        Reason1.setText("");
        admission_Patient_ID.setText("");
        Insurance_Details1.setText("");
    }
}
