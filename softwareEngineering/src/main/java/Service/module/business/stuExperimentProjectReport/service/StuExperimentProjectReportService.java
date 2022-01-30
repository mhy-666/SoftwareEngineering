package Service.module.business.stuExperimentProjectReport.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.stuExperimentProjectReport.domain.dto.StuExperimentProjectReportQueryDTO;
import Service.module.business.stuExperimentProjectReport.domain.dto.StuExperimentProjectReportUpdateDTO;
import Service.module.business.stuExperimentProjectReport.domain.entity.StuExperimentProjectReportEntity;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.module.business.stuExperimentProjectReport.dao.StuExperimentProjectReportDao;
import Service.module.business.stuExperimentProjectReport.domain.dto.StuExperimentProjectReportAddDTO;
import Service.module.business.stuExperimentProjectReport.domain.vo.StuExperimentProjectReportVO;
import Service.module.business.stuExperimentProjectReport.domain.vo.StuExperimentProjectReportExcelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class StuExperimentProjectReportService {

    @Autowired
    private StuExperimentProjectReportDao stuExperimentProjectReportDao;

    /**
     * 根据id查询
     */
    public StuExperimentProjectReportEntity getById(Long id){
        return  stuExperimentProjectReportDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-12 00:21:27
     */
    public ResponseDTO<PageResultDTO<StuExperimentProjectReportVO>> queryByPage(StuExperimentProjectReportQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<StuExperimentProjectReportVO> voList = stuExperimentProjectReportDao.queryByPage(page, queryDTO);
        PageResultDTO<StuExperimentProjectReportVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-12 00:21:27
     */
    public ResponseDTO<String> add(StuExperimentProjectReportAddDTO addDTO) {
        StuExperimentProjectReportEntity entity = SmartBeanUtil.copy(addDTO, StuExperimentProjectReportEntity.class);
        stuExperimentProjectReportDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-12 00:21:27
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(StuExperimentProjectReportUpdateDTO updateDTO) {
        StuExperimentProjectReportEntity entity = SmartBeanUtil.copy(updateDTO, StuExperimentProjectReportEntity.class);
        stuExperimentProjectReportDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-12 00:21:27
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        stuExperimentProjectReportDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-12 00:21:27
     */
    public List<StuExperimentProjectReportExcelVO> queryAllExportData(StuExperimentProjectReportQueryDTO queryDTO) {
        return stuExperimentProjectReportDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-12 00:21:27
     */
    public List<StuExperimentProjectReportExcelVO> queryBatchExportData(List<Long> idList) {
        return stuExperimentProjectReportDao.queryBatchExportData(idList);
    }
}
