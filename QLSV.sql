CREATE DATABASE FPL_DaoTao
USE FPL_DaoTao

CREATE TABLE users(
   username NVARCHAR(50) NOT NULL,
   pass_word NVARCHAR(50) NOT NULL,
   role_vt NVARCHAR(50) NOT NULL
)

CREATE TABLE students(
   masv NVARCHAR(50) NOT NULL,
   hoten NVARCHAR(50) NOT NULL,
   email NVARCHAR(50) NOT NULL,
   sodt NVARCHAR(50) NOT NULL,
   gioitinh bit NOT NULL,
   diaChi NVARCHAR(50) NOT NULL,
   hinh NVARCHAR(50) NOT NULL
)

CREATE TABLE grade(
   id INT IDENTITY,
   masv NVARCHAR(50) NOT NULL,
   tieng_anh FLOAT,
   tin_hoc FLOAT,
   gdtc FLOAT
)


ALTER TABLE users ADD CONSTRAINT PK_users PRIMARY KEY (username)
ALTER TABLE students ADD CONSTRAINT PK_students PRIMARY KEY (masv)
ALTER TABLE grade ADD CONSTRAINT PK_grade PRIMARY KEY (id)

ALTER TABLE grade ADD CONSTRAINT fk_grade FOREIGN KEY (masv) REFERENCES students(masv)

INSERT INTO users(username, pass_word, role_vt) VALUES 
('admin', '123456789', 'QLSV'),
('admin1', '123456789', 'QLDSV')

INSERT INTO students(masv, hoten, email, sodt, gioitinh, diaChi, hinh) VALUES 
('SV001', 'Nguyễn Sỹ Sơn', 'sonnssv001@gmail.com', '0123456789', 0, 'Nghệ An', 'boy.png'),
('SV002', 'Phan Thị Quỳnh Trang', 'trangptqsv002@gmail.com', '0123456789', 1, 'Hà Nội', 'girl.png'),
('SV003', 'Nguyễn Công Quỳnh', 'quynhncsv003@gmail.com', '0123456789', 0, 'Thái Bình', 'man (2).png'),
('SV004', 'Nguyễn Hà Thanh', 'thanhnhsv004@gmail.com', '0123456789', 1, 'Nghệ An', 'girl (3).png'),
('SV005', 'Nguyễn Sỹ Tiến', 'tiennssv001@gmail.com', '0123456789', 0, 'Nghệ An', 'boy.png')

INSERT INTO grade(masv, tieng_anh, tin_hoc, gdtc) VALUES 
('SV001', 9.9, 10, 9),
('SV002', 9, 8, 7),
('SV003', 8, 8, 8),
('SV004', 6, 7, 5)

select * FROM students
select * from grade
