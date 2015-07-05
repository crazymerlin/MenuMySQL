package validators;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NameValidatorTest {

    @Test
    public void testIsNameValid() throws Exception {
        NameValidator nameValidator = new NameValidator();
        Assert.assertTrue(nameValidator.isNameValid("greenTea"));
    }

    @Test
    public void testIsNameInvalid() throws Exception {
        NameValidator nameValidator = new NameValidator();
        Assert.assertFalse(nameValidator.isNameValid("чай"));
    }
}