package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    public ResponseEntity<Object> member(@PathVariable Long id) throws IOException {
        Member member = memberDao.selectById(id);
        if(member==null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));

        }

        return ResponseEntity.status(HttpStatus.OK).body(member);

    }

    @PostMapping("/api/members")
    public void newMember(@RequestBody @Valid RegisterRequest request, HttpServletResponse response) throws IOException{

        try{
            Long newMemberId = memberRegisterService.regist(request);
            response.setHeader("Location","/api/members/"+newMemberId);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (DuplicateMemberException e){
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
}
