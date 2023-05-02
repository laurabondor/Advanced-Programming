package org.example;
public class ArtistDAO extends DAO{
    @Override
    protected String getTableName() {
        return "artists";
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
