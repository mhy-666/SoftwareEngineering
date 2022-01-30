package Service.module.business.course.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;

/**
 *  [ 课程管理 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-01 23:51:13
 * @since JDK1.8
 */
@Data
public class CourseExcelVO {
    @Excel(name = "id")
    private Long id;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "学分")
    private BigDecimal credit;

    @Excel(name = "院系")
    private String department;



}
