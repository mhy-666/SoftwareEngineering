package Service.module.business.courseResource.domain.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 教学资料库 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:00:05
 * @since JDK1.8
 */
@Data
public class CourseResourceAddDTO {
    @ApiModelProperty("教学资料名称")
    private String name;

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("班级编号")
    private Long classId;


}
