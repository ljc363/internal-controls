package io.internal.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.internal.common.utils.MapUtils;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.dao.SysUserPostDao;
import io.internal.modules.sys.entity.SysUserPostEntity;
import io.internal.modules.sys.service.SysUserPostService;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public void saveOrUpdate(Long userId, List<Long> postIdList) {
        //先删除用户与角色关系
        this.removeByMap(new MapUtils().put("user_id", userId));

        if(postIdList == null || postIdList.size() == 0){
            return ;
        }

        //保存用户与角色关系
        for(Long postId : postIdList){
            SysUserPostEntity sysUserPostEntity = new SysUserPostEntity();
            sysUserPostEntity.setUserId(userId);
            sysUserPostEntity.setPostId(postId);

            this.save(sysUserPostEntity);
        }
    }

    @Override
    public List<Long> queryPostIdList(Long userId) {
        return baseMapper.queryPostIdList(userId);
    }

    @Override
    public int deleteBatch(Long[] postIds){
        return baseMapper.deleteBatch(postIds);
    }

}