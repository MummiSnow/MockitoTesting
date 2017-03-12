package testex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import testex.jokefetcher.*;

import java.util.List;

import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class FetcherFactoryTest {
    @Mock
    EduProg ep;
    @Mock
    Chuck cn;
    @Mock
    Moma moma;
    @Mock
    Tambal tambal;

    FetcherFactory ff;

    @Before
    public void setUp() throws Exception {
        ff = new FetcherFactory();

    }

    @Test
    public void getJokesTest() throws Exception {

        List<IJokeFetcher> items = ff.getJokeFetchers("eduprog,chucknorris,moma,tambal");
        Assert.assertThat(items.toArray(), arrayContainingInAnyOrder(instanceOf(EduProg.class), instanceOf(Chuck.class), instanceOf(Moma.class), instanceOf(Tambal.class)));
        Assert.assertThat(items.toArray(),is(arrayWithSize(4)));
    }
}
