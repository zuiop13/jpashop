package jpashop.zuiop.service;

import jpashop.zuiop.entity.ZuiopMember;
import jpashop.zuiop.repository.ZuiopMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ZuiopMemberService {

    private final ZuiopMemberRepository memberRepository;

    /*
    * 회원 가입
    * */
    @Transactional
    public Long join(ZuiopMember zuiopMember) {
        validateDuplicateMember(zuiopMember); // 중복 회원 검증
        memberRepository.save(zuiopMember);
        return zuiopMember.getId();
    }

    private void validateDuplicateMember(ZuiopMember zuiopMember) {
        List<ZuiopMember> findMembers = memberRepository.findByName(zuiopMember.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원");
        }
    }

    /* 회원 전체 조회 */
    public List<ZuiopMember> findMembers() {
        return memberRepository.findAll();
    }

    /* 회원 단건 조회 */
    public ZuiopMember findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
