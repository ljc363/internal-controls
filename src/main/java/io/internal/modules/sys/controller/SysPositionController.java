package io.internal.modules.sys.controller;

import io.internal.common.utils.PageUtils;
import io.internal.common.utils.R;
import io.internal.modules.sys.entity.SysPositionEntity;
import io.internal.modules.sys.entity.service.SysPositionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/sys/position")
public class SysPositionController extends AbstractController{

    @Resource
    private SysPositionService sysPositionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:position:list")
    public R list(@RequestParam Map<String, Object> params){
       PageUtils page = sysPositionService.queryPage(params);
        return R.ok().put("page",page);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{positionId}")
    @RequiresPermissions("sys:position:info")
    public R info(@PathVariable("positionId") Long positionId){
        SysPositionEntity position = sysPositionService.getById(positionId);
        return R.ok().put("position", position);
    }

    /**
     *保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:position:save")
    public R save(@RequestBody SysPositionEntity sysPosition){
        sysPositionService.save(sysPosition);
        return R.ok();
    }

    /**
     *删除
     */
    @RequestMapping(value ="/delete",method = RequestMethod.POST)
    @RequiresPermissions("sys:position:delete")
    public R delete(@RequestBody Long[] ids){

        sysPositionService.removeByIds(Arrays.asList(ids));
           return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:position:update")
    public R update(@RequestBody SysPositionEntity position){
        sysPositionService.updateById(position);
        return R.ok();
    }


}
