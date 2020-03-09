package io.internal.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.internal.common.utils.PageUtils;
import io.internal.modules.sys.entity.SysPositionEntity;

import java.util.List;
import java.util.Map;

public interface SysPositionService extends IService<SysPositionEntity> {

    PageUtils queryPage(Map<String, Object> params);




}
