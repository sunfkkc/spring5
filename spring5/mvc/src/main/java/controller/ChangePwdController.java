package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.WrongIdPasswordException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {

    @Autowired
    private ChangePasswordService changePasswordService;

    @GetMapping
    public String form(@ModelAttribute("command") ChangePwdCommand pwdCommand, HttpSession session){

        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        if(authInfo==null){
            return "redirect:/login";
        }
        return "edit/changePwdForm";
    }

    @PostMapping
    public String submit(@ModelAttribute("command") @Valid ChangePwdCommand pwdCommand, Errors errors, HttpSession session){

        if(errors.hasErrors()){
            return "edit/changePwdForm";
        }

        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

        try{
            changePasswordService.changePassword(authInfo.getEmail(), pwdCommand.getCurrentPassword(), pwdCommand.getNewPassword());
            return "edit/changedPwd";
        }
        catch (WrongIdPasswordException e){
            errors.rejectValue("currentPassword","notMatching");
            return "edit/changePwdForm";
        }
    }
}
