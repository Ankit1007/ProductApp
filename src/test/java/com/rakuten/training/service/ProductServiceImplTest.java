package com.rakuten.training.service;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductServiceImplTest {

  @Test
  public void addNewProduct_Returns_Valid_id_When_ProductValue_GTEQ_MinValue() {
    //Arrange
	  ProductServiceImpl service = new ProductServiceImpl();
	  Product toBeAdded = new Product("test",10000,1);//notice 10000*1>=10000
	  ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
	  Product saved = new Product("test",10000,1);
	  saved.setId(1);
	  Mockito.when(mockDAO.save(toBeAdded)).thenReturn(saved);
	  service.setDao(mockDAO);
	  //Act
	  int id = service.addNewProduct(toBeAdded);
	  //Assert
	  Assert.assertTrue(id>0);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void addNewProduct_Returns_Valid_id_When_ProductValue_LT_MinValue() {
	  //Arrange
	  ProductServiceImpl service  = new ProductServiceImpl();
	  Product toBeAdded = new Product("test",99,1);// notice 99*1 <= 10000
	  //Act
	  service.addNewProduct(toBeAdded);
	  //Assert
  }
  
}
