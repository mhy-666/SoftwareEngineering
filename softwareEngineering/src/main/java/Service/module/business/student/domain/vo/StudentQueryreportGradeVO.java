package Service.module.business.student.domain.vo;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 *  [ 学生信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-10 10:19:19
 * @since JDK1.8
 */
@Data
public class StudentQueryreportGradeVO {
    @ApiModelProperty("项目id")
    private Long projectId;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("报告成绩")
    private BigDecimal Score;


}
