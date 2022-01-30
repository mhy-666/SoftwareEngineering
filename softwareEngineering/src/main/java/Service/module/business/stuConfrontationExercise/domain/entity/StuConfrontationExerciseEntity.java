package Service.module.business.stuConfrontationExercise.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import Service.common.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * [ 学生对抗练习作答情况 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-21 22:44:59
 * @since JDK1.8
 */
@Data
@TableName("r_stu_confrontation_exercise")
public class StuConfrontationExerciseEntity extends BaseEntity{

    /**
     * 对抗练习id
     */
    private Long confrontationId;

    /**
     * 对抗练习名称
     */
    private String confrontationName;

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 班级id
     */
    private Long classId;

    /**
     * 对抗练习描述
     */
    private String confrontationDescrip;

    /**
     * 题库id
     */
    private Long questionbankId;

    /**
     * 作答时间
     */
    private String answerTime;

    /**
     * 截止时间
     */
    private String deadline;

    /**
     * 学号
     */
    private Long studentId;

    /**
     * 学生第一题答案
     */
    private String studentAnswer1;

    /**
     * 学生第二题答案
     */
    private String studentAnswer2;

    /**
     * 学生第三题答案
     */
    private String studentAnswer3;
    /**
     * 学生总分
     */
    private BigDecimal totals;
    /**
     * 学生排名
     */
    private Long rank;
    /**
     * 学生组号
     */
    private Long groupNum;

}
