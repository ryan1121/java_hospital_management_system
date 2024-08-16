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
import hospital_management_system.models.DoctorModel;
import hospital_management_system.views.GUI_doctor;

/**
 *
 * @author User
 */
public class DoctorController {
     private DoctorModel model;
    private GUI_doctor view;
    private MysqlConnect db;

    public DoctorController(DoctorModel model, GUI_doctor view) {
        this.model = model;
        this.view = view;
        this.db = new MysqlConnect();
    }

    public void clearDoctorInfo() {
        model.setDoctorName("");
        model.setDoctorPhone("");
        model.setDoctorEmail("");
        model.setDoctorSpecialization("");
        model.setDoctorDepartment("");
        model.setDoctorExperience("");
        model.setDoctorQualifications("");
        view.getDoctor_status().setSelectedItem("");
        updateView();
    }

    public void fetchDataAndDisplay(String doctorName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = db.getConnection();
            String sql = "SELECT * FROM Doctors WHERE doctor_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, doctorName);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                model.setDoctorId(resultSet.getString("doctor_id"));
                model.setDoctorName(resultSet.getString("doctor_name"));
                model.setDoctorPhone(resultSet.getString("doctor_phone"));
                model.setDoctorEmail(resultSet.getString("doctor_email"));
                model.setDoctorSpecialization(resultSet.getString("doctor_specialization"));
                model.setDoctorDepartment(resultSet.getString("doctor_department"));
                model.setDoctorExperience(resultSet.getString("doctor_experience"));
                model.setDoctorQualifications(resultSet.getString("doctor_qualifications"));
                model.setDoctorStatus(resultSet.getString("doctor_status"));
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
        view.setDoctorId(model.getDoctorId());
        view.setDoctorName(model.getDoctorName());
        view.setDoctorPhone(model.getDoctorPhone());
        view.setDoctorEmail(model.getDoctorEmail());
        view.setDoctorSpecialization(model.getDoctorSpecialization());
        view.setDoctorDepartment(model.getDoctorDepartment());
        view.setDoctorExperience(model.getDoctorExperience());
        view.setDoctorQualifications(model.getDoctorQualifications());
    }
}
