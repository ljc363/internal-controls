package io.internal.modules.sys.service;



import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysPostEntity;

import java.util.Map;

/**
 * 岗位管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-10 16:07:24
 */
public interface SysPostService extends IService<SysPostEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

