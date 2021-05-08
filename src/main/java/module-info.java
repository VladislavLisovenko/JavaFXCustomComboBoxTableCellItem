module JavaFXSomeTricks {
    exports ru.vlsoft;
    exports ru.vlsoft.models;
    opens ru.vlsoft.controllers;
    exports ru.vlsoft.table_cells;

    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
}