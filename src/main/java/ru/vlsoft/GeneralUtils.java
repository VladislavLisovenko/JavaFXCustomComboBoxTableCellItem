package ru.vlsoft;

import ru.vlsoft.models.Product;
import ru.vlsoft.models.TableDetails;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//this class used only for sample data generating
public class GeneralUtils {

    public static final List<Product> products;
    public static List<TableDetails> details;

    static {
        products = IntStream.rangeClosed(1, 100).mapToObj(i -> {
            Product element = new Product();
            element.setName("Product " + i);
            element.setPrice((double) i * 10);
            return element;
        }).collect(Collectors.toList());

        details = IntStream.rangeClosed(1, 3).mapToObj(i -> {

                    Random rand = new Random();
                    TableDetails detail = new TableDetails();
                    detail.setProduct(products.get(rand.nextInt(products.size() - 1)));
                    detail.setPrice(rand.nextInt(1000));
                    detail.setAmount(rand.nextInt(100));
                    return detail;

                }
        ).collect(Collectors.toList());
    }
}
