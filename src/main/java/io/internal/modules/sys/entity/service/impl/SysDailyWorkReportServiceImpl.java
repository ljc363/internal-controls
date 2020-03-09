package io.internal.modules.sys.entity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysDailyWorkReportDao;
import io.internal.modules.sys.entity.SysDailyWorkReportEntity;
import io.internal.modules.sys.entity.service.SysDailyWorkReportService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import io.internal.common.utils.Query;

@Service("sysDailyWorkReportService")
public class SysDailyWorkReportServiceImpl extends ServiceImpl<SysDailyWorkReportDao, SysDailyWorkReportEntity> implements SysDailyWorkReportService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String submitter = (String)params.get("submitter");
        IPage<SysDailyWorkReportEntity> page = this.page(
                new Query<SysDailyWorkReportEntity>().getPage(params),
                new QueryWrapper<SysDailyWorkReportEntity>()
                .like(StringUtils.isNotBlank(submitter),"submitter",submitter)
        );

        return new PageUtils(page);
    }

    @Override
    public boolean saveSysDailyWorkReport(SysDailyWorkReportEntity dailyWorkReport) {
        return this.save(dailyWorkReport);
    }

    @Override
    public boolean update(SysDailyWorkReportEntity dailyWorkReport) {
        return this.updateById(dailyWorkReport);
    }

    @Override
    public boolean deleteBatch(Long[] Ids) {
        return this.removeByIds(Arrays.asList(Ids));
    }
}