package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Date;

@Entity
public class User {
    @Id // primary key
    @GeneratedValue(strategy= GenerationType.IDENTITY) // match with auto increment
    private Integer id;

    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String gender;

    @Size(min = 8, max = 15)
    private String password;

    @NotBlank
    private String profession;
    private String note;
    private Date birthday;

    private boolean married;
    // getters and setters...
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }
    public boolean isMarried() { return married; }
    public void setMarried(boolean married) { this.married = married; }
    // override toString()
    @Override
    public String toString() {
        return "User: [" + name + ", " + email + ", " + gender + ", " + password + ", "
                + profession + ", " + note + ", " + birthday + ", " + married + "]";
    }
}