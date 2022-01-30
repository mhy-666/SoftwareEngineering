package Service.module.business.classinfo.domain.vo;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

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
public class ClassinfoVO {
    @ApiModelProperty("班级编号")
    private Long classId;

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("开课学年学期")
    private String classTerm;

    @ApiModelProperty("上课安排编号")
    private Long scheduleTimeId;

    @ApiModelProperty("上课地点")
    private String place;



}
