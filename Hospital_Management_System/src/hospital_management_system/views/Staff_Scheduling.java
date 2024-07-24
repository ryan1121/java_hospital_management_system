/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital_management_system;

import javax.swing.JOptionPane;

/**
 *
 * @author yc
 */
public class Staff_Scheduling extends javax.swing.JFrame {

    /**
     * Creates new form Staff_Scheduling
     */
    public Staff_Scheduling() {
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

        StaffScheduling.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Staff Scheduling", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        StaffID.setText("Staff ID:");

        ShiftStartTime.setText("Shift Start Time:");

        ShiftEndTime.setText("Shift End Time:");

        ShiftDate.setText("Date:");

        Department.setText("Department/Unit:");

        AssignedTasks.setText("Assigned Tasks:");
        
        ShiftStartTime_input.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        ShiftStartTime_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShiftStartTime_inputActionPerformed(evt);
            }
        });
        
        ShiftEndTime_input.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        ShiftEndTime_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShiftEndTime_inputActionPerformed(evt);
            }
        });
        
        Department_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emergency", "Cardiology", "Neurology", "Pediatrics", "Radiology", "Oncology", "Orthopedics", "Gynecology", "General Surgery", "Intensive Care Unit (ICU)", "Neonatal Intensive Care Unit (NICU)", "Anesthesiology", "Gastroenterology" }));
        Department_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Department_dropdownActionPerformed(evt);
            }
        });

        AssignedTasks_input.setColumns(20);
        AssignedTasks_input.setRows(5);
        jScrollPane1.setViewportView(AssignedTasks_input);

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
                            .addComponent(AssignedTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(StaffSchedulingLayout.createSequentialGroup()
                                .addComponent(Department)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Department_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(StaffSchedulingLayout.createSequentialGroup()
                                .addGroup(StaffSchedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ShiftDate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(ShiftDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(StaffScheduling, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(ClearButton)
                    .addComponent(CancelButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // Retrieve values from the form fields
        String staffID = StaffID_input.getText();
        String shiftStartTime = ShiftStartTime_input.getText();
        String shiftEndTime = ShiftEndTime_input.getText();
        String Department = Department_dropdown.getSelectedItem();
        String AssignedTasks = AssignedTasks_input.getText();
        String shiftDate = StaffScheduleDate.getText();

        // Perform validation and save logic
        if (staffID.isEmpty() || shiftStartTime.isEmpty() || shiftEndTime.isEmpty() || shiftDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Save data to database or any other storage
            JOptionPane.showMessageDialog(this, "Staff schedule saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed
    
        private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
            StaffID_input.setText("");
            ShiftStartTime_input.setText("");
            ShiftEndTime_input.setText("");
            Department_dropdown.setSelectedIndex(0);
            AssignedTasks_input.setText("");
            StaffScheduleDate.setText("");
        }                                           
    
        private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
            this.dispose(); // Close the current window
        }            
                    
    private void ShiftStartTime_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShiftStartTime_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShiftStartTime_inputActionPerformed

    private void ShiftEndTime_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShiftEndTime_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShiftEndTime_inputActionPerformed

    private void Department_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Department_dropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Department_dropdownActionPerformed
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
            java.util.logging.Logger.getLogger(Staff_Scheduling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff_Scheduling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff_Scheduling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff_Scheduling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff_Scheduling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssignedTasks;
    private javax.swing.JTextArea AssignedTasks_input;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel Department;
    private javax.swing.JComboBox<String> Department_dropdown;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel ShiftDate;
    private javax.swing.JLabel ShiftEndTime;
    private javax.swing.JFormattedTextField ShiftEndTime_input;
    private javax.swing.JLabel ShiftStartTime;
    private javax.swing.JFormattedTextField ShiftStartTime_input;
    private javax.swing.JLabel StaffID;
    private javax.swing.JTextField StaffID_input;
    private javax.swing.JFormattedTextField StaffScheduleDate;
    private javax.swing.JPanel StaffScheduling;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
