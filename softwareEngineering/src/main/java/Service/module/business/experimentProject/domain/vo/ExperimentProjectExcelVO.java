package Service.module.business.experimentProject.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 *  [ 教师发布实验项目 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:04:39
 * @since JDK1.8
 */
@Data
public class ExperimentProjectExcelVO {
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



}
