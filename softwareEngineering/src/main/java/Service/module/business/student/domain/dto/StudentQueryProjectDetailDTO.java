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
public class StudentQueryProjectDetailDTO extends PageParamDTO {

    @ApiModelProperty("课程id")
    private Long courseId;

    @ApiModelProperty("班级id")
    private Long classId;

    @ApiModelProperty("项目id")
    private Long projectId;

}
