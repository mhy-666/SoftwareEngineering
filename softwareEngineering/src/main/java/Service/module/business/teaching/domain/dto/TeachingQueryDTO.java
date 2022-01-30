package Service.module.business.teaching.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * [ 授课信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:24:09
 * @since JDK1.8
 */
@Data
public class TeachingQueryDTO extends PageParamDTO {

    @ApiModelProperty("教师工号")
    private Long teacherId;

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("班级编号，每一个课程可能对应多个班级")
    private Long classId;

    @ApiModelProperty("班级开课学年学期，每一个课程可能在某一年某个学期对应多个班级")
    private String classTerm;

    @ApiModelProperty("考勤成绩权重")
    private BigDecimal attendanceWeights;

    @ApiModelProperty("实验项目成绩权重")
    private BigDecimal experimentWeights;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
