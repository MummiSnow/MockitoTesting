package testex;


import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;


public class DateFormatterTest {

    IDateFormatter dateFormatter;


    @Before
    public void setUp() throws Exception {
        dateFormatter = new DateFormatter();
    }

    //This test in reality test nothing
    @Test
    public void testSingleTimezone() throws JokeException {
        String dateTimeFormat = "dd MMM yyyy hh:mm aa";
        SimpleDateFormat simpleFormat = new SimpleDateFormat(dateTimeFormat);
        simpleFormat.setTimeZone(TimeZone.getTimeZone("Europe/Copenhagen"));
        String exp = simpleFormat.format(new Date());

        assertEquals(dateFormatter.getFormattedDate("Europe/Copenhagen", new Date()), exp);
    }




}