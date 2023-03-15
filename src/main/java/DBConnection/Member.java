package DBConnection;

import java.time.LocalDateTime;

public class Member {

    private long id;

    private String email;
    private String password;
    private String name;
    private LocalDateTime regDate;

    public Member(String email, String password, String name, LocalDateTime regDate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.regDate = regDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
