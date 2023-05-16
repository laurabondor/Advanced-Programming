Optional 

-In plus fata de Compulsory, am creat clasa Game in care cream jocul, adaugam playeri, facem mutari si pornim/oprim jocul in functie de un anumit timer

-Apoi am creat clasa Board care contine o matrice de char-uri ce reprezinta tabla de joc. Tot aici avem si o metoda care verifica daca un player a castigat

-Avem si clasa Player care reprezinta clientul ce se conecteaza la server si ii asignam o culoare(WHITE sau BLACK) in momentul in care se alatura jocului 

-In clasa ClientThread am modificat functia run() pentru a trata toate comenzile trimise de clienti: create game, join game si submit move