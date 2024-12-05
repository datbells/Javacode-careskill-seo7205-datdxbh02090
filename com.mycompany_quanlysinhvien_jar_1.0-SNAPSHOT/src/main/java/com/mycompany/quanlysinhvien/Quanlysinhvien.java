package com.mycompany.quanlysinhvien;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String fullName;
    private String studentId;
    private float grade;
    private String className;

    // Constructor
    public Student(String fullName, String studentId, float grade, String className) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.grade = grade;
        this.className = className;
    }

    // Getter và Setter
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Ma sv: " + studentId + ", Ten: " + fullName + ", Lop: " + className + ", Diem: " + grade;
    }
}

public class Quanlysinhvien {
    private static ArrayList<Student> studentsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Tim ho ten sinh vien");
            System.out.println("3. Tim va chinh sua ten sinh vien theo ten day du");
            System.out.println("4. Ket thuc");
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findByLastName();
                    break;
                case 3:
                    findAndEditByFullName();
                    break;
                case 4:
                    System.out.println("Ket thuc truong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 4);
    }

    // Nhập danh sách sinh viên
    public static void enterStudentList() {
        System.out.print("Nhap so luong sinh vien: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1));
            System.out.print("Ten day du: ");
            String fullName = scanner.nextLine();
            System.out.print("Ma sinh vien: ");
            String studentId = scanner.nextLine();
            System.out.print("Diem: ");
            float grade = Float.parseFloat(scanner.nextLine());
            System.out.print("Lop: ");
            String className = scanner.nextLine();

            studentsList.add(new Student(fullName, studentId, grade, className));
        }
    }

    // Tìm sinh viên theo họ
    public static void findByLastName() {
        System.out.print("Nhap ho ten sinh vien: ");
        String lastName = scanner.nextLine();
        boolean found = false;

        for (Student student : studentsList) {
            if (student.getFullName().split(" ")[1].equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay hova ten cua sinh vien: " + lastName);
        }
    }

    // Tìm và chỉnh sửa thông tin sinh viên theo tên đầy đủ
    public static void findAndEditByFullName() {
        System.out.print("Nhap ten day du cua sinh vien: ");
        String fullName = scanner.nextLine();
        boolean found = false;

        for (Student student : studentsList) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println("Sinh vien tim thay: " + student);
                System.out.print("Nhap diem moi: ");
                student.setGrade(Float.parseFloat(scanner.nextLine()));
                System.out.println("Thong tin chinh sua: " + student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien voi ten day du: " + fullName);
        }
    }
}

