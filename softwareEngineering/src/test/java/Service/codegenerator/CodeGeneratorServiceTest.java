package Service.codegenerator;

import Service.BaseTest;
import Service.module.support.codegenerator.constant.SqlOperateTypeEnum;
import Service.module.support.codegenerator.domain.CodeGeneratorDTO;
import Service.module.support.codegenerator.domain.CodeGeneratorQueryColumnDTO;
import Service.module.support.codegenerator.service.CodeGeneratorService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * IdGeneratorService Tester.
 *
 * @author zhuoda
 * @version 1.0
 */
public class CodeGeneratorServiceTest extends BaseTest {

    @Autowired
    private CodeGeneratorService codeGeneratorService;

    @Test
    public void testGenerate() throws Exception {
        /**
         * !!! 所有查询条件均包含了createTime和updateTime的 范围查询 !!!
         */

        // t_peony 牡丹花表
        CodeGeneratorQueryColumnDTO question_id = CodeGeneratorQueryColumnDTO.builder()
                .columnName("question_id")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        //搜索字段 kind， 使用like搜索
        CodeGeneratorQueryColumnDTO question = CodeGeneratorQueryColumnDTO.builder()
                .columnName("question")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
        //搜索字段 kind， 使用like搜索
        CodeGeneratorQueryColumnDTO options = CodeGeneratorQueryColumnDTO.builder()
                .columnName("options")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        //搜索字段 kind， 使用 == 搜索
        CodeGeneratorQueryColumnDTO solution = CodeGeneratorQueryColumnDTO.builder()
                .columnName("solution")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();



//        CodeGeneratorQueryColumnDTO iffinish = CodeGeneratorQueryColumnDTO.builder()
//                .columnName("iffinish")
//                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
//        //搜索字段 color， 使用like搜索
//        CodeGeneratorQueryColumnDTO purpose = CodeGeneratorQueryColumnDTO.builder()
//                .columnName("purpose")
//                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
//        //搜索字段 name， 使用like搜索
//        CodeGeneratorQueryColumnDTO principle = CodeGeneratorQueryColumnDTO.builder()
//                .columnName("principle")
//                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
//        CodeGeneratorQueryColumnDTO content = CodeGeneratorQueryColumnDTO.builder()
//                .columnName("content")
//                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
//        //搜索字段 color， 使用like搜索
//        CodeGeneratorQueryColumnDTO summary = CodeGeneratorQueryColumnDTO.builder()
//                .columnName("summary")
//                .sqlOperate(SqlOperateTypeEnum.LIKE).build();
//        //搜索字段 name， 使用like搜索
//        CodeGeneratorQueryColumnDTO grade = CodeGeneratorQueryColumnDTO.builder()
//                .columnName("grade")
//                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
//        CodeGeneratorQueryColumnDTO correct_teacher_id = CodeGeneratorQueryColumnDTO.builder()
//                .columnName("correct_teacher_id")
//                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();


        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(question_id,question,options, solution);

        CodeGeneratorDTO codeGenerator = CodeGeneratorDTO.builder()
                .author("mhy")//class 注释作者
                .company("同济大学软件学院")//class注释公司名字
                .tableName("e_questions")//表名
                .tablePrefix("e_")//表名前缀
                .basePackage("Service")//包名
                .modulePackage("business.questions")//业务子包名
                .queryColumnList(queryColumnList)//加入搜搜字段
                .build();//构建

        //当需要代码生成的时候，请将注释去掉
        codeGeneratorService.codeGenerator(codeGenerator);
    }

}
