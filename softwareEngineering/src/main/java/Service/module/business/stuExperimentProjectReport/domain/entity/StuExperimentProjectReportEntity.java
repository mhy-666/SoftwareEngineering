package Service.module.business.stuExperimentProjectReport.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * [ 实验报告提交信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:21:27
 * @since JDK1.8
 */
@Data
@TableName("r_stu_experiment_project_report")
public class StuExperimentProjectReportEntity extends BaseEntity {

    /**
     * 学号
     */
    private Long id;
    /**
     * 实验项目编号
     */
    private Long projectId;

    /**
     * 实验项目名称
     */
    private String name;

    /**
     * 课程编号
     */
    private Long courseId;

    /**
     * 班级编号
     */
    private Long classId;

    /**
     * 实验报告编号
     */
    private Long reportId;

    /**
     * 实验报告上传者姓名
     */
    private String reportUploaderName;

    /**
     * 报告截至时间
     */
    private Date deadline;

    /**
     * 是否完成
     */
    private String iffinish;

    /**
     * 实验目的
     */
    private String purpose;

    /**
     * 实验原理
     */
    private String principle;

    /**
     * 实验内容
     */
    private String content;

    /**
     * 实验小结
     */
    private String summary;

    /**
     * 报告得分
     */
    private BigDecimal grade;

    /**
     * 批改报告的教师工号
     */
    private Long correctTeacherId;

}
