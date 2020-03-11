package io.internal.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.internal.modules.sys.entity.SysUserPostEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户与岗位对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-10 16:07:24
 */
@Mapper
public interface SysUserPostDao extends BaseMapper<SysUserPostEntity> {
    /**
     * 根据用户ID，获取岗位ID列表
     */
    List<Long> queryPostIdList(Long userId);

    /**
     * 根据角色ID数组，批量删除
     */
    int deleteBatch(Long[] postIds);

}
