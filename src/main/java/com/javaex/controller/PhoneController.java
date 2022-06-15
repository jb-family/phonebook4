package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	// 필드
	@Autowired
	private PhoneService phoneService; // = new PhoneDao() X 주입해줘

	// 생성자

	// 메소드 - gs

	// 메소드 - 일반
	// 전화번호 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhoneController > list()");

		List<PersonVo> personList = phoneService.getPersonList();

		model.addAttribute("personList", personList);

		return "list";
	}

	// 전화번호 업데이트폼
	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model, @RequestParam("no") int no) {
		System.out.println("PhoneController > updateForm()");

		PersonVo personVo = phoneService.getPerson(no);

		model.addAttribute("personVo", personVo);

		return "updateForm";
	}

	// 전화번호 업데이트
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > update()");

		int count = phoneService.update(personVo);
		System.out.println(count);
		return "redirect:/list";
	}

	// 전화번호 삭제 (url에 PathVariable로 사용하는 방법)
	@RequestMapping(value = "/delete/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete2(@PathVariable("no") int no) {
		System.out.println("PhoneController > delete()");

		int count = phoneService.delete(no);
		System.out.println(count);

		return "redirect:/list";
	}

	// 전화번호 삭제 (url에 쿼리스트링으로 사용하는 방법)
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhoneController > delete()");

		int count = phoneService.delete(no);
		System.out.println(count);

		return "redirect:/list";
	}

	// 전화번호 등록
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > write()");

		int count = phoneService.insert(personVo);
		System.out.println(count);


		return "redirect:/list";
	}

	// 전화번호 등록
	@RequestMapping(value = "/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam("company") String company) {
		System.out.println("PhoneController > write()");

		PersonVo personVo = new PersonVo(name, hp, company);
		int count = phoneService.insert(personVo);
		System.out.println(count);

		return "redirect:/list";
	}

	// 전화번호 등록 폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController > writeForm()");

		return "writeForm";
	}

	// 테스트
	@RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
	public String test() {
		System.out.println("PhoneController > test()");
		// 다오
		return "test";
	}

	// 등록메소드

	// 수정폼메소드

	// 삭제메소드

	// 리스트메소드

}
