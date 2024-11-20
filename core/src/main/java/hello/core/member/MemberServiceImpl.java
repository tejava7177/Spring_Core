package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberRepository 라는 인터페이스에 MemoryMemberRepository라는 구현체를 선택
    // 현재 문제점 : 추상화에도 의존하고 구체화에도 의존하고 있음 = DIP 위반
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member memebr) {
        memberRepository.save(memebr);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
