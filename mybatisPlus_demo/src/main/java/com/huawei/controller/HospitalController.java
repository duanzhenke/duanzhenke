package com.huawei.controller;


import cn.hutool.core.bean.BeanUtil;
import com.huawei.domain.Hospital;
import com.huawei.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dzk
 * @since 2020-07-19
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private IHospitalService hospitalService;

    @GetMapping("test")
    public int test() {
        int count = hospitalService.count();
        System.out.println(count);
        return count;
    }

    @GetMapping("hello")
    public String hello() {
        return "测试swagger2 生成前后段的文档数据";
    }

    @PostMapping ("getHospital")
    public Hospital getHospital() {  
        return new Hospital();
    }
}

