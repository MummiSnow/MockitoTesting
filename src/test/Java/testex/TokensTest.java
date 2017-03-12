package testex;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import testex.jokefetcher.FetcherFactory;
import testex.jokefetcher.IFetcherFactory;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class TokensTest {
    JokeFetcher jf;
    IFetcherFactory ff = new FetcherFactory();
    @Before
    public void setUp() throws Exception {
        jf = new JokeFetcher(new DateFormatter(),ff);

    }

    @Test
    @FileParameters(value= "src/test/testData/tokens.csv")
    public void testWithCSV(String input, String expResult) {
        Assert.assertThat(jf.isStringValid(input), is(Boolean.valueOf(expResult)));
    }
}
