package io.internal.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;

import java.util.Map;

/**
 * 任务计划表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 10:55:24
 */
public interface SysTaskScheduleService extends IService<SysTaskScheduleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

