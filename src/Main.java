import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Test myBatis");


        String resource="PersonMapper.xml";
        Reader reader = Resources.getResourceAsReader("config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement ="PersonMapper.selectByName";
        Person person =sqlSession.selectOne(statement,"cuiqiang");

        System.out.println(person);
        sqlSession.close();

    }
}
