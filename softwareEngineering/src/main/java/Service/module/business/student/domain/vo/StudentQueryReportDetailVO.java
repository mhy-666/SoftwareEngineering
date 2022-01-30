package Service.module.business.student.domain.vo;

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
public class StudentQueryReportDetailVO {

    @ApiModelProperty("项目名称")
    private String purpose;

    @ApiModelProperty("发布者编号")
    private String principle;

    @ApiModelProperty("发布者姓名")
    private String content;

    @ApiModelProperty("项目简介")
    private String summary;

}
