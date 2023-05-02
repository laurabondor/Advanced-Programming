Optional  

-In plus fata de Compulsory, am creat o clasa abstracta DAO care implementeaza metodele create, findByName si findById, iar restul metodelor: getTableName(), getIdColumnName() si getNameColumnName() fiind abstracte si urmand a fi implementate in fiecare clasa pentru care clasa DAO este superclasa(pentru: ArtistDAO, GenreDAO si AlbumDAO).

-Am modificat clasa Database astfel incat sa folosim un connection pool-ul HikariCP

-Apoi am impementat clasa DataImporter in care preluam date despre actori dintr-un CSV FILE si le adaugam in tabelele din baza noastra de date