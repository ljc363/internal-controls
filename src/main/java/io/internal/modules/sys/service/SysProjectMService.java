package io.internal.modules.sys.service;



import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysProjectMEntity;


import java.util.Map;

/**
 * 项目记录
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 11:23:13
 */
public interface SysProjectMService extends IService<SysProjectMEntity> {

    PageUtils queryPage(Map<String, Object> params);

    boolean deleteBatch(Long [] ids);

    boolean updateByIds(SysProjectMEntity sysProjectMEntity);

}

