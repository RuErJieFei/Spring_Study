package com.soft1851.spring.annotation_web.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.annotation_web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JueJinSpider
 * @Description 使用HttpClient和JSoup实现的爬虫，爬取掘金的topic页面
 * @Author xiaobinggan
 * @Date 2020/3/27 1:05 下午
 * @Version 1.0
 **/
public class JueJinSpider {
    private static final Integer SUCCESS = 200;

    public static List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        //目标地址
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7d8c63f265da798e12924b&device_id=1585286243707&token=eyJhY2Nlc3NfdG9rZW4iOiI1eVhJVW1uR253Q0FST2tKIiwicmVmcmVzaF90b2tlbiI6IldLb0hta0VoUHptelBJNE8iLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        //创建context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //如果请求成功，则获取网页源码
        assert response != null;
        if (response.getStatusLine().getStatusCode() == SUCCESS) {
            //获取相应对象实体，并转成UTF-8字符串
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsObject = JSON.parseObject(res);
            JSONArray list = jsObject.getJSONObject("d").getJSONArray("list");
            list.forEach(o -> {
                JSONObject json = JSONObject.parseObject(o.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId"))
                        .topicName(json.getString("title"))
                        .topicIcon(json.getString("icon"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followsCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
                topics.add(topic);
            });
        } else {
            System.err.println("请求失败");
        }
        try {
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return topics;
    }

    public static void main(String[] args) {
        getTopics().forEach(System.out::println);
    }

}
