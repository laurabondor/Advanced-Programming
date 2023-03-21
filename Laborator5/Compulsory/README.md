Compulsory 

-Am creat clasa Catalog care contine o lista de documente si ca metode mai relevante avem o functie de cautare a documentelor dupa Id si alta pentru cautare dupa locatia unde se afla stocat documentul

-Am creat de asemenea si clasa Document care are ca date private id-ul, titlul, locatia si tagurile documentului si implemnetari pentru gettere si settere

-Am mai facut doua clase Book si Article care mostenesc proprietatile si metodele de la clasa Document

-Am creat apoi o clasa responsabila cu operatiuni externe privind un catalog care se numeste CatalogManager. Apoi ca metode de gestionare a continutului unui catalog am implementat o metoda care adauga o noua intrare in catalog, o reprezentare textuala a catalogului, o metoda care salveaza catalogul intr-un fisier extern folosind formatul JSON si o metoda care incarca catalogul dintr-un fisier extern.

-In functia main din clasa App am declarat si adaugat un articol si o carte in catalog apoi am afisat catalogul, dupa care am facut o cautare dupa id si una dupa locatie intr-un document si am salvat catalogul in format JSON