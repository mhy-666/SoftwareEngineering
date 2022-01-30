package Service.module.system.login.domain;

import Service.common.anno.ApiModelPropertyEnum;
import Service.module.system.privilege.constant.PrivilegeTypeEnum;
import Service.util.SmartVerificationUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * [  ]
 *
 * @author yandanyang
 * @version 1.0
 * @company 1024lab.net
 * @copyright (c) 2018 1024lab.netInc. All rights reserved.
 * @date 2019/8/21 0021 上午 10:28
 * @since JDK1.8
 */
@Data
public class registerDTO {

    @ApiModelProperty("邮箱")
    private String email;


    @ApiModelProperty("密码")
    //    @NotNull(message = "密码不能为空")
    //    @Length(min = 6, message = "密码最少为6位字符")
    private String loginPwd;

    @ApiModelProperty("登录名")
    @NotNull(message = "登录名（学号/工号）不能为空")
    private String loginName;

    @ApiModelProperty("姓名")
    @NotNull(message = "姓名不能为空")
    private String actualName;


    @ApiModelProperty("年龄")
    private String age;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("身份信息")
    private Long identity_id;




}
