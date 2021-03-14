package ru.undframe;

public class Column<T>{

    private String columnName;
    private DataType tableDataType;
    private boolean notNull;
    private boolean autoIncrement;

    public Column(String columnName, DataType tableDataType, boolean notNull, boolean autoIncrement) {
        this.columnName = columnName;
        this.tableDataType = tableDataType;
        this.notNull = notNull;
        this.autoIncrement = autoIncrement;
    }

    public String getColumnName() {
        return columnName;
    }

    public DataType getTableDataType() {
        return tableDataType;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }
}
