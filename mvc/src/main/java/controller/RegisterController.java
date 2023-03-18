package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private MemberRegisterService memberRegisterService;

    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @GetMapping("/step1")
    public String handleStep1(){
        return "register/step1";
    }

    @GetMapping("/step2")
    public String showStep2(){
        return "register/step2";
    }

    @PostMapping("/step2")
    public String handleStep2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree
    ){
        if( !agree) return "redirect:step1";

        return "register/step2";
    }

    @PostMapping("/step3")
    public String handleStep3(RegisterRequest regReq){
        try{
            memberRegisterService.regist(regReq);
            return "register/step3";
        }catch (DuplicateMemberException ex){
            return "redirect:step2";
        }
    }


}
