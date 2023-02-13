
package manager;

import entity.Customer;
import entity.Product;
import entity.Purchase;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class BaseDataManager {
    private  EntityManagerFactory emf=Persistence.createEntityManagerFactory("SPTV21ShoesDataU");
    private  EntityManager em = emf.createEntityManager();
    private  EntityTransaction tx =em.getTransaction();
    public void saveProduct(List<Product> products) {  
        tx.begin();
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                if(product.getId()==null){
                    em.persist(product);
                }else{
                    em.merge(product);
                }
        }
        tx.commit();
    }
    public List<Product> loadProduct(){
        try {
            return em.createQuery("SELECT p FROM Product p")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
    }
    }
    public void saveCustomer(List<Customer> customers) {  
        tx.begin();
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                if(customer.getId()==null){
                    em.persist(customer);
                }else{
                    em.merge(customer);
                }
        }
        tx.commit();
    }
    public List<Customer> loadCustomer(){
        try {
            return em.createQuery("SELECT c FROM Customer c")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
    }
    }
    public void savePurchase(List<Purchase> purchases) {  
        tx.begin();
            for (int i = 0; i < purchases.size(); i++) {
                Purchase purchase = purchases.get(i);
                if(purchase.getId()==null){
                    em.persist(purchase);
                }else{
                    em.merge(purchase);
                }
        }
        tx.commit();
    }
    public List<Purchase> loadPurchase(){
        try {
            return em.createQuery("SELECT pu FROM Purchase pu")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
    }
    }
    
}
