package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysProjectMDao;
import io.internal.modules.sys.entity.SysProjectMEntity;
import io.internal.modules.sys.service.SysProjectMService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import io.internal.common.utils.Query;


@Service("sysProjectMService")
public class SysProjectMServiceImpl extends ServiceImpl<SysProjectMDao, SysProjectMEntity> implements SysProjectMService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String projectName = (String)params.get("projectName"); //项目名称
        String number = (String)params.get("number");//项目编号
        String personInCharge = (String) params.get("personInCharge");
        IPage<SysProjectMEntity> page = this.page(
                new Query<SysProjectMEntity>().getPage(params),
                new QueryWrapper<SysProjectMEntity>()
                        .like(StringUtils.isNotBlank(projectName),"project_name",projectName)
                        .like(StringUtils.isNotBlank(number),"number",number)
                        .like(StringUtils.isNotBlank(personInCharge),"person_in_charge",personInCharge)
                        .orderByDesc(number)
        );
        return new PageUtils(page);
    }

    @Override
    public boolean deleteBatch(Long[] ids) {
        return this.removeByIds(Arrays.asList(ids));
    }

    @Override
    public boolean updateByIds(SysProjectMEntity sysProjectMEntity) {
        return this.updateById(sysProjectMEntity);
    }
}