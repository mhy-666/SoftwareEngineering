package Service.module.business.courseResource.controller;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.common.domain.ValidateList;
import Service.common.controller.BaseController;
import Service.constant.SwaggerTagConst;
import Service.module.business.courseResource.domain.dto.CourseResourceAddDTO;
import Service.module.business.courseResource.domain.dto.CourseResourceUpdateDTO;
import Service.module.business.courseResource.domain.dto.CourseResourceQueryDTO;
import Service.module.business.courseResource.domain.vo.CourseResourceVO;
import Service.module.business.courseResource.domain.vo.CourseResourceExcelVO;
import Service.module.business.courseResource.service.CourseResourceService;
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
 * [ 教学资料库 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:00:05
 * @since JDK1.8
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_COURSE_RESOURCES})
public class CourseResourceController extends BaseController {

    @Autowired
    private CourseResourceService courseResourceService;

    @ApiOperation(value = "分页查询教学资料库",notes = "@author mhy")
    @PostMapping("/courseResource/page/query")
    public ResponseDTO<PageResultDTO<CourseResourceVO>> queryByPage(@RequestBody CourseResourceQueryDTO queryDTO) {
        return courseResourceService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加教学资料库",notes = "@author mhy")
    @PostMapping("/courseResource/add")
    public ResponseDTO<String> add(@RequestBody @Validated CourseResourceAddDTO addTO){
        return courseResourceService.add(addTO);
    }

    @ApiOperation(value="修改教学资料库",notes = "@author mhy")
    @PostMapping("/courseResource/update")
    public ResponseDTO<String> update(@RequestBody @Validated CourseResourceUpdateDTO updateDTO){
        return courseResourceService.update(updateDTO);
    }

    @ApiOperation(value="批量删除教学资料库",notes = "@author mhy")
    @PostMapping("/courseResource/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return courseResourceService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author mhy")
    @PostMapping("/courseResource/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<CourseResourceExcelVO> courseResourceList = courseResourceService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("教学资料库", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CourseResourceExcelVO.class, courseResourceList);
        downloadExcel("教学资料库", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author mhy")
    @PostMapping("/courseResource/export/all")
    public void exportAll(@RequestBody @Validated CourseResourceQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<CourseResourceExcelVO> courseResourceList = courseResourceService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("教学资料库", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CourseResourceExcelVO.class, courseResourceList);
        downloadExcel("教学资料库", workbook, response);
    }

}
