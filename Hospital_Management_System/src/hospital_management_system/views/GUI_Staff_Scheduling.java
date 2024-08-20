/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital_management_system.views;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import java.awt.Window;

import hospital_management_system.MysqlConnect;
import hospital_management_system.controllers.*;
import hospital_management_system.models.StaffScheduling;
import hospital_management_system.utils.DateTimeUtils;

/**
 *
 * @author yc
 */
public class GUI_Staff_Scheduling extends javax.swing.JFrame {

    private String role;

    /**
     * Creates new form Staff_Scheduling
     */
    public GUI_Staff_Scheduling() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StaffScheduling = new javax.swing.JPanel();
        StaffID_input = new javax.swing.JTextField();
        StaffScheduleDate = new javax.swing.JFormattedTextField();
        ShiftStartTime_input = new javax.swing.JFormattedTextField();
        ShiftEndTime_input = new javax.swing.JFormattedTextField();
        Department_dropdown = new javax.swing.JComboBox<>();
        AssignedTasks_input = new javax.swing.JTextArea();
        SaveButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

        jScrollPane1 = new javax.swing.JScrollPane();
        StaffID = new javax.swing.JLabel();
        ShiftStartTime = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        AssignedTasks = new javax.swing.JLabel();
        ShiftEndTime = new javax.swing.JLabel();
        shiftDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        StaffScheduling.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Staff Scheduling", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); 

        StaffID.setText("Staff ID:");

        shiftDate.setText("Date:");
        
        ShiftStartTime.setText("Shift Start Time:");

        ShiftEndTime.setText("Shift End Time:");
        
        Department.setText("Department/Unit:");

        AssignedTasks.setText("Assigned Tasks:");

        Department_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emergency", "Cardiology", "Neurology", "Pediatrics", "Radiology", "Oncology", "Orthopedics", "Gynecology", "General Surgery", "Intensive Care Unit (ICU)", "Neonatal Intensive Care Unit (NICU)", "Anesthesiology", "Gastroenterology" }));

        AssignedTasks_input.setColumns(20);
        AssignedTasks_input.setRows(5);
        jScrollPane1.setViewportView(AssignedTasks_input);

        ShiftStartTime_input.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("hh:mm a"))));

        ShiftEndTime_input.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("hh:mm a"))));
        
        StaffScheduleDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/mm/y"))));

        javax.swing.GroupLayout StaffSchedulingLayout = new javax.swing.GroupLayout(StaffScheduling);
        StaffScheduling.setLayout(StaffSchedulingLayout);
        StaffSchedulingLayout.setHorizontalGroup(
            StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffSchedulingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(StaffSchedulingLayout.createSequentialGroup()
                        .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StaffSchedulingLayout.createSequentialGroup()
                                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ShiftStartTime, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(ShiftEndTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ShiftStartTime_input, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(ShiftEndTime_input)))
                            .addComponent(AssignedTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(StaffSchedulingLayout.createSequentialGroup()
                                .addComponent(Department)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Department_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(StaffSchedulingLayout.createSequentialGroup()
                                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(shiftDate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(StaffID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StaffID_input, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(StaffScheduleDate))))
                        .addGap(0, 122, Short.MAX_VALUE)))
                .addContainerGap())
        );
        StaffSchedulingLayout.setVerticalGroup(
            StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffSchedulingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StaffID_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StaffID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shiftDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StaffScheduleDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShiftStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShiftStartTime_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShiftEndTime_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShiftEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Department_dropdown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AssignedTasks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
      
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(StaffScheduling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClearButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(StaffScheduling, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(ClearButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setRole(String role) {
        this.role = role;
    }

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String role = GUI_admin.getInstance().getRole();

        // Ensure that the role variable is properly set before calling this method
        if (role == null || role.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Role is not selected", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a StaffScheduling instance with the input values
        StaffScheduling model = new StaffScheduling(
            StaffID_input.getText(),
            "",
            StaffScheduleDate.getText(),
            ShiftStartTime_input.getText(),
            ShiftEndTime_input.getText(),
            (String) Department_dropdown.getSelectedItem(),
            AssignedTasks_input.getText()
        );

        // Create a scheduleController with the model
        StaffSchedulingController scheduleController = new StaffSchedulingController(model);

        // Delegate the save operation to the scheduleController
        if (scheduleController.saveSchedule(role)) {
            // Refresh the table if save is successful
            refreshCurrentScheduleTable();
        }
    }

    public void refreshCurrentScheduleTable() {
        if ("Doctor".equals(role)) {
            scheduleController.loadDoctorSchedule();
            DoctorScheduleTable.revalidate();
            DoctorScheduleTable.repaint();
        } else if ("Nurse".equals(role)) {
            scheduleController.loadNurseSchedule();
            NurseScheduleTable.revalidate();
            NurseScheduleTable.repaint();
        }
    }

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        StaffID_input.setText("");
        StaffScheduleDate.setText("");
        ShiftStartTime_input.setText("");
        ShiftEndTime_input.setText("");
        Department_dropdown.setSelectedIndex(0);
        AssignedTasks_input.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Staff_Scheduling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Staff_Scheduling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Staff_Scheduling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Staff_Scheduling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Staff_Scheduling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssignedTasks;
    private javax.swing.JTextArea AssignedTasks_input;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel Department;
    private javax.swing.JComboBox<String> Department_dropdown;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel ShiftEndTime;
    private javax.swing.JFormattedTextField ShiftEndTime_input;
    private javax.swing.JLabel ShiftStartTime;
    private javax.swing.JFormattedTextField ShiftStartTime_input;
    private javax.swing.JLabel StaffID;
    private javax.swing.JTextField StaffID_input;
    private javax.swing.JFormattedTextField StaffScheduleDate;
    private javax.swing.JPanel StaffScheduling;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel shiftDate;
    // End of variables declaration//GEN-END:variables
}
