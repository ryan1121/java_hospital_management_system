package hospital_management_system.controllers;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Surgery {
    public static javax.swing.JPanel panel;

    public static String surgeryID;
    public static String PatientID;
    public static String DoctorID;
    public static String surgeryType;
    public static String DateOfSurgery;
    public static String Outcomes;

    public static javax.swing.JTextField surgeryID_textField;
    public static javax.swing.JComboBox<String> surgeryType_comboBox;
    public static javax.swing.JTextField DateOfSurgery_textField;
    public static java.awt.TextField Outcomes_textField;

    public Surgery(
        javax.swing.JPanel panel,
        javax.swing.JTextField patientID_textField,
        javax.swing.JTextField doctorID_textField,
        javax.swing.JTextField surgeryID_textField,
        javax.swing.JComboBox<String> surgeryType_comboBox,
        javax.swing.JTextField DateOfSurgery_textField,
        java.awt.TextField Outcomes_textField
    ){
        this.panel = panel;
        this.surgeryID = surgeryID_textField.getText();
        this.PatientID = patientID_textField.getText();
        this.DoctorID = doctorID_textField.getText();
        this.surgeryType = (String) surgeryType_comboBox.getSelectedItem();
        this.DateOfSurgery = DateOfSurgery_textField.getText();
        // 将日期格式调整为 YYYY-MM-DD
        this.DateOfSurgery = DateTimeUtils.formatDate(DateOfSurgery);


        this.Outcomes = Outcomes_textField.getText();
        this.surgeryID_textField = surgeryID_textField;
        this.surgeryType_comboBox = surgeryType_comboBox;
        this.DateOfSurgery_textField = DateOfSurgery_textField;
        this.Outcomes_textField = Outcomes_textField;
    }
    

    public static void SurgeryManage_SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SurgManage_ClearButtonActionPerformed
        // TODO add your handling code here:
        if (PatientID == null || PatientID.isEmpty() && (DoctorID == null || DoctorID.isEmpty())){
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID and doctor ID !!");
        } else if (PatientID == null || PatientID.isEmpty()) {
            System.out.println("Patient ID is blank");
            JOptionPane.showMessageDialog(panel, "You MUST enter patient ID !!");
        } else if (DoctorID == null || DoctorID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "You MUST enter doctor ID !!");
        } else {

            // 创建 MysqlConnect 对象
            MysqlConnect db = new MysqlConnect();
            String[] values = {surgeryID, PatientID, DoctorID, surgeryType, DateOfSurgery, Outcomes};
            try {
                boolean saveResult = db.saveData("Surgery", "surgeryID, PatientID, DoctorID, surgeryType, DateOfSurgery, Outcomes", values);
                if (saveResult){
                    JOptionPane.showMessageDialog(panel, "Data saved successfully !");
                } else {
                    JOptionPane.showMessageDialog(panel, "Data saved unsuccessfully !");
                }
                setNewSurgeryId(surgeryID_textField);    // reset the new Surgery ID
            } catch (SQLException e) {
                System.err.println("Error while saving data!");
                JOptionPane.showMessageDialog(panel, "Error while saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        

    }//GEN-LAST:event_SurgManage_ClearButtonActionPerformed


    public void SurgManage_ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Surgery_ClearButtonActionPerformed
        // TODO add your handling code here:
        surgeryType_comboBox.setSelectedIndex(-1);
        DateOfSurgery_textField.setText("");
        Outcomes_textField.setText("");
    }//GEN-LAST:event_Surgery_ClearButtonActionPerformed


    public static String setNewSurgeryId(javax.swing.JTextField surgeryID_textField){
        // 创建 MysqlConnect 对象
        MysqlConnect db = new MysqlConnect();
        String newSurgeryId = db.generateNewId("Surgery", "S");
        
        surgeryID_textField.setText(newSurgeryId);
        return newSurgeryId;
    }
}
