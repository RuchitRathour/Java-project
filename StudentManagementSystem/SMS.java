package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

// Main System Class
public class SMS {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while(choice != 6);
    }

    // Add Student
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    // Display All Students
    public static void displayStudents() {
        if(students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for(Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Search Student by ID
    public static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for(Student s : students) {
            if(s.getId() == id) {
                System.out.println("Student Found: " + s);
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Student not found.");
    }

    // Update Student
    public static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for(Student s : students) {
            if(s.getId() == id) {
                System.out.print("Enter new Name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new Age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();
                System.out.print("Enter new Course: ");
                s.setCourse(sc.nextLine());
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Student not found.");
    }

    // Delete Student
    public static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean removed = students.removeIf(s -> s.getId() == id);
        if(removed) System.out.println("Student deleted successfully!");
        else System.out.println("Student not found.");
    }
}


