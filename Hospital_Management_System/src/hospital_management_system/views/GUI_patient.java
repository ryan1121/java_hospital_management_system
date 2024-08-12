/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital_management_system.views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

import hospital_management_system.MysqlConnect;
import hospital_management_system.models.PatientHistory;

/**
 *
 * @author User
 */
public class GUI_patient extends javax.swing.JFrame {
    String id;
    /**
     * Creates new form GUI_patient
     */
    public GUI_patient(String id) {
        this.id = id;
        initComponents();
        fetchDataAndDisplay();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        patient_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        patient_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        patient_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        patient_phone = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        patient_address = new javax.swing.JTextField();
        patient_address_line2 = new javax.swing.JTextField();
        patient_address_line3 = new javax.swing.JTextField();
        patient_gender = new javax.swing.JLabel();
        patient_DOB = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        patient_emergency_relationship = new javax.swing.JTextField();
        patient_emergency_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        patient_emergency_phone = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        insuranceID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        providerName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        policyNumber = new javax.swing.JTextField();
        patient_clear = new javax.swing.JButton();
        patient_save = new javax.swing.JButton();
        backButton1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        patientHistory_jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Information"));

        patient_id.setText("patient_id");
        patient_id.setEnabled(false);
        jLabel1.setText("Patient ID :");
        patient_name.setText("Full Name");
        jLabel2.setText("Name :");
        jLabel15.setText("Gender :");

        jLabel16.setText("Date of Birth : ");

        patient_email.setText("Email");
        jLabel4.setText("Email :");
        jLabel3.setText("Phone Number :");

        patient_phone.setText("phone");
        
        jLabel17.setText("Address :");
        patient_address.setText("Address");
        patient_address_line2.setText("line 2");
        patient_address_line3.setText("line 3");

        patient_gender.setText("Male");

        patient_DOB.setText("12/01/2004");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patient_name, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patient_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(patient_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel15)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(patient_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(patient_email, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(patient_DOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel2)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(patient_address, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patient_address_line2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patient_address_line3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patient_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patient_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patient_gender)
                    .addComponent(patient_DOB))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patient_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patient_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patient_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patient_address_line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patient_address_line3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Emergency Contact"));

        patient_emergency_relationship.setText("Relationship");

        patient_emergency_name.setText("Emergency Contact Name");

        jLabel8.setText("Name : ");

        patient_emergency_phone.setText("Phone Number");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patient_emergency_name, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(patient_emergency_relationship)
                    .addComponent(patient_emergency_phone)
                    .addComponent(jLabel8))
                .addGap(45, 45, 45))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patient_emergency_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patient_emergency_relationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patient_emergency_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Insurance Information"));

        jLabel7.setText("Insurance ID      :");

        jLabel9.setText("Provider Name :");

        jLabel10.setText("Policy Number  :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insuranceID)
                    .addComponent(providerName)
                    .addComponent(policyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(insuranceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(providerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(policyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        patient_clear.setText("Clear");
        patient_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_clearActionPerformed(evt);
            }
        });

        patient_save.setText("Save");
        patient_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_saveActionPerformed(evt);
            }
        });

        backButton1.setForeground(new java.awt.Color(0, 51, 255));
        backButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backButton1.setText("Back");
        backButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backButton1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patient_save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patient_clear))
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(patient_clear)
                                .addComponent(patient_save)
                                .addComponent(backButton1))))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Information", jPanel7);
        
        PatientHistory patientHistoryObj = new PatientHistory();
        ResultSet rs = patientHistoryObj.getPatientHistory(this.id);

        // 准备 JTable 的模型数据
        DefaultTableModel tableModel = new DefaultTableModel(
            new String[] {"History ID", "Event Type", "Date of Event", "Details"}, 0
        );

        // 处理 ResultSet 数据
        try {
            while (rs != null && rs.next()) {
                String historyID = rs.getString("HistoryID");
                System.out.println(historyID);
                String eventType = rs.getString("EventType");
                System.out.println(eventType);
                String eventDate = rs.getString("EventDate");
                System.out.println(eventDate);
                String details = rs.getString("Details");
                System.out.println(details);

                // 将数据添加到模型中
                tableModel.addRow(new Object[] {historyID, eventType, eventDate, details});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       // 设置 JTable 的模型
        patientHistory_jTable.setModel(tableModel);

        // 设置 JTable 的模型和滚动面板
        JScrollPane jScrollPane3 = new JScrollPane(patientHistory_jTable);
        setupTable(patientHistory_jTable, tableModel, jScrollPane3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Patient History", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMousePressed
        // TODO add your handling code here:
        this.dispose();

        GUI_LOGIN Login_GUI = new GUI_LOGIN("Patient");
        Login_GUI.setVisible(true);
    }

    private void patient_clearActionPerformed(java.awt.event.ActionEvent evt){
        patient_name.setText("");
        patient_phone.setText("");
        patient_email.setText("");
        patient_address.setText("");
        patient_address_line2.setText("");
        patient_address_line3.setText("");
        patient_emergency_name.setText("");
        patient_emergency_relationship.setText("");
        patient_emergency_phone.setText("");
        insuranceID.setText("");
        providerName.setText("");
        policyNumber.setText("");
    }

    private void patient_saveActionPerformed(java.awt.event.ActionEvent evt){
        MysqlConnect db = new MysqlConnect();
        String tableName = "Patients";

        String patientId = patient_id.getText(); 
        String name = patient_name.getText(); 
        String phone = patient_phone.getText(); 
        String email = patient_email.getText(); 
        String address = patient_address.getText(); 
        String addressLine2 = patient_address_line2.getText(); 
        String addressLine3 = patient_address_line3.getText();
        String emergencyName = patient_emergency_name.getText();
        String emergencyRelationship = patient_emergency_relationship.getText();
        String emergencyPhone = patient_emergency_phone.getText(); 
        String ins_ID = insuranceID.getText(); 
        String provider_name = providerName.getText(); 
        String policyNo = policyNumber.getText(); 
    
        // 初始化更新语句和条件
        StringBuilder updateBuilder = new StringBuilder();
        String condition = "patient_id = '" + patientId + "'"; 
    
        // 仅更新修改过的字段
        if (!name.isEmpty()) {
            updateBuilder.append("patient_name = '").append(name).append("', ");
        }
        if (!phone.isEmpty()) {
            updateBuilder.append("patient_phone = '").append(phone).append("', ");
        }
        if (!email.isEmpty()) {
            updateBuilder.append("patient_email = '").append(email).append("', ");
        }
        if (!address.isEmpty()) {
            updateBuilder.append("patient_address = '").append(address).append("', ");
        }
        if (!addressLine2.isEmpty()) {
            updateBuilder.append("patient_address_line2 = '").append(addressLine2).append("', ");
        }
        if (!addressLine3.isEmpty()) {
            updateBuilder.append("patient_address_line3 = '").append(addressLine3).append("', ");
        }
        if (!emergencyName.isEmpty()) {
            updateBuilder.append("patient_emergency_name = '").append(emergencyName).append("', ");
        }
        if (!emergencyRelationship.isEmpty()) {
            updateBuilder.append("patient_emergency_relationship = '").append(emergencyRelationship).append("', ");
        }
        if (!emergencyPhone.isEmpty()) {
            updateBuilder.append("patient_emergency_phone = '").append(emergencyPhone).append("', ");
        }
        if (!ins_ID.isEmpty()) {
            updateBuilder.append("insuranceID = '").append(ins_ID).append("', ");
        }
        if (!provider_name.isEmpty()) {
            updateBuilder.append("providerName = '").append(provider_name).append("', ");
        }
        if (!policyNo.isEmpty()) {
            updateBuilder.append("policyNumber = '").append(policyNo).append("', ");
        }
    
        // 移除最后一个逗号和空格
        String update = updateBuilder.toString();
        if (update.endsWith(", ")) {
            update = update.substring(0, update.length() - 2);
        }
    
        // 只有在 update 字符串不为空时才执行更新操作
        if (!update.isEmpty()) {
            db.updateData(tableName, update, condition);
        } else {
            System.out.println("There is no data to update.");
        }
    }   

    private void fetchDataAndDisplay() {
        MysqlConnect db = new MysqlConnect();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection
            connection = db.getConnection();
            // Create a prepared statement
            String sql = "SELECT * FROM Patients WHERE patient_id = ?"; // Adjust the WHERE clause as needed
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id); // Assuming you want to retrieve the row with ID=1
            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Process the result set
            if (resultSet.next()) {
                // Retrieve data by column name
                String id = resultSet.getString("patient_id");
                String name = resultSet.getString("patient_name");
                String gender = resultSet.getString("patient_gender");
                String dob = resultSet.getString("patient_DOB");
                String phone = resultSet.getString("patient_phone");
                String email = resultSet.getString("patient_email");
                String address = resultSet.getString("patient_address");
                String address2 = resultSet.getString("patient_address_line2");
                String address3 = resultSet.getString("patient_address_line3");
                String EmergencyName = resultSet.getString("patient_emergency_name");
                String EmergencyRelation = resultSet.getString("patient_emergency_relationship");
                String EmergencyPhone = resultSet.getString("patient_emergency_phone");
                String ins_ID = resultSet.getString("insuranceID");
                String pro_Name = resultSet.getString("providerName");
                String Pol_Number = resultSet.getString("policyNumber");
                // Set text fields with retrieved data
                patient_id.setText(id);
                patient_name.setText(name);
                patient_gender.setText(gender);
                patient_DOB.setText(dob);
                patient_phone.setText(phone);
                patient_email.setText(email);
                patient_address.setText(address);
                patient_address_line2.setText(address2);
                patient_address_line3.setText(address3);
                patient_emergency_name.setText(EmergencyName);
                patient_emergency_relationship.setText(EmergencyRelation);
                patient_emergency_phone.setText(EmergencyPhone);
                insuranceID.setText(ins_ID);
                providerName.setText(pro_Name);
                policyNumber.setText(Pol_Number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void setupTable(JTable table, DefaultTableModel model, JScrollPane scrollPane) {
        table.setModel(model);
        table.setIntercellSpacing(new Dimension(1, 1));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setCellSelectionEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
        // 自动调整列宽以适应内容
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
    
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
    
                // 设置一个最大宽度，以防止列太宽
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }
    
            tableColumn.setPreferredWidth(preferredWidth);
        }
    
        // 设置行高
        table.setRowHeight(40); // 根据需要调整行高
    
        // 设置单元格自动换行的渲染器
        table.setDefaultRenderer(Object.class, new WrappingCellRenderer());
    
        // 确保表头可见
        table.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    
    private static class WrappingCellRenderer extends DefaultTableCellRenderer {
        private final JTextArea textArea;
    
        public WrappingCellRenderer() {
            textArea = new JTextArea();
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setOpaque(true);
            textArea.setEditable(false);
        }
    
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            textArea.setText(value != null ? value.toString() : "");
            textArea.setSize(table.getColumnModel().getColumn(column).getWidth(), textArea.getPreferredSize().height);
            
            if (isSelected) {
                textArea.setBackground(table.getSelectionBackground());
                textArea.setForeground(table.getSelectionForeground());
            } else {
                textArea.setBackground(table.getBackground());
                textArea.setForeground(table.getForeground());
            }
    
            return textArea;
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backButton1;
    private javax.swing.JTextField insuranceID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable patientHistory_jTable;
    private javax.swing.JLabel patient_DOB;
    private javax.swing.JTextField patient_address;
    private javax.swing.JTextField patient_address_line2;
    private javax.swing.JTextField patient_address_line3;
    private javax.swing.JButton patient_clear;
    private javax.swing.JTextField patient_email;
    private javax.swing.JTextField patient_emergency_name;
    private javax.swing.JTextField patient_emergency_phone;
    private javax.swing.JTextField patient_emergency_relationship;
    private javax.swing.JLabel patient_gender;
    private javax.swing.JTextField patient_id;
    private javax.swing.JTextField patient_name;
    private javax.swing.JTextField patient_phone;
    private javax.swing.JButton patient_save;
    private javax.swing.JTextField policyNumber;
    private javax.swing.JTextField providerName;
    // End of variables declaration//GEN-END:variables
}
