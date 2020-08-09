package com.huawei;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huawei.entiy.User;
import com.huawei.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void test02() {
        User user = new User();
        user.setUsername("dzktest02");
        user.setPassword("123456");
        int insert = userMapper.insert(user);
    }

    @Test
    public void test03() {
        User user = new User();
        user.setId(1l);
        user.setUsername("dzk6666666666");
        user.setPassword("123456");
        int insert = userMapper.updateById(user);

    }


    //测试乐观锁的成功  例子
    @Test
    public void test04() {
        User user = userMapper.selectById(1L);
        user.setUsername("段真科999");
        int i = userMapper.updateById(user);

    }


    //测试乐观锁的失败  例子
    @Test
    public void test05() {
        User user = userMapper.selectById(1L);
        user.setUsername("段真科999");
        //模拟另外一个线程插队的操作
        User user1 = userMapper.selectById(1L);
        user1.setUsername("段真科777777");
        int i = userMapper.updateById(user1);
        int t = userMapper.updateById(user);

    }

    @Test
    public void test06() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "dzk");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);

    }

    //测试分页查询
    @Test
    public void test07() {
        Page<User> userPage = new Page<>();
        IPage<User> userIPage = userMapper.selectPage(userPage, null);

        System.out.println(userIPage);
    }

    //测试逻辑删除数据
    @Test
    public void test08() {
        int i = userMapper.deleteById(1l);
    }
}


