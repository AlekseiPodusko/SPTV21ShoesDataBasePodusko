package manager;

import entity.Customer;
import java.util.Scanner;
import entity.Purchase;
import java.util.List;

public class CustomerManager {
    private  Scanner scanner;

    public CustomerManager() {
        scanner=new Scanner(System.in);
    }
    public Customer createCustomer(){
        Customer customer=new Customer();
        System.out.print("Введите имя покупателя: ");
        customer.setFirstname(scanner.nextLine());scanner.nextLine();
        System.out.print("Введите Фамилию покупателя: ");
        customer.setLastname(scanner.nextLine());scanner.nextLine();
        System.out.print("Введите дату рождения покупателя: ");
        customer.setBirthday(scanner.nextInt());scanner.nextLine();
        System.out.print("Введите баланс покупателя: ");
        customer.setCustomerCash(scanner.nextInt());scanner.nextLine();
        return customer;
        
    }
    public void printListCustomers(List<Customer> customers){
        for (int i=0;i<customers.size();i++){
            System.out.println(i+1 + ". Имя: " 
                    +customers.get(i).getFirstname()+", Фамилия:  "
                    +customers.get(i).getLastname()+", День Рождения: "
                    +customers.get(i).getBirthday()+",Баланс:  "
                    +customers.get(i).getCustomerCash());
        }
    }
    public List<Customer> changeCustomer(List<Customer> customers){
        System.out.println("Список покупателя: ");
        printListCustomers(customers);
        System.out.println("Введите номер покупателя: ");
        int customerNumber=scanner.nextInt();scanner.nextLine();
        System.out.println("Баланс; "+customers.get(customerNumber-1).getCustomerCash());
        System.out.println("Хотите изменить баланс покупателя (y/n)?");
        String tru= scanner.nextLine();
        if (tru.equals("y")){
          System.out.print("Введите новый баланс: ");
          customers.get(customerNumber-1).setCustomerCash(scanner.nextInt());
        }
        return customers;
    }

}
    
    
