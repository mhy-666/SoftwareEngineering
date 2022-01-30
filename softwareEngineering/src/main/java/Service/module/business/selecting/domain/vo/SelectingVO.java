package Service.module.business.selecting.domain.vo;

import lombok.Data;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 学生课程信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:15:32
 * @since JDK1.8
 */
@Data
public class SelectingVO {
    @ApiModelProperty("学号")
    private Long studentId;

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("班级编号")
    private Long classId;

    @ApiModelProperty("班级开课学年学期")
    private String classTerm;

    @ApiModelProperty("考勤成绩")
    private BigDecimal attendScore;

    @ApiModelProperty("实验项目报告成绩")
    private BigDecimal experimentReportScore;

    @ApiModelProperty("总评成绩")
    private BigDecimal sumScore;



}
