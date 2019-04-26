package com.shop.demoshop.controller;

import com.shop.demoshop.model.Qna;
import com.shop.demoshop.model.api.request.QnaRequest;
import com.shop.demoshop.repository.QnaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/qna")
public class QnaBoardRestController {

    private QnaRepository qnaRepository;

    public QnaBoardRestController(QnaRepository qnaRepository) {
        this.qnaRepository = qnaRepository;
    }

    //TODO 글 목록조회, 글 등록, 글 수정, 글 삭제
    @GetMapping("/qnaList")
    public ResponseEntity shopList(Pageable pageable) {
        //TODO pageable 이용하여 페이징 처리
//        Page<Qna> qnaList = qnaRepository.findAll(pageable);
        List<Qna> qnaList = qnaRepository.findAll();
        return ResponseEntity.ok(qnaList);
    }

    @PostMapping("/qnaRegist")
    public ResponseEntity qnaRegist(@RequestBody QnaRequest qnaRequest) {
        ModelMapper modelMapper = new ModelMapper();
        Qna qna = modelMapper.map(qnaRequest, Qna.class);
        qnaRepository.save(qna);
        return ResponseEntity.ok("successfully");
    }

    @PutMapping("/qnaEdit/{qnaNo}")
    public ResponseEntity qnaEdit(@PathVariable Long qnaNo, @RequestBody QnaRequest qnaRequest) {
        Optional<Qna> qna = qnaRepository.findById(qnaNo);

        if(!qna.isPresent()) {
            Qna qnaEdit = qna.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(qnaRequest, qnaEdit);
            qnaRepository.save(qnaEdit);
        }
        return ResponseEntity.ok("질문 수정완료");
    }

    @DeleteMapping("/qnaDelete/{qnaNo}")
    public ResponseEntity qnaDelete(@PathVariable Long qnaNo) {
        qnaRepository.deleteById(qnaNo);
        return ResponseEntity.ok("질문 삭제완료");
    }

}
