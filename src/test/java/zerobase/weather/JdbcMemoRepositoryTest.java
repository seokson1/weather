package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional //테스트 할때 테스트 데이터 때문에 원래 자료 변경 방지 위한 것
public class JdbcMemoRepositoryTest {
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {

        // given - 주어진 것
        Memo newMemo = new Memo(2, "insertMemoTest");

        //when - 무엇을 했을 때 (저장했을 때)
        jdbcMemoRepository.save(newMemo);

        // then - 그러면 이렇게 된다
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        assertEquals(result.get().getText(), "insertMemoTest");
    }
    @Test
    void findAllMemoTest() {
      List<Memo> memoList = jdbcMemoRepository.findAll();
        System.out.println(memoList);
        assertNotNull(memoList);
    }
}
