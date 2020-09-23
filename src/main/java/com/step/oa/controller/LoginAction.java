package com.step.oa.controller;

import com.step.utils.WrapMapper;
import com.step.utils.Wrapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-23.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@RestController("loginAction")
@RequestMapping("/login")
public class LoginAction {
    @PostMapping
    public Wrapper Login(){
        Map map = new HashMap<>();
        map.put("token","123456");
       return WrapMapper.ok(map);
    }
}
