package Service.module.business.scheduleTime.controller;

import Service.common.domain.PageResultDTO;
import Service.common.controller.BaseController;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.constant.SwaggerTagConst;
import Service.module.business.scheduleTime.domain.dto.ScheduleTimeAddDTO;
import Service.module.business.scheduleTime.domain.dto.ScheduleTimeUpdateDTO;
import Service.module.business.scheduleTime.domain.dto.ScheduleTimeQueryDTO;
import Service.module.business.scheduleTime.domain.vo.ScheduleTimeVO;
import Service.module.business.scheduleTime.domain.vo.ScheduleTimeExcelVO;
import Service.module.business.scheduleTime.service.ScheduleTimeService;
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
 * [ 上课安排 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-09 00:47:47
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_SCHEDULETIME})
public class ScheduleTimeController extends BaseController {

    @Autowired
    private ScheduleTimeService scheduleTimeService;

    @ApiOperation(value = "分页查询上课安排",notes = "@author mhy")
    @PostMapping("/scheduleTime/page/query")
    public ResponseDTO<PageResultDTO<ScheduleTimeVO>> queryByPage(@RequestBody ScheduleTimeQueryDTO queryDTO) {
        return scheduleTimeService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加上课安排",notes = "@author mhy")
    @PostMapping("/scheduleTime/add")
    public ResponseDTO<String> add(@RequestBody @Validated ScheduleTimeAddDTO addTO){
        return scheduleTimeService.add(addTO);
    }

    @ApiOperation(value="修改上课安排",notes = "@author mhy")
    @PostMapping("/scheduleTime/update")
    public ResponseDTO<String> update(@RequestBody @Validated ScheduleTimeUpdateDTO updateDTO){
        return scheduleTimeService.update(updateDTO);
    }

    @ApiOperation(value="批量删除上课安排",notes = "@author mhy")
    @PostMapping("/scheduleTime/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return scheduleTimeService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/scheduleTime/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<ScheduleTimeExcelVO> scheduleTimeList = scheduleTimeService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("上课安排", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ScheduleTimeExcelVO.class, scheduleTimeList);
        downloadExcel("上课安排", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/scheduleTime/export/all")
    public void exportAll(@RequestBody @Validated ScheduleTimeQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<ScheduleTimeExcelVO> scheduleTimeList = scheduleTimeService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("上课安排", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, ScheduleTimeExcelVO.class, scheduleTimeList);
        downloadExcel("上课安排", workbook, response);
    }

}
