import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Scraper {

    /// PRIVATE FIELDS
    private final WebDriver driver;
    private final Properties props;

    // STATIC METHODS
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
    }

    /// CONSTRUCTOR
    public Scraper(Properties properties){
        driver = new ChromeDriver();
        props = properties;
    }

    /// PRIVATE METHODS
    private WebElement findElementWithTimeout(String cssSelector, int timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        return driver.findElement(By.cssSelector(cssSelector));
    }

    private void typeSlow(WebElement element, String text){
        for(int i=0; i<text.length(); i++){
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element.sendKeys(""+text.charAt(i));
        }
    }

    private void removeCookiePopup(){
        driver.findElement(By.id("qc-cmp2-ui")).findElements(By.cssSelector("button[mode=\"primary\"]")).get(1).click();
    }

    private void scrapePage(){

    }

    private void login(){
        driver.navigate().to("https://www.stampworld.com");

        removeCookiePopup();

        // Proceed to login
        var signInBtn = driver.findElement(By.id("signIn"));
        signInBtn.click();
        var usernameElement = findElementWithTimeout("#username", 5);
        var passwordElement = findElementWithTimeout("#password", 5);
        typeSlow(usernameElement, props.getProperty("username"));
        typeSlow(passwordElement, props.getProperty("password"));
        var loginBtn = findElementWithTimeout("#loginBtn", 5);
        loginBtn.click();

    }

    /// PUBLIC METHODS
    public void scrape(){
        login();

        driver.close();
    }

    ///MAIN ENTRYPOINT
    public static void main(String[] args){
        Properties props = new Properties();
        try {
            props.loadFromXML(new FileInputStream("settings.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scraper.setupWebdriverChromeDriver();
        new Scraper(props).scrape();
    }
}
