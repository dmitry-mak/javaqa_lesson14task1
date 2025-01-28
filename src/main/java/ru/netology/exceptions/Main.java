package ru.netology.exceptions;

public class Main {
    public static void main(String[] args) {

        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 150);
        Product product3 = new Product(3, "Масло", 200);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

//   System.out.println(shopRepository.findAll().toString());
        for (Product product : shopRepository.findAll()) {
            System.out.println(product.toString());
        }
        shopRepository.removeById(3);
        System.out.println("Убрали один элемент");

        for (Product product : shopRepository.findAll()) {
            System.out.println(product.toString());
        }

//        System.out.println("Убрали несуществующий элемент");
//        shopRepository.removeById(3);
//        for (Product product : shopRepository.findAll()) {
//            System.out.println(product.toString());
//        }
        Product product4 = new Product(2, "Book", 200);
        shopRepository.add(product4);
    }
}