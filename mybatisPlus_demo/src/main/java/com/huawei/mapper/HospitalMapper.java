package com.huawei.mapper;

import com.huawei.domain.Hospital;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dzk
 * @since 2020-07-19
 */
@Mapper // 代表持久层
public interface HospitalMapper extends BaseMapper<Hospital> {

}
