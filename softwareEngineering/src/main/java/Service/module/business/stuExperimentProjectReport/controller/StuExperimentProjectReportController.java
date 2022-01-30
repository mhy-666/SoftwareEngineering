package Service.module.business.stuExperimentProjectReport.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.stuExperimentProjectReport.domain.dto.StuExperimentProjectReportAddDTO;
import Service.module.business.stuExperimentProjectReport.domain.dto.StuExperimentProjectReportUpdateDTO;
import Service.module.business.stuExperimentProjectReport.domain.dto.StuExperimentProjectReportQueryDTO;
import Service.module.business.stuExperimentProjectReport.domain.vo.StuExperimentProjectReportVO;
import Service.module.business.stuExperimentProjectReport.domain.vo.StuExperimentProjectReportExcelVO;
import Service.module.business.stuExperimentProjectReport.service.StuExperimentProjectReportService;
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
 * [ 实验报告提交信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:21:27
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_REPORT})
public class StuExperimentProjectReportController extends BaseController {

    @Autowired
    private StuExperimentProjectReportService stuExperimentProjectReportService;

    @ApiOperation(value = "分页查询实验报告提交信息",notes = "@author mhy")
    @PostMapping("/stuExperimentProjectReport/page/query")
    public ResponseDTO<PageResultDTO<StuExperimentProjectReportVO>> queryByPage(@RequestBody StuExperimentProjectReportQueryDTO queryDTO) {
        return stuExperimentProjectReportService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加实验报告提交信息",notes = "@author mhy")
    @PostMapping("/stuExperimentProjectReport/add")
    public ResponseDTO<String> add(@RequestBody @Validated StuExperimentProjectReportAddDTO addTO){
        return stuExperimentProjectReportService.add(addTO);
    }

    @ApiOperation(value="修改实验报告提交信息",notes = "@author mhy")
    @PostMapping("/stuExperimentProjectReport/update")
    public ResponseDTO<String> update(@RequestBody @Validated StuExperimentProjectReportUpdateDTO updateDTO){
        return stuExperimentProjectReportService.update(updateDTO);
    }

    @ApiOperation(value="批量删除实验报告提交信息",notes = "@author mhy")
    @PostMapping("/stuExperimentProjectReport/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return stuExperimentProjectReportService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/stuExperimentProjectReport/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<StuExperimentProjectReportExcelVO> stuExperimentProjectReportList = stuExperimentProjectReportService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("实验报告提交信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, StuExperimentProjectReportExcelVO.class, stuExperimentProjectReportList);
        downloadExcel("实验报告提交信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/stuExperimentProjectReport/export/all")
    public void exportAll(@RequestBody @Validated StuExperimentProjectReportQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<StuExperimentProjectReportExcelVO> stuExperimentProjectReportList = stuExperimentProjectReportService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("实验报告提交信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, StuExperimentProjectReportExcelVO.class, stuExperimentProjectReportList);
        downloadExcel("实验报告提交信息", workbook, response);
    }

}
