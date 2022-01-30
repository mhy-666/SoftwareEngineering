package Service.module.business.courseResourcePublishing.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 *  [ 教学资料库 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:07:30
 * @since JDK1.8
 */
@Data
public class CourseResourcePublishingExcelVO {
    @Excel(name = "教学资料编号")
    private Long id;

    @Excel(name = "教学资料名称")
    private String name;

    @Excel(name = "课程编号")
    private Long courseId;

    @Excel(name = "班级编号")
    private Long classId;

    @Excel(name = "教学资料上传者编号")
    private Long uploaderId;

    @Excel(name = "教学资料上传者姓名")
    private String uploaderName;

    @Excel(name = "下载次数")
    private String downloadTimes;



}
