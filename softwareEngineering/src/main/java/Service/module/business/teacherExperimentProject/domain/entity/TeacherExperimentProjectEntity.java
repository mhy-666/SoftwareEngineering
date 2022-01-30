package Service.module.business.teacherExperimentProject.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import lombok.Data;

/**
 * [ 实验项目发布信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:10:10
 * @since JDK1.8
 */
@Data
@TableName("r_teacher_experiment_project")
public class TeacherExperimentProjectEntity extends BaseEntity {

    /**
     * 编号
     */
    private Long id;
    /**
     * 实验项目名称
     */
    private String name;

    /**
     * 实验项目所属课程
     */
    private Long courseId;

    /**
     * 实验项目所属班级
     */
    private Long classId;

    /**
     * 项目描述
     */
    private String projectDescrip;

    /**
     * 实验项目报告截止时间
     */
    private Date deadline;

    /**
     * 发布项目的教师工号
     */
    private Long publishTeacherId;

    /**
     * 发布项目的教师姓名
     */
    private String publishTeacherName;

}
