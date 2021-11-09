package xml;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        ReadXmlDomParser newDomParse = new ReadXmlDomParser();
        newDomParse.rssParseTables();
    }
}
