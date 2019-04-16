import Mapper.IPersonMapper;
import domain.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class  Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Test myBatis");


        String resource="PersonMapper.xml";
        Reader reader = Resources.getResourceAsReader("config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();

     //  String statement ="PersonMapper.selectAll";
       Person person = new Person();
       person.setName("qqqqq");
       person.setAge(23);
       person.setScore(60);
      //  List<domain.Person> person = sqlSession.selectList(statement);
      // sqlSession.insert(statement,person);
       //sqlSession.commit();
        IPersonMapper mapper = sqlSession.getMapper(IPersonMapper.class);
        List<Person> people = mapper.selectAll();
        System.out.println(people);

        //System.out.println(yxl);

        //  System.out.println(person);
      //  Person person =sqlSession.selectOne(statement,"cuiqiang");

       // System.out.println(person);



        sqlSession.close();

    }
}
