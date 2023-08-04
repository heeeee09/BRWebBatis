package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

	public static SqlSession getSqlSession() {
		String resource = "mybatis-config.xml";
		SqlSession session = null; // 지역변수로 만들어야 리턴 가능
		
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			// ㄴ 연결 공장을 만드는 사람이
			SqlSessionFactory factory = builder.build(is);
			// ㄴ> 공장을 만든다
			session = factory.openSession();
			// ㄴ>> 최종적으로 만들어내는 것(연결을 열어줌)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
}
