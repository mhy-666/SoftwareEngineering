package Service.module.business.stuConfrontationExercise.domain.vo;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 学生对抗练习作答情况 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-21 22:44:59
 * @since JDK1.8
 */
@Data
public class StuConfrontationExerciseVO {
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



}
