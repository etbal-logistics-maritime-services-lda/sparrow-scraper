import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scraper {
    private static final Logger LOGGER = Logger.getLogger(Scraper.class.getName());

    public Document fetchPage(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error fetching page: " + url, e);
            return null;
        }
    }

    public void scrapeData(String url) {
        Document doc = fetchPage(url);
        if (doc != null) {
            System.out.println(doc.title());
            // Additional scraping logic goes here
        } else {
            System.out.println("Failed to retrieve data from: " + url);
        }
    }
}
