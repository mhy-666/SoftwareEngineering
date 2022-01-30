package Service.module.business.score.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import lombok.Data;

/**
 * [ 课程成绩 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:13:10
 * @since JDK1.8
 */
@Data
@TableName("r_score")
public class ScoreEntity extends BaseEntity {

    /**
     * 学号
     */
    private Long studentId;

    /**
     * 班级号
     */
    private Long classId;

    /**
     * 课程编号
     */
    private Long courseId;

    /**
     * 考勤分数
     */
    private BigDecimal attendScore;

    /**
     * 实验分数
     */
    private BigDecimal experimentScore;

    /**
     * 总分
     */
    private BigDecimal sumScore;

}
