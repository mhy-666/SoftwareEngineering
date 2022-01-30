package Service.module.business.student.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.module.business.student.domain.dto.*;
import Service.module.business.student.domain.vo.*;
import Service.module.business.student.service.StudentService;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.student.domain.dto.*;
import Service.module.business.student.domain.vo.*;
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
 * [ 学生信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-10 10:19:19
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_STUDENT})
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;


    @ApiOperation(value = "获取对抗练习作答情况",notes = "@author mhy")
    @PostMapping("/confront/answer")
    public ResponseDTO<List<StuConfrontationExerciseAnswerVO>> queryConfrontResult(@RequestBody StudentSubmitConfrontationDTO queryDTO) {
        return studentService.queryConfrontResult(queryDTO);
    }

    @ApiOperation(value = "报告成绩",notes = "@author mhy")
    @PostMapping("/student/getreportgrades")
    public ResponseDTO<List<StudentQueryreportGradeVO>> queryreportGrade(@RequestBody StudentQueryReportDetailDTO queryDTO) {
        return studentService.queryreportGrade(queryDTO);
    }

    @ApiOperation(value = "提交对抗练习",notes = "@author mhy")
    @PostMapping("/student/answerconfront")
    public ResponseDTO<String> addConfront(@RequestBody StudentSubmitConfrontationDTO queryDTO) {
        return studentService.addConfront(queryDTO);
    }



    @ApiOperation(value = "获取当前所学课程",notes = "@author mhy")
    @PostMapping("/student/getcourse")
    public ResponseDTO<List<StudentGetCourseVO>> queryCourse(@RequestBody StudentGetCourseDTO queryDTO) {
        return studentService.queryCourse(queryDTO);
    }

    @ApiOperation(value = "实验项目",notes = "@author mhy")
    @PostMapping("/student/getproject")
    public ResponseDTO<List<StudentQueryProjectVO>> queryProject(@RequestBody StudentQueryProjectDTO queryDTO) {
        return studentService.queryProject(queryDTO);
    }

    @ApiOperation(value = "课程成绩",notes = "@author mhy")
    @PostMapping("/student/getgrades")
    public ResponseDTO<List<StudentQueryGradeVO>> queryGrade(@RequestBody StudentQueryGradeDTO queryDTO) {
        return studentService.queryGrade(queryDTO);
    }

    @ApiOperation(value = "查看实验项目详情",notes = "@author mhy")
    @PostMapping("/student/projectdetail")
    public ResponseDTO<List<StudentQueryProjectDetailVO>> queryProjectDetail(@RequestBody StudentQueryProjectDetailDTO queryDTO) {
        return studentService.queryProjectDetail(queryDTO);
    }



    @ApiOperation(value = "获取实验报告",notes = "@author mhy")
    @PostMapping("/student/reportdetail")
    public ResponseDTO<List<StudentQueryReportDetailVO>> queryReportDetail(@RequestBody StudentQueryReportDetailDTO queryDTO) {
        return studentService.queryReportDetail(queryDTO);
    }

    @ApiOperation(value = "保存实验报告",notes = "@author mhy")
    @PostMapping("/student/savereport")
    public ResponseDTO<String> addReport(@RequestBody StudentQueryAddReportDTO queryDTO) {
        return studentService.addReport(queryDTO);
    }





    @ApiOperation(value = "分页查询学生信息",notes = "@author mhy")
    @PostMapping("/student/page/query")
    public ResponseDTO<PageResultDTO<StudentVO>> queryByPage(@RequestBody StudentQueryDTO queryDTO) {
        return studentService.queryByPage(queryDTO);
    }



    @ApiOperation(value = "添加学生信息",notes = "@author mhy")
    @PostMapping("/student/add")
    public ResponseDTO<String> add(@RequestBody @Validated StudentAddDTO addTO){
        return studentService.add(addTO);
    }

    @ApiOperation(value="修改学生信息",notes = "@author mhy")
    @PostMapping("/student/update")
    public ResponseDTO<String> update(@RequestBody @Validated StudentUpdateDTO updateDTO){
        return studentService.update(updateDTO);
    }

    @ApiOperation(value="批量删除学生信息",notes = "@author mhy")
    @PostMapping("/student/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return studentService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/student/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<StudentExcelVO> studentList = studentService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("学生信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, StudentExcelVO.class, studentList);
        downloadExcel("学生信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/student/export/all")
    public void exportAll(@RequestBody @Validated StudentQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<StudentExcelVO> studentList = studentService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("学生信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, StudentExcelVO.class, studentList);
        downloadExcel("学生信息", workbook, response);
    }

}
