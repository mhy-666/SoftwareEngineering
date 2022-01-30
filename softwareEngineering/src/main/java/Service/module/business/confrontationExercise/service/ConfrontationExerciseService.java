package Service.module.business.confrontationExercise.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.confrontationExercise.dao.ConfrontationExerciseDao;
import Service.module.business.confrontationExercise.domain.dto.ConfrontationExerciseAddDTO;
import Service.module.business.confrontationExercise.domain.dto.ConfrontationExerciseUpdateDTO;
import Service.module.business.confrontationExercise.domain.dto.ConfrontationExerciseQueryDTO;
import Service.module.business.confrontationExercise.domain.entity.ConfrontationExerciseEntity;
import Service.module.business.confrontationExercise.domain.vo.ConfrontationExerciseVO;
import Service.module.business.confrontationExercise.domain.vo.ConfrontationExerciseExcelVO;
import Service.util.SmartPageUtil;
import Service.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class ConfrontationExerciseService {

    @Autowired
    private ConfrontationExerciseDao confrontationExerciseDao;

    /**
     * 根据id查询
     */
    public ConfrontationExerciseEntity getById(Long id){
        return  confrontationExerciseDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-21 22:41:43
     */
    public ResponseDTO<PageResultDTO<ConfrontationExerciseVO>> queryByPage(ConfrontationExerciseQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<ConfrontationExerciseVO> voList = confrontationExerciseDao.queryByPage(page, queryDTO);
        PageResultDTO<ConfrontationExerciseVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-21 22:41:43
     */
    public ResponseDTO<String> add(ConfrontationExerciseAddDTO addDTO) {
        ConfrontationExerciseEntity entity = SmartBeanUtil.copy(addDTO, ConfrontationExerciseEntity.class);
        confrontationExerciseDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-21 22:41:43
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(ConfrontationExerciseUpdateDTO updateDTO) {
        ConfrontationExerciseEntity entity = SmartBeanUtil.copy(updateDTO, ConfrontationExerciseEntity.class);
        confrontationExerciseDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-21 22:41:43
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        confrontationExerciseDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-21 22:41:43
     */
    public List<ConfrontationExerciseExcelVO> queryAllExportData(ConfrontationExerciseQueryDTO queryDTO) {
        return confrontationExerciseDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-21 22:41:43
     */
    public List<ConfrontationExerciseExcelVO> queryBatchExportData(List<Long> idList) {
        return confrontationExerciseDao.queryBatchExportData(idList);
    }
}
