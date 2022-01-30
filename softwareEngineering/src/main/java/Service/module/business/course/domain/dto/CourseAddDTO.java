package Service.module.business.course.domain.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 新建 [ 课程管理 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-01 23:51:13
 * @since JDK1.8
 */
@Data
public class CourseAddDTO {
    @ApiModelProperty("课程编号")
    private Integer course_id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("学分")
    private BigDecimal credit;

    @ApiModelProperty("院系")
    private String department;


}
