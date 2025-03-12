-- User Tablosu
CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    user_address VARCHAR(150),
    user_password VARCHAR(100) NOT NULL,
    age INT,
    health_status VARCHAR(50),
    service_id INT
);

-- Doctor Tablosu
CREATE TABLE Doctor (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_name VARCHAR(50) NOT NULL,
    doctor_role VARCHAR(50) NOT NULL,
    doctor_password VARCHAR(100) NOT NULL,
    contact_info VARCHAR(100),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

-- Health Service Tablosu
CREATE TABLE HealthService (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(50) NOT NULL,
    service_type VARCHAR(25) NOT NULL,
    service_availability VARCHAR(10) NOT NULL,
    doctor_id INT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

-- Game Tablosu
CREATE TABLE Game (
    game_id INT AUTO_INCREMENT PRIMARY KEY,
    game_type VARCHAR(25),
    game_name VARCHAR(50),
    gamediff_level INT
);

-- Exercise Advise Tablosu
CREATE TABLE ExerciseAdvise (
    advice_id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(100),
    advisediff_level INT,
    frequency VARCHAR(25)
);

-- Chat Room Tablosu
CREATE TABLE ChatRoom (
    chatroom_id INT AUTO_INCREMENT PRIMARY KEY,
    chatroom_name VARCHAR(50),
    topic_name VARCHAR(25),
    isActive VARCHAR(25),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

INSERT INTO User (user_name, user_email, user_address, user_password, age, health_status, service_id)
VALUES ('Jane Smith', 'jane.smith@example.com', '456 Elm St', 'userpass', 28, 'Healthy', 1);


