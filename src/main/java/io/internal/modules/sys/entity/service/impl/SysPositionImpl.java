package io.internal.modules.sys.entity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysPositionDao;
import io.internal.modules.sys.entity.SysPositionEntity;
import io.internal.modules.sys.entity.service.SysPositionService;
import org.springframework.stereotype.Service;
import io.internal.common.utils.Query;


import java.util.Map;

@Service("sysPositionService")
public class SysPositionImpl extends ServiceImpl<SysPositionDao, SysPositionEntity> implements SysPositionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String orderNum =(String)params.get("orderNum");
        String delFlag =(String)params.get("delFlag");

        IPage<SysPositionEntity> page = this.page(
                new Query<SysPositionEntity>().getPage(params),
                new QueryWrapper<SysPositionEntity>()
                .orderByDesc(orderNum)
        );
        return new PageUtils(page);
    }

}
