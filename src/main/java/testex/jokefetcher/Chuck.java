package testex.jokefetcher;


import testex.Joke;

import static com.jayway.restassured.RestAssured.given;

public class Chuck implements IJokeFetcher {
    @Override
    public Joke getJoke() {
        try{
            String joke  = given().get("http://api.icndb.com/jokes/random").path("value.joke");
            return new Joke(joke,"http://api.icndb.com/");
        }catch(Exception e){
            return null;
        }
    }
}
