package io.internal.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.internal.modules.sys.entity.SysPostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 岗位管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-10 16:07:24
 */
@Mapper
public interface SysPostDao extends BaseMapper<SysPostEntity> {
	
}
