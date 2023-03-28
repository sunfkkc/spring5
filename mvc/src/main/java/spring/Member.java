package spring;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;

public class Member {

    private Long id;
    private String email;
    private String password;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime registerDateTime;
    @Nullable
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Member(String email, String password, String name, LocalDateTime registerDateTime, LocalDate birthDate) {
        this(email,password,name,registerDateTime);
        this.birthDate = birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Member(String email, String password,
                  String name, LocalDateTime regDateTime) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDateTime = regDateTime;
    }

    void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!password.equals(oldPassword))
            throw new WrongIdPasswordException();
        this.password = newPassword;
    }

    public boolean matchPassword(String password){
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", registerDateTime=" + registerDateTime +
                ", birthDate=" + birthDate +
                '}';
    }
}