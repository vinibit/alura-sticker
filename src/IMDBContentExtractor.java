import java.util.ArrayList;
import java.util.List;

public class IMDBContentExtractor implements ContentExtractor {
    
    /* (non-Javadoc)
     * @see ContentExtractor#extractFromJson(java.lang.String)
     */    
    public List<Content> extractFromJson(String json) {
        var parser = new JsonParser();
        
        List<Content> contents = new ArrayList<>();
        for (var attr : parser.parse(json)) {
            String title = attr.get("title");
            String imageUrl = attr.get("image");
            Integer rating = (int) Double.parseDouble(attr.get("imDbRating"));
            String messageText = getMessage(rating);
            contents.add(new Content(title, imageUrl, messageText));
        }
        return contents;
    }

    private String getMessage(Integer rating) {
        String messageText = "COOL!!!";
        switch (rating) {
            case 9:
                messageText = "AEWSOME!";
                break;

            case 8:
                messageText = "SHOW";
                break;

            case 7:
                messageText = "GOOD";
                break;

            case 6:
                messageText = "OK";
                break;
        
            default:
                messageText = "MEEEEH!!!";
                break;
        }
        return messageText;
    }
}
