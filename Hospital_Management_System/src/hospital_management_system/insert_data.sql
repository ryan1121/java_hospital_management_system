/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  DELL
 * Created: Jul 15, 2024
 */
-- 为 Patients 表添加数据
INSERT INTO Patients (patient_id, patient_DOB, patient_gender, patient_phone, patient_name, patient_password, patient_email, patient_address, patient_address_line2, patient_address_line3, patient_emergency_name, patient_emergency_phone, patient_emergency_relationship, insuranceID, providerName, policyNumber, consult_date, consult_time, consult_record, patient_allergies)
VALUES 
('P001', '1990-01-01', 'Male', '1234567890', 'John Doe', 'password123', 'john.doe@example.com', '123 Main St', 'Apt 4B', '', 'Jane Doe', '0987654321', 'Sister', 'INS12345', 'Provider A', 'POL123', '2023-07-20', '10:00:00', 'Initial consultation', 'None'),
('P002', '1985-05-15', 'Female', '2345678901', 'Jane Smith', 'password456', 'jane.smith@example.com', '456 Elm St', '', '', 'John Smith', '0876543210', 'Brother', 'INS67890', 'Provider B', 'POL456', '2023-07-21', '11:00:00', 'Follow-up visit', 'Peanuts'),
('P003', '1978-12-12', 'Male', '3456789012', 'Bob Johnson', 'password789', 'bob.johnson@example.com', '789 Pine St', 'Suite 5', '', 'Alice Johnson', '0765432109', 'Wife', 'INS54321', 'Provider C', 'POL789', '2023-07-22', '09:00:00', 'Routine check-up', 'Penicillin');

-- 为 Doctors 表添加数据
INSERT INTO Doctors (doctor_id, doctor_name, doctor_password, doctor_phone, doctor_email, doctor_specialization, doctor_department, doctor_status, doctor_experience, doctor_qualifications, doctor_license_information, workDate, workTime, workDetails)
VALUES 
('D001', 'Dr. Alice Brown', 'password123', '4567890123', 'alice.brown@example.com', 'Cardiology', 'Cardiology Dept', 'Active', '10 years of experience', 'MD, Cardiology', 'License No. 12345', '2023-07-20', '08:00:00', 'Cardiology consultation'),
('D002', 'Dr. Charlie White', 'password456', '5678901234', 'charlie.white@example.com', 'Neurology', 'Neurology Dept', 'Active', '15 years of experience', 'MD, Neurology', 'License No. 67890', '2023-07-21', '09:00:00', 'Neurology consultation'),
('D003', 'Dr. Emily Green', 'password789', '6789012345', 'emily.green@example.com', 'Pediatrics', 'Pediatrics Dept', 'Active', '8 years of experience', 'MD, Pediatrics', 'License No. 54321', '2023-07-22', '10:00:00', 'Pediatrics consultation');

-- 为 Nurse 表添加数据
INSERT INTO Nurse (nurse_id, nurse_name, nurse_password, nurse_email, nurse_phone, nurse_position, nurse_department, nurse_assign_wards, nurse_supervising_doctor, nurse_qualifications, nurse_experience, nurse_license_information, nurse_status, schedule_date, schedule_time, schedule_details)
VALUES 
('N001', 'Nurse Sarah Brown', 'password123', 'sarah.brown@example.com', '7890123456', 'Head Nurse', 'Cardiology Dept', 'Ward 1', 'D001', 'RN, BSN', '5 years of experience', 'License No. 98765', 'Active', '2023-07-20', '08:00:00', 'Morning shift'),
('N002', 'Nurse David Black', 'password456', 'david.black@example.com', '8901234567', 'Staff Nurse', 'Neurology Dept', 'Ward 2', 'D002', 'RN, MSN', '3 years of experience', 'License No. 87654', 'Active', '2023-07-21', '09:00:00', 'Afternoon shift'),
('N003', 'Nurse Laura White', 'password789', 'laura.white@example.com', '9012345678', 'Staff Nurse', 'Pediatrics Dept', 'Ward 3', 'D003', 'RN', '2 years of experience', 'License No. 76543', 'Active', '2023-07-22', '10:00:00', 'Night shift');

-- 为 PatientCare 表添加数据
INSERT INTO PatientCare (Primary_doctor_id, assigned_nurse_id, dietary_restrictions, patient_progress_note, discharge_date)
VALUES 
('D001', 'N001', 'None', 'Patient is responding well to treatment.', '2023-08-01'),
('D002', 'N002', 'Gluten-free', 'Patient requires additional monitoring.', '2023-08-02'),
('D003', 'N003', 'Lactose-free', 'Patient has shown significant improvement.', '2023-08-03');

-- 为 Admission 表添加数据
INSERT INTO Admission (Admission_ID, Admission_Date1, Admitting_Staff_ID, Admission_Status, Admission_Notes, Reason1, admission_Patient_ID, Insurance_Details, medical_equipment_need)
VALUES 
('A001', '2023-07-20', 'N001', 'Admitted', 'Patient admitted for observation.', 'Chest pain', 'P001', 'INS12345', 'Oxygen tank'),
('A002', '2023-07-21', 'N002', 'Admitted', 'Patient admitted for surgery.', 'Appendicitis', 'P002', 'INS67890', 'Surgical instruments'),
('A003', '2023-07-22', 'N003', 'Admitted', 'Patient admitted for treatment.', 'Asthma', 'P003', 'INS54321', 'Inhaler');

-- 为 Appointment 表添加数据
INSERT INTO Appointment (Appointment_ID, app_patient_id, app_doctor_id, app_date, app_time, appointment_notes, appointment_type, app_status, app_reason, app_location, Admitting_Staff_ID, booking_date, app_cancel)
VALUES 
('AP001', 'P001', 'D001', '2023-07-25', '10:00:00', 'Routine check-up.', 'General', 'Scheduled', 'Routine check-up', 'Room 101', 'N001', '2023-07-20', FALSE),
('AP002', 'P002', 'D002', '2023-07-26', '11:00:00', 'Follow-up visit.', 'Specialist', 'Scheduled', 'Follow-up visit', 'Room 202', 'N002', '2023-07-21', FALSE),
('AP003', 'P003', 'D003', '2023-07-27', '09:00:00', 'Consultation.', 'Specialist', 'Scheduled', 'Consultation', 'Room 303', 'N003', '2023-07-22', FALSE);

-- 为 BedAllocation 表添加数据
INSERT INTO BedAllocation (bed_allocate_number, room_allocate_number, ward_allocate_number, bed_allocation_department, bed_allocation_status, bed_type, bed_patient_id, allocate_date, discharge_date, pre_occ, emergency_equipment)
VALUES 
('B001', 'R001', 'W001', 'Cardiology', 'Occupied', 'Standard', 'P001', '2023-07-20', '2023-08-01', 'None', 'Oxygen tank'),
('B002', 'R002', 'W002', 'Neurology', 'Occupied', 'Standard', 'P002', '2023-07-21', '2023-08-02', 'None', 'Surgical instruments'),
('B003', 'R003', 'W003', 'Pediatrics', 'Occupied', 'Standard', 'P003', '2023-07-22', '2023-08-03', 'None', 'Inhaler');

-- 为 Admin 表添加数据
INSERT INTO Admin (admin_id, admin_name, admin_password, admin_phone, admin_email)
VALUES 
('ADM001', 'Admin One', 'password123', '1112223333', 'admin.one@example.com'),
('ADM002', 'Admin Two', 'password456', '2223334444', 'admin.two@example.com'),
('ADM003', 'Admin Three', 'password789', '3334445555', 'admin.three@example.com');

-- 为 Prescription 表添加数据
INSERT INTO Prescription (PrescriptionID_textField, PatientID, DoctorID, Medication_comboxBox, dosage_Spinner, PrescriptionDate_textField, instructions)
VALUES 
('PR001', 'P001', 'D001', 'Medication A', '1 tablet', '2023-07-20', 'Take one tablet daily.'),
('PR002', 'P002', 'D002', 'Medication B', '2 tablets', '2023-07-21', 'Take two tablets after meals.'),
('PR003', 'P003', 'D003', 'Medication C', '1 tablet', '2023-07-22', 'Take one tablet every 8 hours.');

-- 为 MedicalRecords 表添加数据
INSERT INTO MedicalRecords (medicalRecordID_textField, PatientID, DoctorID, DateOfVisit_textField, notes_textField8, medical_record_treatmentPlans)
VALUES 
('MR001', 'P001', 'D001', '2023-07-20', 'Patient is stable.', 'Continue current medication.'),
('MR002', 'P002', 'D002', '2023-07-21', 'Surgery successful.', 'Monitor for infection.'),
('MR003', 'P003', 'D003', '2023-07-22', 'Asthma treatment started.', 'Regular inhaler use.');

-- 为 Surgeries 表添加数据
INSERT INTO Surgeries (surgeryID_textField, PatientID, DoctorID, surgeryType_comboBox, DateOfSurgery_textField, Outcomes_textField)
VALUES 
('S001', 'P002', 'D002', 'Appendectomy', '2023-07-21', 'Successful'),
('S002', 'P001', 'D001', 'Bypass Surgery', '2023-07-23', 'Successful'),
('S003', 'P003', 'D003', 'Tonsillectomy', '2023-07-24', 'Successful');

-- 为 Consultations 表添加数据
INSERT INTO Consultations (ConsultationID_textField, PatientID, DoctorID, DateOfConsultation_textField, notes_textField)
VALUES 
('C001', 'P001', 'D001', '2023-07-20', 'Routine check-up.'),
('C002', 'P002', 'D002', '2023-07-21', 'Follow-up visit.'),
('C003', 'P003', 'D003', '2023-07-22', 'Initial consultation.');

-- 为 Diagnoses 表添加数据
INSERT INTO Diagnoses (diagonisisID_textField, PatientID, DoctorID, diagonosisDescription_TextArea, DateOfDiagonosis_textField, treatmentPlans_TextArea, surgeryID_textField)
VALUES 
('DI001', 'P001', 'D001', 'Hypertension', '2023-07-20', 'Medication and lifestyle changes.', NULL),
('DI002', 'P002', 'D002', 'Appendicitis', '2023-07-21', 'Surgery required.', 'S001'),
('DI003', 'P003', 'D003', 'Asthma', '2023-07-22', 'Inhaler use.', NULL);

-- 为 PatientHistory 表添加数据
INSERT INTO PatientHistory (HistoryID, PatientID, EventType, EventDate, Details)
VALUES 
('H001', 'P001', 'Admission', '2023-07-20', 'Patient admitted for observation.'),
('H002', 'P002', 'Surgery', '2023-07-21', 'Appendectomy performed.'),
('H003', 'P003', 'Consultation', '2023-07-22', 'Initial consultation for asthma.');

-- 为 Billing 表添加数据
INSERT INTO Billing (ServicesDescription, CostPerService, Quantity, TotalPayment)
VALUES 
('Consultation', 50.00, 1, 50.00),
('Surgery', 1000.00, 1, 1000.00),
('Medication', 20.00, 5, 100.00);

-- 为 Payment 表添加数据
INSERT INTO Payment (PaymentID, PaymentDate, PaymentMethod, PaymentAmount, PaymentStatus, InvoiceID)
VALUES 
('PAY001', '2023-07-20', 'Credit Card', 50.00, 'Paid', 'INV001'),
('PAY002', '2023-07-21', 'Cash', 1000.00, 'Paid', 'INV002'),
('PAY003', '2023-07-22', 'Insurance', 100.00, 'Pending', 'INV003');

-- 为 StaffScheduling 表添加数据
INSERT INTO StaffScheduling (StaffID, StaffScheduleDate, ShiftStartTime, ShiftEndTime, Department, AssignedTasks, StaffAvailability)
VALUES 
('D001', '2023-07-20', '08:00:00', '16:00:00', 'Cardiology', 'Consultations', 'Available'),
('N001', '2023-07-21', '08:00:00', '16:00:00', 'Cardiology', 'Patient care', 'Available'),
('D002', '2023-07-21', '09:00:00', '17:00:00', 'Neurology', 'Surgeries', 'Available');

-- 为 InventoryManagement 表添加数据
INSERT INTO InventoryManagement (InventoryID, ItemCode, ItemName, InventoryStockQuantity, InventoryMaximumStock, InventoryMinimunStock, SupplierInformation, InventoryExpirydate)
VALUES 
('INV001', 'IT001', 'Stethoscope', 50, 100, 10, 'Supplier A', '2024-07-20'),
('INV002', 'IT002', 'Surgical Masks', 200, 500, 50, 'Supplier B', '2024-07-21'),
('INV003', 'IT003', 'Gloves', 300, 600, 100, 'Supplier C', '2024-07-22');

-- 为 MedicalSupplyManagement 表添加数据
INSERT INTO MedicalSupplyManagement (SupplyID, SupplyName, SupplyCode, SupplyStockQuantity, SupplyMinimunStock, SupplyMaximumStock, SupplierInformation, SupplyExpiryDate)
VALUES 
('MS001', 'Bandages', 'SUP001', 100, 20, 200, 'Supplier X', '2024-07-20'),
('MS002', 'IV Bags', 'SUP002', 50, 10, 100, 'Supplier Y', '2024-07-21'),
('MS003', 'Syringes', 'SUP003', 200, 50, 500, 'Supplier Z', '2024-07-22');

-- 为 TransferManagement 表添加数据
INSERT INTO TransferManagement (TransferID, PatientID, TransferFrom, TransferTo, PatientTransferDate, TransferTime, ReasonForTransfer, StatusOfTransfer)
VALUES 
('T001', 'P001', 'ER', 'Cardiology', '2023-07-20', '08:00:00', 'Chest pain', 'Completed'),
('T002', 'P002', 'ER', 'Surgery', '2023-07-21', '09:00:00', 'Appendicitis', 'Completed'),
('T003', 'P003', 'ER', 'Pediatrics', '2023-07-22', '10:00:00', 'Asthma', 'Completed');

-- 为 Invoice 表添加数据
INSERT INTO Invoice (InvoiceID, InvoiceDate, InvoiceDue, PatientID, TotalPayment, AmountPaid, BalanceDue)
VALUES 
('INV001', '2023-07-20', '2023-10-20', 'P001', 50.00, 50.00, 0.00),
('INV002', '2023-07-21', '2023-10-21', 'P002', 1000.00, 1000.00, 0.00),
('INV003', '2023-07-22', '2023-10-22', 'P003', 100.00, 0.00, 100.00);
