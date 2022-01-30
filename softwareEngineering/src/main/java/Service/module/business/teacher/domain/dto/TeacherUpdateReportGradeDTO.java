package Service.module.business.teacher.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

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
public class TeacherUpdateReportGradeDTO extends PageParamDTO {

    @ApiModelProperty("学号")
    private Long studentId;

    @ApiModelProperty("工号")
    private Long teacherId;

    @ApiModelProperty("课程id")
    private Long courseId;

    @ApiModelProperty("班级id")
    private Long classId;

    @ApiModelProperty("项目id")
    private Long projectId;

    @ApiModelProperty("报告id")
    private Long reportId;

    @ApiModelProperty("报告id")
    private BigDecimal grade;
}
