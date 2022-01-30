package Service.module.business.courseResourcePublishing.domain.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 教学资料库 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-12 00:07:30
 * @since JDK1.8
 */
@Data
public class CourseResourcePublishingAddDTO {
    @ApiModelProperty("教学资料名称")
    private String name;

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("班级编号")
    private Long classId;

    @ApiModelProperty("教学资料上传者编号")
    private Long uploaderId;

    @ApiModelProperty("教学资料上传者姓名")
    private String uploaderName;

    @ApiModelProperty("下载次数")
    private String downloadTimes;


}
