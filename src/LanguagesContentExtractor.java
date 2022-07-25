import java.util.ArrayList;
import java.util.List;

public class LanguagesContentExtractor implements ContentExtractor {    

    @Override
    public List<Content> extractFromJson(String json) {        
        var parser = new JsonParser();
        
        List<Content> contents = new ArrayList<>();
        for (var attr : parser.parse(json)) {            
            String title = attr.get("title");
            String imageUrl = attr.get("image");
            String rating = attr.get("ranking");
            contents.add(new Content(title, imageUrl, rating));
        }
        return contents;        
    } 
    
}
