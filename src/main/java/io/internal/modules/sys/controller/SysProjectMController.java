package io.internal.modules.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.internal.common.utils.PageUtils;
import io.internal.common.utils.R;
import io.internal.modules.sys.entity.SysProjectMEntity;
import io.internal.modules.sys.entity.SysUserEntity;
import io.internal.modules.sys.service.SysProjectMService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 项目记录
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 11:23:13
 */
@RestController
@RequestMapping("sys/projectM")
public class SysProjectMController {
    @Autowired
    private SysProjectMService sysProjectMService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:projectM:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysProjectMService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("sys:projectM:info")
    public R info(@PathVariable("id") Long id){
		SysProjectMEntity ProjectM = sysProjectMService.getById(id);

        return R.ok().put("projectM", ProjectM);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:projectM:save")
    public R save(@RequestBody SysProjectMEntity sysProjectM){
		sysProjectMService.save(sysProjectM);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:projectM:update")
    public R update(@RequestBody SysProjectMEntity sysProjectM){
		sysProjectMService.updateByIds(sysProjectM);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:projectM:delete")
    public R delete(@RequestBody Long[] ids){
		sysProjectMService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 项目列表
     */
    @GetMapping("/select")
    @RequiresPermissions("sys:projectM:select")
    public R select(){
        Map<String, Object> map = new HashMap<>();
        List<SysProjectMEntity> list = (List<SysProjectMEntity>) sysProjectMService.listByMap(map);
        return R.ok().put("list", list);
    }
}
