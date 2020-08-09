package com.huawei.entiy;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer Version;

    @TableLogic
    private Integer deleted;  //是否逻辑删除

}
