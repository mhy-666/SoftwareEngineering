package Service.module.business.experimentProject.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.module.business.experimentProject.service.ExperimentProjectService;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.experimentProject.domain.dto.ExperimentProjectAddDTO;
import Service.module.business.experimentProject.domain.dto.ExperimentProjectUpdateDTO;
import Service.module.business.experimentProject.domain.dto.ExperimentProjectQueryDTO;
import Service.module.business.experimentProject.domain.vo.ExperimentProjectVO;
import Service.module.business.experimentProject.domain.vo.ExperimentProjectExcelVO;
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
 * [ 教师发布实验项目 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:04:39
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_EXPERIMENTPROJECT})
public class ExperimentProjectController extends BaseController {

    @Autowired
    private ExperimentProjectService experimentProjectService;

    @ApiOperation(value = "分页查询教师发布实验项目",notes = "@author mhy")
    @PostMapping("/experimentProject/page/query")
    public ResponseDTO<PageResultDTO<ExperimentProjectVO>> queryByPage(@RequestBody ExperimentProjectQueryDTO queryDTO) {
        return experimentProjectService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加教师发布实验项目",notes = "@author mhy")
    @PostMapping("/experimentProject/add")
    public ResponseDTO<String> add(@RequestBody @Validated ExperimentProjectAddDTO addTO){
        return experimentProjectService.add(addTO);
    }

    @ApiOperation(value="修改教师发布实验项目",notes = "@author mhy")
    @PostMapping("/experimentProject/update")
    public ResponseDTO<String> update(@RequestBody @Validated ExperimentProjectUpdateDTO updateDTO){
        return experimentProjectService.update(updateDTO);
    }

    @ApiOperation(value="批量删除教师发布实验项目",notes = "@author mhy")
    @PostMapping("/experimentProject/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return experimentProjectService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/experimentProject/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<ExperimentProjectExcelVO> experimentProjectList = experimentProjectService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("教师发布实验项目", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ExperimentProjectExcelVO.class, experimentProjectList);
        downloadExcel("教师发布实验项目", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/experimentProject/export/all")
    public void exportAll(@RequestBody @Validated ExperimentProjectQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<ExperimentProjectExcelVO> experimentProjectList = experimentProjectService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("教师发布实验项目", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ExperimentProjectExcelVO.class, experimentProjectList);
        downloadExcel("教师发布实验项目", workbook, response);
    }

}
