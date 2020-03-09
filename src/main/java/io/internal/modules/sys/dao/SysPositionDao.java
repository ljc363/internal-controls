package io.internal.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.internal.modules.sys.entity.SysPositionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 部门岗位管理
 */
@Mapper
public interface SysPositionDao extends BaseMapper<SysPositionEntity> {

 List<SysPositionEntity> queryList(Map<String,Object> params);

    /**
     * 查询岗位ID列表
     * @param parentId  部门ID
     */
    List<Long> queryPositionIdList(Long parentId);
}
