/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  DELL
 * Created: Jul 15, 2024
 */

-- 插入假数据到 Patients 表
INSERT INTO Patients (patient_id, patient_DOB, patient_gender, patient_phone, patient_name, patient_password, patient_email, patient_address, patient_address_line2, patient_address_line3, patient_emergency_name, patient_emergency_phone, patient_emergency_relationship, insuranceID, providerName, policyNumber, consult_date, consult_time, consult_record, patient_allergies)
VALUES
('P001', '1980-05-15', 'Male', '1234567890', 'John Doe', 'password123', 'john.doe@example.com', '123 Main St', 'Apt 4B', 'New York, NY', 'Jane Doe', '0987654321', 'Sister', 'INS12345', 'HealthPlus', 'POL123456', '2024-07-01', '10:30:00', 'Regular check-up', 'None'),
('P002', '1992-08-22', 'Female', '2345678901', 'Jane Smith', 'password456', 'jane.smith@example.com', '456 Elm St', 'Suite 5C', 'Los Angeles, CA', 'Jack Smith', '1234567890', 'Husband', 'INS67890', 'WellCare', 'POL789012', '2024-07-02', '11:00:00', 'Consultation', 'Peanuts'),
('P003', '1975-11-30', 'Male', '3456789012', 'Mike Johnson', 'password789', 'mike.johnson@example.com', '789 Oak St', 'Floor 2', 'Chicago, IL', 'Mary Johnson', '2345678901', 'Wife', 'INS98765', 'HealthNet', 'POL345678', '2024-07-03', '14:00:00', 'Follow-up', 'Penicillin');

-- 插入假数据到 Doctors 表
INSERT INTO Doctors (doctor_id, doctor_name, doctor_password, doctor_phone, doctor_email, doctor_specialization, doctor_department, doctor_status, doctor_experience, doctor_qualifications, doctor_license_information, workDate, workTime, workDetails)
VALUES
('D001', 'Dr. Smith', 'drsmith123', '9876543210', 'dr.smith@example.com', 'Cardiology', 'Cardiology Department', 'Active', '10 years in cardiology field', 'MD, Cardiology', 'License info: XYZ123', '2024-07-01', '08:00:00', 'Cardiology specialist at XYZ Hospital'),
('D002', 'Dr. Johnson', 'drjohnson456', '8765432109', 'dr.johnson@example.com', 'Pediatrics', 'Pediatrics Department', 'Active', '8 years in pediatrics', 'MD, Pediatrics', 'License info: ABC456', '2024-07-02', '09:00:00', 'Pediatrician at ABC Clinic'),
('D003', 'Dr. Brown', 'drbrown789', '7654321098', 'dr.brown@example.com', 'Orthopedics', 'Orthopedics Department', 'Active', '12 years in orthopedic surgery', 'MD, Orthopedics', 'License info: DEF789', '2024-07-03', '10:00:00', 'Orthopedic surgeon at DEF Medical Center');

-- 插入假数据到 Nurse 表
INSERT INTO Nurse (nurse_id, nurse_name, nurse_password, nurse_email, nurse_phone, nurse_position, nurse_department, nurse_assign_wards, nurse_supervising_doctor, nurse_qualifications, nurse_experience, nurse_license_information, nurse_status, schedule_date, schedule_time, schedule_details)
VALUES
('N001', 'Nurse Adams', 'nurseadams123', 'adams.nurse@example.com', '6543210987', 'Senior Nurse', 'Surgical Ward', 'Ward A', 'Dr. Smith', 'Registered Nurse (RN)', '5 years in surgical nursing', 'License info: GHI123', 'Active', '2024-07-01', '07:00:00', 'Senior nurse in Surgical Ward'),
('N002', 'Nurse Lee', 'nurselee456', 'lee.nurse@example.com', '5432109876', 'Nurse', 'Pediatrics Ward', 'Ward B', 'Dr. Johnson', 'Registered Nurse (RN)', '3 years in pediatric nursing', 'License info: JKL456', 'Active', '2024-07-02', '08:00:00', 'Pediatric nurse in Ward B'),
('N003', 'Nurse Taylor', 'nursetaylor789', 'taylor.nurse@example.com', '4321098765', 'Nurse Practitioner', 'Orthopedics Ward', 'Ward C', 'Dr. Brown', 'Nurse Practitioner (NP)', '7 years in orthopedic nursing', 'License info: MNO789', 'Active', '2024-07-03', '09:00:00', 'Nurse practitioner in Orthopedics Ward');

-- 插入假数据到 PatientCare 表
INSERT INTO PatientCare (Primary_doctor_id, assigned_nurse_id, dietary_restrictions, patient_progress_note, discharge_date)
VALUES
('D001', 'N001', 'No dairy products', 'Patient recovering well', '2024-07-10'),
('D002', 'N002', 'No peanuts', 'Patient improving steadily', '2024-07-11'),
('D003', 'N003', 'Low sodium diet', 'Patient discharged', '2024-07-12');

-- 插入假数据到 Admission 表
INSERT INTO Admission (Admission_ID, Admission_Date1, Admitting_Staff_ID, Admission_Status, Admission_Notes, Reason1, admission_Patient_ID, Insurance_Details, medical_equipment_need)
VALUES
('ADM001', '2024-07-01', 'N001', 'Admitted', 'Patient transferred from ER', 'Emergency', 'P001', 'Insurance provider: ABC Insurance', 'Oxygen support'),
('ADM002', '2024-07-02', 'N002', 'Admitted', 'Scheduled admission for surgery', 'Surgery', 'P002', 'Insurance provider: XYZ Insurance', 'Surgical tools'),
('ADM003', '2024-07-03', 'N003', 'Admitted', 'Routine admission for consultation', 'Consultation', 'P003', 'Insurance provider: DEF Insurance', 'Medical monitor');

-- 插入假数据到 Appointment 表
INSERT INTO Appointment (Appointment_ID, app_patient_id, app_doctor_id, app_date, app_time, appointment_notes, appointment_type, app_status, app_reason, app_location, Admitting_Staff_ID, booking_date, app_cancel)
VALUES
('APP001', 'P001', 'D001', '2024-07-05', '08:30:00', 'Regular check-up', 'General', 'Scheduled', 'Routine check-up', 'Room A', 'N001', '2024-07-01', FALSE),
('APP002', 'P002', 'D002', '2024-07-06', '09:00:00', 'Consultation for ongoing treatment', 'Specialist', 'Scheduled', 'Follow-up consultation', 'Room B', 'N002', '2024-07-02', FALSE),
('APP003', 'P003', 'D003', '2024-07-07', '10:00:00', 'Orthopedic consultation', 'Specialist', 'Scheduled', 'Consultation for knee pain', 'Room C', 'N003', '2024-07-03', FALSE);

-- 插入假数据到 BedAllocation 表
INSERT INTO BedAllocation (bed_allocate_number, room_allocate_number, ward_allocate_number, bed_allocation_department, bed_allocation_status, bed_type, bed_patient_id, allocate_date, discharge_date, pre_occ, emergency_equipment)
VALUES
('B001', 'R001', 'W001', 'Surgical Ward', 'Occupied', 'Single', 'P001', '2024-07-01', '2024-07-10', 'None', 'Oxygen tank'),
('B002', 'R002', 'W002', 'Pediatrics Ward', 'Occupied', 'Pediatric', 'P002', '2024-07-02', '2024-07-11', 'Surgery', 'Ventilator'),
('B003', 'R003', 'W003', 'Orthopedics Ward', 'Occupied', 'Orthopedic', 'P003', '2024-07-03', '2024-07-12', 'Consultation', 'Walker');

-- 插入假数据到 Admin 表
INSERT INTO Admin (admin_id, admin_name, admin_password, admin_phone, admin_email)
VALUES
('ADM001', 'Admin Smith', 'admin123', '9876543210', 'admin.smith@example.com'),
('ADM002', 'Admin Johnson', 'admin456', '8765432109', 'admin.johnson@example.com'),
('ADM003', 'Admin Brown', 'admin789', '7654321098', 'admin.brown@example.com');

-- 插入假数据到 Prescription 表
INSERT INTO Prescription (PrescriptionID_textField, PatientID, DoctorID, Medication_comboxBox, dosage_Spinner, PrescriptionDate_textField, instructions)
VALUES
('RX001', 'P001', 'D001', 'Aspirin', '100mg', '2024-07-05', 'Take one tablet daily with food'),
('RX002', 'P002', 'D002', 'Amoxicillin', '500mg', '2024-07-06', 'Take twice daily for 7 days'),
('RX003', 'P003', 'D003', 'Ibuprofen', '200mg', '2024-07-07', 'Take as needed for pain');

-- 插入假数据到 MedicalRecords 表
INSERT INTO MedicalRecords (medicalRecordID_textField, PatientID, DoctorID, DateOfVisit_textField, notes_textField8, medical_record_treatmentPlans)
VALUES
('MR001', 'P001', 'D001', '2024-07-05', 'Patient complained of headaches', 'Prescribed medication for pain relief'),
('MR002', 'P002', 'D002', '2024-07-06', 'Patient had fever and cough', 'Prescribed antibiotics for infection'),
('MR003', 'P003', 'D003', '2024-07-07', 'Patient complained of knee pain', 'Recommended consultation with orthopedic specialist');

-- 插入假数据到 Surgeries 表
INSERT INTO Surgeries (surgeryID_textField, PatientID, DoctorID, surgeryType_comboBox, DateOfSurgery_textField, Outcomes_textField)
VALUES
('S001', 'P001', 'D001', 'Appendectomy', '2024-07-10', 'Successful recovery'),
('S002', 'P002', 'D002', 'Tonsillectomy', '2024-07-11', 'Steady recovery'),
('S003', 'P003', 'D003', 'Knee replacement', '2024-07-12', 'Excellent recovery');

-- 插入假数据到 Consultations 表
INSERT INTO Consultations (ConsultationID_textField, PatientID, DoctorID, DateOfConsultation_textField, notes_textField)
VALUES
('C001', 'P001', 'D001', '2024-07-05', 'Discussed ongoing treatment plan'),
('C002', 'P002', 'D002', '2024-07-06', 'Reviewed progress after antibiotics'),
('C003', 'P003', 'D003', '2024-07-07', 'Consulted on knee pain management');

-- 插入假数据到 Diagnoses 表
INSERT INTO Diagnoses (diagonisisID_textField, PatientID, DoctorID, diagonosisDescription_TextArea, DateOfDiagonosis_textField, treatmentPlans_TextArea, surgeryID_textField)
VALUES
('D001', 'P001', 'D001', 'Appendicitis', '2024-07-10', 'Scheduled surgery for appendectomy', 'S001'),
('D002', 'P002', 'D002', 'Tonsillitis', '2024-07-11', 'Prescribed antibiotics and rest', 'S002'),
('D003', 'P003', 'D003', 'Osteoarthritis', '2024-07-12', 'Recommended knee replacement surgery', 'S003');

-- 插入假数据到 PatientHistory 表
INSERT INTO PatientHistory (HistoryID, PatientID, EventType, EventDate, Details)
VALUES
('H001', 'P001', 'Admission', '2024-07-01', 'Admitted for appendectomy'),
('H002', 'P002', 'Admission', '2024-07-02', 'Admitted for tonsillectomy'),
('H003', 'P003', 'Admission', '2024-07-03', 'Admitted for knee consultation');

-- 插入假数据到 BillingAndInvoicing 表
INSERT INTO BillingAndInvoicing (InvoiceID, PatientID, ServiceDate, ServicesDescription, CostPerService, Quantity, TotalCosts)
VALUES
(1, 'P001', '2024-07-05', 'Appendectomy', 1500.00, 1, 1500.00),
(2, 'P002', '2024-07-06', 'Tonsillectomy', 1200.00, 1, 1200.00),
(3, 'P003', '2024-07-07', 'Consultation', 200.00, 1, 200.00);

-- 插入假数据到 PaymentProcessing 表
INSERT INTO PaymentProcessing (PaymentID, PaymentProcessingDate, PaymentMethod, PaymentAmount, PaymentStatus)
VALUES
(1, '2024-07-15', 'Credit Card', 1500.00, 'Paid'),
(2, '2024-07-16', 'Cash', 1200.00, 'Paid'),
(3, '2024-07-17', 'Insurance', 200.00, 'Paid');

-- 插入假数据到 TrackThePayment 表
INSERT INTO TrackThePayment (PaymentID, InvoiceID, PatientID, DateOfPayment, PaymentMethod, PaymentAmount, PaymentStatus, TransactionReference)
VALUES
(1, 1, 'P001', '2024-07-15', 'Credit Card', 1500.00, 'Paid', 'Transaction ID: 123456789'),
(2, 2, 'P002', '2024-07-16', 'Cash', 1200.00, 'Paid', 'Transaction ID: 987654321'),
(3, 3, 'P003', '2024-07-17', 'Insurance', 200.00, 'Paid', 'Claim ID: ABCDEF123');

-- 插入假数据到 StaffScheduling 表
INSERT INTO StaffScheduling (StaffID, StaffScheduleDate, ShiftStartTime, ShiftEndTime, Department, AssignedTasks, StaffAvailability)
VALUES
(1, '2024-07-01', '08:00:00', '16:00:00', 'Cardiology', 'Patient rounds and consultations', 'Available'),
(2, '2024-07-02', '09:00:00', '17:00:00', 'Pediatrics', 'Surgical assistance and patient care', 'Available'),
(3, '2024-07-03', '10:00:00', '18:00:00', 'Orthopedics', 'Orthopedic surgeries and consultations', 'Available');

-- 插入假数据到 InventoryManagement 表
INSERT INTO InventoryManagement (InventoryID, ItemCode, ItemName, InventoryStockQuantity, InventoryMaximumStock, InventoryMinimunStock, SupplierInformation, InventoryExpirydate)
VALUES
(1, 'ITEM001', 'Bandages', 500, 1000, 100, 'Supplier: Medical Supplies Inc.', '2025-01-01'),
(2, 'ITEM002', 'Antibiotics', 300, 800, 50, 'Supplier: Pharma Supplies Ltd.', '2024-12-31'),
(3, 'ITEM003', 'Surgical Instruments', 200, 500, 20, 'Supplier: SurgiTech Solutions', '2024-12-31');

-- 插入假数据到 MedicalSupplyManagement 表
INSERT INTO MedicalSupplyManagement (SupplyID, SupplyName, SupplyCode, SupplyStockQuantity, SupplyMinimunStock, SupplyMaximumStock, SupplierInformation, SupplyExpiryDate)
VALUES
(1, 'Oxygen Tanks', 'SUP001', 50, 10, 100, 'Supplier: Medical Supplies Inc.', '2025-01-01'),
(2, 'Ventilators', 'SUP002', 20, 5, 50, 'Supplier: Life Support Systems', '2024-12-31'),
(3, 'Wheelchairs', 'SUP003', 30, 10, 50, 'Supplier: Mobility Solutions Ltd.', '2024-12-31');

-- 插入假数据到 TransferManagement 表
INSERT INTO TransferManagement (TransferID, PatientID, TransferFrom, TransferTo, PatientTransferDate, PatientTransferTime, ReasonForTransfer, StatusOfTransfer)
VALUES
(1, 'P001', 'ER', 'Surgical Ward', '2024-07-01', '10:00:00', 'Emergency surgery required', 'Completed'),
(2, 'P002', 'Pediatrics Ward', 'Operating Room', '2024-07-02', '11:00:00', 'Scheduled surgery', 'Completed'),
(3, 'P003', 'Orthopedics Ward', 'Consultation Room', '2024-07-03', '12:00:00', 'Routine consultation', 'Completed');

-- 插入假数据到 Invoice 表
INSERT INTO Invoice (InvoiceNo, InvoiceDate, InvoiceDue, PatientID, PatientName, ServicesDescription, CostPerService, Quantity, TotalCosts, TotalPayment, AmountPaid, BalanceDue)
VALUES
(1, '2024-07-05', '2024-10-05', 'P001', 'John Doe', 'Appendectomy', 1500.00, 1, 1500.00, 1500.00, 1000.00, 500.00),
(2, '2024-07-06', '2024-10-06', 'P002', 'Jane Smith', 'Tonsillectomy', 1200.00, 1, 1200.00, 1200.00, 600.00, 600.00),
(3, '2024-07-07', '2024-10-07', 'P003', 'Mike Johnson', 'Consultation', 200.00, 1, 200.00, 200.00, 200.00, 0.00);

