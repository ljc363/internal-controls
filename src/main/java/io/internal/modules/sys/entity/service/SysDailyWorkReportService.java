package io.internal.modules.sys.entity.service;



import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysDailyWorkReportEntity;

import java.util.Map;

/**
 * 工作日报
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 15:13:58
 */
public interface SysDailyWorkReportService extends IService<SysDailyWorkReportEntity> {

    PageUtils queryPage(Map<String, Object> params);

    boolean saveSysDailyWorkReport(SysDailyWorkReportEntity dailyWorkReport);

    boolean update(SysDailyWorkReportEntity dailyWorkReport);

    boolean deleteBatch(Long[] Ids);
}

