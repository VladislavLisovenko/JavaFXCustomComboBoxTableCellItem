package ru.vlsoft.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import ru.vlsoft.GeneralUtils;
import ru.vlsoft.models.Product;
import ru.vlsoft.models.TableDetails;
import ru.vlsoft.table_cells.ProductTableCell;

public class MainFormController {

    @FXML
    private TableView<TableDetails> tableView;

    @FXML
    void initialize() {

        tableView.getColumns().clear();
        tableView.setItems(FXCollections.observableList(GeneralUtils.details));
        tableView.setEditable(true);

        {
            TableColumn<TableDetails, Product> column = new TableColumn<>("Product");
            column.setCellValueFactory(new PropertyValueFactory<>("product"));
            column.setCellFactory(tableDetailsProductTableColumn -> new ProductTableCell<>());
            column.setEditable(true);
            column.setMinWidth(200.);
            column.setOnEditCommit(handler -> {
                handler.getRowValue().setProduct(handler.getNewValue());
                tableView.refresh();
            });
            tableView.getColumns().add(column);
        }

        {
            TableColumn<TableDetails, Integer> column = new TableColumn<>("Price");
            column.setCellValueFactory(new PropertyValueFactory<>("price"));
            column.setEditable(true);
            column.setMinWidth(100.);
            column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            column.setOnEditCommit(handler -> {
                handler.getRowValue().setPrice(handler.getNewValue());
                tableView.refresh();
            });
            tableView.getColumns().add(column);
        }

        {
            TableColumn<TableDetails, Integer> column = new TableColumn<>("Amount");
            column.setCellValueFactory(new PropertyValueFactory<>("amount"));
            column.setEditable(true);
            column.setMinWidth(100.);
            column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            column.setOnEditCommit(handler -> {
                handler.getRowValue().setAmount(handler.getNewValue());
                tableView.refresh();
            });
            tableView.getColumns().add(column);
        }

        {
            TableColumn<TableDetails, Double> column = new TableColumn<>("Total");
            column.setCellValueFactory(new PropertyValueFactory<>("total"));
            column.setMinWidth(100.);
            tableView.getColumns().add(column);
        }

    }

}
