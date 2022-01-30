package Service.module.business.stuExperimentProjectReport.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 实验报告提交信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:21:27
 * @since JDK1.8
 */
@Data
public class StuExperimentProjectReportExcelVO {
    @Excel(name = "实验报告上传者学号")
    private Long id;

    @Excel(name = "实验项目编号")
    private Long projectId;

    @Excel(name = "实验项目名称")
    private String name;

    @Excel(name = "课程编号")
    private Long courseId;

    @Excel(name = "班级编号")
    private Long classId;

    @Excel(name = "实验报告编号")
    private Long reportId;

    @Excel(name = "实验报告上传者姓名")
    private String reportUploaderName;

    @Excel(name = "报告截至时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date deadline;

    @Excel(name = "是否完成")
    private String iffinish;

    @Excel(name = "实验目的")
    private String purpose;

    @Excel(name = "实验原理")
    private String principle;

    @Excel(name = "实验内容")
    private String content;

    @Excel(name = "实验小结")
    private String summary;

    @Excel(name = "报告得分")
    private String grade;

    @Excel(name = "批改报告的教师工号")
    private Long correctTeacherId;



}
