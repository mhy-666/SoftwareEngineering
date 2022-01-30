package Service.module.business.teacherExperimentProject.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 实验项目发布信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:10:10
 * @since JDK1.8
 */
@Data
public class TeacherExperimentProjectAddDTO {
    @ApiModelProperty("实验项目名称")
    private String name;

    @ApiModelProperty("实验项目所属课程")
    private Long courseId;

    @ApiModelProperty("实验项目所属班级")
    private Long classId;

    @ApiModelProperty("项目描述")
    private String projectDescrip;

    @ApiModelProperty("实验项目报告截止时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deadline;

    @ApiModelProperty("发布项目的教师工号")
    private Long publishTeacherId;

    @ApiModelProperty("发布项目的教师姓名")
    private String publishTeacherName;


}
