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
public class StuConfrontationExerciseQueryListVO {

    @ApiModelProperty("对抗练习id")
    private Long confrontationId;

    @ApiModelProperty("对抗练习名称")
    private String confrontationName;

    @ApiModelProperty("截止时间")
    private String deadline;


}
