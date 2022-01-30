package Service.module.business.questions.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.questions.dao.QuestionsDao;
import Service.module.business.questions.domain.dto.QuestionsAddDTO;
import Service.module.business.questions.domain.dto.QuestionsUpdateDTO;
import Service.module.business.questions.domain.dto.QuestionsQueryDTO;
import Service.module.business.questions.domain.entity.QuestionsEntity;
import Service.module.business.questions.domain.vo.QuestionsVO;
import Service.module.business.questions.domain.vo.QuestionsExcelVO;
import Service.util.SmartPageUtil;
import Service.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [  ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-22 15:34:53
 * @since JDK1.8
 */
@Service
public class QuestionsService {

    @Autowired
    private QuestionsDao questionsDao;

    /**
     * 根据id查询
     */
    public QuestionsEntity getById(Long id){
        return  questionsDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-22 15:34:53
     */
    public ResponseDTO<PageResultDTO<QuestionsVO>> queryByPage(QuestionsQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<QuestionsVO> voList = questionsDao.queryByPage(page, queryDTO);
        PageResultDTO<QuestionsVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-22 15:34:53
     */
    public ResponseDTO<String> add(QuestionsAddDTO addDTO) {
        QuestionsEntity entity = SmartBeanUtil.copy(addDTO, QuestionsEntity.class);
        questionsDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-22 15:34:53
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(QuestionsUpdateDTO updateDTO) {
        QuestionsEntity entity = SmartBeanUtil.copy(updateDTO, QuestionsEntity.class);
        questionsDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-22 15:34:53
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        questionsDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-22 15:34:53
     */
    public List<QuestionsExcelVO> queryAllExportData(QuestionsQueryDTO queryDTO) {
        return questionsDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-22 15:34:53
     */
    public List<QuestionsExcelVO> queryBatchExportData(List<Long> idList) {
        return questionsDao.queryBatchExportData(idList);
    }
}
