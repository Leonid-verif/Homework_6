package test.java.Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;



public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By searchInput = By.id("twotabsearchtextbox");
    By searchInputGo = By.id("nav-search-submit-text");
    private Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10, 500);

    }

    public HomePage open() {
        logger.info("Open Home page");
        driver.get("https://www.amazon.com/");
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        return this;

    }
    public HomePage clickSearch() {
        logger.info("Click Search");
        driver.findElement(searchInput).click();
        return this;
    }

    public HomePage typeSearch() {
        logger.info("Type Search");
        driver.findElement(searchInput).sendKeys("laptop");
        wait.until(ExpectedConditions.elementToBeClickable(searchInputGo));
        return this;
    }


    public HomePage clickSearchGo() {
        logger.info("Click SearchGo");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")));

        return this;
    }

    public HomePage clickSeeMore () {
        logger.info("Click SeeMore");
        driver.findElement(By.xpath("//div[@id=\"brandsRefinements\"]//span[@class=\"a-expander-prompt\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"brandsRefinements\"]//span[@class=\"a-expander-prompt\"]")));

        return this;
    }

    public HomePage clickBrand (String value) {
        logger.info("Click Brand");
        driver.findElement(By.xpath(value)).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]")));

        int sizev =  wait.until(driver1 -> driver1.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]")).size());
//        wait.until(driver1 -> driver1.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]")).size() == sizev);
        System.out.println("Размер массива: " + sizev);
        return this;
    }



}

