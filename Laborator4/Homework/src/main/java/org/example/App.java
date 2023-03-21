package org.example;
import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class App
{
    public static void main( String[] args ) {

        Faker faker = new Faker();
        List<Project> projects = IntStream.range(0, 3)
                .mapToObj(i -> new Project(faker.book().title()))
                .collect(Collectors.toCollection(ArrayList::new));

        List<Student> students = IntStream.range(0, 4)
                .mapToObj(i -> new Student(faker.name().fullName(), new ArrayList<>(projects)))
                .collect(Collectors.toCollection(ArrayList::new));

        //add a new Student
        students.add(new Student("Student", Collections.singletonList(new Project("P0"))));
        projects.add(new Project("P0"));

        System.out.println("Students:");
        students.forEach(System.out::println);
        System.out.println("\nProjects:");
        projects.forEach(System.out::println);

        // Print students with number of preferences lower than the average
        double average = students.stream()
                  .mapToInt(student -> student.getProjects().size())
                  .average()
                  .orElse(0);

        System.out.println("\nStudentii care au un numar de preferinte < media:");
        students.stream()
                .filter(student -> student.getProjects().size() < average )
                .forEach(System.out::println);

        DescribeProblem result = new DescribeProblem(students, projects);
        System.out.println();
        result.greedyAlgorithm();
    }
}
