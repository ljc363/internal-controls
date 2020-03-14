package io.internal.modules.sys.controller;

import io.internal.common.utils.Constant;
import io.internal.common.utils.PageUtils;
import io.internal.common.utils.R;
import io.internal.modules.sys.entity.SysTaskScheduleEntity;
import io.internal.modules.sys.entity.SysUserEntity;
import io.internal.modules.sys.service.SysTaskScheduleService;
import io.internal.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;





/**
 * 任务计划表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 10:55:24
 */
@RestController
@RequestMapping("sys/taskSchedule")
public class SysTaskScheduleController extends AbstractController{
    @Autowired
    private SysTaskScheduleService sysTaskScheduleService;
    @Autowired
    private SysUserService sysUserService;
    /**
     * 获取本人的任务列表
     */
    @RequestMapping("/ownList")
    public R ownList(@RequestParam Map<String, Object> params){
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("userId", getUserId());
        }
        PageUtils page = sysTaskScheduleService.queryPage1(params);
       return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:taskSchedule:list")
    public R list(@RequestParam Map<String, Object> params){

        PageUtils page = sysTaskScheduleService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:taskSchedule:info")
    public R info(@PathVariable("id") Long id){
		SysTaskScheduleEntity sysTaskSchedule = sysTaskScheduleService.getById(id);

        return R.ok().put("taskSchedule", sysTaskSchedule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:taskSchedule:save")
    public R save(@RequestBody SysTaskScheduleEntity sysTaskSchedule){
		sysTaskScheduleService.save(sysTaskSchedule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:taskSchedule:update")
    public R update(@RequestBody SysTaskScheduleEntity sysTaskSchedule){
		sysTaskScheduleService.updateById(sysTaskSchedule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:taskSchedule:delete")
    public R delete(@RequestBody Long[] ids){
		sysTaskScheduleService.deleteBatch(ids);
        return R.ok();
    }

}
