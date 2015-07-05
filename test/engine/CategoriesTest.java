package engine;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CategoriesTest {

    @Test
    public void testGetCategoryByName() throws Exception {
        Categories categories = new Categories();
        categories.initCategories();
        String actual = categories.getCategoryByName("Second").toString();
        String expected = "Second";
        Assert.assertEquals(actual, expected);
    }
}