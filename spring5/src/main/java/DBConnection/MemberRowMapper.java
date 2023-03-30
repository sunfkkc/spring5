package DBConnection;

import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member(

                rs.getString("EMAIL"),
                rs.getString("PWD"),
                rs.getString("USERNAME"),
                rs.getTimestamp("REGDATE").toLocalDateTime());

        member.setId(rs.getLong("ID"));

        return member;
    }
}
