package Service.module.system.login;

import Service.common.anno.NoNeedLogin;
import Service.common.anno.NoValidPrivilege;
import Service.common.anno.OperateLog;
import Service.common.domain.ResponseDTO;
import Service.constant.SwaggerTagConst;
import Service.module.system.employee.domain.dto.EmployeeLoginFormDTO;
import Service.module.system.login.domain.KaptchaVO;
import Service.module.system.login.domain.LoginDetailVO;
import Service.module.system.login.domain.RequestTokenBO;
import Service.util.SmartRequestTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 后台登录
 *
 * @author lidoudou
 * @date 2017年12月19日上午11:46:04
 */
@RestController
@Api(tags = {SwaggerTagConst.Admin.MANAGER_USER_LOGIN})
@OperateLog
public class LoginController {

    @Autowired
    private LoginService loginService;




    @PostMapping("/session/login")
    @ApiOperation(value = "登录", notes = "登录")
    @NoNeedLogin
    public ResponseDTO<LoginDetailVO> login(@Valid @RequestBody EmployeeLoginFormDTO loginForm, HttpServletRequest request) {
        return loginService.login(loginForm, request);
    }

    @GetMapping("/session/get")
    @ApiOperation(value = "获取session", notes = "获取session")
    @NoValidPrivilege
    public ResponseDTO<LoginDetailVO> getSession() {
        RequestTokenBO requestUser = SmartRequestTokenUtil.getRequestUser();
        return ResponseDTO.succData(loginService.getSession(requestUser));
    }

    @GetMapping("/session/logOut")
    @ApiOperation(value = "退出登陆", notes = "退出登陆")
    @NoValidPrivilege
    public ResponseDTO<Boolean> logOut() {
        RequestTokenBO requestToken = SmartRequestTokenUtil.getRequestUser();
        if (null == requestToken) {
            return ResponseDTO.wrap(LoginResponseCodeConst.LOGIN_ERROR);
        }
        return loginService.logoutByToken(requestToken);
    }

    @GetMapping("/session/verificationCode")
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    @NoNeedLogin
    public ResponseDTO<KaptchaVO> verificationCode() {
        return loginService.verificationCode();
    }

}
