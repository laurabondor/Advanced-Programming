package org.example;
import java.util.List;
import java.util.Objects;
public class Student implements Comparable<Student> {
    private String name;
    private List<Project> projects;
    /**
     * Student reprezinta constructorul clasei
     *
     * @param name reprezinta numele studentului Student
     */
    public Student(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }
    /**
     * este o metoda getter
     * @return returneaza numele studentului Student
     * */
    public String getName() {
        return name;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(projects, student.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projects);
    }
}
