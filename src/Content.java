public class Content {
    
    private final String title;
    private final String imageURL;
    private final String rating;  

    public Content(String title, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
        this.rating = null;
    }

    public Content(String title, String imageURL, String rating) {
        this.title = title;
        this.imageURL = imageURL;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getMessageText() {
        String messageText;
        switch (rating) {
            case "1":
                messageText = "Awesome!";
                break;

            case "2":
                messageText = "Show!";
                break;

            case "3":
                messageText = "Good.";
                break;

            case "4":
                messageText = "Ok...";
                break;
        
            default:
                messageText = "MEEEEH!!!";
                break;
        }
        return messageText;
    }    
}
