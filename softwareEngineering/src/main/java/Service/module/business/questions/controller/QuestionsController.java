package Service.module.business.questions.controller;

import Service.common.domain.PageResultDTO;
import Service.common.controller.BaseController;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.module.business.questions.domain.dto.QuestionsAddDTO;
import Service.module.business.questions.domain.dto.QuestionsUpdateDTO;
import Service.module.business.questions.domain.dto.QuestionsQueryDTO;
import Service.module.business.questions.domain.vo.QuestionsVO;
import Service.module.business.questions.domain.vo.QuestionsExcelVO;
import Service.module.business.questions.service.QuestionsService;
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
 * [  ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-22 15:34:53
 * @since JDK1.8
 */
@RestController
@Api(tags = {""})
public class QuestionsController extends BaseController {

    @Autowired
    private QuestionsService questionsService;

    @ApiOperation(value = "分页查询",notes = "@author mhy")
    @PostMapping("/questions/page/query")
    public ResponseDTO<PageResultDTO<QuestionsVO>> queryByPage(@RequestBody QuestionsQueryDTO queryDTO) {
        return questionsService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加",notes = "@author mhy")
    @PostMapping("/questions/add")
    public ResponseDTO<String> add(@RequestBody @Validated QuestionsAddDTO addTO){
        return questionsService.add(addTO);
    }

    @ApiOperation(value="修改",notes = "@author mhy")
    @PostMapping("/questions/update")
    public ResponseDTO<String> update(@RequestBody @Validated QuestionsUpdateDTO updateDTO){
        return questionsService.update(updateDTO);
    }

    @ApiOperation(value="批量删除",notes = "@author mhy")
    @PostMapping("/questions/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return questionsService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/questions/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<QuestionsExcelVO> questionsList = questionsService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, QuestionsExcelVO.class, questionsList);
        downloadExcel("", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/questions/export/all")
    public void exportAll(@RequestBody @Validated QuestionsQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<QuestionsExcelVO> questionsList = questionsService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, QuestionsExcelVO.class, questionsList);
        downloadExcel("", workbook, response);
    }

}
