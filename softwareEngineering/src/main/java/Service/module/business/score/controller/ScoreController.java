package Service.module.business.score.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.score.domain.dto.ScoreAddDTO;
import Service.module.business.score.domain.dto.ScoreUpdateDTO;
import Service.module.business.score.domain.dto.ScoreQueryDTO;
import Service.module.business.score.domain.vo.ScoreVO;
import Service.module.business.score.domain.vo.ScoreExcelVO;
import Service.module.business.score.service.ScoreService;
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
 * [ 课程成绩 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:13:10
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_SCORE})
public class ScoreController extends BaseController {

    @Autowired
    private ScoreService scoreService;

    @ApiOperation(value = "分页查询课程成绩",notes = "@author mhy")
    @PostMapping("/score/page/query")
    public ResponseDTO<PageResultDTO<ScoreVO>> queryByPage(@RequestBody ScoreQueryDTO queryDTO) {
        return scoreService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加课程成绩",notes = "@author mhy")
    @PostMapping("/score/add")
    public ResponseDTO<String> add(@RequestBody @Validated ScoreAddDTO addTO){
        return scoreService.add(addTO);
    }

    @ApiOperation(value="修改课程成绩",notes = "@author mhy")
    @PostMapping("/score/update")
    public ResponseDTO<String> update(@RequestBody @Validated ScoreUpdateDTO updateDTO){
        return scoreService.update(updateDTO);
    }

    @ApiOperation(value="批量删除课程成绩",notes = "@author mhy")
    @PostMapping("/score/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return scoreService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/score/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<ScoreExcelVO> scoreList = scoreService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("课程成绩", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ScoreExcelVO.class, scoreList);
        downloadExcel("课程成绩", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/score/export/all")
    public void exportAll(@RequestBody @Validated ScoreQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<ScoreExcelVO> scoreList = scoreService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("课程成绩", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ScoreExcelVO.class, scoreList);
        downloadExcel("课程成绩", workbook, response);
    }

}
