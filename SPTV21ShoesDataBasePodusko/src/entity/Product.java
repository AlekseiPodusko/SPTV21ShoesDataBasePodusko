
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(fetch = FetchType.EAGER, optional = true)
    @Column()
    private String productName;
    private int productPrice;
    private int productQuantity;
    
    public Product() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductname() {
        return productName;
    }

    public void setProductname(String productname) {
        this.productName = productname;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductprice(int productprice) {
        this.productPrice = productprice;
    }
    public int getProductquantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productquantity) {
        this.productQuantity = productquantity;
    }

    @Override
    public String toString() {
        return "Product{" + 
                "productname=" + productName + 
                ", productprice=" + productPrice + 
                ", productquant=" + productQuantity +
                '}';
    }


    
}