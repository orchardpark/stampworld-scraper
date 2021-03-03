import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Scraper {

    /// PRIVATE FIELDS
    private WebDriver driver;

    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
    }

    /// CONSTRUCTOR
    public Scraper(){
        driver = new ChromeDriver();
    }

    /// PUBLIC METHODS
    public void scrape(){
        try {
            driver.navigate().to(new URL("www.google.com"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    ///MAIN ENTRYPOINT
    public static void main(String[] args){
        Scraper.setupWebdriverChromeDriver();
        new Scraper().scrape();
    }
}
