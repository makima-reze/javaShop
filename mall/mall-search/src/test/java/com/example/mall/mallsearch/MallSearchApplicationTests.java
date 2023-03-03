package com.example.mall.mallsearch;


import com.alibaba.fastjson.JSON;
import com.example.mall.mallsearch.config.ElasticSearchConfig;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallSearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void indexData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("user");
        indexRequest.id("1");
        User user = new User();
        user.setAge(18);
        user.setGender("男");
        user.setUserName("zhangsan");
        String string = JSON.toJSONString(user);
        indexRequest.source(string, XContentType.JSON);
        IndexResponse index = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);

    }

    @Data
    class User{
        private String userName;
        private String gender;
        private Integer age;
    }

    @Test
    public void contextLoads() {
        System.out.println(client);

    }

}
