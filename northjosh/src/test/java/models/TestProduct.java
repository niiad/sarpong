package models;

import com.example.northjosh.models.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProduct {

    // first constructor
    private Product product1;
    // second constructor
    private Product product2;
    // third constructor
    private Product product3;

    // create the instances of Product before tests start
    @Before
    public void before() {
        this.product1 = new Product(123456789, "987654321", "Name1", 0, 0.01,
                "Private Label", "Pizza/Premium");
        this.product2 = new Product("123456789", "Name2", 1000, 5.99,
                "General Mills", "All Family Cereal");
        this.product3 = new Product("5555555", "Name3", 50, 1000.02,
                1, 50000, "manufacturer", "subcategory");
    }

    @Test
    public void testGettersConstructor1() {
        assertEquals(product1.getProductID(), 123456789);
        assertTrue(product1.getUpc().equals("987654321"));
        assertTrue(product1.getProductName().equals("Name1"));
        assertEquals(product1.getQuantity(), 0);
        assertEquals(product1.getPrice(), 0.01, 0.00);
        assertTrue(product1.getManufacturer().equals("Private Label"));
        assertTrue(product1.getSubcategory().equals("Pizza/Premium"));
    }

    @Test
    public void testGettersConstructor2() {
        assertTrue(product2.getUpc().equals("123456789"));
        assertTrue(product2.getProductName().equals("Name2"));
        assertEquals(product2.getQuantity(), 1000);
        assertEquals(product2.getPrice(), 5.99, 0.00);
        assertTrue(product2.getManufacturer().equals("General Mills"));
        assertTrue(product2.getSubcategory().equals("All Family Cereal"));
    }

    @Test
    public void testGettersConstructor3() {
        assertTrue(product3.getUpc().equals("5555555"));
        assertTrue(product3.getProductName().equals("Name3"));
        assertEquals(product3.getQuantity(), 50);
        assertEquals(product3.getPrice(), 1000.02, 0.00);
        assertEquals(product3.getManufacturerInt(), 1);
        assertEquals(product3.getSubcategoryInt(), 50000);
        assertTrue(product3.getManufacturer().equals("manufacturer"));
        assertTrue(product3.getSubcategory().equals("subcategory"));
    }

    @Test
    public void testSetters() {
        product3.setProductID(400);
        assertEquals(product3.getProductID(), 400);

        product3.setProductName("new name");
        assertTrue(product3.getProductName().equals("new name"));

        product3.setQuantity(35);
        assertEquals(product3.getQuantity(), 35);

        product3.setPrice(30.05);
        assertEquals(product3.getPrice(), 30.05, 0.00);

        product3.setManufacturerInt(44);
        assertEquals(product3.getManufacturerInt(), 44);

        product3.setSubcategoryInt(0);
        assertEquals(product3.getSubcategoryInt(), 0);

        product3.setManufacturer("another manufacturer");
        assertTrue(product3.getManufacturer().equals("another manufacturer"));

        product3.setSubcategory("another subcategory");
        assertTrue(product3.getSubcategory().equals("another subcategory"));
    }
}
