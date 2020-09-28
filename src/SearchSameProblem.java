import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class SearchSameProblem {
    /*
    NO:1
    功能：从一个txt文件中，提取出所有的题目，放入HashSet<String>
    参数：文件名,HashSet<String>
    返回：HashSet<String>
     */
    public HashSet<String> GetQuestionFromPaper(String m_filename,HashSet<String> m_hash) throws IOException {
        String m_line="";        //读取题号
        BufferedReader reader = new BufferedReader(new FileReader(m_filename));//只能输入文件名，不能是路径
        while(m_line!=null)
        {
            m_line=reader.readLine();
            if(m_line!=null)
            {
                String[] m_s=m_line.split(" ");
                m_hash.add(m_s[1]);
            }
            else
            {
                break;
            }
            reader.readLine();
        }
        return m_hash;
    }
    /*
    NO:2
    功能：把一个账户文件夹下所有txt中的题目都提取到一个HashSet中
    参数：账户名,用来识别文件夹
    返回：一个HashSet，即每个txt对应的HashSet的总和
     */
    public HashSet<String> GetAllQuestions(String m_id) throws IOException {
        HashSet<String> m_hashset=new HashSet<>();
        File m_file=new File(m_id);
        if(m_file.exists())
        {
            String[] m_str=m_file.list();
            if(m_str.length>0)
            {
                for(int i=0;i<m_str.length;i++)
                {
                    GetQuestionFromPaper(m_id+"/"+m_str[i],m_hashset);
                }
            }
        }
        return m_hashset;
    }
}