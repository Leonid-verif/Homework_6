package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.Pages.HomePage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TestDP extends TestSetup {
    HomePage homePage;
    WebDriverWait wait;
    By iPhoneListBy = By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]");


    @BeforeMethod
    public void pageInitilize() {
        homePage = new HomePage(driver);
        homePage
                .open()
                .clickSearch()
                .typeSearch()
                .clickSearchGo()
                .clickSeeMore();
    }

    @Test ( dataProvider = "dp")
    public void test_search_laptop(String brand, String value ) throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.clickBrand(value);

        int counter = 0 ;
         List<WebElement> hpList = driver.findElements(iPhoneListBy);
        for (WebElement el : hpList) {
            el.getText();
            counter = counter + 1;
            System.out.println(el.getText());
            System.out.println(counter);
            assertTrue(el.getText().toLowerCase().contains(brand),"Ожидаемый результат: строка содержит - " + brand);
        }
    }


    @DataProvider(name = "dp")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"hp","//li[@id=\"p_89/HP\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"acer","//li[@id=\"p_89/Acer\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"asus","//li[@id=\"p_89/ASUS\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"lenovo","//li[@id=\"p_89/Lenovo\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"dell","//li[@id=\"p_89/Dell\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"microsoft","//li[@id=\"p_89/Microsoft\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"apple","//li[@id=\"p_89/Apple\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"chuwi","//li[@id=\"p_89/CHUWI\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"lg","//li[@id=\"p_89/LG\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"jumper","//li[@id=\"p_89/jumper\"]//i[@class=\"a-icon a-icon-checkbox\"]"},

        };
    }

}
