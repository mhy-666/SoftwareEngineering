package Service.module.business.classinfo.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 实验班级信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-02 20:44:23
 * @since JDK1.8
 */
@Data
public class ClassinfoQueryDTO extends PageParamDTO {

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

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
