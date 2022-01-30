package Service.module.business.selecting.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.selecting.domain.dto.SelectingAddDTO;
import Service.module.business.selecting.domain.dto.SelectingUpdateDTO;
import Service.module.business.selecting.domain.dto.SelectingQueryDTO;
import Service.module.business.selecting.domain.vo.SelectingVO;
import Service.module.business.selecting.domain.vo.SelectingExcelVO;
import Service.module.business.selecting.service.SelectingService;
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
 * [ 学生课程信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:15:32
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_SELECTING})
public class SelectingController extends BaseController {

    @Autowired
    private SelectingService selectingService;

    @ApiOperation(value = "分页查询学生课程信息",notes = "@author mhy")
    @PostMapping("/selecting/page/query")
    public ResponseDTO<PageResultDTO<SelectingVO>> queryByPage(@RequestBody SelectingQueryDTO queryDTO) {
        return selectingService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加学生课程信息",notes = "@author mhy")
    @PostMapping("/selecting/add")
    public ResponseDTO<String> add(@RequestBody @Validated SelectingAddDTO addTO){
        return selectingService.add(addTO);
    }

    @ApiOperation(value="修改学生课程信息",notes = "@author mhy")
    @PostMapping("/selecting/update")
    public ResponseDTO<String> update(@RequestBody @Validated SelectingUpdateDTO updateDTO){
        return selectingService.update(updateDTO);
    }

    @ApiOperation(value="批量删除学生课程信息",notes = "@author mhy")
    @PostMapping("/selecting/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return selectingService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/selecting/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<SelectingExcelVO> selectingList = selectingService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("学生课程信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, SelectingExcelVO.class, selectingList);
        downloadExcel("学生课程信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/selecting/export/all")
    public void exportAll(@RequestBody @Validated SelectingQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<SelectingExcelVO> selectingList = selectingService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("学生课程信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, SelectingExcelVO.class, selectingList);
        downloadExcel("学生课程信息", workbook, response);
    }

}
