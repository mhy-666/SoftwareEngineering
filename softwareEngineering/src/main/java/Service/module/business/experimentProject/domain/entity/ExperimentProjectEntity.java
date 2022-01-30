package Service.module.business.experimentProject.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * [ 教师发布实验项目 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:04:39
 * @since JDK1.8
 */
@Data
@TableName("e_experiment_project")
public class ExperimentProjectEntity extends BaseEntity {

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
     * 截止时间
     */
    private Date deadline;

}
