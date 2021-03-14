import ru.undframe.*;

public class TestClass {

    public static void main(String[] args) {

        DatabaseProperties databaseProperties = new DatabaseProperties();
        databaseProperties.setDatabase("KSite");
        databaseProperties.setHost("localhost");
        databaseProperties.setUser("root");
        databaseProperties.setPassword("root");

        URM urm = new URM(databaseProperties,"ru.undframe");

        TableSpec table = urm.getTables()[0];
        table.addColumn(new Column("id", DataType.INTEGER,true,true));
        table.setPrimaryKey("id");

        System.out.println(urm.toString());

        urm.createTables();

    }

}
