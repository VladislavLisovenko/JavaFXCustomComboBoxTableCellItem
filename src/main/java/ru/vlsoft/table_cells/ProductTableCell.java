package ru.vlsoft.table_cells;

import javafx.collections.FXCollections;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import ru.vlsoft.GeneralUtils;
import ru.vlsoft.models.Product;
import ru.vlsoft.view_models.ProductListViewModel;

import java.util.Optional;

public class ProductTableCell<T> extends TableCell<T, Product> {

    private Label label;
    private ComboBox<Product> comboBox;

    public ProductTableCell() {
        label = new Label();
        comboBox = new ComboBox<>();
        comboBox.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> productListView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Product item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        } else {

                            Label labelName = new Label(item.getName());
                            labelName.setMinWidth(100);
                            labelName.setMaxWidth(100);

                            Label labelPrice = new Label(item.getPrice().toString());
                            labelPrice.setMinWidth(100);
                            labelPrice.setMaxWidth(100);
                            labelPrice.setAlignment(Pos.CENTER_RIGHT);

                            HBox box = new HBox();
                            box.getChildren().addAll(labelName, labelPrice);

                            setGraphic(box);

                        }
                    }
                };
            }
        });
        comboBox.setOnAction(handler -> {
            commitEdit(comboBox.getSelectionModel().getSelectedItem());
        });
    }

    @Override
    public void startEdit() {
        super.startEdit();

        setEditableContent();

    }

    @Override
    protected void updateItem(Product product, boolean empty) {
        super.updateItem(product, empty);

        setReadableContent();
    }

    @Override
    public void commitEdit(Product product) {
        super.commitEdit(product);

        setReadableContent();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setReadableContent();
    }

    private void setEditableContent() {

        comboBox.setItems(FXCollections.observableArrayList(GeneralUtils.products));
        comboBox.getSelectionModel().select(getItem());

        HBox box = new HBox();
        box.setMinWidth(getWidth() - 4);
        box.setMaxWidth(getWidth() - 4);
        box.getChildren().add(comboBox);

        setGraphic(box);

    }

    private void setReadableContent() {
        if (getItem() == null) {
            setGraphic(null);
        } else {
            label.setText(getItem().getName());
            setGraphic(label);
        }
    }

}
