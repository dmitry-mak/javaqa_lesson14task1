package ru.netology.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    @Test
    void add() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 150);

        shopRepository.add(product1);
        Product[] expected = {product1};
        Assertions.assertArrayEquals(expected, shopRepository.findAll());
        shopRepository.add(product2);
        expected = new Product[]{product1, product2};
        Assertions.assertArrayEquals(expected, shopRepository.findAll());
    }

    @Test
    void shouldDeleteProductFromList() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 150);

        shopRepository.add(product1);
        shopRepository.add(product2);

        shopRepository.remove(1);
        Product[] expected = {product2};

        Assertions.assertArrayEquals(expected, shopRepository.findAll());

    }

    @Test
    void shouldDeleteProductById() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 150);
        Product product3 = new Product(3, "Масло", 200);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        shopRepository.removeById(2);
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, shopRepository.findAll());

    }

    //    Удаление несуществующего элемента. Должен выкидывать NotFoundException
    @Test
    void shouldThrowNotFoundException() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 150);
        Product product3 = new Product(3, "Масло", 200);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(4);
        });
    }

    //    Добавление элемента с уже существующим id. Должен выбрасывать AlreadyExistsException
    @Test
    void shouldThrowAlreadyExistsException() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 150);
        Product product3 = new Product(2, "Масло", 200);

        shopRepository.add(product1);
        shopRepository.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(product3);
        });
    }

    //    Удаление элемента из пустого репозитория. Должен выбрасывать NotFoundException
    @Test
    void deleteElementFromEmptyArray() {
        ShopRepository shopRepository = new ShopRepository();
        Assertions.assertThrows(NotFoundException.class, () -> shopRepository.removeById(1));
    }
}