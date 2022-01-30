package Service.module.business.score.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.score.domain.entity.ScoreEntity;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.module.business.score.dao.ScoreDao;
import Service.module.business.score.domain.dto.ScoreAddDTO;
import Service.module.business.score.domain.dto.ScoreUpdateDTO;
import Service.module.business.score.domain.dto.ScoreQueryDTO;
import Service.module.business.score.domain.vo.ScoreVO;
import Service.module.business.score.domain.vo.ScoreExcelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    /**
     * 根据id查询
     */
    public ScoreEntity getById(Long id){
        return  scoreDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-12 00:13:10
     */
    public ResponseDTO<PageResultDTO<ScoreVO>> queryByPage(ScoreQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<ScoreVO> voList = scoreDao.queryByPage(page, queryDTO);
        PageResultDTO<ScoreVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-12 00:13:10
     */
    public ResponseDTO<String> add(ScoreAddDTO addDTO) {
        ScoreEntity entity = SmartBeanUtil.copy(addDTO, ScoreEntity.class);
        scoreDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-12 00:13:10
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(ScoreUpdateDTO updateDTO) {
        ScoreEntity entity = SmartBeanUtil.copy(updateDTO, ScoreEntity.class);
        scoreDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-12 00:13:10
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        scoreDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-12 00:13:10
     */
    public List<ScoreExcelVO> queryAllExportData(ScoreQueryDTO queryDTO) {
        return scoreDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-12 00:13:10
     */
    public List<ScoreExcelVO> queryBatchExportData(List<Long> idList) {
        return scoreDao.queryBatchExportData(idList);
    }
}
