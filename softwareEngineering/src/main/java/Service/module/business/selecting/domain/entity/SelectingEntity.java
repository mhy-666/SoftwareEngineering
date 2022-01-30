package Service.module.business.selecting.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import lombok.Data;

/**
 * [ 学生课程信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:15:32
 * @since JDK1.8
 */
@Data
@TableName("r_selecting")
public class SelectingEntity extends BaseEntity {

    /**
     * 学号

     */
    private Long studentId;

    /**
     * 课程编号

     */
    private Long courseId;

    /**
     * 班级编号

     */
    private Long classId;

    /**
     * 班级开课学年学期

     */
    private String classTerm;

    /**
     * 考勤成绩
     */
    private BigDecimal attendScore;

    /**
     * 实验项目报告成绩
     */
    private BigDecimal experimentReportScore;

    /**
     * 总评成绩

     */
    private BigDecimal sumScore;

}
