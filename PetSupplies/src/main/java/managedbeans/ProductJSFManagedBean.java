/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import boundary.ProductFacade;
import entities.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author RERANA
 */
@Named(value = "productJSFManagedBean")
@RequestScoped
public class ProductJSFManagedBean {

    @EJB
    private ProductFacade productFacade;
   
    private Product product;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    Product product1=new Product("first product", "the description of it", 22.5);
    Product product2= new Product("second product", "the descirption of it", 50.2);
    Product products[]= new Product[2];
  
    /**
     * Creates a new instance of ProductJSFManagedBean
     */
    public ProductJSFManagedBean() {
        products[0]= product1;
        products[1]= product2;
    }
    
    
    public void fillDB(){
       
        for(Product p: products){
        this.productFacade.create(p);
        
        }
        
    }
    
    public List<Product> listFromDB(){
        
        return this.productFacade.findAll();
    }
    

}
