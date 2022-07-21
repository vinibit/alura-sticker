public class Content {
    
    private final String title;
    private final String imageURL;
    private final String messageText;  

    public Content(String title, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
        this.messageText = "";
    }

    public Content(String title, String imageURL, String messageText) {
        this.title = title;
        this.imageURL = imageURL;
        this.messageText = messageText;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getMessageText() {
        return messageText;
    }    
}
