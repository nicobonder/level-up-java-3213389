package com.linkedin.javacodechallenges;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import com.google.gson.Gson;

public class App {

    public static Optional<String> parseJoke(String responseBody) {
        try {
            JokeResponse jokeResponse = new Gson().fromJson(responseBody,
                JokeResponse.class);
            //En la clase JokeResponse tengo la prop joke, 
            //entonces puedo hacer getJoke y obtengo solo esa parte de la respuesta
            String joke = jokeResponse.getJoke();
            if(joke != null) {
                return Optional.of(jokeResponse.getJoke());
            } 
        } catch(Exception e) {
            System.out.println("We are out of jokes. Sorry");
            return Optional.empty();
        }
        return null;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO: Call https://icanhazdadjoke.com/ API and display joke
       //Create a client
        var client = HttpClient.newHttpClient();

        //Create a request
        var request = HttpRequest.newBuilder(
            URI.create("https://icanhazdadjoke.com/"))
            .header("accept", "application/json")
            .build();

        //Use the client to send the request
        var resp = client.send(request, BodyHandlers.ofString());
        Optional<String> jokeOpt = parseJoke(resp.body());
        jokeOpt.ifPresent(System.out::println);
    }

    
}
