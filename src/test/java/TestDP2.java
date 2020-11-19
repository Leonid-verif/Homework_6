package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.Pages.HomePage;
import test.java.utils.DPAnnotationTransformer;
import test.java.utils.DPSource;
import test.java.utils.RetryAnalyzer;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TestDP2 extends TestSetup {
    HomePage homePage;
    WebDriverWait wait;
    By laptopListBy = By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]");


    @BeforeMethod
    public void pageInitilize() {
        homePage = new HomePage(driver);
        homePage
                .open()
//                .clkDontChange()
                .clickSearch()
                .typeSearch()
                .clickSearchGo()
                .clickSeeMore();
    }

//    @Test ( dataProvider = "dp", retryAnalyzer = RetryAnalyzer.class)
    @Test ( dataProvider = "dp" ,retryAnalyzer = RetryAnalyzer.class)
    public void test_search_laptop(String brand, String value ) throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.clickBrand(value);

        int counter = 0 ;
        List<WebElement> noteList = driver.findElements(laptopListBy);
        for (WebElement el : noteList) {
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
        };
    }

}
