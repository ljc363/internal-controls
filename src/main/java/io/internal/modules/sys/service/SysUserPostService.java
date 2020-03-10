package io.internal.modules.sys.service;

;

import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysUserPostEntity;

import java.util.Map;

/**
 * 用户与岗位对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-10 16:07:24
 */
public interface SysUserPostService extends IService<SysUserPostEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

