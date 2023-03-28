package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;

@Controller
public class MemberDetailController {
    @Autowired
    private MemberDao memberDao;

    @GetMapping("/members/{id}")
    public String detail(@PathVariable("id") Long memId, Model model){
        Member member = memberDao.selectById(memId);
        if(member == null) throw new MemberNotFoundException();

        model.addAttribute("member",member);
        return "member/memberDetail";
    }
}
