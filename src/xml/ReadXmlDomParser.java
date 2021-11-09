package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadXmlDomParser
{
    public List<newsItem> rssParseTables(String url)
    {
        List<newsItem> tempArray = new ArrayList<>();
        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);

            doc.getDocumentElement().normalize();

            // get <channel>
            NodeList list = doc.getElementsByTagName("item");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // get text
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String link = element.getElementsByTagName("link").item(0).getTextContent();
                    String description = element.getElementsByTagName("description").item(0).getTextContent();
                    String pubDate = element.getElementsByTagName("pubDate").item(0).getTextContent();

                    System.out.println("Title : " + title);
                    System.out.println("Link : " + link);
                    System.out.println("Description : " + description);
                    System.out.println("Publication date : " + pubDate);
                    tempArray.add(new newsItem(title, link, description, pubDate));
                }
            }
            return tempArray;

            } catch (ParserConfigurationException | SAXException | IOException e)
            {
                e.printStackTrace();
            }
            return null;
    }
}
