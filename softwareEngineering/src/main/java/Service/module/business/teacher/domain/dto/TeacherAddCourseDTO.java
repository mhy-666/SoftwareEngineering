package Service.module.business.teacher.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * [ 开设课程情况 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-21 22:44:59
 * @since JDK1.8
 */
@Data
public class TeacherAddCourseDTO extends PageParamDTO {

    @ApiModelProperty("教师id")
    private Long id;

    @ApiModelProperty("课程名称")
    private String name;

    @ApiModelProperty("学分")
    private BigDecimal credit;

    @ApiModelProperty("院系")
    private String department;




}
