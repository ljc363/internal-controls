package io.internal.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.internal.common.validator.group.AddGroup;
import io.internal.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_project_milepost")
public class SysProjectMilepostEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long Id;
    /**
     * 所属项目
     */
    @NotNull(message="所属项目不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String itemsUnderIt;
    /**
     * 内容
     */
    private String content;
    /**
     * 负责人
     */
    @NotNull(message="负责人不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String personInCharge;
    /**
     * 计划开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date plannedStartTime;
    /**
     * 计划结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date plannedEndTime;
    /**
     * 实际结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date actualEndTime;
    /**
     * 实际开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date actualStartTime;
    /**
     * 进度
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
