package spring;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<Member> memRowMapper =
            new RowMapper<Member>() {
                @Override
                public Member mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    LocalDate birthDate = null;
                    if( rs.getDate("BIRTHDATE") !=null){
                        birthDate = rs.getDate("BIRTHDATE").toLocalDate();
                    }


                    Member member = new Member(rs.getString("EMAIL"),
                            rs.getString("PWD"),
                            rs.getString("USERNAME"),
                            rs.getTimestamp("REGDATE").toLocalDateTime(), birthDate );
                    member.setId(rs.getLong("ID"));
                    return member;
                }
            };

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where EMAIL = ?",
                memRowMapper, email);

        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {
                // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
                PreparedStatement pstmt = con.prepareStatement(
                        "insert into MEMBER (EMAIL, PWD, USERNAME, REGDATE,BIRTHDATE) " +
                                "values (?, ?, ?, ?, ?)",
                        new String[] { "ID" });
                // 인덱스 파라미터 값 설정
                pstmt.setString(1, member.getEmail());
                pstmt.setString(2, member.getPassword());
                pstmt.setString(3, member.getName());
                pstmt.setTimestamp(4,
                        Timestamp.valueOf(member.getRegisterDateTime()));
                pstmt.setDate(5,Date.valueOf(member.getBirthDate()));
//                pstmt.setTimestamp(5,Timestamp.valueOf(member.getBirthDate()));

                // 생성한 PreparedStatement 객체 리턴
                return pstmt;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {
        jdbcTemplate.update(
                "update MEMBER set USERNAME = ?, PWD = ? where EMAIL = ?",
                member.getName(), member.getPassword(), member.getEmail());
    }

    public List<Member> selectAll() {
        List<Member> results = jdbcTemplate.query("select * from MEMBER",
                memRowMapper);
        return results;
    }

    public int count() {
        Integer count = jdbcTemplate.queryForObject(
                "select count(*) from MEMBER", Integer.class);
        return count;
    }

    public List<Member> selectByRegdate(LocalDateTime from, LocalDateTime to) {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where REGDATE between ? and ? " +
                        "order by REGDATE desc",
                memRowMapper,
                from, to);
        return results;
    }

    public Member selectById(Long memId) {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where ID = ?",
                memRowMapper, memId);

        return results.isEmpty() ? null : results.get(0);
    }

}