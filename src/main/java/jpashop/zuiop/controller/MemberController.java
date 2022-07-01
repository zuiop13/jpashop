package jpashop.zuiop.controller;

import jpashop.zuiop.entity.ZuiopAddress;
import jpashop.zuiop.entity.ZuiopMember;
import jpashop.zuiop.service.ZuiopMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/zuiop")
@RequiredArgsConstructor
public class MemberController {
    private final ZuiopMemberService memberService;
    @GetMapping(value = "/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "zuiop/members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "zuiop/members/createMemberForm";
        }
        ZuiopAddress address = new ZuiopAddress(form.getCity(), form.getStreet(),
                form.getZipcode());
        ZuiopMember member = new ZuiopMember();
        member.setName(form.getName());
        member.setZAddress(address);
        memberService.join(member);
        return "redirect:/zuiop/";
    }
}
