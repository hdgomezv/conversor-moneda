import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Search {

    double exchange;

    public Exchange searchExchange(String base_code, String target_code, double amount) {
        URI direccion = URI
                .create("https://v6.exchangerate-api.com/v6/dbe7c5601aea34fce8047990/pair/" + base_code + "/" + target_code + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Exchange.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void showResult(String base_code, String target_code, double amount) {
        Search mySearch = new Search();
        exchange = mySearch.searchExchange(base_code, target_code, amount).conversion_result();
        System.out.println("El valor de " + amount + " [" + base_code + "] " + "corresponde al valor de " + exchange + " [" + target_code + "]\n");
    }
}
