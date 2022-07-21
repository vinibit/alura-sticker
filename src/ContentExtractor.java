import java.util.List;

public interface ContentExtractor {
    
    List<Content> extractFromJson(String json);
}
