package com.soft1851.spring.annotation_web.spider;


import com.soft1851.spring.annotation_web.entity.Rank;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BiliBiliSpider
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/27 3:15 下午
 * @Version 1.0
 **/
public class BiliBiliSpider {
    private static final Integer SUCCESS = 200;

    public static List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();


        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36";
        String url = "https://www.bilibili.com/ranking?spm_id_from=333.851.b_7072696d61727950616765546162.3";
        CloseableHttpClient httpResponse = HttpClients.createDefault();

        try {
            System.setProperty("webdriver.chrome.driver", "/Users/xiaobinggan/chromedriver/chromedriver");
            HttpGet get = new HttpGet(url);
            get.setHeader("User-Agent", userAgent);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpResponse.execute(get, context);
            int statusCode = response.getStatusLine().getStatusCode();

            WebDriver driver = new ChromeDriver();
            driver.get(url);
            Thread.sleep(2000);

            Actions actions = new Actions(driver);
            for (int i = 0; i < 20; i++) {
                Thread.sleep(500);
                actions.sendKeys(Keys.PAGE_DOWN).perform();
            }

            if (statusCode == SUCCESS) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
//                    String res = EntityUtils.toString(entity);
                    String res = driver.getPageSource();
                    Document document = Jsoup.parse(res);
                    //通过JS获取JSON数据
//                    Elements scripts = document.getElementsByTag("script");
//                    String wholeData = scripts.get(5).html();
//                    String data = wholeData.substring(wholeData.indexOf("rankList") + 10, wholeData.indexOf("rankRouteParams") - 2);
//                    JSONArray jsonArray = JSONArray.parseArray(data);
//                    jsonArray.forEach(o -> {
//                        JSONObject jsonObject = JSONObject.parseObject(o.toString());
//                        Rank rank = Rank.builder()
//                                .title(jsonObject.getString("title"))
//                                .cover(jsonObject.getString("pic"))
//                                .build();
//                        ranks.add(rank);
//                    });
                    Elements elements = document.getElementsByClass("rank-item");

                    for (Element element : elements) {
                        String num = element.child(0).text();
                        Element contentEle = element.child(1);
                        String title = contentEle.select(".title").text();
                        Elements img = contentEle.select(".lazy-img img");
                        String cover = img.attr("src");
                        Rank rank = Rank.builder().id(num).title(title).cover(cover).build();
                        ranks.add(rank);
                    }
                }
            }
            try {
                response.close();
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return ranks;
    }

    public static void main(String[] args) {
        getRanks().forEach(System.out::println);
    }
}
