package io.internal.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.internal.modules.sys.entity.SysUserPostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与岗位对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-10 16:07:24
 */
@Mapper
public interface SysUserPostDao extends BaseMapper<SysUserPostEntity> {
	
}
