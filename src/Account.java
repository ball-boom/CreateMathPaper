/*
Account类：
记录用户id、用户密码、用户的属性（小学，初中，高中）
 */
public class Account {
    private String m_id;
    private String m_password="123";
    private String m_school;

    public Account(String id,String m_school)
    {
        this.m_id=id;
        this.m_school=m_school;
    }

    public String GetId()
    {
        return this.m_id;
    }

    public void SetId(String id)
    {
        this.m_id = id;
    }

    public String GetPassword()
    {
        return this.m_password;
    }

    public void SetPassword(String password)
    {
        this.m_password = password;
    }

    public String getM_school() {
        return this.m_school;
    }

    public void setM_school(String m_school) {
        this.m_school = m_school;
    }
}
