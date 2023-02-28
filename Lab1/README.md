# lab1
Main.java 
-Afisam mesajul "Hello world!" pe ecran
-Declaram un vector de tip string si il initializam cu valorile date in cerinta
-Generam un numar de tip int cu ajutorul functiei Math.random()
-efectuam o serie de instructiuni de inmultire si adunare, unde folosim si functia Integer.parseInt() pentru a converti un numar la int
-adunam suma cifrelor numarului n pana cand suma < 9 (adica este formata dintr-o singura cifra) apoi afisam un mesaj urmat de elementul vectorului languages aflat pe pozitia calculata la pasul anterior

Homework.java
-in cazul in care n-ul citit este mai mare ca 30_000 vom afisa timpul de rulare al aplicatiei folosind functia System.currentTimeMillis(), altfel vom afisa matricea sub forma (i,j,LatinSquare[i][j]) | i si j reprezentand linia, respectiv coloana
-pentru crearea matricei LatinSquare am parcurs matricea initializata cu 0 pe linii si coloane, iar la pasul i am initializat o variabila de tip int numita number care preia numarul liniei curente + 1. In interiorul celor doua bucle verificam daca valoarea variabilei number a iesit din intervalul nostru [1,n], iar daca da, o resetam la 1, apoi punem valoarea lui number in componenta matricei [i][j] si incrementam variabila number

Bonus1.java
-Pentru a crea matricea de adiacenta Cn, citim un n dupa care declaram matricea matrix de tip int si de dimensiune nxn
-Pentru a crea circuit in graf vom parcurge matricea pe linii si coloane dupa care vom pune 1 in componentele ale caror noduri sunt vecine consecutive(1-2, 2-3, 3-4), inclusiv in componenta care face legatura dintre nodul final si cel initial (ex. 4-1) pentru a crea circuit 
-Dupa ce avem matricea creata, pentru a obtine matricea An, vom folosi o functie pentru inmultirea a doua matrici pe care o vom apela de n ori, iar matricea rezultatata o vom printa

Bonus2.java
Algoritmul pe care l-am folosit pentru a crea un graf k-regulat:
Parcurgem matricea pe linii si coloane:
-la pasul initial, 0, vom pune muchie de la nodul i la toate celalte k noduri j in ordine crescatoare 
-la restul pasilor parcurgem coloanele in ordine descrescatoare si intai adaugam muchie la nodurile de grad 0, apoi la celelalte noduri  pana cand gradul nodului i si j sunt egale cu k
