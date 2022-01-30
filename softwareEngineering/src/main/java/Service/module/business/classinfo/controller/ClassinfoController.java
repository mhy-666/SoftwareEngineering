package Service.module.business.classinfo.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.module.business.classinfo.domain.dto.ClassinfoAddDTO;
import Service.module.business.classinfo.domain.dto.ClassinfoQueryDTO;
import Service.module.business.classinfo.domain.dto.ClassinfoUpdateDTO;
import Service.module.business.classinfo.domain.vo.ClassinfoExcelVO;
import Service.module.business.classinfo.domain.vo.ClassinfoVO;
import Service.module.business.classinfo.service.ClassinfoService;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
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
 * [ 实验班级信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-02 20:44:23
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_CLASSINFO})
public class ClassinfoController extends BaseController {

    @Autowired
    private ClassinfoService classinfoService;

    @ApiOperation(value = "分页查询实验班级信息",notes = "@author mhy")
    @PostMapping("/classinfo/page/query")
    public ResponseDTO<PageResultDTO<ClassinfoVO>> queryByPage(@RequestBody ClassinfoQueryDTO queryDTO) {
        return classinfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加实验班级信息",notes = "@author mhy")
    @PostMapping("/classinfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated ClassinfoAddDTO addTO){
        return classinfoService.add(addTO);
    }

    @ApiOperation(value="修改实验班级信息",notes = "@author mhy")
    @PostMapping("/classinfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated ClassinfoUpdateDTO updateDTO){
        return classinfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除实验班级信息",notes = "@author mhy")
    @PostMapping("/classinfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return classinfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/classinfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<ClassinfoExcelVO> classinfoList = classinfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("实验班级信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ClassinfoExcelVO.class, classinfoList);
        downloadExcel("实验班级信息", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/classinfo/export/all")
    public void exportAll(@RequestBody @Validated ClassinfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<ClassinfoExcelVO> classinfoList = classinfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("实验班级信息", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ClassinfoExcelVO.class, classinfoList);
        downloadExcel("实验班级信息", workbook, response);
    }

}
