/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import boundary.ProductFacade;
import entities.Product;
import java.util.ArrayList;
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
    
    Product product1=new Product("Bench groen", "Groene bench voor uw hond of cat, gemakkelijk op reis!", 80.95);
    Product product2= new Product("Krabpaal deluxe", "zeer mooie en practische krabpaal voor de cat.", 65.85);
    Product product3 = new Product("Dentastix", "Gebitsverbeterende snack voor honden.", 9.99);
    Product product4 = new Product("Koookieez", "Heerlijke snacks  voor de hond.", 5.49);
    Product product5 = new Product("Zonnebloempitten", "Zaden voor uw parkiet.", 1.99);
    Product products[]= new Product[5];
  
    
  
    /**
     * Creates a new instance of ProductJSFManagedBean
     */
    public ProductJSFManagedBean() {
        products[0]= product1;
        products[1]= product2;
        products[2]= product3;
        products[3]= product4;
        products[4] = product5;
       // fillDB();
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
