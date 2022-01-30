package Service.module.business.courseResourcePublishing.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

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
public class CourseResourcePublishingQueryDTO extends PageParamDTO {

    @ApiModelProperty("教学资料编号")
    private Long id;

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

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
