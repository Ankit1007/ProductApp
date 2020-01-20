package com.rakuten.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

@Component //@Component("uiObj")
public class ProductConsoleUI {

  ProductService service; // = new ProductServiceImpl();
  
  ProductDAO dao;
  
  @Autowired
  public void removeFromDb() {
	  
  }
  
  @Autowired
  public void setService(ProductService service) {
    this.service = service;
  }

  public void createProductWithUI() {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter Name: ");
    String name = s.nextLine();
    System.out.println("Enter Price: ");
    float price = Float.parseFloat(s.nextLine());
    System.out.println("Enter QoH: ");
    int qoh = Integer.parseInt(s.nextLine());

    Product p = new Product(name, price, qoh);
    int id = service.addNewProduct(p);
    System.out.println("Created Product  with Id: " + id);
    
    s.close();
  }
}
