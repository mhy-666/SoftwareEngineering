package Service.module.business.stuConfrontationExercise.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 *  [ 学生对抗练习作答情况 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-21 22:44:59
 * @since JDK1.8
 */
@Data
public class StuConfrontationExerciseExcelVO {
    @Excel(name = "对抗练习id")
    private Long confrontationId;

    @Excel(name = "对抗练习名称")
    private String confrontationName;

    @Excel(name = "课程id")
    private Long courseId;

    @Excel(name = "班级id")
    private Long classId;

    @Excel(name = "对抗练习描述")
    private String confrontationDescrip;

    @Excel(name = "题库id")
    private Long questionbankId;

    @Excel(name = "作答时间")
    private String answerTime;

    @Excel(name = "截止时间")
    private String deadline;

    @Excel(name = "学号")
    private Long studentId;

    @Excel(name = "学生第一题答案")
    private String studentAnswer1;

    @Excel(name = "学生第二题答案")
    private String studentAnswer2;

    @Excel(name = "学生第三题答案")
    private String studentAnswer3;



}
