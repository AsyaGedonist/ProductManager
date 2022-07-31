package product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "1: Война и мир", 1_200, "Лев Толстой");
    Product item2 = new Book(2, "1: 1984", 600, "Джордж Оруэлл");
    Product item3 = new Smartphone(3, "1: Iphone", 65_000, "Apple");

    @BeforeEach
    public void setup(){
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
    }

    @Test
    public void ShouldViewAll(){
        Product[] actual = manager.getItems();
        Product[] expected = {item1, item2, item3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldDelete(){
        manager.del(2);

        Product[] actual = manager.getItems();
        Product[] expected = {item1, item3};

        assertArrayEquals(expected, actual);
    }

@Test
    public void ShouldFindAll(){
    Product[] actual = manager.searchBy("1");
    Product[] expected = {item1, item2, item3};

    assertArrayEquals(expected, actual);
}

@Test
    public void ShouldFindNothing(){
    Product[] actual = manager.searchBy("k");
    Product[] expected = {};

    assertArrayEquals(expected, actual);
}

}
