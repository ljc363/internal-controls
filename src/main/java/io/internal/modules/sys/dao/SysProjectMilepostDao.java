package io.internal.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.internal.modules.sys.entity.SysProjectMilepostEntity;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 项目里程碑
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 10:55:24
 */
@Mapper
public interface SysProjectMilepostDao extends BaseMapper<SysProjectMilepostEntity> {


}
