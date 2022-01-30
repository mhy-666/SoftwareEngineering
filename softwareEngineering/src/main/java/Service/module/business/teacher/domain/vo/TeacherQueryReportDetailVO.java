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
public class TeacherQueryReportDetailVO {

    @ApiModelProperty("学号")
    private Long uploaderId;

    @ApiModelProperty("学生姓名")
    private String uploaderName;;

    @ApiModelProperty("目的")
    private String purpose;

    @ApiModelProperty("原理")
    private String principle;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("小结")
    private String summary;

    @ApiModelProperty("成绩")
    private BigDecimal grade;
}
