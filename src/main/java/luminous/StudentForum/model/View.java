package luminous.StudentForum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="views")
public class View{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fkUser;
    private int fkPost;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkUser() {
        return this.fkUser;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    public int getFkPost() {
        return this.fkPost;
    }

    public void setFkPost(int fkPost) {
        this.fkPost = fkPost;
    }

    public View(int fkUser, int fkPost) {
        this.fkUser = fkUser;
        this.fkPost = fkPost;
    }


    public View() {
    }


}
