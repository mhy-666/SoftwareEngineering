package Service.module.business.score.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.math.BigDecimal;

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
public class ScoreExcelVO {
    @Excel(name = "学号")
    private Long studentId;

    @Excel(name = "班级号")
    private Long classId;

    @Excel(name = "课程编号")
    private Long courseId;

    @Excel(name = "考勤分数")
    private BigDecimal attendScore;

    @Excel(name = "实验分数")
    private BigDecimal experimentScore;

    @Excel(name = "总分")
    private BigDecimal sumScore;



}
