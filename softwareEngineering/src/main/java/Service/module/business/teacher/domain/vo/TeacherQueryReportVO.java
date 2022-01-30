package Service.module.business.teacher.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

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
public class TeacherQueryReportVO{

    @ApiModelProperty("课程id")
    private Long reportId;

    @ApiModelProperty("班级id")
    private Long uploaderId;

    @ApiModelProperty("项目id")
    private String uploaderName;

    @ApiModelProperty("项目id")
    private BigDecimal grade;



}
