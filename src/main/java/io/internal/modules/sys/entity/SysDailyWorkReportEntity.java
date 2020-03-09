package io.internal.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 工作日报
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 15:13:58
 */
@Data
@TableName("sys_daily_work_report")
public class SysDailyWorkReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 完成的工作
	 */
	private String workDoneToday;
	/**
	 * 未完成的工作
	 */
	private String unfinishedWork;
	/**
	 * 协调工作
	 */
	private String coordinate;
	/**
	 * 提交时间
	 */
	private Date submissionTime;
	/**
	 * 提交人
	 */
	private String submitter;
	/**
	 * 备注
	 */
	private String remarks;

}
