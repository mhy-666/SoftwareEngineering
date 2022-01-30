package Service.module.business.score.domain.vo;

import lombok.Data;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 课程成绩 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:13:10
 * @since JDK1.8
 */
@Data
public class ScoreVO {
    @ApiModelProperty("学号")
    private Long studentId;

    @ApiModelProperty("班级号")
    private Long classId;

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("考勤分数")
    private BigDecimal attendScore;

    @ApiModelProperty("实验分数")
    private BigDecimal experimentScore;

    @ApiModelProperty("总分")
    private BigDecimal sumScore;



}
