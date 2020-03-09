package io.internal.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.internal.modules.sys.enums.PacesEnum;
import lombok.Data;

/**
 * 项目记录
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-06 11:23:13
 */
@Data
@TableName("sys_project_m")
public class SysProjectMEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 项目编号
	 */
	private String number;
	/**
	 * 负责人
	 */
	private String personInCharge;
	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
	private Date startsTime;
	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
	private Date endTime;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;

}
