package xml;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        ReadXmlDomParser newDomParse = new ReadXmlDomParser();
        System.out.println(newDomParse.rssParseTables("https://www.sport.ru/rssfeeds/football.rss").toString());
    }
}
