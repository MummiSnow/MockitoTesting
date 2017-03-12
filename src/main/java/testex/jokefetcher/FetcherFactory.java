package testex.jokefetcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FetcherFactory implements IFetcherFactory {

    /**
     * These are the valid types that can be used to indicate required jokes
     * eduprog: Contains joke related to programming and education. API only returns a new value each hour
     * chucknorris: Fetch a chucknorris joke. Not always political correct ;-)
     * moma: Fetch a "MOMA" joke. Defenitely never political correct ;-)
     * tambal: Just random jokes
     */
    private final List<String> availableTypes = Arrays.asList("eduprog","chucknorris","moma","tambal");

    /**
     * The valid string values to use in a call to getJokes(..)
     * @return All the valid strings that can be used
     */
    @Override
    public List<String> getAvailableTypes(){
        return availableTypes;
    }

    @Override
    public List<IJokeFetcher> getJokeFetchers(String jokesToFetch) {
        ArrayList<IJokeFetcher> returnList = new ArrayList<>();
        String[] tokens = jokesToFetch.split(",");
        for (String token : tokens) {
            switch (token) {
                case "eduprog":
                    returnList.add(new EduProg());
                    break;
                case "chucknorris":
                    returnList.add(new Chuck());
                    break;
                case "moma":
                    returnList.add(new Moma());
                    break;
                case "tambal":
                    returnList.add(new Tambal());
                    break;
                default:
                    break;
            }
        }
        return returnList;
    }
}
