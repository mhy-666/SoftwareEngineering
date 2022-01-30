package Service.module.business.confrontationExercise.controller;

import Service.common.domain.PageResultDTO;
import Service.common.controller.BaseController;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.module.business.confrontationExercise.domain.dto.ConfrontationExerciseAddDTO;
import Service.module.business.confrontationExercise.domain.dto.ConfrontationExerciseUpdateDTO;
import Service.module.business.confrontationExercise.domain.dto.ConfrontationExerciseQueryDTO;
import Service.module.business.confrontationExercise.domain.vo.ConfrontationExerciseVO;
import Service.module.business.confrontationExercise.domain.vo.ConfrontationExerciseExcelVO;
import Service.module.business.confrontationExercise.service.ConfrontationExerciseService;
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
 * [ 对抗练习信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-21 22:41:43
 * @since JDK1.8
 */
@RestController
@Api(tags = {"对抗练习信息"})
public class ConfrontationExerciseController extends BaseController {

    @Autowired
    private ConfrontationExerciseService confrontationExerciseService;

    @ApiOperation(value = "分页查询对抗练习信息",notes = "@author mhy")
    @PostMapping("/confrontationExercise/page/query")
    public ResponseDTO<PageResultDTO<ConfrontationExerciseVO>> queryByPage(@RequestBody ConfrontationExerciseQueryDTO queryDTO) {
        return confrontationExerciseService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加对抗练习信息",notes = "@author mhy")
    @PostMapping("/confrontationExercise/add")
    public ResponseDTO<String> add(@RequestBody @Validated ConfrontationExerciseAddDTO addTO){
        return confrontationExerciseService.add(addTO);
    }

    @ApiOperation(value="修改对抗练习信息",notes = "@author mhy")
    @PostMapping("/confrontationExercise/update")
    public ResponseDTO<String> update(@RequestBody @Validated ConfrontationExerciseUpdateDTO updateDTO){
        return confrontationExerciseService.update(updateDTO);
    }

    @ApiOperation(value="批量删除对抗练习信息",notes = "@author mhy")
    @PostMapping("/confrontationExercise/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return confrontationExerciseService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/confrontationExercise/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<ConfrontationExerciseExcelVO> confrontationExerciseList = confrontationExerciseService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("对抗练习信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ConfrontationExerciseExcelVO.class, confrontationExerciseList);
        downloadExcel("对抗练习信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/confrontationExercise/export/all")
    public void exportAll(@RequestBody @Validated ConfrontationExerciseQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<ConfrontationExerciseExcelVO> confrontationExerciseList = confrontationExerciseService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("对抗练习信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ConfrontationExerciseExcelVO.class, confrontationExerciseList);
        downloadExcel("对抗练习信息", workbook, response);
    }

}
