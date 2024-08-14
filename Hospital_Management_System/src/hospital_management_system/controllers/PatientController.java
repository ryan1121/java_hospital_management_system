/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_management_system.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hospital_management_system.MysqlConnect;
import hospital_management_system.models.PatientModel;
import hospital_management_system.views.GUI_patient;

/**
 *
 * @author User
 */
public class PatientController {
     private PatientModel model;
    private GUI_patient view;
    private MysqlConnect db;

    public PatientController(PatientModel model, GUI_patient view) {
        this.model = model;
        this.view = view;
        this.db = new MysqlConnect();
    }

    public void clearPatientInfo() {
        model.setPatientName("");
        model.setPatientPhone("");
        model.setPatientEmail("");
        model.setPatientAddress("");
        model.setPatientAddressLine2("");
        model.setPatientAddressLine3("");
        model.setPatientEmergencyName("");
        model.setPatientEmergencyRelationship("");
        model.setPatientEmergencyPhone("");
        model.setInsuranceID("");
        model.setProviderName("");
        model.setPolicyNumber("");
        updateView();
    }

    public void fetchDataAndDisplay(String patientId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = db.getConnection();
            String sql = "SELECT * FROM Patients WHERE patient_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, patientId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                model.setPatientId(resultSet.getString("patient_id"));
                model.setPatientName(resultSet.getString("patient_name"));
                model.setPatientGender(resultSet.getString("patient_gender"));
                model.setPatientDOB(resultSet.getString("patient_DOB"));
                model.setPatientPhone(resultSet.getString("patient_phone"));
                model.setPatientEmail(resultSet.getString("patient_email"));
                model.setPatientAddress(resultSet.getString("patient_address"));
                model.setPatientAddressLine2(resultSet.getString("patient_address_line2"));
                model.setPatientAddressLine3(resultSet.getString("patient_address_line3"));
                model.setPatientEmergencyName(resultSet.getString("patient_emergency_name"));
                model.setPatientEmergencyRelationship(resultSet.getString("patient_emergency_relationship"));
                model.setPatientEmergencyPhone(resultSet.getString("patient_emergency_phone"));
                model.setInsuranceID(resultSet.getString("insuranceID"));
                model.setProviderName(resultSet.getString("providerName"));
                model.setPolicyNumber(resultSet.getString("policyNumber"));
            }
            updateView();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateView() {
        view.setPatientId(model.getPatientId());
        view.setPatientName(model.getPatientName());
        view.setPatientGender(model.getPatientGender());
        view.setPatientDOB(model.getPatientDOB());
        view.setPatientPhone(model.getPatientPhone());
        view.setPatientEmail(model.getPatientEmail());
        view.setPatientAddress(model.getPatientAddress());
        view.setPatientAddressLine2(model.getPatientAddressLine2());
        view.setPatientAddressLine3(model.getPatientAddressLine3());
        view.setPatientEmergencyName(model.getPatientEmergencyName());
        view.setPatientEmergencyRelationship(model.getPatientEmergencyRelationship());
        view.setPatientEmergencyPhone(model.getPatientEmergencyPhone());
        view.setInsuranceID(model.getInsuranceID());
        view.setProviderName(model.getProviderName());
        view.setPolicyNumber(model.getPolicyNumber());
    }
}
