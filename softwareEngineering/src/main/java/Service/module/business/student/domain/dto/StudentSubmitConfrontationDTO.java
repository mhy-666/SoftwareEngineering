package Service.module.business.student.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新建 [ 学生信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-10 10:19:19
 * @since JDK1.8
 */
@Data
public class StudentSubmitConfrontationDTO extends PageParamDTO {

    @ApiModelProperty("学号")
    private Long studentId;

    @ApiModelProperty("课程id")
    private Long courseId;

    @ApiModelProperty("班级id")
    private Long classId;

    @ApiModelProperty("对抗练习id")
    private Long confrontationId;

    @ApiModelProperty("第一题学生答案")
    private String student_answer1;

    @ApiModelProperty("第二题学生答案")
    private String student_answer2;

    @ApiModelProperty("第三题学生答案")
    private String student_answer3;

    @ApiModelProperty("所用时间")
    private String answer_time;
}
