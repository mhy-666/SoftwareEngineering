package Service.module.business.teaching.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.module.business.teaching.service.TeachingService;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.teaching.domain.dto.TeachingAddDTO;
import Service.module.business.teaching.domain.dto.TeachingUpdateDTO;
import Service.module.business.teaching.domain.dto.TeachingQueryDTO;
import Service.module.business.teaching.domain.vo.TeachingVO;
import Service.module.business.teaching.domain.vo.TeachingExcelVO;
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
 * [ 授课信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:24:09
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_TEACHING})
public class TeachingController extends BaseController {

    @Autowired
    private TeachingService teachingService;

    @ApiOperation(value = "分页查询授课信息",notes = "@author mhy")
    @PostMapping("/teaching/page/query")
    public ResponseDTO<PageResultDTO<TeachingVO>> queryByPage(@RequestBody TeachingQueryDTO queryDTO) {
        return teachingService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加授课信息",notes = "@author mhy")
    @PostMapping("/teaching/add")
    public ResponseDTO<String> add(@RequestBody @Validated TeachingAddDTO addTO){
        return teachingService.add(addTO);
    }

    @ApiOperation(value="修改授课信息",notes = "@author mhy")
    @PostMapping("/teaching/update")
    public ResponseDTO<String> update(@RequestBody @Validated TeachingUpdateDTO updateDTO){
        return teachingService.update(updateDTO);
    }

    @ApiOperation(value="批量删除授课信息",notes = "@author mhy")
    @PostMapping("/teaching/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return teachingService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/teaching/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<TeachingExcelVO> teachingList = teachingService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("授课信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TeachingExcelVO.class, teachingList);
        downloadExcel("授课信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/teaching/export/all")
    public void exportAll(@RequestBody @Validated TeachingQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<TeachingExcelVO> teachingList = teachingService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("授课信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TeachingExcelVO.class, teachingList);
        downloadExcel("授课信息", workbook, response);
    }

}
