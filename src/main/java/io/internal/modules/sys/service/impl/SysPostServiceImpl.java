package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysPostDao;
import io.internal.modules.sys.entity.SysPostEntity;
import io.internal.modules.sys.service.SysPostService;
import org.springframework.stereotype.Service;
import java.util.Map;
import io.internal.common.utils.Query;


@Service("sysPostService")
public class SysPostServiceImpl extends ServiceImpl<SysPostDao, SysPostEntity> implements SysPostService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysPostEntity> page = this.page(
                new Query<SysPostEntity>().getPage(params),
                new QueryWrapper<SysPostEntity>()
        );

        return new PageUtils(page);
    }

}