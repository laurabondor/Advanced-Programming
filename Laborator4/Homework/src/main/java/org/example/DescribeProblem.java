package org.example;
import java.util.*;
public class DescribeProblem {
    private List<Student> students;
    private List<Project> projects;
    /**
     * DescribeProblem reprezinta constructorul clasei
     * @param students reprezinta studentii
     * @param projects reprezinta proiectele
     * */
    public DescribeProblem(List<Student> students, List<Project> projects) {
        this.students = students;
        this.projects = projects;
    }
    /**
     * in functia greedyAlgorithm() definim doua structuri de date: un HashSet cu proiectele initiale care vor reprezenta proiectele disponibile si un HashMap pentru a stoca asocierile student-proiect
     * apoi trecem prin fiecare student si prin lista lor de preferinte pentru a vedea daca proiectul lor se afla in proiectele disponibile din HashSet
     * daca se afla atunci studentului respectiv ii este asignat proiectul si apoi proiectul ales de student se scoate din HashSet-ul cu proiectele disponibile
     * la final afisam asocierile de tip: student-proiect
     * */
    public void greedyAlgorithm(){
        Set<Project> availableProjects = new HashSet<>(projects);
        Map<Project, Student> matching = new HashMap<>();

        students.stream()
                .forEach(student -> {
                    for (Project project : student.getProjects()) {
                        if (availableProjects.contains(project)) {
                            matching.put(project, student);
                            availableProjects.remove(project);
                            break;
                        }
                    }
                });
        System.out.println("Asocierea proiectelor dupa aplicarea alg Greedy:");
        for (Project project : matching.keySet()) {
            Student student = matching.get(project);
            System.out.println(student.getName() + " - " + project.getName());
        }
    }
}
