package org.example;
import java.util.Objects;
public class Project implements Comparable<Project>{
    private String name;
    /**
     * Project reprezinta constructorul clasei Project
     * @param name reprezinta numele proiectului Project
     * */
    public Project(String name) {
        this.name = name;
    }
    /**
     * este o metoda getter
     * @return returneaza numele proiectului Project
     * */
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Project other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
