package Service.module.business.teacher.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 教师信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-10 10:25:31
 * @since JDK1.8
 */
@Data
public class TeacherQueryDTO extends PageParamDTO {

    @ApiModelProperty("教师工号")
    private Long id;

    @ApiModelProperty("教师姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("手机号码")
    private String phoneNumber;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("院系")
    private String department;

    @ApiModelProperty("用户备注")
    private String notes;

    @ApiModelProperty("	账户状态")
    private String userStatus;

    @ApiModelProperty("	账户身份")
    private String identity;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
