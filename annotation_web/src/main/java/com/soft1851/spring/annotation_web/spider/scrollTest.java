package com.soft1851.spring.annotation_web.spider;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @ClassName scrollTest
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/27 5:31 下午
 * @Version 1.0
 **/
public class scrollTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/xiaobinggan/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bilibili.com/ranking?spm_id_from=333.851.b_7072696d61727950616765546162.3");
        Thread.sleep(2000);
        /*
         * 方法一：利用Selenium里的Actions和Keys模拟键盘操作，从而控制页面滚动；
         */
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.HOME).perform();
        String s = driver.getPageSource();

    }
}
