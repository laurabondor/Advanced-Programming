Compulsory 

-Am creat clasa Token in care retinem numarul tokenului respectiv

-Am creat clasa SharedMemory care contine o coada de token-uri(cu numere de la 1 la n^3), apoi am creat o metoda pentru a putea extrage token-urile din SharedMemory sincronizand firele de executie si cu ceilalti roboti

-Am creat clasa ExplorationMap in care fiecare robot viziteaza celule aleatorii(nevizitate) si extrage token-uri din SharedMemory pe care le stocheaza in celula matricei, apoi afisam un mesaj cu numele robotului si celula vizitata

-Am creat clasa Exploration in care simulam explorarea hartii aleatorie folosind un fir de executie(Thread) pentru fiecare robot 

-Am creat clasa Robot care implementeaza interfata Runnable, si are diverse functionalitati pentru robot: fiecare robot se poate misca aleatoriu pe harta si poate extrage token-uri din SharedMemory 
