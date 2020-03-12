package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.common.utils.Query;
import io.internal.modules.sys.dao.SysProjectMilepostDao;
import io.internal.modules.sys.dao.SysTaskScheduleDao;
import io.internal.modules.sys.entity.SysProjectMEntity;
import io.internal.modules.sys.entity.SysProjectMilepostEntity;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;
import io.internal.modules.sys.entity.SysUserEntity;
import io.internal.modules.sys.service.SysProjectMService;
import io.internal.modules.sys.service.SysProjectMilepostService;
import io.internal.modules.sys.service.SysTaskScheduleService;
import io.internal.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("SysProjectMilepostService")
public class SysProjectMilepostServiceImpl extends ServiceImpl<SysProjectMilepostDao, SysProjectMilepostEntity> implements SysProjectMilepostService {

    @Autowired
    private SysProjectMService sysProjectMService;
    @Autowired
    private SysUserService sysUserService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String personInCharge = (String)params.get("personInCharge");
        IPage<SysProjectMilepostEntity> page = this.page(
                new Query<SysProjectMilepostEntity>().getPage(params),
                new QueryWrapper<SysProjectMilepostEntity>()
                .like(StringUtils.isNotBlank(personInCharge),"person_in_charge",personInCharge)
        );
        return new PageUtils(page);
    }

}