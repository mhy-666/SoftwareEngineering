package Service.module.business.teacherExperimentProject.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 实验项目发布信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:10:10
 * @since JDK1.8
 */
@Data
public class TeacherExperimentProjectExcelVO {
    @Excel(name = "实验项目编号")
    private Long id;

    @Excel(name = "实验项目名称")
    private String name;

    @Excel(name = "实验项目所属课程")
    private Long courseId;

    @Excel(name = "实验项目所属班级")
    private Long classId;

    @Excel(name = "项目描述")
    private String projectDescrip;

    @Excel(name = "实验项目报告截止时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date deadline;

    @Excel(name = "发布项目的教师工号")
    private Long publishTeacherId;

    @Excel(name = "发布项目的教师姓名")
    private String publishTeacherName;



}
