package Service.module.business.teaching.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import lombok.Data;

/**
 * [ 授课信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:24:09
 * @since JDK1.8
 */
@Data
@TableName("r_teaching")
public class TeachingEntity extends BaseEntity {

    /**
     * 教师工号

     */
    private Long teacherId;

    /**
     * 课程编号

     */
    private Long courseId;

    /**
     * 班级编号，每一个课程可能对应多个班级

     */
    private Long classId;

    /**
     * 班级开课学年学期，每一个课程可能在某一年某个学期对应多个班级

     */
    private String classTerm;

    /**
     * 考勤成绩权重
     */
    private BigDecimal attendanceWeights;

    /**
     * 实验项目成绩权重
     */
    private BigDecimal experimentWeights;

}
