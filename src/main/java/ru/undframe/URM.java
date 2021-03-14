package ru.undframe;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class URM {

    private Collection<TableSpec> tables = new ArrayList<>();
    private SQLWorker sqlWorker;

    public URM(DatabaseProperties databaseProperties,String pckg) {

        sqlWorker = new SQLWorker(databaseProperties);

        Reflections reflections = new Reflections(pckg);


        List<Class<?>> tClasses = new ArrayList<>(reflections.getTypesAnnotatedWith(Table.class));
        tClasses.sort((o1, o2) -> {
            Table o1Annotation = o1.getAnnotation(Table.class);
            Table o2Annotation = o2.getAnnotation(Table.class);
            return Integer.compare(o1Annotation.prority(), o2Annotation.prority());
        });

        for (Class<?> table : tClasses) {
            this.tables.add(TableSpec.initFromClass(table));
        }
    }

    public TableSpec[] getTables(){
        return tables.toArray(new TableSpec[0]);
    }

    public void createTables(){
        for (TableSpec table : tables) {
            sqlWorker.createTable(table);
        }
    }

    @Override
    public String toString() {
        return "URM{" +
                "tables=" + tables +
                '}';
    }
}
