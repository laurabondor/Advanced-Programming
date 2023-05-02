package org.example;
public class GenreDAO extends DAO{
    @Override
    protected String getTableName() {
        return "genres";
    }

    @Override
    protected String getIdColumnName() {
        return "id";
    }

    @Override
    protected String getNameColumnName() {
        return "name";
    }
}
