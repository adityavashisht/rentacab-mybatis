import com.indasil.rentcab.domain.Person;
import com.indasil.rentcab.mapper.PersonMapper;
import com.indasil.rentcab.mybatis.SessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vashishta on 10/19/15.
 */
public class MyBatisConfigTest {

    private SqlSessionFactory sessionFactory;

    @Before
    public void init() {
        sessionFactory = SessionFactoryBuilder.getSessionFactory();
    }

    @Test
    public void testMe() {
        sessionFactory.getConfiguration();
    }

    @Test
    public void createPerson() {

        SqlSession session = sessionFactory.openSession();
        try {
            Person p = new Person();
            p.setName("Aditya");
            session.insert("create", p);
            session.commit();
        } finally {
            session.close();
        }

    }


    @Test
    public void testCreateViaMapper() {
        SqlSession session = sessionFactory.openSession();
        try {
            Person p = new Person();
            p.setName("Aditya");

            PersonMapper personMapper = session.getMapper(PersonMapper.class);
            personMapper.create(p);

            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void readPersonById() {

        SqlSession session = sessionFactory.openSession();
        try {

            PersonMapper personMapper = session.getMapper(PersonMapper.class);
            Person p = personMapper.read(6L, null);
            System.out.println(p.getName());
        } finally {
            session.close();
        }

    }

    @Test
    public void readPersonByIdAndName() {

        SqlSession session = sessionFactory.openSession();
        try {

            PersonMapper personMapper = session.getMapper(PersonMapper.class);
            Person p = personMapper.read(6L, "Aditya");
            System.out.println(p.getName());
        } finally {
            session.close();
        }

    }

    @Test
    public void updatePerson() {

        SqlSession session = sessionFactory.openSession();
        try {

            PersonMapper personMapper = session.getMapper(PersonMapper.class);
            Person p = personMapper.read(6L, null);
            p.setName("Huseein");

            personMapper.update(p);

            p = personMapper.read(6L, null);

            System.out.println(p.getName());


        } finally {
            session.close();
        }

    }

    @Test
    public void deletePerson() {

        SqlSession session = sessionFactory.openSession();
        try {

            PersonMapper personMapper = session.getMapper(PersonMapper.class);
            personMapper.delete(5L);
            session.commit();

        } finally {
            session.close();
        }

    }


}
