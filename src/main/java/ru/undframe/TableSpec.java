package ru.undframe;

import java.util.ArrayList;
import java.util.List;

public class TableSpec {

    private String name;
    private List<Column> columns = new ArrayList<>();
    private String primaryKey;

    public static TableSpec initFromClass(Class c){
        Table t = (Table)c.getDeclaredAnnotation(Table.class);

        TableSpec tableSpec = new TableSpec();
        tableSpec.name = t.name();
        return tableSpec;
    }

    public void addColumn(Column column){
        columns.add(column);
    }

    public void setPrimaryKey(String primaryKey){
        this.primaryKey = primaryKey;
    }

    public String getPrimaryKey(){
        return primaryKey;
    }

    public Column[] getColumns(){
        return columns.toArray(new Column[]{});
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "TableSpec{" +
                "name='" + name + '\'' +
                '}';
    }
}
