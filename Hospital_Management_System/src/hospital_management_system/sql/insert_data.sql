-- 插入 Patients 表的数据
INSERT INTO Patients (patient_id, patient_DOB, patient_gender, patient_phone, patient_name, patient_password, patient_email, patient_address, patient_address_line2, patient_address_line3, patient_emergency_name, patient_emergency_phone, patient_emergency_relationship, insuranceID, providerName, policyNumber, consult_date, consult_time, consult_record, patient_allergies)
VALUES 
('P001', '1990-01-01', 'Male', '1234567890', 'John Doe', 'password123', 'john.doe@example.com', '123 Main St', 'Apt 1', 'Floor 2', 'Jane Doe', '0987654321', 'Wife', 'INS123', 'Provider A', 'POL123', '2024-07-21', '10:00:00', 'Consultation record 1', 'None'),
('P002', '1985-05-05', 'Female', '2345678901', 'Mary Smith', 'password456', 'mary.smith@example.com', '456 Elm St', '', '', 'Paul Smith', '1122334455', 'Brother', 'INS456', 'Provider B', 'POL456', '2024-07-20', '11:00:00', 'Consultation record 2', 'Penicillin'),
('P003', '1995-09-09', 'Male', '3456789012', 'James Brown', 'password789', 'james.brown@example.com', '789 Oak St', 'Suite 3', '', 'Linda Brown', '6677889900', 'Mother', 'INS789', 'Provider C', 'POL789', '2024-07-19', '09:00:00', 'Consultation record 3', 'Peanuts');

-- 插入 Doctors 表的数据
INSERT INTO Doctors (doctor_id, doctor_name, doctor_password, doctor_phone, doctor_email, doctor_specialization, doctor_department, doctor_status, doctor_experience, doctor_qualifications, workDate, workTime, workDetails)
VALUES 
('D001', 'Dr. Alice Johnson', 'docpassword1', '4567890123', 'alice.johnson@example.com', 'Cardiology', 'Cardiology Dept', 'Active', '10 years', 'MD, Cardiology', '2024-07-21', '08:00:00', 'Morning shift'),
('D002', 'Dr. Bob Williams', 'docpassword2', '5678901234', 'bob.williams@example.com', 'Neurology', 'Neurology Dept', 'Active', '8 years', 'MD, Neurology', '2024-07-20', '10:00:00', 'Afternoon shift'),
('D003', 'Dr. Carol Taylor', 'docpassword3', '6789012345', 'carol.taylor@example.com', 'Pediatrics', 'Pediatrics Dept', 'Active', '5 years', 'MD, Pediatrics', '2024-07-19', '12:00:00', 'Evening shift');

-- 插入 Nurse 表的数据
INSERT INTO Nurse (nurse_id, nurse_name, nurse_password, nurse_email, nurse_phone, nurse_position, nurse_department, nurse_assign_wards, nurse_supervising_doctor, nurse_qualifications, nurse_experience, nurse_status, schedule_date, schedule_time, schedule_details)
VALUES 
('N001', 'Nancy White', 'nursepass1', 'nancy.white@example.com', '7890123456', 'Head Nurse', 'General Ward', 'Ward A', 'D001', 'RN, BSN', '15 years', 'Active', '2024-07-21', '07:00:00', 'Morning shift in Ward A'),
('N002', 'Oliver Black', 'nursepass2', 'oliver.black@example.com', '8901234567', 'Staff Nurse', 'Emergency Dept', 'Ward B', 'D002', 'RN', '10 years', 'Active', '2024-07-20', '09:00:00', 'Afternoon shift in Ward B'),
('N003', 'Sophia Green', 'nursepass3', 'sophia.green@example.com', '9012345678', 'Junior Nurse', 'Pediatrics Dept', 'Ward C', 'D003', 'RN', '3 years', 'Active', '2024-07-19', '11:00:00', 'Evening shift in Ward C');

-- 插入 PatientCare 表的数据
INSERT INTO PatientCare (Primary_doctor_id, assigned_nurse_id, dietary_restrictions, patient_progress_note, discharge_date)
VALUES 
('D001', 'N001', 'Gluten-free', 'Patient recovering well', '2024-07-22'),
('D002', 'N002', 'Low-sodium', 'Patient needs more rest', '2024-07-23'),
('D003', 'N003', 'Diabetic', 'Patient showing improvement', '2024-07-24');

-- 插入 Admission 表的数据
INSERT INTO Admission (Admission_ID, Admission_Date1, Admitting_Staff_ID, Admission_Status, Admission_Notes, Reason1, admission_Patient_ID, Insurance_Details, medical_equipment_need)
VALUES 
('A001', '2024-07-18', 'N001', 'Admitted', 'Patient admitted for observation', 'Chest pain', 'P001', 'Insurance details for P001', 'Oxygen mask'),
('A002', '2024-07-17', 'N002', 'Admitted', 'Patient admitted for surgery', 'Appendicitis', 'P002', 'Insurance details for P002', 'Surgical instruments'),
('A003', '2024-07-16', 'N003', 'Admitted', 'Patient admitted for treatment', 'Asthma', 'P003', 'Insurance details for P003', 'Nebulizer');

-- 插入 Appointment 表的数据
INSERT INTO Appointment (Appointment_ID, app_patient_id, app_doctor_id, app_date, app_time, appointment_notes, appointment_type, app_status, app_reason, app_location, Admitting_Staff_ID, booking_date, app_cancel)
VALUES 
('AP001', 'P001', 'D001', '2024-07-25', '14:00:00', 'Regular checkup', 'Consultation', 'Scheduled', 'Routine checkup', 'Room 101', 'N001', '2024-07-20', FALSE),
('AP002', 'P002', 'D002', '2024-07-26', '15:00:00', 'Follow-up visit', 'Consultation', 'Scheduled', 'Post-surgery follow-up', 'Room 202', 'N002', '2024-07-21', FALSE),
('AP003', 'P003', 'D003', '2024-07-27', '16:00:00', 'Initial consultation', 'Consultation', 'Scheduled', 'New symptoms', 'Room 303', 'N003', '2024-07-22', FALSE);

-- 插入 BedAllocation 表的数据
INSERT INTO BedAllocation (bed_allocate_number, room_allocate_number, ward_allocate_number, bed_allocation_department, bed_allocation_status, bed_type, bed_patient_id, allocate_date, discharge_date, pre_occ, emergency_equipment)
VALUES 
('B001', 'R001', 'W001', 'General Ward', 'Occupied', 'Single', 'P001', '2024-07-18', '2024-07-22', 'Clean', 'None'),
('B002', 'R002', 'W002', 'Surgical Ward', 'Occupied', 'Double', 'P002', '2024-07-17', '2024-07-23', 'Clean', 'None'),
('B003', 'R003', 'W003', 'Pediatrics Ward', 'Occupied', 'Single', 'P003', '2024-07-16', '2024-07-24', 'Clean', 'None');

-- 插入 Admin 表的数据
INSERT INTO Admin (admin_id, admin_name, admin_password, admin_phone, admin_email)
VALUES 
('AD001', 'Admin One', 'adminpass1', '0123456789', 'admin.one@example.com'),
('AD002', 'Admin Two', 'adminpass2', '1234567890', 'admin.two@example.com'),
('AD003', 'Admin Three', 'adminpass3', '2345678901', 'admin.three@example.com');

-- 插入 Prescription 表的数据
INSERT INTO Prescription (PrescriptionID_textField, PatientID, DoctorID, Medication_comboxBox, dosage_Spinner, PrescriptionDate_textField, instructions)
VALUES 
('PR001', 'P001', 'D001', 'Medication A', 'Once daily', '2024-07-21', 'Take after meals'),
('PR002', 'P002', 'D002', 'Medication B', 'Twice daily', '2024-07-20', 'Take with water'),
('PR003', 'P003', 'D003', 'Medication C', 'Once weekly', '2024-07-19', 'Take before bed');

-- 插入 MedicalRecords 表的数据
INSERT INTO MedicalRecords (medicalRecordID_textField, PatientID, DoctorID, DateOfVisit_textField, notes_textField8, medical_record_treatmentPlans)
VALUES 
('MR001', 'P001', 'D001', '2024-07-21', 'Patient stable', 'Continue current medication'),
('MR002', 'P002', 'D002', '2024-07-20', 'Patient improving', 'Reduce dosage of medication'),
('MR003', 'P003', 'D003', '2024-07-19', 'Patient needs further tests', 'Schedule follow-up');

-- 插入 Surgeries 表的数据
INSERT INTO Surgeries (surgeryID_textField, PatientID, DoctorID, surgeryType_comboBox, DateOfSurgery_textField, Outcomes_textField)
VALUES 
('S001', 'P001', 'D001', 'Appendectomy', '2024-07-22', 'Successful'),
('S002', 'P002', 'D002', 'Cholecystectomy', '2024-07-21', 'Successful'),
('S003', 'P003', 'D003', 'Hernia Repair', '2024-07-20', 'Complications, needs follow-up');

-- 插入 Consultations 表的数据
INSERT INTO Consultations (ConsultationID_textField, PatientID, DoctorID, DateOfConsultation_textField, notes_textField)
VALUES 
('C001', 'P001', 'D001', '2024-07-21', 'Routine checkup, patient stable'),
('C002', 'P002', 'D002', '2024-07-20', 'Follow-up, patient improving'),
('C003', 'P003', 'D003', '2024-07-19', 'Initial consultation, further tests needed');

-- 插入 Diagnosis 表的数据
INSERT INTO Diagnosis (DiagnosisID_textField, PatientID, DoctorID, DiagnosisDescription_TextArea, DateOfDiagnosis_textField, treatmentPlans_TextArea, surgeryID_textField)
VALUES 
('DI001', 'P001', 'D001', 'Diagnosed with hypertension', '2024-07-21', 'Medication and lifestyle changes', 'S001'),
('DI002', 'P002', 'D002', 'Diagnosed with diabetes', '2024-07-20', 'Insulin and diet management', 'S002'),
('DI003', 'P003', 'D003', 'Diagnosed with asthma', '2024-07-19', 'Inhaler and avoid triggers', 'S003');

-- 插入 PatientHistory 表的数据
INSERT INTO PatientHistory (HistoryID, PatientID, EventType, EventDate, Details)
VALUES 
('H001', 'P001', 'Admission', '2024-07-18', 'Admitted for chest pain'),
('H002', 'P002', 'Surgery', '2024-07-17', 'Underwent appendectomy'),
('H003', 'P003', 'Consultation', '2024-07-16', 'Initial consultation for asthma symptoms');

-- 插入 Invoice 表的数据
INSERT INTO Invoice (InvoiceID, InvoiceDate, InvoiceDue, PatientID, TotalPayment, AmountPaid, BalanceDue)
VALUES 
('INV001', '2024-07-21', '2024-10-21', 'P001', 1000.00, 500.00, 500.00),
('INV002', '2024-07-20', '2024-10-20', 'P002', 1500.00, 750.00, 750.00),
('INV003', '2024-07-19', '2024-10-19', 'P003', 2000.00, 1000.00, 1000.00);

-- 插入 Billing 表的数据
INSERT INTO Billing (InvoiceID, ServicesDescription, CostPerService, Quantity, TotalPayment)
VALUES 
('INV001', 'Consultation', 100.00, 5, 500.00),
('INV002', 'Surgery', 300.00, 5, 1500.00),
('INV003', 'Medication', 50.00, 20, 1000.00);

-- 插入 StaffScheduling 表的数据
INSERT INTO StaffScheduling (StaffID, StaffScheduleDate, ShiftStartTime, ShiftEndTime, Department, AssignedTasks)
VALUES 
('S001', '2024-07-21', '08:00:00', '16:00:00', 'Cardiology', 'Morning rounds'),
('S002', '2024-07-20', '10:00:00', '18:00:00', 'Neurology', 'Afternoon rounds'),
('S003', '2024-07-19', '12:00:00', '20:00:00', 'Pediatrics', 'Evening rounds');

-- 插入 InventoryManagement 表的数据
INSERT INTO InventoryManagement (InventoryID, ItemCode, ItemName, InventoryStockQuantity, InventoryMaximumStock, InventoryMinimunStock, SupplierInformation, InventoryExpirydate)
VALUES 
('INV001', 'IC001', 'Bandages', 100, 500, 50, 'Supplier A', '2025-07-21'),
('INV002', 'IC002', 'Syringes', 200, 1000, 100, 'Supplier B', '2025-07-20'),
('INV003', 'IC003', 'Gloves', 300, 1500, 150, 'Supplier C', '2025-07-19');

-- 插入 MedicalSupplyManagement 表的数据
INSERT INTO MedicalSupplyManagement (SupplyID, SupplyName, SupplyCode, SupplyStockQuantity, SupplyMinimunStock, SupplyMaximumStock, SupplierInformation, SupplyExpiryDate)
VALUES 
('MS001', 'Stethoscopes', 'SC001', 50, 10, 200, 'Supplier D', '2025-07-21'),
('MS002', 'Thermometers', 'TC002', 75, 15, 300, 'Supplier E', '2025-07-20'),
('MS003', 'Scalpels', 'SC003', 25, 5, 100, 'Supplier F', '2025-07-19');

-- 插入 TransferManagement 表的数据
INSERT INTO TransferManagement (TransferID, PatientID, TransferFrom, TransferTo, PatientTransferDate, TransferTime, ReasonForTransfer, StatusOfTransfer)
VALUES 
('TR001', 'P001', 'General Ward', 'ICU', '2024-07-21', '14:00:00', 'Critical condition', 'Completed'),
('TR002', 'P002', 'Surgical Ward', 'Recovery Room', '2024-07-20', '15:00:00', 'Post-surgery recovery', 'Completed'),
('TR003', 'P003', 'Pediatrics Ward', 'General Ward', '2024-07-19', '16:00:00', 'Improvement in condition', 'Completed');

-- 插入 Payment 表的数据
INSERT INTO Payment (PaymentID, PaymentDate, PaymentMethod, PaymentAmount, PaymentStatus, InvoiceID)
VALUES 
('PAY001', '2024-07-21', 'Credit Card', 500.00, 'Paid', 'INV001'),
('PAY002', '2024-07-20', 'Debit Card', 750.00, 'Paid', 'INV002'),
('PAY003', '2024-07-19', 'Cash', 1000.00, 'Paid', 'INV003');
