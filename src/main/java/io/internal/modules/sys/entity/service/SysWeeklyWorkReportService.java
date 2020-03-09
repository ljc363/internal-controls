package io.internal.modules.sys.entity.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysWeeklyWorkReportEntity;

import java.util.Map;

/**
 * 工作周报
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 15:13:58
 */
public interface SysWeeklyWorkReportService extends IService<SysWeeklyWorkReportEntity> {

    PageUtils queryPage(Map<String, Object> params);

    boolean saveWeeklyWorkReport(SysWeeklyWorkReportEntity weeklyWorkReport);

    boolean update(SysWeeklyWorkReportEntity weeklyWorkReport);

    boolean deleteBatch(Long[] Ids);
}

