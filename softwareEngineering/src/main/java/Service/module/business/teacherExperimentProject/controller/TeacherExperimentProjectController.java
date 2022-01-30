package Service.module.business.teacherExperimentProject.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.module.business.teacherExperimentProject.service.TeacherExperimentProjectService;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.teacherExperimentProject.domain.dto.TeacherExperimentProjectAddDTO;
import Service.module.business.teacherExperimentProject.domain.dto.TeacherExperimentProjectUpdateDTO;
import Service.module.business.teacherExperimentProject.domain.dto.TeacherExperimentProjectQueryDTO;
import Service.module.business.teacherExperimentProject.domain.vo.TeacherExperimentProjectVO;
import Service.module.business.teacherExperimentProject.domain.vo.TeacherExperimentProjectExcelVO;
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
 * [ 实验项目发布信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:10:10
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_PUBLISHINGING_EX})
public class TeacherExperimentProjectController extends BaseController {

    @Autowired
    private TeacherExperimentProjectService teacherExperimentProjectService;

    @ApiOperation(value = "分页查询实验项目发布信息",notes = "@author mhy")
    @PostMapping("/teacherExperimentProject/page/query")
    public ResponseDTO<PageResultDTO<TeacherExperimentProjectVO>> queryByPage(@RequestBody TeacherExperimentProjectQueryDTO queryDTO) {
        return teacherExperimentProjectService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加实验项目发布信息",notes = "@author mhy")
    @PostMapping("/teacherExperimentProject/add")
    public ResponseDTO<String> add(@RequestBody @Validated TeacherExperimentProjectAddDTO addTO){
        return teacherExperimentProjectService.add(addTO);
    }

    @ApiOperation(value="修改实验项目发布信息",notes = "@author mhy")
    @PostMapping("/teacherExperimentProject/update")
    public ResponseDTO<String> update(@RequestBody @Validated TeacherExperimentProjectUpdateDTO updateDTO){
        return teacherExperimentProjectService.update(updateDTO);
    }

    @ApiOperation(value="批量删除实验项目发布信息",notes = "@author mhy")
    @PostMapping("/teacherExperimentProject/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return teacherExperimentProjectService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/teacherExperimentProject/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<TeacherExperimentProjectExcelVO> teacherExperimentProjectList = teacherExperimentProjectService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("实验项目发布信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TeacherExperimentProjectExcelVO.class, teacherExperimentProjectList);
        downloadExcel("实验项目发布信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/teacherExperimentProject/export/all")
    public void exportAll(@RequestBody @Validated TeacherExperimentProjectQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<TeacherExperimentProjectExcelVO> teacherExperimentProjectList = teacherExperimentProjectService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("实验项目发布信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TeacherExperimentProjectExcelVO.class, teacherExperimentProjectList);
        downloadExcel("实验项目发布信息", workbook, response);
    }

}
