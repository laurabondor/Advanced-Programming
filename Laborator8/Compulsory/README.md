Compulsory 

-Pentru baza mea de date Student din Oracle, am creat un script care creaza 4 tabele: albums, artists, genres si album_genres si l-am rulat

-Apoi am descarcat si am adaugat in pom.xml libraria pentru baza mea de date Oracle

-Am implementat clasa Database in care cream/oprim o conexiune catre baza mea de date din Oracle

-Am implementat apoi clasele ArtistDAO si GenreDAO in care am impementat metode de inserare a valorilor in tabela artists, respectiv genres; si metode de cautare a valorilor dupa nume si dupa id

-Am impementat apoi si clasa AlbumDAO in care la fel, avem o metoda de inserare a valorile in tabela albums si am in plus si inserarea de valori in tabela album_genres care primeste ca id, albumul curent, si id-ul cautat din tabela genres

-In functia Main apelam diferite metode pentru inserarea datelor in tabele dupa care le afisam