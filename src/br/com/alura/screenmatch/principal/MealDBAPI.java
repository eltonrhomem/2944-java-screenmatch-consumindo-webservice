package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MealDBAPI {
    public static void main(String args[]) throws IOException, InterruptedException {
        System.out.println("Digite o nome do prato: ");
        Scanner scanner = new Scanner(System.in);
        String nomeDoPrato = scanner.nextLine();

        String endereco = String.format("http://www.themealdb.com/api/json/v1/1/search.php?s=%s", nomeDoPrato);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());



    }
}
