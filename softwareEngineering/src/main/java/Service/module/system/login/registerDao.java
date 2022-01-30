package Service.module.system.login;


import Service.module.system.employee.domain.entity.EmployeeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface registerDao extends BaseMapper<EmployeeEntity> {

}
