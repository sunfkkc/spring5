package DBConnection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForMemberDao {

    private static MemberDao memberDao;
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        MemberDao memberDao1 = ctx.getBean(MemberDao.class);

        Member member = memberDao1.selectByEmail("rlcks77@nate.com");

        System.out.println(member.toString());
    }
}
