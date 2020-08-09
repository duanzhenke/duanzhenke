package com.huawei.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dzk
 * @since 2020-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Hospital implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 序号
     */
    @TableField("serial_Num")
    private String serialNum;

    /**
     * 日期
     */
    private String dateTime;

    /**
     * 测试卡
     */
    @TableField("testCard")
    private String testCard;

    /**
     * 批次
     */
    private String batch;

    /**
     * 姓名
     */
    private String name;

    /**
     * 备注医院
     */
    private String remark;


}
