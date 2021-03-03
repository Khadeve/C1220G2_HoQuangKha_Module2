package _11_java_javaCollectionsFramework.exercise.task1;

import java.util.*;

public class ProductManager {
    private final ArrayList<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
    }

    public ProductManager(List<Product> products) {
        productList = new ArrayList<>(products);
    }

    public int getSize() {
        return productList.size();
    }

    //add a new product.
    public void addNewProduct(Product newProduct) {
        productList.add(newProduct);
    }

    //update a product based on id.
    public void editProductInfo(int id) throws IndexOutOfBoundsException {
        if (id <= 0 || id > getSize()) {
            throw new IndexOutOfBoundsException("[size=" + getSize() + ",id" + id + "]");
        }
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a new name:");
        String newName = in.nextLine();

        System.out.print("Enter a new price:");
        double newPrice = in.nextDouble();

        productList.get(id - 1).setName(newName);
        productList.get(id - 1).setPrice(newPrice);
    }

    //remove a product from the list based on id.
    public void removeProduct(int id) throws IndexOutOfBoundsException {
        if (id <= 0 || id > getSize()) {
            throw new IndexOutOfBoundsException("[size=" + getSize() + ",id=" + id + "]");
        }
        productList.remove(id - 1);
    }

    //search product based on name.
    public Product searchByName(String productName) {
        //Iterator<Product> iter = productList.iterator();
        for (Product p : productList) {
            if (p.getName().equals(productName)) {
                return p;
            }
        }
        return null;
    }

    //sort in ascending order based on price of products.
    public void sortInAscendingOrder() {
        productList.sort(Comparator.comparing(Product::getPrice));
    }

    //sort in descending order based on price of products.
    public void sortInDescendingOrder() {
        productList.sort(Comparator.comparing(Product::getPrice,
                (f, s) -> Double.compare(s, f)));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        productList.forEach((e) -> str.append(e).append("\n"));
        return str.toString();
    }
}
