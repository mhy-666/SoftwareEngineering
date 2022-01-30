package Service.module.business.teacherExperimentProject.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.module.business.teacherExperimentProject.dao.TeacherExperimentProjectDao;
import Service.module.business.teacherExperimentProject.domain.dto.TeacherExperimentProjectAddDTO;
import Service.module.business.teacherExperimentProject.domain.dto.TeacherExperimentProjectUpdateDTO;
import Service.module.business.teacherExperimentProject.domain.dto.TeacherExperimentProjectQueryDTO;
import Service.module.business.teacherExperimentProject.domain.entity.TeacherExperimentProjectEntity;
import Service.module.business.teacherExperimentProject.domain.vo.TeacherExperimentProjectVO;
import Service.module.business.teacherExperimentProject.domain.vo.TeacherExperimentProjectExcelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 实验项目发布信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:10:10
 * @since JDK1.8
 */
@Service
public class TeacherExperimentProjectService {

    @Autowired
    private TeacherExperimentProjectDao teacherExperimentProjectDao;

    /**
     * 根据id查询
     */
    public TeacherExperimentProjectEntity getById(Long id){
        return  teacherExperimentProjectDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-12 00:10:10
     */
    public ResponseDTO<PageResultDTO<TeacherExperimentProjectVO>> queryByPage(TeacherExperimentProjectQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<TeacherExperimentProjectVO> voList = teacherExperimentProjectDao.queryByPage(page, queryDTO);
        PageResultDTO<TeacherExperimentProjectVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-12 00:10:10
     */
    public ResponseDTO<String> add(TeacherExperimentProjectAddDTO addDTO) {
        TeacherExperimentProjectEntity entity = SmartBeanUtil.copy(addDTO, TeacherExperimentProjectEntity.class);
        teacherExperimentProjectDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-12 00:10:10
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(TeacherExperimentProjectUpdateDTO updateDTO) {
        TeacherExperimentProjectEntity entity = SmartBeanUtil.copy(updateDTO, TeacherExperimentProjectEntity.class);
        teacherExperimentProjectDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-12 00:10:10
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        teacherExperimentProjectDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-12 00:10:10
     */
    public List<TeacherExperimentProjectExcelVO> queryAllExportData(TeacherExperimentProjectQueryDTO queryDTO) {
        return teacherExperimentProjectDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-12 00:10:10
     */
    public List<TeacherExperimentProjectExcelVO> queryBatchExportData(List<Long> idList) {
        return teacherExperimentProjectDao.queryBatchExportData(idList);
    }
}
