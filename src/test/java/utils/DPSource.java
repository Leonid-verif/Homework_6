package test.java.utils;

import org.testng.annotations.DataProvider;

public class DPSource {
    @DataProvider
    public Object[][] smoke(){
        return new Object[][]{
                {"acer","//li[@id=\"p_89/Acer\"]//i[@class=\"a-icon a-icon-checkbox\"]"},
                {"hp","//li[@id=\"p_89/HP\"]//i[@class=\"a-icon a-icon-checkbox1\"]"},
        };
    };
}
