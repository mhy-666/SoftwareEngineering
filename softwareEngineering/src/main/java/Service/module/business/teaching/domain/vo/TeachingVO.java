package Service.module.business.teaching.domain.vo;

import lombok.Data;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 授课信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:24:09
 * @since JDK1.8
 */
@Data
public class TeachingVO {
    @ApiModelProperty("教师工号")
    private Long teacherId;

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("班级编号，每一个课程可能对应多个班级")
    private Long classId;

    @ApiModelProperty("班级开课学年学期，每一个课程可能在某一年某个学期对应多个班级")
    private String classTerm;

    @ApiModelProperty("考勤成绩权重")
    private BigDecimal attendanceWeights;

    @ApiModelProperty("实验项目成绩权重")
    private BigDecimal experimentWeights;



}
