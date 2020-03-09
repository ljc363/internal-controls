package io.internal.modules.sys.controller;

import java.util.Map;

import io.internal.common.utils.Constant;
import io.internal.common.utils.PageUtils;
import io.internal.common.utils.R;
import io.internal.modules.sys.entity.SysWeeklyWorkReportEntity;
import io.internal.modules.sys.service.SysUserService;
import io.internal.modules.sys.service.SysWeeklyWorkReportService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 工作周报
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 15:13:58
 */
@RestController
@RequestMapping("sys/weeklyWorkReport")
public class SysWeeklyWorkReportController extends AbstractController{
    @Autowired
    private SysWeeklyWorkReportService sysWeeklyWorkReportService;
    @Autowired
    private SysUserService sysUserService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:weeklyWorkReport:list")
    public R list(@RequestParam Map<String, Object> params){
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId",getUserId());
        }
        PageUtils page = sysWeeklyWorkReportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:weeklyWorkReport:info")
    public R info(@PathVariable("id") Long id){
		SysWeeklyWorkReportEntity sysWeeklyWorkReport = sysWeeklyWorkReportService.getById(id);
        return R.ok().put("weeklyWorkReport", sysWeeklyWorkReport);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:weeklyWorkReport:save")
    public R save(@RequestBody SysWeeklyWorkReportEntity sysWeeklyWorkReport){
        Long  userId  = getUserId();
        sysWeeklyWorkReport.setSubmitter( sysUserService.getById(userId).getUsername());
		sysWeeklyWorkReportService.saveWeeklyWorkReport(sysWeeklyWorkReport);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:weeklyWorkReport:update")
    public R update(@RequestBody SysWeeklyWorkReportEntity sysWeeklyWorkReport){
		sysWeeklyWorkReportService.update(sysWeeklyWorkReport);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:weeklyWorkReport:delete")
    public R delete(@RequestBody Long[] ids){
		sysWeeklyWorkReportService.deleteBatch(ids);

        return R.ok();
    }

}
