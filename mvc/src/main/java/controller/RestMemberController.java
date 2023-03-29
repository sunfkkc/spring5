package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.*;


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
    public Member member(@PathVariable Long id) throws IOException {
        Member member = memberDao.selectById(id);
        if(member==null) {

            throw new MemberNotFoundException();

        }

        return member;

    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoData(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
    }

    @PostMapping("/api/members")
    public ResponseEntity<Object> newMember(@RequestBody @Valid RegisterRequest request) throws IOException{

        try{
            Long newMemberId = memberRegisterService.regist(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(memberDao.selectById(newMemberId));

        }catch (DuplicateMemberException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("이메일 중복입니다."));
        }
    }
}
