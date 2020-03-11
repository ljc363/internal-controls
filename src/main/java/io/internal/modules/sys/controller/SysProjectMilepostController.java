package io.internal.modules.sys.controller;

import io.internal.common.utils.PageUtils;
import io.internal.common.utils.R;
import io.internal.modules.sys.entity.SysProjectMilepostEntity;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;
import io.internal.modules.sys.service.SysProjectMilepostService;
import io.internal.modules.sys.service.SysTaskScheduleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 项目里程碑
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 10:55:24
 */
@RestController
@RequestMapping("sys/projectMilepost")
public class SysProjectMilepostController {
    @Autowired
    private SysProjectMilepostService sysProjectMilepostService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:projectMilepost:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysProjectMilepostService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:projectMilepost:info")
    public R info(@PathVariable("id") Long id){
        SysProjectMilepostEntity sysProjectMilepost = sysProjectMilepostService.getById(id);

        return R.ok().put("projectMilepost", sysProjectMilepost);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:projectMilepost:save")
    public R save(@RequestBody SysProjectMilepostEntity sysProjectMilepost){
        sysProjectMilepostService.save(sysProjectMilepost);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:projectMilepost:update")
    public R update(@RequestBody SysProjectMilepostEntity sysProjectMilepost){
		sysProjectMilepostService.updateById(sysProjectMilepost);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:projectMilepost:delete")
    public R delete(@RequestBody Long[] ids){
		sysProjectMilepostService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
