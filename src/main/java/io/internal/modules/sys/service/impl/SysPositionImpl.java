package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.annotation.DataFilter;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysPositionDao;
import io.internal.modules.sys.entity.SysPositionEntity;
import io.internal.modules.sys.service.SysPositionService;
import org.springframework.stereotype.Service;
import io.internal.common.utils.Query;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("sysPositionService")
public class SysPositionImpl extends ServiceImpl<SysPositionDao, SysPositionEntity> implements SysPositionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        IPage<SysPositionEntity> page = this.page(
                new Query<SysPositionEntity>().getPage(params),
                Wrappers.<SysPositionEntity>lambdaQuery()
                .orderByAsc(SysPositionEntity::getOrderNum)
        );
        return new PageUtils(page);
    }


}
