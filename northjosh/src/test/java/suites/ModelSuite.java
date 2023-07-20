package suites;

import models.TestProduct;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestProduct.class
})

public class ModelSuite {
}
