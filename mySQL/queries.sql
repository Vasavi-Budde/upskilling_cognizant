-- Users table
CREATE TABLE Users(
user_id INT PRIMARY KEY,
full_name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
city VARCHAR(100) NOT NULL,
registration_date DATE NOT NULL);

INSERT INTO Users VALUES
(1,'vasavi','vasavi@gmail.com','LXPT','2024-12-01'),
(2,'Roshini','roshini@gamil.com','MNCL','2024-12-05'),
(3,'Raju','raju@gmail.com','KNR','2024-12-10'),
(4,'Rama','rama@gmail.com','JGTL','2025-01-15'),
(5,'Hanuman','ethan@gmail.com','HYD','2025-02-01');

SELECT * fROM users;

-- Evwnts table

CREATE TABLE Events (
    event_id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status VARCHAR(20),
    organizer_id INT
);

INSERT INTO Events VALUES
(1,'Java Workshop',
'Java Basics and OOP Concepts',
'LXPT',
'2025-06-10 10:00:00',
'2025-06-10 04:00:00',
'upcoming',
1),

(2,'AI & ML Seminar',
'Introduction to AI and Machine Learning',
'KNR',
'2025-05-15 09:00:00',
'2025-05-15 05:00:00',
'completed',
3),

(3,'Web Development Bootcamp',
'HTML CSS JavaScript Training',
'HYD',
'2025-07-01 10:00:00',
'2025-07-03 04:00:00',
'upcoming',
5),

(4,'Python Workshop',
'Python for Beginners',
'MNCL',
'2025-08-05 09:00:00',
'2025-08-05 05:00:00',
'upcoming',
2),

(5,'Cloud Computing Session',
'AWS and Cloud Basics',
'JGTL',
'2025-09-01 10:00:00',
'2025-09-01 04:00:00',
'cancelled',
4);

SELECT * FROM Events;

-- Sessions table

CREATE TABLE Sessions (
    session_id INT PRIMARY KEY,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL
);

INSERT INTO Sessions VALUES
(1,1,'Java Basics','vasavi',
'2025-06-10 10:00:00',
'2025-06-10 11:00:00'),

(2,1,'OOP Concepts','Roshini',
'2025-06-10 11:15:00',
'2025-06-10 12:30:00'),

(3,2,'Introduction to AI','Raju',
'2025-05-15 09:30:00',
'2025-05-15 11:00:00'),

(4,3,'HTML Basics','Hanuman',
'2025-07-01 10:00:00',
'2025-07-01 12:00:00'),

(5,4,'Python Fundamentals','Rama',
'2025-08-05 09:00:00',
'2025-08-05 11:00:00');

SELECT * FROM Sessions;

-- Registration table

CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL
);

INSERT INTO Registrations VALUES
(1,1,1,'2025-05-01'),
(2,2,1,'2025-05-02'),
(3,3,2,'2025-04-30'),
(4,4,4,'2025-07-20'),
(5,5,3,'2025-06-15');

SELECT * FROM Registrations;

-- Feedback table


CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY,
    user_id INT,
    event_id INT,
    rating INT,
    comments TEXT,
    feedback_date DATE NOT NULL
);

INSERT INTO Feedback VALUES
(1,3,2,4,'Great AI session!','2025-05-16'),
(2,2,1,3,'Good workshop.','2025-06-11'),
(3,5,3,5,'Excellent training.','2025-07-04'),
(4,1,1,4,'Very useful content.','2025-06-11'),
(5,4,4,2,'Need more examples.','2025-08-06');

SELECT * FROM Feedback;

-- Resources table

CREATE TABLE Resources (
    resource_id INT PRIMARY KEY,
    event_id INT,
    resource_type VARCHAR(20),
    resource_url VARCHAR(255),
    uploaded_at DATETIME
);

INSERT INTO Resources VALUES
(1,1,'pdf','java_notes.pdf','2025-05-01 10:00:00'),
(2,2,'image','ai_poster.jpg','2025-04-20 09:00:00'),
(3,3,'link','html_docs.com','2025-06-25 15:00:00'),
(4,4,'pdf','python_notes.pdf','2025-07-25 11:00:00');

SELECT * FROM Resources;

-- 1. User Upcoming Events


SELECT
    u.full_name,
    e.title,
    e.city,
    e.start_date
FROM Users u
JOIN Registrations r
ON u.user_id = r.user_id
JOIN Events e
ON r.event_id = e.event_id
WHERE e.status='upcoming'
AND u.city = e.city
ORDER BY e.start_date;


-- 2. Top Rated Events


SELECT
    e.title,
    AVG(f.rating) AS average_rating
FROM Events e
JOIN Feedback f
ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
ORDER BY average_rating DESC;

-- 3.Inactive Users

SELECT
    u.user_id,
    u.full_name,
    u.city
FROM Users u
LEFT JOIN Registrations r
ON u.user_id = r.user_id
AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
WHERE r.registration_id IS NULL;

-- Task 4: Peak Session Hours

SELECT
    event_id,
    COUNT(*) AS session_count
FROM Sessions
WHERE TIME(start_time) BETWEEN '10:00:00' AND '12:00:00'
GROUP BY event_id;

-- Task 5: Most Active Cities

SELECT
    u.city,
    COUNT(r.registration_id) AS total_registrations
FROM Users u
JOIN Registrations r
ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY total_registrations DESC
LIMIT 5;

-- Task 6: Event Resource Summary

SELECT
    e.title,
    COUNT(res.resource_id) AS total_resources
FROM Events e
LEFT JOIN Resources res
ON e.event_id = res.event_id
GROUP BY e.event_id, e.title;

-- Task 7: Low Feedback Alerts

SELECT
    u.full_name,
    e.title,
    f.rating,
    f.comments
FROM Feedback f
JOIN Users u
ON f.user_id = u.user_id
JOIN Events e
ON f.event_id = e.event_id
WHERE f.rating < 3;

-- Task 8: Sessions per Upcoming Event

SELECT
    e.title,
    COUNT(s.session_id) AS total_sessions
FROM Events e
LEFT JOIN Sessions s
ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title;

-- Task 9: Organizer Event Summary

SELECT
    u.full_name AS organizer_name,
    e.status,
    COUNT(e.event_id) AS total_events
FROM Users u
JOIN Events e
ON u.user_id = e.organizer_id
GROUP BY u.full_name, e.status;

-- Task 10: Feedback Gap

SELECT
    e.title
FROM Events e
JOIN Registrations r
ON e.event_id = r.event_id
LEFT JOIN Feedback f
ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.event_id, e.title;

-- Task 11: Daily New User Count

SELECT
    registration_date,
    COUNT(*) AS total_users
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date
ORDER BY registration_date;

-- Task 12: Event with Maximum Sessions

SELECT
    e.title,
    COUNT(s.session_id) AS total_sessions
FROM Events e
JOIN Sessions s
ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
ORDER BY total_sessions DESC
LIMIT 1;

-- Task 13: Average Rating per City

SELECT
    e.city,
    AVG(f.rating) AS average_rating
FROM Events e
JOIN Feedback f
ON e.event_id = f.event_id
GROUP BY e.city;

-- Task 14: Most Registered Events

SELECT
    e.title,
    COUNT(r.registration_id) AS total_registrations
FROM Events e
JOIN Registrations r
ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_registrations DESC
LIMIT 3;

-- Task 15: Event Session Time Conflict

SELECT
    s1.event_id,
    s1.title AS session1,
    s2.title AS session2
FROM Sessions s1
JOIN Sessions s2
ON s1.event_id = s2.event_id
AND s1.session_id < s2.session_id
AND s1.start_time < s2.end_time
AND s1.end_time > s2.start_time;

-- Task 16: Unregistered Active Users

SELECT
    u.user_id,
    u.full_name,
    u.registration_date
FROM Users u
LEFT JOIN Registrations r
ON u.user_id = r.user_id
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
AND r.registration_id IS NULL;

-- Task 17: Multi-Session Speakers

SELECT
    speaker_name,
    COUNT(session_id) AS total_sessions
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(session_id) > 1;

-- Task 18: Resource Availability Check

SELECT
    e.event_id,
    e.title
FROM Events e
LEFT JOIN Resources r
ON e.event_id = r.event_id
WHERE r.resource_id IS NULL;

-- Task 19: Completed Events with Feedback Summary

SELECT
    e.title,
    COUNT(DISTINCT r.registration_id) AS total_registrations,
    AVG(f.rating) AS average_rating
FROM Events e
LEFT JOIN Registrations r
ON e.event_id = r.event_id
LEFT JOIN Feedback f
ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title;

-- Task 20: User Engagement Index

SELECT
    u.user_id,
    u.full_name,
    COUNT(DISTINCT r.event_id) AS events_attended,
    COUNT(DISTINCT f.feedback_id) AS feedbacks_given
FROM Users u
LEFT JOIN Registrations r
ON u.user_id = r.user_id
LEFT JOIN Feedback f
ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name;

-- Task 21: Top Feedback Providers

SELECT
    u.full_name,
    COUNT(f.feedback_id) AS total_feedbacks
FROM Users u
JOIN Feedback f
ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY total_feedbacks DESC
LIMIT 5;

-- Task 22: Duplicate Registrations Check

SELECT
    user_id,
    event_id,
    COUNT(*) AS registration_count
FROM Registrations
GROUP BY user_id, event_id
HAVING COUNT(*) > 1;

-- Task 23: Registration Trends

SELECT
    YEAR(registration_date) AS year,
    MONTH(registration_date) AS month,
    COUNT(*) AS total_registrations
FROM Registrations
GROUP BY YEAR(registration_date),
         MONTH(registration_date)
ORDER BY year, month;

-- Task 24: Average Session Duration per Event

SELECT
    e.title,
    AVG(
        TIMESTAMPDIFF(
            MINUTE,
            s.start_time,
            s.end_time
        )
    ) AS avg_duration_minutes
FROM Events e
JOIN Sessions s
ON e.event_id = s.event_id
GROUP BY e.event_id, e.title;

-- Task 25: Events Without Sessions

SELECT
    e.event_id,
    e.title
FROM Events e
LEFT JOIN Sessions s
ON e.event_id = s.event_id
WHERE s.session_id IS NULL;
