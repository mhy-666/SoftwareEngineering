package Service.module.business.courseResourcePublishing.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.module.business.courseResourcePublishing.service.CourseResourcePublishingService;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.courseResourcePublishing.domain.dto.CourseResourcePublishingAddDTO;
import Service.module.business.courseResourcePublishing.domain.dto.CourseResourcePublishingUpdateDTO;
import Service.module.business.courseResourcePublishing.domain.dto.CourseResourcePublishingQueryDTO;
import Service.module.business.courseResourcePublishing.domain.vo.CourseResourcePublishingVO;
import Service.module.business.courseResourcePublishing.domain.vo.CourseResourcePublishingExcelVO;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import Service.module.business.teacher.service.TeacherService;
import org.apache.poi.ss.usermodel.Workbook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_PUBLISHINGING_RE})
public class CourseResourcePublishingController extends BaseController {

    @Autowired
    private CourseResourcePublishingService courseResourcePublishingService;

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "查看教学资料",notes = "@author mhy")
    @PostMapping("/courseResourcePublishing/getlist")
    public ResponseDTO<List<CourseResourcePublishingVO>> queryRescource(@RequestBody CourseResourcePublishingQueryDTO queryDTO) {
        return teacherService.queryRescource(queryDTO);
    }

    @ApiOperation(value = "分页查询教学资料库",notes = "@author mhy")
    @PostMapping("/courseResourcePublishing/page/query")
    public ResponseDTO<PageResultDTO<CourseResourcePublishingVO>> queryByPage(@RequestBody CourseResourcePublishingQueryDTO queryDTO) {
        return courseResourcePublishingService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加教学资料库",notes = "@author mhy")
    @PostMapping("/courseResourcePublishing/add")
    public ResponseDTO<String> add(@RequestBody @Validated CourseResourcePublishingAddDTO addTO){
        return courseResourcePublishingService.add(addTO);
    }

    @ApiOperation(value="修改教学资料库",notes = "@author mhy")
    @PostMapping("/courseResourcePublishing/update")
    public ResponseDTO<String> update(@RequestBody @Validated CourseResourcePublishingUpdateDTO updateDTO){
        return courseResourcePublishingService.update(updateDTO);
    }

    @ApiOperation(value="批量删除教学资料库",notes = "@author mhy")
    @PostMapping("/courseResourcePublishing/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return courseResourcePublishingService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/courseResourcePublishing/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<CourseResourcePublishingExcelVO> courseResourcePublishingList = courseResourcePublishingService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("教学资料库", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CourseResourcePublishingExcelVO.class, courseResourcePublishingList);
        downloadExcel("教学资料库", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/courseResourcePublishing/export/all")
    public void exportAll(@RequestBody @Validated CourseResourcePublishingQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<CourseResourcePublishingExcelVO> courseResourcePublishingList = courseResourcePublishingService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("教学资料库", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CourseResourcePublishingExcelVO.class, courseResourcePublishingList);
        downloadExcel("教学资料库", workbook, response);
    }

}
