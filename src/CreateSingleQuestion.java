/*
CreateSingleQuestion类，实现生成一道题目
包含了:
1.用户账户初始化
2.为小学生成一道题
3.为初中生成一道题
4.为高中生成一道题
 */
public class CreateSingleQuestion {
    /*
    NO:1
    功能：初始化账户
    参数：无
    返回：Account[]，包含了初始化的九个账户
     */
    public Account[] InIt()
    {
        Account[] m_account = new Account[9];
        m_account[0]=new Account("张三1","小学");
        m_account[1]=new Account("张三2","小学");
        m_account[2]=new Account("张三3","小学");
        m_account[3]=new Account("李四1","初中");
        m_account[4]=new Account("李四2","初中");
        m_account[5]=new Account("李四3","初中");
        m_account[6]=new Account("王五1","高中");
        m_account[7]=new Account("王五2","高中");
        m_account[8]=new Account("王五3","高中");
        return m_account;
    }
    /*
    NO:2
    功能：为小学生出一道题。流程：生成操作数->加入括号->加入"+,-,*,/"
    参数：无
    返回：String，一道题目
     */
    public String ExamPrimary()
    {
        SimpleOperation simpleOperation =new SimpleOperation();
        String[] m_s= simpleOperation.CreateOperationNum();
        m_s= simpleOperation.AddBrackets(m_s);
        return simpleOperation.UniteOperation(m_s);
    }
    /*
    NO:3
    功能：为初中学生出题。流程:生成操作数->加入括号->加入平方->加入"+,-,*,/"
    参数：无
    返回：String，一道题目
     */
    public String ExamJunior()
    {
        SimpleOperation simpleOperation =new SimpleOperation();
        String[] m_s= simpleOperation.CreateOperationNum();
        m_s= simpleOperation.AddBrackets(m_s);
        m_s= simpleOperation.AddSquare(m_s);
        return simpleOperation.UniteOperation(m_s);
    }
    /*
    NO:4
    功能：为高中学生出题。流程:生成操作数->加入括号->加入平方->加入三角函数->加入"+,-,*,/"
    参数：无
    返回：String，一道题目
     */
    public String ExamSenior()
    {
        SimpleOperation simpleOperation =new SimpleOperation();
        String[] m_s= simpleOperation.CreateOperationNum();
        m_s= simpleOperation.AddBrackets(m_s);
        m_s= simpleOperation.AddSquare(m_s);
        m_s= simpleOperation.AddSin(m_s);
        return simpleOperation.UniteOperation(m_s);
    }
}