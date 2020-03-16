package io.internal.modules.sys.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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
    void deleteBatch(Long[] ids);



    PageUtils queryPage1(Map<String, Object> params);
}

