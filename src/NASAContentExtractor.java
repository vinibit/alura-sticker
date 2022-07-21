import java.util.ArrayList;
import java.util.List;

public class NASAContentExtractor implements ContentExtractor {
    
    public List<Content> extractFromJson(String json) {
        var parser = new JsonParser();
        
        List<Content> contents = new ArrayList<>();
        for (var attr : parser.parse(json)) {
            String title = attr.get("title");
            String imageUrl = attr.get("url");
            contents.add(new Content(title, imageUrl));
        }
        return contents;
    }
}
