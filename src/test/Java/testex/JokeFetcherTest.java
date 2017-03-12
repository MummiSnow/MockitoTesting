package testex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import testex.jokefetcher.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JokeFetcherTest {


    @Mock IDateFormatter ifMock;
    @Mock IFetcherFactory factory;
    @Mock Moma moma;
    @Mock Chuck chuck;
    @Mock EduProg edu;
    @Mock Tambal tambal;
    JokeFetcher jf;

    @Before
    public void setup() {
        List<IJokeFetcher> fetchers = Arrays.asList(edu, chuck,moma,tambal);
        when(factory.getJokeFetchers("EduJoke,ChuckNorris,Moma,Tambal")).thenReturn(fetchers);
        List<String> types = Arrays.asList("EduJoke","ChuckNorris","Moma","Tambal");
        when(factory.getAvailableTypes()).thenReturn(types);
        jf = new JokeFetcher (ifMock, factory);
    }




    @Test
    public void getAvailableTypesTest() throws Exception {

        List<String> types = factory.getAvailableTypes();

        Assert.assertThat(types, hasItems("eduprog","chucknorris","moma","tambal"));
        Assert.assertEquals(4, types.size());
    }

    @Test
    public void getJokesTest() throws Exception {
        given(ifMock.getFormattedDate(eq("Europe/Copenhagen"), anyObject())).willReturn("17 feb. 2017 10:56 AM");
        Assert.assertThat(jf.getJokes("eduprog,chucknorris,chucknorris,moma,tambal","Europe/Copenhagen").getTimeZoneString(),is("17 feb. 2017 10:56 AM"));
    }

    @Test
    public void ChuckNorrisJokeTest() throws Exception {
        given(chuck.getJoke()).willReturn(new Joke("Insert Chuck Norris Joke here", "Anders Norris"));
        Assert.assertThat(chuck.getJoke().getJoke(), is("Insert Chuck Norris Joke here"));
        Assert.assertThat(chuck.getJoke().getReference(),is("Anders Norris"));
    }

    @Test
    public void MomaJokeTest() throws Exception {
        given(moma.getJoke()).willReturn(new Joke("Insert Yo mama Joke here", "Anders Moma"));
        Assert.assertThat(moma.getJoke().getJoke(), is("Insert Yo mama Joke here"));
        Assert.assertThat(moma.getJoke().getReference(),is("Anders Moma"));
    }

    @Test
    public void TambalJokeTest() throws Exception {
        given(tambal.getJoke()).willReturn(new Joke("Insert Tambal Joke here", "Anders Tambal"));
        Assert.assertThat(tambal.getJoke().getJoke(), is("Insert Tambal Joke here"));
        Assert.assertThat(tambal.getJoke().getReference(),is("Anders Tambal"));
    }

    @Test
    public void EduprogJokeTest() throws Exception {
        given(edu.getJoke()).willReturn(new Joke("Insert edu Joke here", "Anders Edu"));
        Assert.assertThat(edu.getJoke().getJoke(), is("Insert edu Joke here"));
        Assert.assertThat(edu.getJoke().getReference(),is("Anders Edu"));
    }
}