package hospital_management_system.views;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Data_Tables extends JFrame {
    private String role;
    private String username;

    private JButton PatientButton;
    private JButton DoctorStaffSchedulingButton;
    private JButton PrescriptionButton;
    private JButton DiagnosisButton;
    private JButton NurseStaffScheduleButton;
    private JButton InventotryButton;
    private JButton PatientHistoryButton;
    private JButton MedicalRecordsButton;
    private JButton AdmissionButton;
    private JButton MedicalSupplyButton;
    private JButton AppointmentButton;
    private JButton BillingButton;
    private JButton SurgeryButton;
    private JButton PaymentButton;
    private JButton PatientTransferButton;
    private JButton AdminButton;
    private JButton BedAllocationButton;
    private JButton ConsultationsButton;
    private JButton InvoiceButton;
    private JLabel SelectRoleLabel;
    private JLabel SelectRoleLabel1;
    private JLabel TitleLabel;
    private JLabel BackLabel;

    public List<String> getAllowedButtons(String role) {
        System.out.println("Current role is " + role);
        if (role.equals("Admin")) {
            return Arrays.asList("AdminButton", "PatientButton", "DoctorStaffSchedulingButton", "NurseStaffScheduleButton", "PrescriptionButton", "DiagnosisButton", "InvoiceButton", "InventotryButton", "MedicalRecordsButton", "AdmissionButton", "BillingButton", "SurgeryButton", "PaymentButton", "PatientTransferButton", "BedAllocationButton", "ConsultationsButton", "MedicalSupplyButton", "AppointmentButton", "PatientHistoryButton");
        } else if (role.equals("Doctor")) {
            return Arrays.asList("PatientButton", "DoctorStaffSchedulingButton", "PrescriptionButton", "DiagnosisButton", "MedicalRecordsButton", "SurgeryButton", "ConsultationsButton");
        } else if (role.equals("Nurse")) {
            return Arrays.asList("PatientButton", "NurseStaffScheduleButton", "InvoiceButton", "InventoryButton", "AdmissionButton", "BillingButton", "PaymentButton", "PatientTransferButton", "BedAllocationButton", "MedicalSupplyButton", "AppointmentButton", "PatientHistoryButton");
        } else {
            return Arrays.asList();
        }
    }

    public Data_Tables(String role, String username) {
        this.role = role;
        this.username = username;

        initComponents(role);
        configureButtons(role);
    }

    private void configureButtons(String role) {
        List<String> allowedButtons = getAllowedButtons(role);

    // Collect all components to remove gaps
    java.awt.Component[] components = getContentPane().getComponents();
    GridBagConstraints gbc = new GridBagConstraints();

    // Keep track of rows and columns
    int row = 3;
    int col = 0;
    
    for (java.awt.Component comp : components) {
        if (comp instanceof JButton) {
            JButton button = (JButton) comp;
            if (allowedButtons.contains(button.getName())) {
                // Show allowed buttons and set their position
                button.setVisible(true);
                gbc.gridx = col;
                gbc.gridy = row;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.insets = new Insets(5, 5, 5, 5);
                gbc.fill = GridBagConstraints.BOTH;
                add(button, gbc);

                // Update position for the next button
                col++;
                if (col > 2) {  // Assuming 3 columns
                    col = 0;
                    row++;
                }
            } else {
                // Hide buttons not allowed for this role
                button.setVisible(false);
            }
        }
    }
    
    // Revalidate and repaint the frame to apply the new layout
    revalidate();
    repaint();
    }

    private void initComponents(String role) {
        setTitle("Hospital Management System");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
    
        TitleLabel = new JLabel("Hospital Management System", JLabel.CENTER);
        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        addComponent(TitleLabel, 0, 0, 3, 1);
    
        SelectRoleLabel1 = new JLabel("Welcome back, ", JLabel.CENTER);
        addComponent(SelectRoleLabel1, 0, 1, 3, 1);
    
        SelectRoleLabel = new JLabel("-- Please select the data tables for checking --", JLabel.CENTER);
        addComponent(SelectRoleLabel, 0, 2, 3, 1);
    
        // Initialize buttons
        initButton(PatientButton = new JButton(), "Patients", "PatientButton", 0, 3);
        initButton(DoctorStaffSchedulingButton = new JButton(), "DoctorStaffScheduling", "DoctorStaffSchedulingButton", 1, 3);
        initButton(PrescriptionButton = new JButton(), "Prescription", "PrescriptionButton", 2, 3);
        initButton(DiagnosisButton = new JButton(), "Diagnosis", "DiagnosisButton", 0, 4);
        initButton(NurseStaffScheduleButton = new JButton(), "NurseStaffScheduling", "NurseStaffScheduleButton", 1, 4);
        initButton(InventotryButton = new JButton(), "InventoryManagement", "InventotryButton", 2, 4);
        initButton(PatientHistoryButton = new JButton(), "PatientHistory", "PatientHistoryButton", 0, 5);
        initButton(MedicalRecordsButton = new JButton(), "MedicalRecords", "MedicalRecordsButton", 1, 5);
        initButton(AdmissionButton = new JButton(), "Admission", "AdmissionButton", 2, 5);
        initButton(MedicalSupplyButton = new JButton(), "MedicalSupplyManagement", "MedicalSupplyButton", 2, 6);
        initButton(AppointmentButton = new JButton(), "Appointment", "AppointmentButton", 0, 7);
        initButton(BillingButton = new JButton(), "Billing", "BillingButton", 1, 7);
        initButton(SurgeryButton = new JButton(), "Surgery", "SurgeryButton", 2, 7);
        initButton(PaymentButton = new JButton(), "Payment", "PaymentButton", 0, 8);
        initButton(PatientTransferButton = new JButton(), "TransferManagement", "PatientTransferButton", 1, 8);
        initButton(AdminButton = new JButton(), "Admin", "AdminButton", 2, 8);
        initButton(BedAllocationButton = new JButton(), "BedAllocation", "BedAllocationButton", 0, 9);
        initButton(ConsultationsButton = new JButton(), "Consultations", "ConsultationsButton", 1, 9);
        initButton(InvoiceButton = new JButton(), "Invoice", "InvoiceButton", 2, 9);
        
        // Add the Back label
        BackLabel = new JLabel("Back", JLabel.CENTER);
        BackLabel.setForeground(Color.BLUE);
        BackLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BackLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Implement the back functionality here
                backLabelMouseClicked(evt);
            }
        });
        // Position the label with some space between it and the buttons
        addComponent(BackLabel, 0, 10, 3, 1); // Placed on a new row
        
        pack();
        
        // Increase width and height if the role is "Admin"
        if (role.equals("Admin")) {
            setSize(getWidth() + 100, getHeight() + 100); // Add 100 pixels to width and height
        }
    }
    

    private void initButton(JButton button, String tableName, String name, int gridx, int gridy) {
        button.setText(tableName);
        button.setName(name);
        addComponent(button, gridx, gridy, 1, 1);
        button.addActionListener(evt -> buttonActionPerformed(evt, tableName));
    }
    
    private void addComponent(java.awt.Component comp, int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        add(comp, gbc);
    }
    
    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        // Create an object for the home page gui
        Home_Page_GUI homepage_GUI = new Home_Page_GUI(this.role, this.username);
        homepage_GUI.setVisible(true);
    }
    
    private void buttonActionPerformed(java.awt.event.ActionEvent evt, String tableName) {
        GUI_Check_Data checkDataGUI = new GUI_Check_Data(tableName);
        checkDataGUI.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Data_Tables().setVisible(true));
    }
}
