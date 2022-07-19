import java.net.URI;
import java.net.URL;
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
        var url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        URI address = URI.create(url);
        
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address)
            .GET()
            .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        // Extrair: título, poster, classificação
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);

        var factory = new StickerFactory();

        // Manipular e exibir dados
        for (var movieData : moviesList) {
            
            System.out.println(movieData.get("title"));
            System.out.println(movieData.get("image"));
            System.out.println(movieData.get("imDbRating"));
            System.out.println("------------------------------------------------------------------------------------");

            String imageUrl = movieData.get("image");
            String title = movieData.get("title");
            Integer rating = (int) Double.parseDouble(movieData.get("imDbRating"));

            String message;
            switch (rating) {
                case 9:
                    message = "AEWSOME!";
                    break;

                case 8:
                    message = "SHOW!";
                    break;

                case 7:
                    message = "GOOD!";
                    break;

                case 6:
                    message = "OK!";
                    break;
            
                default:
                    message = "MEEH!";
                    break;
            }

            var stream = new URL(imageUrl).openStream();
            factory.create(stream, title + ".png", message);
        }
    }
}
