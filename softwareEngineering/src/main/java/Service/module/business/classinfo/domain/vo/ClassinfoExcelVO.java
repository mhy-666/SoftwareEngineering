package Service.module.business.classinfo.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 *  [ 实验班级信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-02 20:44:23
 * @since JDK1.8
 */
@Data
public class ClassinfoExcelVO {
    @Excel(name = "班级编号")
    private Long classId;

    @Excel(name = "课程编号")
    private Long courseId;

    @Excel(name = "开课学年学期")
    private String classTerm;

    @Excel(name = "上课安排编号")
    private Long scheduleTimeId;

    @Excel(name = "上课地点")
    private String place;



}
