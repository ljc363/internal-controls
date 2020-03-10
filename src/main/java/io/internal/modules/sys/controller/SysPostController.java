package io.internal.modules.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.internal.common.utils.Constant;
import io.internal.common.utils.PageUtils;
import io.internal.common.utils.R;
import io.internal.modules.sys.entity.SysPostEntity;
import io.internal.modules.sys.entity.SysRoleEntity;
import io.internal.modules.sys.service.SysPostService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 岗位管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-10 16:07:24
 */
@RestController
@RequestMapping("sys/post")
public class SysPostController {
    @Autowired
    private SysPostService sysPostService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:post:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysPostService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{postId}")
    @RequiresPermissions("sys:post:info")
    public R info(@PathVariable("postId") Long postId){
		SysPostEntity sysPost = sysPostService.getById(postId);

        return R.ok().put("sysPost", sysPost);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:post:save")
    public R save(@RequestBody SysPostEntity sysPost){
		sysPostService.save(sysPost);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:post:update")
    public R update(@RequestBody SysPostEntity sysPost){
		sysPostService.updateById(sysPost);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:post:delete")
    public R delete(@RequestBody Long[] positionIds){
		sysPostService.removeByIds(Arrays.asList(positionIds));

        return R.ok();
    }


    /**
     * 岗位列表
     */
    @GetMapping("/select")
    @RequiresPermissions("sys:post:select")
    public R select(){
        Map<String, Object> map = new HashMap<>();

        /*//如果不是超级管理员，则只查询自己所拥有的角色列表
        if(getUserId() != Constant.SUPER_ADMIN){
            map.put("create_user_id", getUserId());
        }*/
        List<SysPostEntity> list = (List<SysPostEntity>) sysPostService.listByMap(map);

        return R.ok().put("list", list);
    }
}
