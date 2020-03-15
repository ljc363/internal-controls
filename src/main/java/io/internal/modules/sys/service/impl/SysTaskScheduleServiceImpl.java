package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.omg.CORBA.ContextIdSeqHelper;
import io.internal.common.utils.PageUtils;
import io.internal.common.utils.Query;
import io.internal.modules.sys.dao.SysTaskScheduleDao;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;
import io.internal.modules.sys.entity.SysUserEntity;
import io.internal.modules.sys.service.SysTaskScheduleService;
import io.internal.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.ContentHandler;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;


@Service("sysTaskScheduleService")
public class SysTaskScheduleServiceImpl extends ServiceImpl<SysTaskScheduleDao, SysTaskScheduleEntity> implements SysTaskScheduleService {

  @Autowired
  private SysUserService sysUserService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String projectName = (String)params.get("projectName");
        String taskName = (String)params.get("taskName");
        String personInCharge = (String)params.get("personInCharge");
        String status = (String)params.get("status");
        IPage<SysTaskScheduleEntity> page = this.page(
                new Query<SysTaskScheduleEntity>().getPage(params),
                Wrappers.<SysTaskScheduleEntity>lambdaQuery()
                .like(StringUtils.isNotBlank(status), SysTaskScheduleEntity::getStatus,String.format("%%%s%%",status))
                .like(StringUtils.isNotBlank(projectName), SysTaskScheduleEntity::getProjectName,String.format("%%%s%%",projectName))
                .like(StringUtils.isNotBlank(taskName), SysTaskScheduleEntity::getTaskName,String.format("%%%s%%",taskName))
                .orderByAsc(SysTaskScheduleEntity::getTaskPriority)
        );
          for (SysTaskScheduleEntity taskSchedule : page.getRecords()){
              SysUserEntity sysUserEntity = sysUserService.getById(taskSchedule.getUserId());
              taskSchedule.setPersonInCharge(sysUserEntity.getRealName());
          }
        return new PageUtils(page);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        this.removeByIds(Arrays.asList(ids));
    }

   @Override
    public SysTaskScheduleEntity personInCharge(String personInCharge) {
        return baseMapper.personInCharge(personInCharge);
    }

    @Override
    public PageUtils queryPage1(Map<String, Object> params) {
        String projectName = (String)params.get("projectName");
        String taskName = (String)params.get("taskName");
        String status = (String)params.get("status");
        IPage<SysTaskScheduleEntity> page = this.page(
                new Query<SysTaskScheduleEntity>().getPage(params),
                Wrappers.<SysTaskScheduleEntity>lambdaQuery()
                .ne(SysTaskScheduleEntity::getStatus,2)
                .like(StringUtils.isNotBlank(status), SysTaskScheduleEntity::getStatus,String.format("%%%s%%",status))
                .like(StringUtils.isNotBlank(taskName), SysTaskScheduleEntity::getTaskName,String.format("%%%s%%",taskName))
                .like(StringUtils.isNotBlank(projectName),SysTaskScheduleEntity::getProjectName,String.format("%%%s%%",projectName))
                .orderByAsc(SysTaskScheduleEntity::getTaskPriority)
        );
        for (SysTaskScheduleEntity taskSchedule : page.getRecords()){
            SysUserEntity sysUserEntity = sysUserService.getById(taskSchedule.getUserId());
            taskSchedule.setPersonInCharge(sysUserEntity.getRealName());
        }
        return new PageUtils(page);
    }

}