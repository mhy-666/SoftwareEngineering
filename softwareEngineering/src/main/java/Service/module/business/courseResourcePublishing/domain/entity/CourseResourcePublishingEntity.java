package Service.module.business.courseResourcePublishing.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * [ 教学资料库 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:07:30
 * @since JDK1.8
 */
@Data
@TableName("r_course_resource_publishing")
public class CourseResourcePublishingEntity extends BaseEntity {

    /**
     * 编号
     */
    private Long id;
    /**
     * 教学资料名称
     */
    private String name;

    /**
     * 课程编号
     */
    private Long courseId;

    /**
     * 班级编号
     */
    private Long classId;

    /**
     * 教学资料上传者编号
     */
    private Long uploaderId;

    /**
     * 教学资料上传者姓名
     */
    private String uploaderName;

    /**
     * 下载次数
     */
    private String downloadTimes;

}
