package io.internal.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysProjectMilepostEntity;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;

import java.util.Map;

/**
 * 项目里程碑
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 10:55:24
 */
public interface SysProjectMilepostService extends IService<SysProjectMilepostEntity> {


    PageUtils queryPage(Map<String, Object> params);


}

