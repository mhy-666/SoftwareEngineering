package Service.module.business.teacher.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 *  [ 教师信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-10 10:25:31
 * @since JDK1.8
 */
@Data
public class TeacherExcelVO {
    @Excel(name = "教师工号")
    private Long id;

    @Excel(name = "教师姓名")
    private String name;

    @Excel(name = "年龄")
    private Integer age;

    @Excel(name = "性别")
    private String sex;

    @Excel(name = "手机号码")
    private String phoneNumber;

    @Excel(name = "电子邮箱")
    private String email;

    @Excel(name = "院系")
    private String department;

    @Excel(name = "用户备注")
    private String notes;

    @Excel(name = "	账户状态")
    private String userStatus;

    @Excel(name = "	账户身份")
    private String identity;



}
