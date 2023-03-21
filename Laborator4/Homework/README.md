Homework

-In plus fata de Compulsory, am creat clasa DescribeProblem in care am creat un algoritm Greedy pentru a asigna fiecarui student cate un proiect. 

Intai am definim doua structuri de date: un HashSet cu proiectele initiale care vor reprezenta proiectele disponibile si un HashMap pentru a stoca asocierile student-proiect

Apoi am trecut prin fiecare student si prin lista lor de preferinte pentru a vedea daca proiectul lor se afla in proiectele disponibile din HashSet

Daca se afla atunci studentului respectiv ii este asignat proiectul si apoi proiectul ales de student se sterge din HashSet-ul cu proiectele disponibile

La final afisam asocierile de tip: student-proiect

-Apoi in functia main din clasa App, am generat nume false aleatorii pentru studenti si proiecte cu ajutorul biblitecii JavaFaker 

-Apoi tot in functia main am creat o interogare care sa afiseze toti studentii care au un numar de preferinte mai mic decat numarul mediu de preferinte