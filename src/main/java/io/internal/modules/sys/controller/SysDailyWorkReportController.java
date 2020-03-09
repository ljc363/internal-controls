package io.internal.modules.sys.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.internal.common.utils.PageUtils;
import io.internal.common.utils.R;
import io.internal.modules.sys.entity.SysDailyWorkReportEntity;
import io.internal.modules.sys.entity.service.SysDailyWorkReportService;
import io.internal.modules.sys.entity.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





/**
 * 工作日报
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 15:13:58
 */
@RestController
@RequestMapping("sys/dailyWorkReport")
public class SysDailyWorkReportController extends AbstractController{
    @Autowired
    private SysDailyWorkReportService sysDailyWorkReportService;

    @Autowired
    private SysUserService sysUserService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:dailyWorkReport:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDailyWorkReportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:dailyWorkReport:info")
    public R info(@PathVariable("id") Long id){
		SysDailyWorkReportEntity sysDailyWorkReport = sysDailyWorkReportService.getById(id);

        return R.ok().put("dailyWorkReport", sysDailyWorkReport);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:dailyWorkReport:save")
    public R save(@RequestBody SysDailyWorkReportEntity sysDailyWorkReport){
        sysDailyWorkReport.setSubmissionTime(new Date());
        sysDailyWorkReport.setSubmitter( sysUserService.getById(getUserId()).getUsername());
        sysDailyWorkReportService.save(sysDailyWorkReport);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:dailyWorkReport:update")
    public R update(@RequestBody SysDailyWorkReportEntity sysDailyWorkReport){
		sysDailyWorkReportService.updateById(sysDailyWorkReport);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dailyWorkReport:delete")
    public R delete(@RequestBody Long[] ids){
		sysDailyWorkReportService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
