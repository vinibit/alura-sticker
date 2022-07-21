import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os Top 250 filmes
        //var url = "https://imdb-api.com/en/API/Top250Movies/k_teste";        
        
        var client = new ApiClient();
        
        // Extrair: título, poster, classificação
        var urlImdb = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        String imdbBody = client.fetch(urlImdb);
        ContentExtractor imdbContentExtractor = new IMDBContentExtractor();
        List<Content> contents = imdbContentExtractor.extractFromJson(imdbBody);
        
        var urlNasa = "https://api.nasa.gov/planetary/apod?api_key=0L5vmAuoYi36tkAnEzoMxo59l3YGhevyT0DKrfxr&start_date=2022-06-12&end_date=2022-06-14";
        String nasaBody = client.fetch(urlNasa);
        ContentExtractor nasaContentExtractor = new NASAContentExtractor();
        contents.addAll(nasaContentExtractor.extractFromJson(nasaBody));

        var factory = new StickerFactory();

        // Manipular e exibir dados
        for (var content : contents) {
            
            System.out.println(content.getTitle());            
            System.out.println("-----------------------------------------------------------------------");

            String imageUrl = content.getImageURL();
            String title = content.getTitle();
            var stream = new URL(imageUrl).openStream();
            factory.create(stream, title + ".png", content.getMessageText());
        }
    }
}