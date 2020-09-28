import java.io.IOException;
import java.util.Scanner;
/*
Main类，用于用户登入，并调用其他方法
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CreateOnePaper createOnePaper =new CreateOnePaper();
        CreateSingleQuestion createSingleQuestion =new CreateSingleQuestion();
        Account[] m_user= createSingleQuestion.InIt();
        Account m_current = null;
        int m_amount=m_user.length;
        String m_id;
        String m_password;
        boolean m_flag;             //账号密码是否正确
        Scanner input=new Scanner(System.in);
        while(true)
        {
            m_flag=false;
            System.out.println("请输入账号密码");
            m_id=input.next();
            m_password=input.next();
            for(int i=0;i<m_amount;i++)
            {
                if(m_user[i].GetId().equals(m_id) && m_user[i].GetPassword().equals(m_password))
                {
                    m_current=m_user[i];
                    m_flag=true;
                }
            }
            if(m_flag)
            {
                createOnePaper.TeacherOperation(m_current);
            }
            else
            {
                System.out.println("账号或密码错误");
            }
        }
    }
}
