package io.internal.modules.sys.entity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysTaskScheduleDao;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;
import io.internal.modules.sys.entity.service.SysTaskScheduleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import io.internal.common.utils.Query;

@Service("sysTaskScheduleService")
public class SysTaskScheduleServiceImpl extends ServiceImpl<SysTaskScheduleDao, SysTaskScheduleEntity> implements SysTaskScheduleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String projectName = (String)params.get("projectName");
        String taskName = (String)params.get("taskName");
        IPage<SysTaskScheduleEntity> page = this.page(
                new Query<SysTaskScheduleEntity>().getPage(params),
                new QueryWrapper<SysTaskScheduleEntity>()
                .like(StringUtils.isNotBlank(projectName),"projectName",projectName)
                .like(StringUtils.isNotBlank(taskName),"taskName",taskName)

        );

        return new PageUtils(page);
    }

}