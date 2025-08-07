-- Университеты
INSERT INTO academy.universities (name) VALUES ('Московский государственный университет');
INSERT INTO academy.universities (name) VALUES ('Санкт-Петербургский политехнический университет');
INSERT INTO academy.universities (name) VALUES ('Новосибирский государственный университет');
INSERT INTO academy.universities (name) VALUES ('Университет ИТ и робототехники');
INSERT INTO academy.universities (name) VALUES ('Московский физико-технический институт');
INSERT INTO academy.universities (name) VALUES ('Высшая школа экономики');
INSERT INTO academy.universities (name) VALUES ('Университет информационных технологий');

-- Курсы
INSERT INTO academy.courses (name, years_education) VALUES ('Программная инженерия', 4);
INSERT INTO academy.courses (name, years_education) VALUES ('Математика', 3);
INSERT INTO academy.courses (name, years_education) VALUES ('Экономика', 4);
INSERT INTO academy.courses (name, years_education) VALUES ('Физика', 3);
INSERT INTO academy.courses (name, years_education) VALUES ('Искусственный интеллект', 4);
INSERT INTO academy.courses (name, years_education) VALUES ('Кибербезопасность', 3);
INSERT INTO academy.courses (name, years_education) VALUES ('Бизнес-администрирование', 3);
INSERT INTO academy.courses (name, years_education) VALUES ('Теория игр', 2);

-- Студенты
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Иван', 'Иванов', 1);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Мария', 'Петрова', 1);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Алексей', 'Сидоров', 2);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Елена', 'Кузнецова', 3);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Дмитрий', 'Морозов', 2);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Ольга', 'Зайцева', 4);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Сергей', 'Николаев', 5);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Анастасия', 'Федорова', 6);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Павел', 'Крылов', 7);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Катя', 'Волкова', 4);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Михаил', 'Лебедев', 3);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Наталья', 'Смирнова', 6);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Владимир', 'Козлов', 5);
INSERT INTO academy.students (first_name, last_name, university_id) VALUES ('Ирина', 'Соколова', 7);

-- Связи студентов с курсами (многие ко многим)
-- Иван Иванов (университет 1)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (1, 1);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (1, 2);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (1, 5);

-- Мария Петрова (университет 1)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (2, 3);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (2, 7);

-- Алексей Сидоров (университет 2)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (3, 4);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (3, 2);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (3, 8);

-- Елена Кузнецова (университет 3)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (4, 1);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (4, 6);

-- Дмитрий Морозов (университет 2)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (5, 3);

-- Ольга Зайцева (университет 4)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (6, 6);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (6, 5);

-- Сергей Николаев (университет 5)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (7, 1);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (7, 4);

-- Анастасия Федорова (университет 6)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (8, 7);

-- Павел Крылов (университет 7)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (9, 2);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (9, 5);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (9, 6);

-- Катя Волкова (университет 4)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (10, 8);

-- Михаил Лебедев (университет 3)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (11, 1);
INSERT INTO academy.students_courses (student_id, course_id) VALUES (11, 2);

-- Наталья Смирнова (университет 6)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (12, 7);

-- Владимир Козлов (университет 5)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (13, 3);

-- Ирина Соколова (университет 7)
INSERT INTO academy.students_courses (student_id, course_id) VALUES (14, 4);
