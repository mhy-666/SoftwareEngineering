package Service.module.business.stuConfrontationExercise.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 学生对抗练习作答情况 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-21 22:44:59
 * @since JDK1.8
 */
@Data
public class StuConfrontationExerciseQueryDTO extends PageParamDTO {

    @ApiModelProperty("对抗练习id")
    private Long confrontationId;

    @ApiModelProperty("对抗练习名称")
    private String confrontationName;

    @ApiModelProperty("课程id")
    private Long courseId;

    @ApiModelProperty("班级id")
    private Long classId;

    @ApiModelProperty("对抗练习描述")
    private String confrontationDescrip;

    @ApiModelProperty("题库id")
    private Long questionbankId;

    @ApiModelProperty("作答时间")
    private String answerTime;

    @ApiModelProperty("截止时间")
    private String deadline;

    @ApiModelProperty("学号")
    private Long studentId;

    @ApiModelProperty("学生第一题答案")
    private String studentAnswer1;

    @ApiModelProperty("学生第二题答案")
    private String studentAnswer2;

    @ApiModelProperty("学生第三题答案")
    private String studentAnswer3;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
