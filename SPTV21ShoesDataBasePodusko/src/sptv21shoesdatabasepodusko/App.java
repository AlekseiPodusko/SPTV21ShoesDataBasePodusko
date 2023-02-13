package sptv21shoesdatabasepodusko;


import entity.Customer;
import entity.Purchase;
import entity.Product;
import manager.ProductManager;
import manager.CustomerManager;
import manager.PurchaseManager;
import manager.FileDataManager;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import manager.BaseDataManager;


public class App {
    private final Scanner scanner;
    //private Product[] products;
    List<Product> products;
    //private Customer[] customers;
    List<Customer> customers;
    //private Purchase[] purchases;
    List<Purchase> purchases;
    private ProductManager productManager;
    private PurchaseManager purchaseManager;
    private CustomerManager customerManager;
   // private final FileDataManager dataManager;
    private final BaseDataManager dataManager;
    
    
public App(){
    scanner=new Scanner(System.in);
    //products=new Product[0];
    //customers=new Customer[0];
    //purchases=new Purchase[0];
    productManager=new ProductManager();
    customerManager = new CustomerManager();
    purchaseManager= new PurchaseManager();
    //dataManager=new FileDataManager();
    dataManager=new BaseDataManager();
    products = dataManager.loadProduct();
    purchases = dataManager.loadPurchase();
    customers=dataManager.loadCustomer();

}

   public void run(){
       System.out.println("*********Добро пожаловать в магазин обуви*********");
       System.out.println("********************Скороход**********************");
       boolean reapeat=true;
       do{
           
           System.out.println("---------------------Задачи-----------------------");
           System.out.println("0.Выход");
           System.out.println("1.Добавить продукты");
           System.out.println("2.Список продуктов");
           System.out.println("3.Добавить покупателя");
           System.out.println("4.Список зарег. покупателей");
           System.out.println("5.Покупка покупателем продукта");
           System.out.println("6.Оборт магазина за все время работы");
           System.out.println("7.Добавить денег покупателю");
           int task=scanner.nextInt();
           scanner.nextLine();
           switch(task){
               case 0:
                    reapeat=false; 
                    break;
               case 1:
                   System.out.println("Добавить продукт");
                   this.products.add(productManager.createProducts());
                   dataManager.saveProduct(products);
                   break;
               case 2:
                   System.out.println("Список продуктов");
                   productManager.printListProducts(products);
                   
                   break;
               case 3:
                   System.out.println("Добавить покупателя");
                   this.customers.add(customerManager.createCustomer());
                   dataManager.saveCustomer(customers);
                   break;
               case 4:
                   System.out.println("Список зарег. покупателей");
                   customerManager.printListCustomers(customers);
                   break;
               case 5:
                   System.out.println("Покупка покупателем продукта");
                   this.purchases.add(purchaseManager.buy(customers,products));
                   dataManager.saveCustomer(customers);
                   dataManager.saveProduct(products);
                   dataManager.savePurchase(this.purchases);
                   break;
               case 6:
                   System.out.println("Оборот магазина за все время работы");
                   purchaseManager.allSale(this.purchases);
                   
                   break;
               case 7:
                   System.out.println("Изменить баланс покупателю");
                   this.customers=customerManager.changeCustomer(customers);
                   break;
               default:
                   System.out.println("Выберите задачу из списка");
           }
       }while(reapeat);
       System.out.println("Закрытие Магазина! Arivederchi!");
   }
 //   private void addProduct(List<Product> products){
  //     this.products=Arrays.copyOf(products, products.size()+1);
   //    this.products.get(this.products.length-1)= product;
  // }
   // private void addCustomer(List<Customer> customer){
   //    this.customers=Arrays.copyOf(this.customers, this.customers.length+1);
   //    this.customers.get(this.customers.length-1)= customer;
   //}
   // private void addPurchase(List<Purchase> purchase){
    //   if (purchase!=null){
    //      this.purchases= Arrays.copyOf(purchase,this.purchases.size()+1);
    //      this.purchases.get(this.purchases.size()-1)= purchase;
    //   }
}