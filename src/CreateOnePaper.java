import javax.imageio.IIOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class CreateOnePaper {
    /*
    NO:1
    功能：获取当前系统的时间
    参数：无
    返回：当前系统时间，String类
     */
    public String GetTime()
    {
        Date m_t = new Date();
        SimpleDateFormat m_df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return m_df.format(m_t);
    }
    /*
    NO:2
    功能：生成试卷，并且放入文件夹中
    参数：生成的题目数，生成的题目类型（小学，初中，高中），用户名
    返回：无参
     */
    public void CreateExam(int m_num,String m_type,String m_id) throws IOException {
        CreateSingleQuestion createSingleQuestion =new CreateSingleQuestion();
        SearchSameProblem searchSameProblem =new SearchSameProblem();
        HashSet<String> m_hash=new HashSet<>();
        m_hash= searchSameProblem.GetAllQuestions(m_id);
        String m_str;
        int m_i=0;
        File file=new File(m_id);
        if(!file.exists())
        {
            file.mkdir();
        }
        try
        {
            String m_time=GetTime();
            BufferedWriter m_bw=new BufferedWriter(new FileWriter(m_id+"/"+m_time+".txt"));
            if(m_type=="小学")
            {
                m_i=1;
                while(m_i<=m_num)
                {
                    m_str=createSingleQuestion.ExamPrimary();
                    if (!m_hash.contains(m_str))
                    {
                        m_bw.write(String.valueOf(m_i)+". "+ m_str+"=");
                        m_bw.write("\n\n");
                        m_i++;
                        m_hash.add(m_str);
                    }
                }
            }
            else if(m_type=="初中")
            {
                m_i=1;
                while(m_i<=m_num)
                {
                    m_str=createSingleQuestion.ExamJunior();
                    if (!m_hash.contains(m_str))
                    {
                        m_bw.write(String.valueOf(m_i)+". "+ m_str+"=");
                        m_bw.write("\n\n");
                        m_i++;
                        m_hash.add(m_str);
                    }
                }
            }
            else if(m_type=="高中")
            {
                m_i=1;
                while(m_i<=m_num)
                {
                    m_str=createSingleQuestion.ExamSenior();
                    if (!m_hash.contains(m_str))
                    {
                        m_bw.write(String.valueOf(m_i)+". "+ m_str+"=");
                        m_bw.write("\n\n");
                        m_i++;
                        m_hash.add(m_str);
                    }
                }
            }
            m_bw.close();
        }
        catch (IIOException e)
        {
            e.printStackTrace();
        }
    }
    /*
    NO:3
    功能：在一个账号下，执行相应操作。如生成题目，切换账户类型。
    参数：无
    返回：无
     */
    public void TeacherOperation(Account m_account) throws IOException {
        String m_order;

        String m_school=m_account.getM_school();
        String m_id=m_account.GetId();
        Scanner input = new Scanner(System.in);
        while(true)
        {

            System.out.println("准备生成"+m_school+"数学题目，请输入生成题目数量");
            System.out.println("题目数量的有效输入范围是“10-30”");
            System.out.println("输入-1将退出当前用户，重新登录。输入1切换当前类型。");

            int m_num=input.nextInt();
            if(m_num==-1)
            {
                break;
            }
            else if(m_num==1)
            {
                label:
                while(true)
                {
                    System.out.println("输入“切换为XX”，XX为小学、初中、高中三者中的一个。");
                    System.out.println("不想切换了，输入-1");
                    m_order = input.next();
                    switch (m_order) {
                        case "-1":
                            break label;
                        case "切换为小学":
                            m_school = "小学";
                            break label;
                        case "切换为初中":
                            m_school = "初中";
                            break label;
                        case "切换为高中":
                            m_school = "高中";
                            break label;
                        default:
                            System.out.println("请输入小学、初中和高中三个选项中的一个");
                            break;
                    }
                }
            }
            else if(10<=m_num&&m_num<=30)
            {
                CreateExam(m_num,m_school,m_id);
            }
            else
            {
                System.out.println("输入的题目数量不符合规范，请重新输入");
            }
        }
    }
}
