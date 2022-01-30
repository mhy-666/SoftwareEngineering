package Service.module.business.classinfo.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.classinfo.dao.ClassinfoDao;
import Service.module.business.classinfo.domain.dto.ClassinfoAddDTO;
import Service.module.business.classinfo.domain.dto.ClassinfoQueryDTO;
import Service.module.business.classinfo.domain.dto.ClassinfoUpdateDTO;
import Service.module.business.classinfo.domain.entity.ClassinfoEntity;
import Service.module.business.classinfo.domain.vo.ClassinfoExcelVO;
import Service.module.business.classinfo.domain.vo.ClassinfoVO;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class ClassinfoService {

    @Autowired
    private ClassinfoDao classinfoDao;

    /**
     * 根据id查询
     */
    public ClassinfoEntity getById(Long id){
        return  classinfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-02 20:44:23
     */
    public ResponseDTO<PageResultDTO<ClassinfoVO>> queryByPage(ClassinfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<ClassinfoVO> voList = classinfoDao.queryByPage(page, queryDTO);
        PageResultDTO<ClassinfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-02 20:44:23
     */
    public ResponseDTO<String> add(ClassinfoAddDTO addDTO) {
        ClassinfoEntity entity = SmartBeanUtil.copy(addDTO, ClassinfoEntity.class);
        classinfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-02 20:44:23
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(ClassinfoUpdateDTO updateDTO) {
        ClassinfoEntity entity = SmartBeanUtil.copy(updateDTO, ClassinfoEntity.class);
        classinfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-02 20:44:23
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        classinfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-02 20:44:23
     */
    public List<ClassinfoExcelVO> queryAllExportData(ClassinfoQueryDTO queryDTO) {
        return classinfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-02 20:44:23
     */
    public List<ClassinfoExcelVO> queryBatchExportData(List<Long> idList) {
        return classinfoDao.queryBatchExportData(idList);
    }
}
