package com.amigoscode._4_datastructures._8_challenge;

// Exercise: Data Structure Challenge
// Combine multiple data structures to solve a real-world problem.
// Manage a collection of students, group them, track recently viewed, and generate reports.

import java.util.*;

public class DataStructureChallenge {

    // TODO: 1 - Create a Student record (or class) with three fields:
    //           String name, int grade, String subject
    //           If using a record: record Student(String name, int grade, String subject) {}
    //           If using a class: include constructor, getters, and a toString() method

    static record Student(String name, int grade, String subject){}


    public static void main(String[] args) {

        // TODO: 2 - Create a List of 10 students with various names, grades, and subjects
        //           Use at least 3 different subjects (e.g., "Math", "Science", "English")
        //           Example: new Student("Alice", 92, "Math")
        List<Student> students = new ArrayList<>(List.of(
                new Student("Susi", 2, "Math"),
                new Student("Alice", 1, "English"),
                new Student("Peter", 3, "Science"),
                new Student("Mogan", 4, "Science"),
                new Student("Samsan", 1, "German"),
                new Student("Tempora", 2, "BK"),
                new Student("Gusi", 5, "Math"),
                new Student("Musi", 5, "Math"),
                new Student("Pastor", 5, "Math")
        ));


        // TODO: 3 - Use a Map<String, List<Student>> to group students by subject
        //           Iterate through the student list
        //           For each student, use computeIfAbsent() to get or create the list for their subject
        //           Then add the student to that list
        //           Print each subject and its students
        Map<String, List<Student>> studentGroupBySubject
                = new HashMap<>();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            studentGroupBySubject
                    .computeIfAbsent(student.subject, s -> new ArrayList<>())
                    .add(student);
        }

        //scores.computeIfAbsent("Eve", s -> s.length() * 10 );


        // TODO: 4 - Use a Set<String> to find all unique subjects
        //           Iterate through the students and add each subject to the set
        //           Print the unique subjects
        Set<String> uniqueSubjects = new HashSet<>();

        for (var student : students)
            uniqueSubjects.add(student.subject());


        // TODO: 5 - Use a Stack<Student> to track the last 3 students "viewed"
        //           Push any 3 students from the list onto the stack
        //           Then pop and print them to show the viewing history (most recent first)
        Stack<Student> viewed = new Stack<>();
        for (int i = 0; i < students.size(); i++)
            if (i % 3 == 0)
                viewed.push(students.get(i));



        // TODO: 6 - Sort the student list by grade in descending order using a Comparator
        //           Use list.sort() with Comparator.comparingInt() and .reversed()
        //           Print the sorted list

        System.out.println(students);
        students.sort(Comparator.comparingInt(Student::grade));
        System.out.println(students);


        // TODO: 7 - Print a summary report:
        //           - Total number of students
        //           - Number of unique subjects (from the Set)
        //           - Highest grade student (first in sorted list)
        //           - Number of students per subject (from the Map)
        System.out.println("Summary report");
        System.out.printf("Total number of students: %s\n", students.size());
        System.out.printf("Highest grade student: %s\n", students.getFirst().name());
        System.out.println(studentGroupBySubject);

    }
}
