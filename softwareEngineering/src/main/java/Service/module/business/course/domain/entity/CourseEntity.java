package Service.module.business.course.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * [ 课程管理 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-01 23:51:13
 * @since JDK1.8
 */
@Data
@TableName("t_course")
public class CourseEntity extends BaseEntity {


    private Integer course_id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 学分
     */
    private BigDecimal credit;

    /**
     * 院系
     */
    private String department;

}
