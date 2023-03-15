package DBConnection;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email){

    List<Member> members = jdbcTemplate.query("select * from member WHERE EMAIL = ?",(ResultSet rs, int rowNum)->{

            Member member = new Member(

                rs.getString("EMAIL"),
                rs.getString("PWD"),
                rs.getString("USERNAME"),
                rs.getTimestamp("REGDATE").toLocalDateTime());

            member.setId(rs.getLong("ID"));

            return member;


        },email);

        return members.isEmpty() ? null : members.get(0);
    }



    public void insert(Member member){}

    public void update(Member member){}

    public List<Member> selectAll(){

        List<Member> members = jdbcTemplate.query("select * from member",(ResultSet rs, int rowNum)->{

            Member member = new Member(

                    rs.getString("EMAIL"),
                    rs.getString("PWD"),
                    rs.getString("USERNAME"),
                    rs.getTimestamp("REGDATE").toLocalDateTime());

            member.setId(rs.getLong("ID"));

            return member;
        });

        return members;

    }




}
