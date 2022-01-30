package Service.module.business.teacher.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import Service.common.domain.PageParamDTO;

import java.util.Date;

/**
 * 新建 [ 学生信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-10 10:19:19
 * @since JDK1.8
 */
@Data
public class TeacherAddProjectDTO extends PageParamDTO {

    @ApiModelProperty("课程id")
    private Long courseId;

    @ApiModelProperty("班级id")
    private Long classId;

    @ApiModelProperty("项目name")
    private String projectName;

    @ApiModelProperty("项目简介")
    private String projectDescrip;

    @ApiModelProperty("项目截止时间")
    private String deadline;
}
