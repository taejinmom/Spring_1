package hello.core.member;

public interface MemberService {
    // 회원가입과 조회 기능 로직
    void join(Member member);
    Member findMember(Long memberId);
}
