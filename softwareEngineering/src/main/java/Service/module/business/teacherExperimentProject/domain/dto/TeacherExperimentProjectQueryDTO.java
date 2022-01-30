package Service.module.business.teacherExperimentProject.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 实验项目发布信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:10:10
 * @since JDK1.8
 */
@Data
public class TeacherExperimentProjectQueryDTO extends PageParamDTO {

    @ApiModelProperty("实验项目编号")
    private Long id;

    @ApiModelProperty("实验项目名称")
    private String name;

    @ApiModelProperty("实验项目所属课程")
    private Long courseId;

    @ApiModelProperty("实验项目所属班级")
    private Long classId;

    @ApiModelProperty("项目描述")
    private String projectDescrip;

    @ApiModelProperty("实验项目报告截止时间")
    private Date deadline;

    @ApiModelProperty("发布项目的教师工号")
    private Long publishTeacherId;

    @ApiModelProperty("发布项目的教师姓名")
    private String publishTeacherName;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
