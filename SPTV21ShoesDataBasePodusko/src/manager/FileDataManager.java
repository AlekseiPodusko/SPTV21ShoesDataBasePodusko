package manager;


import entity.Product; 
import entity.Customer; 
import entity.Purchase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataManager {
    private final String PRODUCT_FILE = "files/PRODUCT";
    private final String CUSTOMER_FILE = "files/CUSTOMER";
    private final String PURCHASE_FILE="files/PURCHASE";

    public FileDataManager(){
        File file = new File("files");
        file.mkdirs();
    }

    public void saveProduct(List<Product> products) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PRODUCT_FILE );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла PRODUCT");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        }
    }
    public List<Product> loadProduct() {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(PRODUCT_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла Product");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс");
        }
        return products;
    }

    public void saveCustomer(List<Customer> customers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(CUSTOMER_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла CUSTOMER");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        }
    }
    public List<Customer> loadCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(CUSTOMER_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            customers = (List<Customer>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла CUSTOMER");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс");
        }
        return customers;
    }

    public void savePurchase(List<Purchase> purchases) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PURCHASE_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(purchases);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла Purchase");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        }
    }
    public List<Purchase> loadPurchase() {
        List<Purchase> purchases = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(PURCHASE_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            purchases = (List<Purchase> ) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла Purchase");
        } catch (IOException e) {
            System.out.println("Ошибка Ввода Вывода");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс");
        }
        return purchases;
    }



}