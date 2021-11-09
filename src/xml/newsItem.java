package xml;

public class newsItem
{
    private final String title;
    private final String link;
    private final String description;
    private final String pubDate;

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

    @Override
    public String toString()
    {
        return "{title: " + title + ", link: " + link + ", description: " + description + "pubDate: " + pubDate + "}"+ "\n";
    }
}
