package Service.module.business.stuConfrontationExercise.controller;

import Service.common.domain.PageResultDTO;
import Service.common.controller.BaseController;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.constant.SwaggerTagConst;
import Service.module.business.stuConfrontationExercise.domain.dto.*;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseQueryListVO;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseQueryQuestionVO;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseVO;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseExcelVO;
import Service.module.business.stuConfrontationExercise.service.StuConfrontationExerciseService;
import Service.module.business.teacher.domain.dto.TeacherQueryCourseDTO;
import Service.module.business.teacher.domain.dto.TeacherQueryReportDTO;
import Service.module.business.teacher.domain.vo.TeacherQueryCourseVO;
import Service.module.business.teacher.domain.vo.TeacherQueryReportVO;
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
 * [ 学生对抗练习作答情况 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-21 22:44:59
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_TEACHER})
public class StuConfrontationExerciseController extends BaseController {

    @Autowired
    private StuConfrontationExerciseService stuConfrontationExerciseService;


    @ApiOperation(value = "获取对抗练习题目",notes = "@author mhy")
    @PostMapping("/confront/question")
    public ResponseDTO<List<StuConfrontationExerciseQueryQuestionVO>> queryConfrontationQuestion(@RequestBody StuConfrontationExerciseQueryQuestionDTO queryDTO) {
        return stuConfrontationExerciseService.queryConfrontationQuestion(queryDTO);
    }

    @ApiOperation(value = "获取对抗练习列表",notes = "@author mhy")
    @PostMapping("/confront/getconfront")
    public ResponseDTO<List<StuConfrontationExerciseQueryListVO>> queryConfrontationList(@RequestBody StuConfrontationExerciseQueryListDTO queryDTO) {
        return stuConfrontationExerciseService.queryConfrontationList(queryDTO);
    }




    @ApiOperation(value = "分页查询学生对抗练习作答情况",notes = "@author mhy")
    @PostMapping("/stuConfrontationExercise/page/query")
    public ResponseDTO<PageResultDTO<StuConfrontationExerciseVO>> queryByPage(@RequestBody StuConfrontationExerciseQueryDTO queryDTO) {
        return stuConfrontationExerciseService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加学生对抗练习作答情况",notes = "@author mhy")
    @PostMapping("/stuConfrontationExercise/add")
    public ResponseDTO<String> add(@RequestBody @Validated StuConfrontationExerciseAddDTO addTO){
        return stuConfrontationExerciseService.add(addTO);
    }

    @ApiOperation(value="修改学生对抗练习作答情况",notes = "@author mhy")
    @PostMapping("/stuConfrontationExercise/update")
    public ResponseDTO<String> update(@RequestBody @Validated StuConfrontationExerciseUpdateDTO updateDTO){
        return stuConfrontationExerciseService.update(updateDTO);
    }

    @ApiOperation(value="批量删除学生对抗练习作答情况",notes = "@author mhy")
    @PostMapping("/stuConfrontationExercise/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return stuConfrontationExerciseService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/stuConfrontationExercise/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<StuConfrontationExerciseExcelVO> stuConfrontationExerciseList = stuConfrontationExerciseService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("学生对抗练习作答情况", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, StuConfrontationExerciseExcelVO.class, stuConfrontationExerciseList);
        downloadExcel("学生对抗练习作答情况", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/stuConfrontationExercise/export/all")
    public void exportAll(@RequestBody @Validated StuConfrontationExerciseQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<StuConfrontationExerciseExcelVO> stuConfrontationExerciseList = stuConfrontationExerciseService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("学生对抗练习作答情况", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, StuConfrontationExerciseExcelVO.class, stuConfrontationExerciseList);
        downloadExcel("学生对抗练习作答情况", workbook, response);
    }

}
