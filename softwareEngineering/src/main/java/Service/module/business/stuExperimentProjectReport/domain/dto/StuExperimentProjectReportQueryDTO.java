package Service.module.business.stuExperimentProjectReport.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 实验报告提交信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:21:27
 * @since JDK1.8
 */
@Data
public class StuExperimentProjectReportQueryDTO extends PageParamDTO {

    @ApiModelProperty("实验报告上传者学号")
    private Long id;

    @ApiModelProperty("实验项目编号")
    private Long projectId;

    @ApiModelProperty("实验项目名称")
    private String name;

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("班级编号")
    private Long classId;

    @ApiModelProperty("实验报告编号")
    private Long reportId;

    @ApiModelProperty("实验报告上传者姓名")
    private String reportUploaderName;

    @ApiModelProperty("报告截至时间")
    private Date deadline;

    @ApiModelProperty("是否完成")
    private String iffinish;

    @ApiModelProperty("实验目的")
    private String purpose;

    @ApiModelProperty("实验原理")
    private String principle;

    @ApiModelProperty("实验内容")
    private String content;

    @ApiModelProperty("实验小结")
    private String summary;

    @ApiModelProperty("报告得分")
    private String grade;

    @ApiModelProperty("批改报告的教师工号")
    private Long correctTeacherId;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
