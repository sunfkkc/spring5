package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.Member;
import spring.MemberDao;
import spring.MemberRegisterService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class RestMemberController {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberRegisterService memberRegisterService;

    @GetMapping("/api/members")
    public List<Member> members(){
        return memberDao.selectAll();
    }

    @GetMapping("/api/members/{id}")
    public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Member member = memberDao.selectById(id);
        if(member==null) {response.sendError(HttpServletResponse.SC_NOT_FOUND); return null;}

        return member;

    }
}
