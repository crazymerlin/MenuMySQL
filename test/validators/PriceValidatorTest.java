package validators;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PriceValidatorTest {

    @Test
    public void testIsPriceValid() throws Exception {
        PriceValidator priceValidator = new PriceValidator();
        Assert.assertTrue(priceValidator.isPriceValid(100));
    }

    @Test
    public void testIsZeroInvalid() throws Exception {
        PriceValidator priceValidator = new PriceValidator();
        Assert.assertFalse(priceValidator.isPriceValid(0));
    }

    @Test
    public void testIsPriceBelowZeroInvalid() throws Exception {
        PriceValidator priceValidator = new PriceValidator();
        Assert.assertFalse(priceValidator.isPriceValid(-10));
    }
}