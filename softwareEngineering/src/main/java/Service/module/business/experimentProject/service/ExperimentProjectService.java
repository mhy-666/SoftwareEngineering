package Service.module.business.experimentProject.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.experimentProject.domain.entity.ExperimentProjectEntity;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.module.business.experimentProject.dao.ExperimentProjectDao;
import Service.module.business.experimentProject.domain.dto.ExperimentProjectAddDTO;
import Service.module.business.experimentProject.domain.dto.ExperimentProjectUpdateDTO;
import Service.module.business.experimentProject.domain.dto.ExperimentProjectQueryDTO;
import Service.module.business.experimentProject.domain.vo.ExperimentProjectVO;
import Service.module.business.experimentProject.domain.vo.ExperimentProjectExcelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 教师发布实验项目 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:04:39
 * @since JDK1.8
 */
@Service
public class ExperimentProjectService {

    @Autowired
    private ExperimentProjectDao experimentProjectDao;

    /**
     * 根据id查询
     */
    public ExperimentProjectEntity getById(Long id){
        return  experimentProjectDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-12 00:04:39
     */
    public ResponseDTO<PageResultDTO<ExperimentProjectVO>> queryByPage(ExperimentProjectQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<ExperimentProjectVO> voList = experimentProjectDao.queryByPage(page, queryDTO);
        PageResultDTO<ExperimentProjectVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-12 00:04:39
     */
    public ResponseDTO<String> add(ExperimentProjectAddDTO addDTO) {
        ExperimentProjectEntity entity = SmartBeanUtil.copy(addDTO, ExperimentProjectEntity.class);
        experimentProjectDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-12 00:04:39
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(ExperimentProjectUpdateDTO updateDTO) {
        ExperimentProjectEntity entity = SmartBeanUtil.copy(updateDTO, ExperimentProjectEntity.class);
        experimentProjectDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-12 00:04:39
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        experimentProjectDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-12 00:04:39
     */
    public List<ExperimentProjectExcelVO> queryAllExportData(ExperimentProjectQueryDTO queryDTO) {
        return experimentProjectDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-12 00:04:39
     */
    public List<ExperimentProjectExcelVO> queryBatchExportData(List<Long> idList) {
        return experimentProjectDao.queryBatchExportData(idList);
    }
}
