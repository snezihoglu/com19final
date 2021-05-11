package iaau.webapp.user;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users1 {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String img;

    public Users1() {
    }

    public Users1(String username, String password, String img,String firstname,String lastname) {
        this.username=username;
        this.password=password;
        this.img=img;
        this.firstname= firstname;
        this.lastname= lastname;

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

