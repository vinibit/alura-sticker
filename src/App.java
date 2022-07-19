import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os Top 250 filmes
        //var url = "https://imdb-api.com/en/API/Top250Movies/k_teste";        
        var url = "https://api.mocki.io/v2/549a5d8b/Top250TVs";
        URI address = URI.create(url);
        
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address)
            .GET()
            .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        //System.out.println(body);

        // Extrair: título, poster, classificação
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);
        //System.out.println(moviesList.size());
        //System.out.println(moviesList.get(0));

        // Manipular e exibir dados
        for (var movieData : moviesList) {
            
            System.out.println(movieData.get("title"));
            System.out.println(movieData.get("image"));
            System.out.println(movieData.get("imDbRating"));
            System.out.println();
        }
    }
}
