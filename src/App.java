import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os Top 250 filmes
        //var url = "https://imdb-api.com/en/API/Top250Movies/k_teste";        
        
        var client = new ApiClient();
        
        // Extrair: título, poster, classificação
        var url = "https://bit-languages-api.herokuapp.com/languages";
        String body = client.fetch(url);
        ContentExtractor extractor = new LanguagesContentExtractor();
        List<Content> contents = extractor.extractFromJson(body);        

        var factory = new StickerFactory();

        // Manipular e exibir dados
        for (var content : contents) {
            
            System.out.println(content.getTitle());                        
            System.out.println("---------------------------");

            String title = content.getTitle();
            String imageUrl = content.getImageURL();
            var stream = new URL(imageUrl).openStream();
            
            factory.create(stream, title + ".png", content.getMessageText());
        }
    }
}