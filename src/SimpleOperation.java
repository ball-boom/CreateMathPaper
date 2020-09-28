/*
SimpleOperation类，实现生成复杂问题的初始化操作
包含了：
1.生成随机数
2.生成操作数
3.加入括号
4.加入平方，开方
5.加入三角函数
6.加入"+,-,*,/"
 */
public class SimpleOperation {
    /*
    NO:0
    功能：生成一个范围内的随机数
    参数：m_range,范围
    返回：int，该范围内的随机数
     */
    public int CreateRandom(int m_range)
    {
        int m_max=100,m_min=1;
        int m_ran2 = (int) (Math.random()*(m_max-m_min)+m_min);
        return m_ran2%m_range+1;
    }
    /*
    NO:1
    功能：生成操作数
    参数：无
    返回：String[]，包含了五个以内的操作数
     */
    public String[] CreateOperationNum()
    {
        int m_amount=CreateRandom(5);
        if(m_amount==1)
        {
            m_amount++;
        }
        String[] m_primary=new String[m_amount];
        for (int i = 0; i < m_amount; i++)
        {
            m_primary[i]=String.valueOf(CreateRandom(100));
        }
        return m_primary;
    }
    /*
    NO:2
    功能：加入括号。实现方法，在操作数数组中加入左括号，右括号
    参数：String[],操作数
    返回：String[],加入括号后的操作数
     */
    public String[] AddBrackets(String[] m_brackets)
    {
        boolean m_pair=true;
        int m_amount=m_brackets.length;
        for(int i=0;i<m_amount;i++)
        {
            switch (CreateRandom(3))
            {
                case 1:
                    if(m_pair)
                    {
                        m_pair=false;
                        m_brackets[i]="("+m_brackets[i];
                    }
                    else
                    {
                        m_pair=true;
                        m_brackets[i]=m_brackets[i]+")";
                    }
                default:
            }
        }
        if(!m_pair)
        {
            m_brackets[m_amount-1]=m_brackets[m_amount-1]+")";
        }
        return m_brackets;
    }
    /*
    NO:3
    功能：加入开方，平方
    参数：String[]
    返回：String[]
     */
    public String[] AddSquare(String[] m_square)
    {
        boolean m_flag=true;//至少有一个开方或平方，则为0
        int m_amount= m_square.length;

        while(m_flag)                                                      //判断是否有了至少一个根号
        {
            for (int i = 0; i < m_amount; i++)
            {
                switch (CreateRandom(5))
                {
                    case 1:                                                 //加上根号与括号
                        m_square[i]="("+"√"+m_square[i]+")";
                        m_flag=false;
                        break;
                    case 2:                                                 //加上平方与括号
                        m_square[i]="("+m_square[i]+"^2"+")";
                        m_flag=false;
                        break;
                    default:
                }
            }
        }
        return m_square;
    }
    /*
    NO:4
   功能：加入sin,cos,tan
   参数：String[]
   返回：String[]，包含了几个操作数
    */
    public String[] AddSin(String[] m_sin)
    {
        boolean m_flag=true;                                               //至少有一个至少有一个sin,cos或tan的运算符号
        int m_amount= m_sin.length;

        while(m_flag)                                                  //判断是否有了至少有一个至少有一个sin,cos或tan的运算符号
        {
            for (int i = 0; i < m_amount; i++)
            {
                switch (CreateRandom(5))
                {
                    case 1:                                            //加上sin与括号
                        m_sin[i]="("+"sin"+m_sin[i]+")";
                        m_flag=false;
                        break;
                    case 2:                                            //加上cos与括号
                        m_sin[i]="("+"cos"+m_sin[i]+")";
                        m_flag=false;
                        break;
                    case 3:                                            //加上tan与括号
                        m_sin[i]="("+"tan"+m_sin[i]+")";
                        m_flag=false;
                        break;
                    default:
                }
            }
        }
        return m_sin;
    }
    /*
    NO:5
    功能：将已经生成的操作数（包含根号、平方；括号；三角函数），用"+,-,*,/"连接起来
    参数：String[]
    返回：String[]
    */
    public String UniteOperation(String[] m_operation)
    {
        int m_amount=m_operation.length;
        String m_str=m_operation[0];
        if(m_amount>1)
        {
            for (int i = 1; i < m_amount; i++)
            {
                switch (CreateRandom(4))
                {
                    case 1:
                        m_str=m_str+"+"+m_operation[i];
                        break;
                    case 2:
                        m_str=m_str+"-"+m_operation[i];
                        break;
                    case 3:
                        m_str=m_str+"*"+m_operation[i];
                        break;
                    case 4:
                        m_str=m_str+"/"+m_operation[i];
                        break;
                    default:
                }
            }
        }
        return m_str;
    }
}
