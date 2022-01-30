package Service.module.business.confrontationExercise.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 对抗练习信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-21 22:41:43
 * @since JDK1.8
 */
@Data
public class ConfrontationExerciseQueryDTO extends PageParamDTO {

    @ApiModelProperty("对抗练习id")
    private Long id;

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

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
