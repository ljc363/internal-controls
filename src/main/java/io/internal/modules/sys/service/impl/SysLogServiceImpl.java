

package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.common.utils.Query;
import io.internal.modules.sys.dao.SysLogDao;
import io.internal.modules.sys.entity.SysLogEntity;
import io.internal.modules.sys.service.SysLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String)params.get("key");

        IPage<SysLogEntity> page = this.page(
            new Query<SysLogEntity>().getPage(params),
            Wrappers .<SysLogEntity>lambdaQuery()
                    .like(StringUtils.isNotBlank(key),SysLogEntity::getUsername, String.format("%%%s%%",key))
                    .orderByDesc(SysLogEntity::getId)
        );

        return new PageUtils(page);
    }
}
