package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysTaskScheduleDao;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;
import io.internal.modules.sys.entity.SysUserEntity;
import io.internal.modules.sys.service.SysTaskScheduleService;
import io.internal.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import io.internal.common.utils.Query;

import javax.annotation.Resource;

@Service("sysTaskScheduleService")
public class SysTaskScheduleServiceImpl extends ServiceImpl<SysTaskScheduleDao, SysTaskScheduleEntity> implements SysTaskScheduleService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String projectName = (String)params.get("projectName");
        String taskName = (String)params.get("taskName");
        IPage<SysTaskScheduleEntity> page = this.page(
                new Query<SysTaskScheduleEntity>().getPage(params),
                new QueryWrapper<SysTaskScheduleEntity>()
                .like(StringUtils.isNotBlank(projectName),"project_name",projectName)
                .like(StringUtils.isNotBlank(taskName),"task_name",taskName)
        );
          for (SysTaskScheduleEntity taskSchedule :page.getRecords()){
              SysUserEntity sysUserEntity = sysUserService.getById(taskSchedule.getUserId());
              taskSchedule.setPersonInCharge(sysUserEntity.getRealName());
          }
        return new PageUtils(page);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        this.removeByIds(Arrays.asList(ids));
    }
}