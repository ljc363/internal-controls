package io.internal.modules.sys.entity.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysWeeklyWorkReportDao;
import io.internal.modules.sys.entity.SysWeeklyWorkReportEntity;
import io.internal.modules.sys.entity.service.SysWeeklyWorkReportService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import io.internal.common.utils.Query;

@Service("sysWeeklyWorkReportService")
public class SysWeeklyWorkReportServiceImpl extends ServiceImpl<SysWeeklyWorkReportDao, SysWeeklyWorkReportEntity> implements SysWeeklyWorkReportService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String submitter = (String)params.get("submitter");
        IPage<SysWeeklyWorkReportEntity> page = this.page(
                new Query<SysWeeklyWorkReportEntity>().getPage(params),
                new QueryWrapper<SysWeeklyWorkReportEntity>()
                .like(StringUtils.isBlank(submitter),"submitter",submitter)
        );
        return new PageUtils(page);
    }

    @Override
    public boolean saveWeeklyWorkReport(SysWeeklyWorkReportEntity weeklyWorkReport) {
        weeklyWorkReport.setSubmissionTime(new DateTime());
        return this.save(weeklyWorkReport);
    }

    @Override
    public boolean update(SysWeeklyWorkReportEntity weeklyWorkReport) {
        return this.updateById(weeklyWorkReport);
    }

    @Override
    public boolean deleteBatch(Long[] Ids) {
        return this.removeByIds(Arrays.asList(Ids));
    }
}