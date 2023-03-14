package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class App
{
    public static void main( String[] args ) {

        var students = Stream.of(
                new Student("S0", Arrays.asList(new Project("P0"), new Project("P1"), new Project("P2"))),
                new Student("S1", Arrays.asList(new Project("P0"), new Project("P1"))),
                new Student("S2", Collections.singletonList(new Project("P0")))
        ).toList();
        List<Student> studentsList = new LinkedList<>(students);

        var projects = Stream.of(
                new Project("P0"),
                new Project("P1"),
                new Project("P2")
        ).collect(Collectors.toCollection(TreeSet::new));

        Collections.sort(studentsList);
        studentsList.forEach(System.out::println);
        projects.forEach(System.out::println);
    }
}
