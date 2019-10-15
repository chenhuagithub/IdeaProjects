package JDBC.template;

public class User {
    private Integer id;
    private String loginName;
    private String loginPwd;
    private String realName;

    public Integer getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
