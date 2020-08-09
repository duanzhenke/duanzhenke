package com.huawei;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huawei.domain.Hospital;
import com.huawei.entiy.User;
import com.huawei.mapper.HospitalMapper;
import com.huawei.service.IHospitalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WapperTest {
    @Autowired
    private HospitalMapper hospitalMapper;
    @Autowired
    private IHospitalService hospitalService;

    // 条件构造器查询
    @Test
    public void test01() {
        QueryWrapper<Hospital> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("batch",19255);
        List<Hospital> hospitals = hospitalMapper.selectList(queryWrapper);
        System.out.println(hospitals);
    }
    @Test
    public void test(){
        int count = hospitalService.count();
        System.out.println(count);
    }

}
