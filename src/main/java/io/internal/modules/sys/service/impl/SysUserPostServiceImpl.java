package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysUserPostDao;
import io.internal.modules.sys.entity.SysUserPostEntity;
import io.internal.modules.sys.service.SysUserPostService;
import org.springframework.stereotype.Service;
import java.util.Map;
import io.internal.common.utils.Query;


@Service("sysUserPostService")
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostDao, SysUserPostEntity> implements SysUserPostService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUserPostEntity> page = this.page(
                new Query<SysUserPostEntity>().getPage(params),
                new QueryWrapper<SysUserPostEntity>()
        );

        return new PageUtils(page);
    }

}