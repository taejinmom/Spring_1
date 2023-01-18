package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long,Member> store = new ConcurrentHashMap<>();

    //member객체를 map에 put한다
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }
    //id를 입력하면 해당 아이디를 키로 벨류값은 member객체를 꺼내온다
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
