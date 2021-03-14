package ru.undframe;

import java.sql.*;

public class SQLWorker {

    private Connection connection;

    public SQLWorker(DatabaseProperties databaseProperties){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + databaseProperties.getHost() + "/" + databaseProperties.getDatabase() + "?" +
                    "user=" + databaseProperties.getUser() + "&password=" + databaseProperties.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void createTable(TableSpec tableSpec){

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            StringBuilder execute = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableSpec.getName() + "\n" +
                    "(\n" +
                    "\n");

            for (Column column : tableSpec.getColumns()) {
                StringBuilder stringBuilder = new StringBuilder(column.getColumnName());
                stringBuilder.append(" ").append(column.getTableDataType().getTypeName());
                if(column.isNotNull())
                    stringBuilder.append(" NOT NULL");
                if(column.isAutoIncrement())
                    stringBuilder.append(" AUTO_INCREMENT");

                execute.append(stringBuilder).append(", ");
            }

            execute.append("    PRIMARY KEY (").append(tableSpec.getPrimaryKey()).append(")\n").append("\n").append(");\n").append("\n");

            System.out.println(execute.toString());

            stmt.executeUpdate(execute.toString());



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }


    }

}
