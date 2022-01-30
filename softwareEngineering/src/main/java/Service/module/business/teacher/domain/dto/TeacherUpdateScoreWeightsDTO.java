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
public class TeacherUpdateScoreWeightsDTO extends PageParamDTO {


    @ApiModelProperty("工号")
    private Long id;

    @ApiModelProperty("课程id")
    private Long courseId;

    @ApiModelProperty("班级id")
    private Long classId;

    @ApiModelProperty("考勤成绩权重")
    private BigDecimal attendanceWeights;

    @ApiModelProperty("实验项目成绩权重")
    private BigDecimal experimentWeights;

}
