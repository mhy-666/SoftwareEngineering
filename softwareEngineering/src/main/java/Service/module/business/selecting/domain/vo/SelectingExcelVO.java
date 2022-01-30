package Service.module.business.selecting.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.math.BigDecimal;

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
public class SelectingExcelVO {
    @Excel(name = "学号")
    private Long studentId;

    @Excel(name = "课程编号")
    private Long courseId;

    @Excel(name = "班级编号")
    private Long classId;

    @Excel(name = "班级开课学年学期")
    private String classTerm;

    @Excel(name = "考勤成绩")
    private BigDecimal attendScore;

    @Excel(name = "实验项目报告成绩")
    private BigDecimal experimentReportScore;

    @Excel(name = "总评成绩")
    private BigDecimal sumScore;



}
