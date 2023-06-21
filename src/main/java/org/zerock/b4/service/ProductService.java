package org.zerock.b4.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.b4.dto.PageRequestDTO;
import org.zerock.b4.dto.PageResponseDTO;
import org.zerock.b4.dto.ProductDTO;
import org.zerock.b4.dto.ProductListDTO;
import org.zerock.b4.dto.ProductRegisterDTO;

@Transactional
public interface ProductService {

	Integer register(ProductRegisterDTO registerDTO);

	PageResponseDTO<ProductListDTO> list(PageRequestDTO pageRequestDTO);


	ProductDTO get(Integer pno);

	List<String> getImages(Integer pno);

	// [STEP4]
	// 메소드 => 리턴 타입: 반환 / void 기준점? 
	// => 특별한 일이 없다면, 성공해야 한다 = void
	// => 예외 상황, 정말 필요한 값이 있다면 = return
	// 수정과 삭제는 기본이 void
	
	
	// void modify(//DTO);
	// 상품 데이터 수정
	// 기존 첨부파일 DB에서 삭제
	// DTO에 있는 첨부파일 DB에 추가
	// -> 트랜잭션

	// 팀으로 뭉쳐서 악으로 깡으로~~~~~~!!

	

	
}
