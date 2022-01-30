package Service.module.business.teacher.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.constant.SwaggerTagConst;
import Service.module.business.teacher.domain.dto.*;
import Service.module.business.teacher.domain.vo.*;
import Service.module.business.teacher.service.TeacherService;
import Service.common.controller.BaseController;
import Service.module.business.teacher.domain.dto.*;
import Service.module.business.teacher.domain.vo.*;
import Service.module.business.teacherExperimentProject.domain.entity.TeacherExperimentProjectEntity;
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
 * [ 教师信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-10 10:25:31
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_TEACHER})
public class TeacherController extends BaseController {

    @Autowired
    private TeacherService teacherService;


    @ApiOperation(value = "获取实验项目详情",notes = "@author mhy")
    @PostMapping("/teacher/projectdetail")
    public ResponseDTO<List<TeacherQueryProjectDetailVO>> queryProjectDetail(@RequestBody TeacherQueryProjectDTO queryDTO) {
        return teacherService.queryProjectDetail(queryDTO);
    }

    @ApiOperation(value="关闭课程",notes = "@author mhy")
    @PostMapping("/teacher/closecourse")
    public ResponseDTO<String> delete(@RequestBody @Validated Long id) {
        return teacherService.closeCourse(id);
    }

    @ApiOperation(value = "开设课程",notes = "@author mhy")
    @PostMapping("/teacher/newcourse")
    public ResponseDTO<String> addCourse(@RequestBody TeacherAddCourseDTO queryDTO) {
        return teacherService.addCourse(queryDTO);
    }

    @ApiOperation(value = "获取教学课程列表",notes = "@author mhy")
    @PostMapping("/teacher/getcourse")
    public ResponseDTO<List<TeacherQueryCourseVO>> queryCourse(@RequestBody TeacherQueryCourseDTO queryDTO) {
        return teacherService.queryCourse(queryDTO);
    }

    @ApiOperation(value = "获取实验报告列表",notes = "@author mhy")
    @PostMapping("/teacher/getreport")
    public ResponseDTO<List<TeacherQueryReportVO>> queryReport(@RequestBody TeacherQueryReportDTO queryDTO) {
        return teacherService.queryReport(queryDTO);
    }

    @ApiOperation(value = "发布实验项目",notes = "@author mhy")
    @PostMapping("/teacher/newproject")
    public ResponseDTO<String> addProject(@RequestBody TeacherAddProjectDTO queryDTO) {
        return teacherService.addProject(queryDTO);
    }

    @ApiOperation(value = "发布对抗练习",notes = "@author mhy")
    @PostMapping("/teacher/newagainst")
    public ResponseDTO<String> addConfrontation(@RequestBody TeacherAddConfrontationDTO queryDTO) {
        return teacherService.addConfrontation(queryDTO);
    }

    @ApiOperation(value = "获取实验项目列表",notes = "@author mhy")
    @PostMapping("/teacher/getproject")
    public ResponseDTO<List<TeacherQueryProjectVO>> queryProject(@RequestBody TeacherQueryProjectDTO queryDTO) {
        return teacherService.queryProject(queryDTO);
    }

    @ApiOperation(value = "查看实验报告详情",notes = "@author mhy")
    @PostMapping("/teacher/reportdetail")
    public ResponseDTO<List<TeacherQueryReportDetailVO>> queryReportDetail(@RequestBody TeacherQueryReportDetailDTO queryDTO) {
        return teacherService.queryReportDetail(queryDTO);
    }

    @ApiOperation(value = "实验报告评分",notes = "@author mhy")
    @PostMapping("/teacher/rate")
    public ResponseDTO<String> updateReportGrade(@RequestBody TeacherUpdateReportGradeDTO queryDTO) {
        return teacherService.updateReportGrade(queryDTO);
    }

    @ApiOperation(value = "设置分数权重",notes = "@author mhy")
    @PostMapping("/teacher/setweights")
    public ResponseDTO<String> updateScoreWeights(@RequestBody TeacherUpdateScoreWeightsDTO queryDTO) {
        return teacherService.updateScoreWeights(queryDTO);
    }





    @ApiOperation(value = "分页查询教师信息",notes = "@author mhy")
    @PostMapping("/teacher/page/query")
    public ResponseDTO<PageResultDTO<TeacherVO>> queryByPage(@RequestBody TeacherQueryDTO queryDTO) {
        return teacherService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加教师信息",notes = "@author mhy")
    @PostMapping("/teacher/add")
    public ResponseDTO<String> add(@RequestBody @Validated TeacherAddDTO addTO){
        return teacherService.add(addTO);
    }

    @ApiOperation(value="修改教师信息",notes = "@author mhy")
    @PostMapping("/teacher/update")
    public ResponseDTO<String> update(@RequestBody @Validated TeacherUpdateDTO updateDTO){
        return teacherService.update(updateDTO);
    }

    @ApiOperation(value="批量删除教师信息",notes = "@author mhy")
    @PostMapping("/teacher/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return teacherService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/teacher/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<TeacherExcelVO> teacherList = teacherService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("教师信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TeacherExcelVO.class, teacherList);
        downloadExcel("教师信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/teacher/export/all")
    public void exportAll(@RequestBody @Validated TeacherQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<TeacherExcelVO> teacherList = teacherService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("教师信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TeacherExcelVO.class, teacherList);
        downloadExcel("教师信息", workbook, response);
    }

}
