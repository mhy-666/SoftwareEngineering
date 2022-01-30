package Service.module.business.student.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * [ 学生信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-10 10:19:19
 * @since JDK1.8
 */
@Data
@TableName("e_student")
public class StudentEntity extends BaseEntity {

    /**
     * 学号
     */
    private Long id;
    /**
     * 学生姓名

     */
    private String name;

    /**
     * 年龄

     */
    private Integer age;

    /**
     * 性别

     */
    private String sex;

    /**
     * 手机号码

     */
    private String phoneNumber;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 用户备注
     */
    private String notes;

    /**
     * 	账户状态
     */
    private String userStatus;

    /**
     * 	账户身份
     */
    private String identity;

}
