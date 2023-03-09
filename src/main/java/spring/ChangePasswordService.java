package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ChangePasswordService {

    @Autowired
    @Qualifier("changePwd")
    private MemberDao memberDao;

    public void changePassword( String email, String oldPwd, String newPwd){

        Member member = memberDao.selectByEmail(email);
        if( member == null){
            throw new MemberNotFoundException();
        }

        member.changePassword(oldPwd, newPwd);

        memberDao.update(member);
    }

}
