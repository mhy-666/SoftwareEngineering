package Service.module.business.course.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.module.business.course.domain.vo.CourseExcelVO;
import Service.module.business.course.service.CourseService;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.course.domain.dto.CourseAddDTO;
import Service.module.business.course.domain.dto.CourseUpdateDTO;
import Service.module.business.course.domain.dto.CourseQueryDTO;
import Service.module.business.course.domain.vo.CourseVO;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * [ 课程管理 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-01 23:51:13
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_COURSE})
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "分页查询课程管理",notes = "@author mhy")
    @PostMapping("/course/page/query")
    public ResponseDTO<PageResultDTO<CourseVO>> queryByPage(@RequestBody CourseQueryDTO queryDTO) {
        return courseService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加课程管理",notes = "@author mhy")
    @PostMapping("/course/add")
    public ResponseDTO<String> add(@RequestBody @Validated CourseAddDTO addTO){
        return courseService.add(addTO);
    }

    @ApiOperation(value="修改课程管理",notes = "@author mhy")
    @PostMapping("/course/update")
    public ResponseDTO<String> update(@RequestBody @Validated CourseUpdateDTO updateDTO){
        return courseService.update(updateDTO);
    }

    @ApiOperation(value="批量删除课程管理",notes = "@author mhy")
    @PostMapping("/course/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return courseService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/course/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<CourseExcelVO> courseList = courseService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("课程管理", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CourseExcelVO.class, courseList);
        downloadExcel("课程管理", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/course/export/all")
    public void exportAll(@RequestBody @Validated CourseQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<CourseExcelVO> courseList = courseService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("课程管理", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CourseExcelVO.class, courseList);
        downloadExcel("课程管理", workbook, response);
    }

}
