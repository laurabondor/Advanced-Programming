Compulsory 

-Am creat primul proiect ServerApplication, in care am creat 2 clase: GameServer si ClientThread. 

-In clasa GameServer cream un ServerSocket care ruleaza pe un anumit port, apoi cream o bucla while pentru a astepta ca clientii sa se conecteze si acceptam cererea clientilor si cream un ClientThread pentru fiecare client in parte.

-In clasa ClientThread citim comenzile primite de la client si le executam

-Apo am creat al doilea proiect ClientApplication, in care am facut clasa GameClient. Aici cream un socket pe care il conectam la adresa IP si portul serverului pentru a putea stabili conexiunea. Apoi citim comenzi de la tastatura si le trimitem serverului pentru executie, iar cand citim de la tastaura "exit", inchidem clientul.



