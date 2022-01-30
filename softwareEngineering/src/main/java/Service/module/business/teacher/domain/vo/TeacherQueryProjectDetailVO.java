package Service.module.business.teacher.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
public class TeacherQueryProjectDetailVO {




    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("教师id")
    private Long teacherId;

    @ApiModelProperty("教师名称")
    private String teacherName;

    @ApiModelProperty("项目描述")
    private String projectDescrip;

    @ApiModelProperty("截止时间")
    private Date deadline;


}
