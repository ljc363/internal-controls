package io.internal.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.internal.modules.sys.entity.SysDailyWorkReportEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 工作日报
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 15:13:58
 */
@Mapper
public interface SysDailyWorkReportDao extends BaseMapper<SysDailyWorkReportEntity> {
	
}
