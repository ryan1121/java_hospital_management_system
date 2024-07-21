-- 创建数据库
CREATE DATABASE hospital_management;
USE hospital_management;

-- 创建 Patients 表
CREATE TABLE Patients (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    patient_id VARCHAR(25) NOT NULL UNIQUE,
    patient_DOB DATE NOT NULL,
    patient_gender ENUM('Male', 'Female') NOT NULL,
    patient_phone VARCHAR(255),
    patient_name VARCHAR(255) NOT NULL,
    patient_password VARCHAR(255) NOT NULL,
    patient_email VARCHAR(255),
    patient_address VARCHAR(255),
    patient_address_line2 VARCHAR(255),
    patient_address_line3 VARCHAR(255),
    patient_emergency_name VARCHAR(255),
    patient_emergency_phone VARCHAR(20),
    patient_emergency_relationship VARCHAR(255),
    insuranceID VARCHAR(50),
    providerName VARCHAR(255),
    policyNumber VARCHAR(50),
    consult_date DATE,
    consult_time TIME,
    consult_record TEXT,
    patient_allergies TEXT
);

-- 创建 Doctors 表
CREATE TABLE Doctors (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id VARCHAR(25) NOT NULL UNIQUE,
    doctor_name VARCHAR(255) NOT NULL,
    doctor_password VARCHAR(255) NOT NULL,
    doctor_phone VARCHAR(20),
    doctor_email VARCHAR(255),
    doctor_specialization VARCHAR(255),
    doctor_department VARCHAR(255),
    doctor_status VARCHAR(50),
    doctor_experience TEXT,
    doctor_qualifications TEXT,
    doctor_license_information TEXT,
    workDate DATE,
    workTime TIME,
    workDetails TEXT
);

-- 创建 Nurse 表
CREATE TABLE Nurse(
    nurse_id VARCHAR(25) PRIMARY KEY,
    nurse_name VARCHAR(255),
    nurse_password VARCHAR(255) NOT NULL,
    nurse_email VARCHAR(255),
    nurse_phone VARCHAR(20),
    nurse_position VARCHAR(255),
    nurse_department VARCHAR(255),
    nurse_assign_wards VARCHAR(255),
    nurse_supervising_doctor VARCHAR(25),
    nurse_qualifications TEXT,
    nurse_experience TEXT,
    nurse_license_information TEXT,
    nurse_status VARCHAR(50),
    schedule_date DATE,
    schedule_time TIME,
    schedule_details TEXT,
    FOREIGN KEY (nurse_supervising_doctor) REFERENCES Doctors(doctor_id)
);

-- 创建 PatientCare 表
CREATE TABLE PatientCare(
    Primary_doctor_id VARCHAR(25),
    assigned_nurse_id VARCHAR(25),
    dietary_restrictions TEXT,
    patient_progress_note TEXT,
    discharge_date DATE,
    FOREIGN KEY (Primary_doctor_id) REFERENCES Doctors(doctor_id),
    FOREIGN KEY (assigned_nurse_id) REFERENCES Nurse(nurse_id)
);

-- 创建 Admission 表
CREATE TABLE Admission(
    Admission_ID VARCHAR(25) PRIMARY KEY,
    Admission_Date1 DATE,
    Admitting_Staff_ID VARCHAR(25),
    Admission_Status VARCHAR(50),
    Admission_Notes TEXT,
    Reason1 TEXT,
    admission_Patient_ID VARCHAR(25),
    Insurance_Details TEXT,
    medical_equipment_need TEXT,
    FOREIGN KEY (admission_Patient_ID) REFERENCES Patients(patient_id)
);

-- 创建 Appointment 表
CREATE TABLE Appointment(
    Appointment_ID VARCHAR(25) PRIMARY KEY,
    app_patient_id VARCHAR(25),
    app_doctor_id VARCHAR(25),
    app_date DATE,
    app_time TIME,
    appointment_notes TEXT,
    appointment_type VARCHAR(50),
    app_status VARCHAR(50),
    app_reason TEXT,
    app_location VARCHAR(255),
    Admitting_Staff_ID VARCHAR(25),
    booking_date DATE,
    app_cancel BOOLEAN,
    FOREIGN KEY (app_patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (app_doctor_id) REFERENCES Doctors(doctor_id),
    FOREIGN KEY (Admitting_Staff_ID) REFERENCES Nurse(nurse_id)
);

-- 创建 BedAllocation 表
CREATE TABLE BedAllocation(
    bed_allocate_number VARCHAR(25) PRIMARY KEY,
    room_allocate_number VARCHAR(25),
    ward_allocate_number VARCHAR(25),
    bed_allocation_department VARCHAR(255),
    bed_allocation_status VARCHAR(50),
    bed_type VARCHAR(50),
    bed_patient_id VARCHAR(25),
    allocate_date DATE,
    discharge_date DATE,
    pre_occ TEXT,
    emergency_equipment TEXT,
    FOREIGN KEY (bed_patient_id) REFERENCES Patients(patient_id)
);

-- 创建 Admin 表
CREATE TABLE Admin(
    admin_id VARCHAR(25) PRIMARY KEY,
    admin_name VARCHAR(255),
    admin_password VARCHAR(255) NOT NULL,
    admin_phone VARCHAR(20),
    admin_email VARCHAR(255)
);

-- 创建 Prescription 表
CREATE TABLE Prescription (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    PrescriptionID_textField VARCHAR(25) NOT NULL UNIQUE,
    PatientID VARCHAR(25) NOT NULL,
    DoctorID VARCHAR(25) NOT NULL,
    Medication_comboxBox VARCHAR(255) NOT NULL,
    dosage_Spinner VARCHAR(255) NOT NULL,
    PrescriptionDate_textField DATE NOT NULL,
    instructions TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(doctor_id)
);

-- 创建 MedicalRecords 表
CREATE TABLE MedicalRecords (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    medicalRecordID_textField VARCHAR(25) NOT NULL UNIQUE,
    PatientID VARCHAR(25) NOT NULL,
    DoctorID VARCHAR(25) NOT NULL,
    DateOfVisit_textField DATE NOT NULL,
    notes_textField8 TEXT,
    medical_record_treatmentPlans TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(doctor_id)
);

-- 创建 Surgeries 表
CREATE TABLE Surgeries (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    surgeryID_textField VARCHAR(25) NOT NULL UNIQUE,
    PatientID VARCHAR(25) NOT NULL,
    DoctorID VARCHAR(25) NOT NULL,
    surgeryType_comboBox VARCHAR(255) NOT NULL,
    DateOfSurgery_textField DATE NOT NULL,
    Outcomes_textField TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(doctor_id)
);

-- 创建 Consultations 表
CREATE TABLE Consultations (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ConsultationID_textField VARCHAR(25) NOT NULL UNIQUE,
    PatientID VARCHAR(25) NOT NULL,
    DoctorID VARCHAR(25) NOT NULL,
    DateOfConsultation_textField DATE NOT NULL,
    notes_textField TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(doctor_id)
);

-- 创建 Diagnoses 表
CREATE TABLE Diagnoses (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    diagonisisID_textField VARCHAR(25) NOT NULL UNIQUE,
    PatientID VARCHAR(25) NOT NULL,
    DoctorID VARCHAR(25) NOT NULL,
    diagonosisDescription_TextArea TEXT NOT NULL,
    DateOfDiagonosis_textField DATE NOT NULL,
    treatmentPlans_TextArea TEXT,
    surgeryID_textField VARCHAR(25),
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(doctor_id)
);

-- 创建 PatientHistory 表
CREATE TABLE PatientHistory (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    HistoryID VARCHAR(25) NOT NULL UNIQUE,
    PatientID VARCHAR(25) NOT NULL,
    EventType VARCHAR(255) NOT NULL,
    EventDate DATE NOT NULL,
    Details TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id)
);

-- 创建 BillingAndInvoicing 表
CREATE TABLE BillingAndInvoicing (
    InvoiceID INT PRIMARY KEY,
    PatientID VARCHAR(25),
    ServiceDate DATE,
    ServicesDescription VARCHAR(100),
    CostPerService DECIMAL(10, 2),
    Quantity INT,
    TotalCosts DECIMAL(10, 2),
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id)
);

-- 创建 PaymentProcessing 表
CREATE TABLE PaymentProcessing (
    PaymentID INT PRIMARY KEY,
    PaymentProcessingDate DATE,
    PaymentMethod VARCHAR(50),
    PaymentAmount DECIMAL(10, 2),
    PaymentStatus VARCHAR(50),
    InvoiceID INT,
    FOREIGN KEY (InvoiceID) REFERENCES BillingAndInvoicing(InvoiceID)
);

-- 创建 TrackThePayment 表
CREATE TABLE TrackThePayment (
    PaymentID INT PRIMARY KEY,
    InvoiceID INT,
    PatientID VARCHAR(25),
    DateOfPayment DATE,
    PaymentMethod VARCHAR(50),
    PaymentAmount DECIMAL(10, 2),
    PaymentStatus VARCHAR(50),
    TransactionsReference VARCHAR(255),
    FOREIGN KEY (PaymentID) REFERENCES PaymentProcessing(PaymentID),
    FOREIGN KEY (InvoiceID) REFERENCES BillingAndInvoicing(InvoiceID),
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id)
);

-- 创建 StaffScheduling 表
CREATE TABLE StaffScheduling (
    StaffID INT,
    StaffScheduleDate DATE,
    ShiftStartTime TIME,
    ShiftEndTime TIME,
    Department VARCHAR(100),
    AssignedTasks TEXT,
    StaffAvailability VARCHAR(50),
    PRIMARY KEY (StaffID, StaffScheduleDate)
);

-- 创建 InventoryManagement 表
CREATE TABLE InventoryManagement (
    InventoryID INT PRIMARY KEY,
    ItemCode VARCHAR(50),
    ItemName VARCHAR(100),
    InventoryStockQuantity INT,
    InventoryMaximumStock INT,
    InventoryMinimunStock INT,
    SupplierInformation TEXT,
    InventoryExpirydate DATE
);

-- 创建 MedicalSupplyManagement 表
CREATE TABLE MedicalSupplyManagement (
    SupplyID INT PRIMARY KEY,
    SupplyName VARCHAR(100),
    SupplyCode VARCHAR(50),
    SupplyStockQuantity INT,
    SupplyMinimunStock INT,
    SupplyMaximumStock INT,
    SupplierInformation TEXT,
    SupplyExpiryDate DATE
);

-- 创建 TransferManagement 表
CREATE TABLE TransferManagement (
    TransferID INT PRIMARY KEY,
    PatientID VARCHAR(25),
    TransferFrom VARCHAR(100),
    TransferTo VARCHAR(100),
    PatientTransferDate DATE,
    TransferTime DATETIME,
    ReasonForTransfer TEXT,
    StatusOfTransfer VARCHAR(50),
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id)
);

-- 创建 Invoice 表
CREATE TABLE Invoice (
    InvoiceNo INT PRIMARY KEY,
    InvoiceDate DATE,
    InvoiceDue DATE,
    PatientID VARCHAR(25),
    PatientName VARCHAR(255),
    ServicesDescription VARCHAR(100),
    CostPerService DECIMAL(10, 2),
    Quantity INT,
    TotalCosts DECIMAL(10, 2),
    TotalPayment DECIMAL(10, 2),
    AmountPaid DECIMAL(10, 2),
    BalanceDue DATE,
    FOREIGN KEY (PatientID) REFERENCES Patients(patient_id)
);
