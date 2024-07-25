USE hospital_management;

-- 插入 Patients 表的三条数据
INSERT INTO Patients (patient_id, patient_DOB, patient_gender, patient_phone, patient_name, patient_password, patient_email, patient_address, patient_address_line2, patient_address_line3, patient_emergency_name, patient_emergency_phone, patient_emergency_relationship, insuranceID, providerName, policyNumber, consult_date, consult_time, consult_record, patient_allergies)
VALUES 
('P001', '1985-05-15', 'Male', '1234567890', 'John Doe', 'password123', 'john.doe@example.com', '123 Main St', 'Apt 101', 'City', 'Jane Doe', '0987654321', 'Spouse', 'INS001', 'Provider A', 'POL001', '2024-01-01', '10:00:00', 'Consultation notes', 'None'),
('P002', '1990-10-20', 'Female', '2345678901', 'Jane Smith', 'password456', 'jane.smith@example.com', '456 Elm St', 'Apt 202', 'Town', 'John Smith', '1098765432', 'Parent', 'INS002', 'Provider B', 'POL002', '2024-02-01', '11:00:00', 'Consultation notes', 'Peanuts'),
('P003', '1978-03-10', 'Male', '3456789012', 'Robert Brown', 'password789', 'robert.brown@example.com', '789 Oak St', 'Apt 303', 'Village', 'Rebecca Brown', '2109876543', 'Sibling', 'INS003', 'Provider C', 'POL003', '2024-03-01', '12:00:00', 'Consultation notes', 'Latex');

-- 插入 Doctors 表的三条数据
INSERT INTO Doctors (doctor_id, doctor_name, doctor_password, doctor_phone, doctor_email, doctor_specialization, doctor_department, doctor_status, doctor_experience, doctor_qualifications, workDate, workTime, workDetails)
VALUES 
('D001', 'Dr. Alice Johnson', 'docpass123', '1231231234', 'alice.johnson@example.com', 'Cardiology', 'Cardiology Dept', 'Active', '10 years of experience', 'MD, PhD', '2024-01-01', '09:00:00', 'Details about work'),
('D002', 'Dr. Bob Smith', 'docpass456', '2342342345', 'bob.smith@example.com', 'Neurology', 'Neurology Dept', 'Active', '8 years of experience', 'MD', '2024-02-01', '10:00:00', 'Details about work'),
('D003', 'Dr. Carol Davis', 'docpass789', '3453453456', 'carol.davis@example.com', 'Orthopedics', 'Orthopedics Dept', 'Active', '12 years of experience', 'MD, MSc', '2024-03-01', '11:00:00', 'Details about work');

-- 插入 Nurse 表的三条数据
INSERT INTO Nurse (nurse_id, nurse_name, nurse_password, nurse_email, nurse_phone, nurse_position, nurse_department, nurse_assign_wards, nurse_supervising_doctor, nurse_qualifications, nurse_experience, nurse_status, schedule_date, schedule_time, schedule_details)
VALUES 
('N001', 'Nurse Emma Wilson', 'nursepass123', 'emma.wilson@example.com', '1231231235', 'Senior Nurse', 'Cardiology Dept', 'Ward 1', 'D001', 'RN, BSN', '5 years of experience', 'Active', '2024-01-02', '08:00:00', 'Details about schedule'),
('N002', 'Nurse Liam Johnson', 'nursepass456', 'liam.johnson@example.com', '2342342346', 'Junior Nurse', 'Neurology Dept', 'Ward 2', 'D002', 'RN', '3 years of experience', 'Active', '2024-02-02', '09:00:00', 'Details about schedule'),
('N003', 'Nurse Olivia Brown', 'nursepass789', 'olivia.brown@example.com', '3453453457', 'Head Nurse', 'Orthopedics Dept', 'Ward 3', 'D003', 'RN, MSN', '7 years of experience', 'Active', '2024-03-02', '10:00:00', 'Details about schedule');

-- 插入 PatientCare 表的三条数据
INSERT INTO PatientCare (Primary_doctor_id, assigned_nurse_id, dietary_restrictions, patient_progress_note, discharge_date)
VALUES 
('D001', 'N001', 'No dairy', 'Patient is recovering well', '2024-04-01'),
('D002', 'N002', 'No gluten', 'Patient shows improvement', '2024-05-01'),
('D003', 'N003', 'Low sugar', 'Patient is stable', '2024-06-01');

-- 插入 Admission 表的三条数据
INSERT INTO Admission (Admission_ID, Admission_Date1, Admitting_Staff_ID, Admission_Status, Admission_Notes, Reason1, admission_Patient_ID, Insurance_Details, medical_equipment_need)
VALUES 
('A001', '2024-01-05', 'N001', 'Admitted', 'Patient admitted for surgery', 'Appendicitis', 'P001', 'Insurance details A', 'Need for ventilator'),
('A002', '2024-02-10', 'N002', 'Admitted', 'Patient admitted for observation', 'Severe headache', 'P002', 'Insurance details B', 'Need for ECG'),
('A003', '2024-03-15', 'N003', 'Admitted', 'Patient admitted for treatment', 'Fractured leg', 'P003', 'Insurance details C', 'Need for crutches');

-- 插入 Appointment 表的三条数据
INSERT INTO Appointment (Appointment_ID, app_patient_id, app_doctor_id, app_date, app_time, appointment_notes, appointment_type, app_status, app_reason, app_location, Admitting_Staff_ID, booking_date, app_cancel)
VALUES 
('AP001', 'P001', 'D001', '2024-01-10', '09:30:00', 'Routine check-up', 'Check-up', 'Scheduled', 'Regular check-up', 'Room 101', 'N001', '2024-01-01', FALSE),
('AP002', 'P002', 'D002', '2024-02-15', '10:30:00', 'Follow-up visit', 'Follow-up', 'Scheduled', 'Post-surgery follow-up', 'Room 202', 'N002', '2024-02-01', FALSE),
('AP003', 'P003', 'D003', '2024-03-20', '11:30:00', 'Consultation', 'Consultation', 'Scheduled', 'Consultation for treatment', 'Room 303', 'N003', '2024-03-01', FALSE);

-- 插入 BedAllocation 表的三条数据
INSERT INTO BedAllocation (bed_allocate_number, room_allocate_number, ward_allocate_number, bed_allocation_department, bed_allocation_status, bed_type, bed_patient_id, allocate_date, discharge_date, pre_occ, emergency_equipment)
VALUES 
('B001', 'R001', 'W001', 'Cardiology Dept', 'Occupied', 'Single', 'P001', '2024-01-05', '2024-01-15', 'Pre-occ A', 'Ventilator'),
('B002', 'R002', 'W002', 'Neurology Dept', 'Occupied', 'Double', 'P002', '2024-02-10', '2024-02-20', 'Pre-occ B', 'ECG'),
('B003', 'R003', 'W003', 'Orthopedics Dept', 'Occupied', 'Single', 'P003', '2024-03-15', '2024-03-25', 'Pre-occ C', 'Crutches');

-- 插入 Admin 表的三条数据
INSERT INTO Admin (admin_id, admin_name, admin_password, admin_phone, admin_email)
VALUES 
('AD001', 'Admin John', 'adminpass123', '1231231238', 'admin.john@example.com'),
('AD002', 'Admin Alice', 'adminpass456', '2342342349', 'admin.alice@example.com'),
('AD003', 'Admin Bob', 'adminpass789', '3453453450', 'admin.bob@example.com');

-- 插入 Prescription 表的三条数据
INSERT INTO Prescription (PrescriptionID, PatientID, DoctorID, Medication_comboxBox, dosage_Spinner, PrescriptionDate, instructions)
VALUES 
('PR001', 'P001', 'D001', 'Med A', 'Dosage A', '2024-01-10', 'Take once daily'),
('PR002', 'P002', 'D002', 'Med B', 'Dosage B', '2024-02-15', 'Take twice daily'),
('PR003', 'P003', 'D003', 'Med C', 'Dosage C', '2024-03-20', 'Take thrice daily');

-- 插入 MedicalRecords 表的三条数据
INSERT INTO MedicalRecords (medicalRecordID, PatientID, DoctorID, DateOfVisit, notes, treatmentPlans)
VALUES 
('MR001', 'P001', 'D001', '2024-01-10', 'Notes for patient P001', 'Treatment plan A'),
('MR002', 'P002', 'D002', '2024-02-15', 'Notes for patient P002', 'Treatment plan B'),
('MR003', 'P003', 'D003', '2024-03-20', 'Notes for patient P003', 'Treatment plan C');

-- 插入 Surgery 表的三条数据
INSERT INTO Surgery (surgeryID, PatientID, DoctorID, surgeryType, DateOfSurgery, Outcomes)
VALUES 
('S001', 'P001', 'D001', 'Appendectomy', '2024-01-12', 'Successful'),
('S002', 'P002', 'D002', 'Craniotomy', '2024-02-17', 'Successful'),
('S003', 'P003', 'D003', 'Knee Replacement', '2024-03-22', 'Successful');

-- 插入 Consultations 表的三条数据
INSERT INTO Consultations (ConsultationID, PatientID, DoctorID, DateOfConsultation, notes)
VALUES 
('C001', 'P001', 'D001', '2024-01-10', 'Consultation notes for P001'),
('C002', 'P002', 'D002', '2024-02-15', 'Consultation notes for P002'),
('C003', 'P003', 'D003', '2024-03-20', 'Consultation notes for P003');

-- 插入 Diagnosis 表的三条数据
INSERT INTO Diagnosis (DiagnosisID, PatientID, DoctorID, DiagnosisDescription, DateOfDiagnosis, treatmentPlans)
VALUES 
('DI001', 'P001', 'D001', 'Appendicitis', '2024-01-10', 'Surgery required'),
('DI002', 'P002', 'D002', 'Migraine', '2024-02-15', 'Medication prescribed'),
('DI003', 'P003', 'D003', 'Arthritis', '2024-03-20', 'Physical therapy recommended');

-- 插入 PatientHistory 表的三条数据
INSERT INTO PatientHistory (HistoryID, PatientID, EventType, EventDate, Details)
VALUES 
('H001', 'P001', 'Surgery', '2024-01-12', 'Appendectomy performed'),
('H002', 'P002', 'Treatment', '2024-02-17', 'Migraine treatment initiated'),
('H003', 'P003', 'Consultation', '2024-03-22', 'Consultation for knee pain');

-- 插入 Invoice 表的三条数据
INSERT INTO Invoice (InvoiceID, InvoiceDate, InvoiceDue, PatientID, TotalPayment, AmountPaid, BalanceDue)
VALUES 
('INV001', '2024-01-15', DATE_ADD('2024-01-15', INTERVAL 3 MONTH), 'P001', 1500.00, 500.00, 1000.00),
('INV002', '2024-02-20', DATE_ADD('2024-02-20', INTERVAL 3 MONTH), 'P002', 2000.00, 1000.00, 1000.00),
('INV003', '2024-03-25', DATE_ADD('2024-03-25', INTERVAL 3 MONTH), 'P003', 2500.00, 1500.00, 1000.00);

-- 插入 Billing 表的三条数据
INSERT INTO Billing (InvoiceID, ServicesDescription, CostPerService, Quantity, TotalPayment)
VALUES 
('INV001', 'Appendectomy', 500.00, 3, 1500.00),
('INV002', 'Migraine treatment', 1000.00, 2, 2000.00),
('INV003', 'Knee Replacement', 1250.00, 2, 2500.00);
USE hospital_management;

-- 插入 DoctorStaffScheduling 表的三条数据
INSERT INTO DoctorStaffScheduling (DoctorID, StaffScheduleDate, ShiftStartTime, ShiftEndTime, Department, AssignedTasks)
VALUES 
('D001', '2024-01-05', '08:00:00', '16:00:00', 'Cardiology Dept', 'Routine check-ups'),
('D002', '2024-01-06', '09:00:00', '17:00:00', 'Neurology Dept', 'Patient consultations'),
('D003', '2024-01-07', '10:00:00', '18:00:00', 'Orthopedics Dept', 'Surgery preparations');

-- 插入 NurseStaffScheduling 表的三条数据
INSERT INTO NurseStaffScheduling (NurseID, StaffScheduleDate, ShiftStartTime, ShiftEndTime, Department, AssignedTasks)
VALUES 
('N001', '2024-01-06', '09:00:00', '17:00:00', 'Cardiology Dept', 'Ward rounds'),
('N002', '2024-01-07', '08:00:00', '16:00:00', 'Neurology Dept', 'Patient monitoring'),
('N003', '2024-01-08', '07:00:00', '15:00:00', 'Orthopedics Dept', 'Surgery assistance');

-- 插入 InventoryManagement 表的三条数据
INSERT INTO InventoryManagement (InventoryID, ItemCode, ItemName, InventoryStockQuantity, InventoryMaximumStock, InventoryMinimunStock, SupplierInformation, InventoryExpirydate)
VALUES 
('I001', 'ITM001', 'Bandages', 100, 500, 50, 'Supplier A', '2025-01-01'),
('I002', 'ITM002', 'Syringes', 200, 1000, 100, 'Supplier B', '2025-02-01'),
('I003', 'ITM003', 'Gloves', 300, 1500, 150, 'Supplier C', '2025-03-01');

-- 插入 MedicalSupplyManagement 表的三条数据
INSERT INTO MedicalSupplyManagement (SupplyID, SupplyName, SupplyCode, SupplyStockQuantity, SupplyMinimunStock, SupplyMaximumStock, SupplierInformation, SupplyExpiryDate)
VALUES 
('S001', 'IV Drips', 'SPLY001', 50, 300, 30, 'Supplier X', '2024-12-01'),
('S002', 'Masks', 'SPLY002', 100, 600, 60, 'Supplier Y', '2024-11-01'),
('S003', 'Sanitizers', 'SPLY003', 200, 900, 90, 'Supplier Z', '2024-10-01');

-- 插入 TransferManagement 表的三条数据
INSERT INTO TransferManagement (TransferID, PatientID, TransferFrom, TransferTo, PatientTransferDate, TransferTime, ReasonForTransfer, StatusOfTransfer)
VALUES 
('T001', 'P001', 'Room 101', 'Room 201', '2024-01-20', '14:00:00', 'Need for specialized care', 'Completed'),
('T002', 'P002', 'Room 202', 'Room 302', '2024-02-25', '15:00:00', 'Closer monitoring required', 'Completed'),
('T003', 'P003', 'Room 303', 'Room 403', '2024-03-30', '16:00:00', 'Post-surgery recovery', 'Completed');

-- 插入 Payment 表的三条数据
INSERT INTO Payment (PaymentID, PaymentDate, PaymentMethod, PaymentAmount, PaymentStatus, InvoiceID)
VALUES 
('PAY001', '2024-01-15', 'Credit Card', 500.00, 'Completed', 'INV001'),
('PAY002', '2024-02-20', 'Cash', 1000.00, 'Completed', 'INV002'),
('PAY003', '2024-03-25', 'Insurance', 1500.00, 'Completed', 'INV003');
