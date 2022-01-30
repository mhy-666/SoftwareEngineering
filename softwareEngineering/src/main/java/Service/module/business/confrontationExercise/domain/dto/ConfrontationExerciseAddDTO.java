package Service.module.business.confrontationExercise.domain.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 对抗练习信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-21 22:41:43
 * @since JDK1.8
 */
@Data
public class ConfrontationExerciseAddDTO {
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


}
