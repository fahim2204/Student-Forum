package luminous.StudentForum.model;

public class PostDetails {
  
    private String cname;
    private String pbody;
    private String title;
    private String views;


    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPbody() {
        return this.pbody;
    }

    public void setPbody(String pbody) {
        this.pbody = pbody;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return this.views;
    }

    public void setViews(String views) {
        this.views = views;
    }
   
}
