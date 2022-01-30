package Service.module.business.stuConfrontationExercise.domain.vo;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

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
public class StuConfrontationExerciseQueryDetailVO {
    @ApiModelProperty("学生id")
    private Long studentId;

    @ApiModelProperty("得分")
    private BigDecimal totals;

    @ApiModelProperty("对抗练习名称")
    private Long rank;

    @ApiModelProperty("作答时间")
    private String answerTime;

    @ApiModelProperty("第一题学生答案")
    private String student_answer1;

    @ApiModelProperty("第二题学生答案")
    private String student_answer2;

    @ApiModelProperty("第三题学生答案")
    private String student_answer3;





}
