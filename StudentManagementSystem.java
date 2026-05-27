import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class StudentManagementSystem {
ArrayList<Student> students = new ArrayList<>();
Scanner sc = new Scanner(System.in);

String fileName = "students.txt";
// Constructor
public StudentManagementSystem() {
    loadStudentsFromFile();
}

// Add Student
public void addStudent() {
    System.out.print("Enter Student ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Age: ");
    int age = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Course: ");
    String course = sc.nextLine();

    Student s = new Student(id, name, age, course);

    students.add(s);

    saveStudentsToFile();

    System.out.println("Student Added Successfully!");
}

// View Students
public void viewStudents() {

    if (students.isEmpty()) {
        System.out.println("No Students Found!");
        return;
    }

    for (Student s : students) {
        s.displayStudent();
    }
}

// Search Student
public void searchStudent() {

    System.out.print("Enter Student ID to Search: ");
    int id = sc.nextInt();

    boolean found = false;

    for (Student s : students) {

        if (s.getId() == id) {
            s.displayStudent();
            found = true;
        }
    }

    if (!found) {
        System.out.println("Student Not Found!");
    }
}

// Update Student
public void updateStudent() {

    System.out.print("Enter Student ID to Update: ");
    int id = sc.nextInt();
    sc.nextLine();

    boolean found = false;

    for (Student s : students) {

        if (s.getId() == id) {

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Course: ");
            String course = sc.nextLine();

            s.setName(name);
            s.setAge(age);
            s.setCourse(course);

            saveStudentsToFile();

            System.out.println("Student Updated Successfully!");

            found = true;
        }
    }

    if (!found) {
        System.out.println("Student Not Found!");
    }
}

// Delete Student
public void deleteStudent() {

    System.out.print("Enter Student ID to Delete: ");
    int id = sc.nextInt();

    boolean found = false;

    for (Student s : students) {

        if (s.getId() == id) {

            students.remove(s);

            saveStudentsToFile();

            System.out.println("Student Deleted Successfully!");

            found = true;

            break;
        }
    }

    if (!found) {
        System.out.println("Student Not Found!");
    }
}

// Save Students To File
public void saveStudentsToFile() {

    try {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (Student s : students) {

            writer.write(
                    s.getId() + "," +
                    s.getName() + "," +
                    s.getAge() + "," +
                    s.getCourse());

            writer.newLine();
        }

        writer.close();

    } catch (IOException e) {

        System.out.println("Error Saving File!");
    }
}

// Load Students From File
public void loadStudentsFromFile() {

    try {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int age = Integer.parseInt(data[2]);
            String course = data[3];

            students.add(new Student(id, name, age, course));
        }

        reader.close();

    } catch (IOException e) {

        System.out.println("No Previous Student Data Found.");
    }
}
```

}
