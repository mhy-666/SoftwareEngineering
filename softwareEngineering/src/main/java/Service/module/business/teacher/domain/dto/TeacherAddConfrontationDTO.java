package Service.module.business.teacher.domain.dto;

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
public class TeacherAddConfrontationDTO extends PageParamDTO {

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


}
