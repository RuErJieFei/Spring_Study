package com.soft1851.spring.annotation_web.spider;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName JinDongSpider
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/28 9:25 上午
 * @Version 1.0
 **/
public class JinDongSpider {
    private static final Integer SUCCESS = 200;

    public static void getItems() {
        //模拟浏览器
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(600 * 1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = null;
        try {
            page = webClient.getPage("https://list.jd.com/list.html?cat=9987,653,655");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert page != null;
        List<HtmlDivision> divs = page.getByXPath("//*[@id=\"plist\"]/ul/li[1]");
        for (HtmlDivision div : divs) {
            DomNodeList<DomNode> children = div.getChildNodes();
            String name = "";
            String price = "";
            String comments = "";
            for (DomNode dn : children) {
                NamedNodeMap map = dn.getAttributes();
                Node node = map.getNamedItem("class");
                if (node != null) {
                    String value = node.getNodeValue();
                    if (value.contains("p-name")) {
                        name = dn.asText();
                    } else if (value.contains("p-name")) {
                        price = dn.asText();
                    } else if (value.contains("p-commit")) {
                        comments = dn.asText();
                    }
                }
            }
            System.out.println(name + "//" + price + "//" + comments);
        }
    }

    public static void main(String[] args) {
        getItems();
    }
}
