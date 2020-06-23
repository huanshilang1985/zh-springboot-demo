package com.zh.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author he.zhang
 * @date 2020/4/21 20:40
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getUser() {
        try {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < 10000; i++){
                Thread.sleep(100);
                list.add("aaaaa");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "用户查询";
    }
}
