package ru.netology.exceptions;

public class ShopRepository {

    private Product[] products = new Product[0];

    //    добавление нового элемента в массив
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    // Добавление нового продукта в репозиторий
    public void add(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                throw new AlreadyExistsException("Element with id " + product.getId() + " already exists");
            }
        }
        products = addToArray(products, product);
    }

    //    нахождение всех элементов массива
    public Product[] findAll() {
        return products;
    }

    // удаление элемента из массива
    public void remove(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    //    нахождение элемента массива по id
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    //    удаление из массива элемента по заданному id
    public void removeById(int id) {
        Product product = findById(id);
        if (product == null) {
            throw new NotFoundException(
                    "Element with id " + id + " not found"
            );
        }
        remove(id);
    }
}
