package io.internal.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 任务计划表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 10:55:24
 */
@Mapper
public interface SysTaskScheduleDao extends BaseMapper<SysTaskScheduleEntity> {

    List<SysTaskScheduleEntity>list();

   SysTaskScheduleEntity personInCharge ( String personInCharge);


}
