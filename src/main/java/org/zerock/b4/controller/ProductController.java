package org.zerock.b4.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.b4.dto.PageRequestDTO;
import org.zerock.b4.dto.ProductDTO;
import org.zerock.b4.dto.ProductRegisterDTO;
import org.zerock.b4.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;
	
	// [STEP1]
	// GET방식
	// Pathvariable = String 
	@GetMapping("/modify/{pno}")
	public String modifyGet(@PathVariable("pno") Integer pno, PageRequestDTO pageRequestDTO, Model model) {
		
		ProductDTO dto = productService.get(pno);

		model.addAttribute("dto", dto);
		

		// 서비스에서 상품 조회 -> Model에 담아줌
		// todo를 생각해본다면 -> 상품 조회 기능이 없음 -> DTO, Mapper, Service 필요

		
		return "/product/modify";

	}

		@GetMapping("/images/{pno}")
		@ResponseBody // json으로 만들어 줌
		public List<String> getImages(@PathVariable("pno") Integer pno){
			
			return productService.getImages(pno);
		}

	// [STEP3]
	// POST로 상품 수정
	// @PostMapping("/modify/{pno}")
	// public String modifyPost(//DTO ) {

		// DTO 확인 -> 등록 과정과 동일한 내용 / 차이점: pno 존재
		// Todo -> DTO 개발

	// }

	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model){

		model.addAttribute("res", productService.list(pageRequestDTO));



	}

	@GetMapping("/register")
	public void register(){
		log.info("get product register");
	}


	@PostMapping("/register")
	public String registerPost(ProductRegisterDTO registerDTO, RedirectAttributes rttr){

		log.info("--------------------------------");
		log.info(registerDTO);

		Integer pno = productService.register(registerDTO);

		log.info("NEW PNO: " + pno);

		rttr.addFlashAttribute("result", pno);

		return "redirect:/product/list";
	}
	  
}
