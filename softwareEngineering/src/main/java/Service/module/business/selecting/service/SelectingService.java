package Service.module.business.selecting.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.selecting.domain.dto.SelectingUpdateDTO;
import Service.module.business.selecting.domain.entity.SelectingEntity;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.module.business.selecting.dao.SelectingDao;
import Service.module.business.selecting.domain.dto.SelectingAddDTO;
import Service.module.business.selecting.domain.dto.SelectingQueryDTO;
import Service.module.business.selecting.domain.vo.SelectingVO;
import Service.module.business.selecting.domain.vo.SelectingExcelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class SelectingService {

    @Autowired
    private SelectingDao selectingDao;

    /**
     * 根据id查询
     */
    public SelectingEntity getById(Long id){
        return  selectingDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-12 00:15:32
     */
    public ResponseDTO<PageResultDTO<SelectingVO>> queryByPage(SelectingQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<SelectingVO> voList = selectingDao.queryByPage(page, queryDTO);
        PageResultDTO<SelectingVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-12 00:15:32
     */
    public ResponseDTO<String> add(SelectingAddDTO addDTO) {
        SelectingEntity entity = SmartBeanUtil.copy(addDTO, SelectingEntity.class);
        selectingDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-12 00:15:32
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(SelectingUpdateDTO updateDTO) {
        SelectingEntity entity = SmartBeanUtil.copy(updateDTO, SelectingEntity.class);
        selectingDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-12 00:15:32
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        selectingDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-12 00:15:32
     */
    public List<SelectingExcelVO> queryAllExportData(SelectingQueryDTO queryDTO) {
        return selectingDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-12 00:15:32
     */
    public List<SelectingExcelVO> queryBatchExportData(List<Long> idList) {
        return selectingDao.queryBatchExportData(idList);
    }
}
