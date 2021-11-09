package xml;

public class newsItem
{
    private String title;
    private String link;
    private String description;
    private String pubDate;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public newsItem(String title, String link, String description, String pubDate)
    {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
    }

}
