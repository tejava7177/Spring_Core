package hello.core.member;

public interface MemberService {
    //가입
    void join(Member memebr);

    //조회
    Member findMember(Long meberId);
}
