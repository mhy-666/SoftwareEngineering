package Service.module.business.student.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

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
public class StudentExcelVO {
    @Excel(name = "学生编号")
    private Long id;

    @Excel(name = "学生姓名")
    private String name;

    @Excel(name = "年龄")
    private Integer age;

    @Excel(name = "性别")
    private String sex;

    @Excel(name = "手机号码")
    private String phoneNumber;

    @Excel(name = "电子邮箱")
    private String email;

    @Excel(name = "用户备注")
    private String notes;

    @Excel(name = "	账户状态")
    private String userStatus;

    @Excel(name = "	账户身份")
    private String identity;



}
