Logistics Service

Spring Boot 기반 물류 관리 백엔드 서비스입니다.  
재고, 입출고, 주문 관리 기능을 구현하는 것을 목표로 합니다.

---

## 주요 기능
- 상품 관리 (등록, 조회, 수정, 삭제)
- 재고 관리
- 입고 / 출고 처리
- 주문 관리 (예정)
- 사용자 인증 및 권한 관리 (예정)

---

## 기술 스택
- Backend: Java, Spring Boot
- Database: MySQL, H2
- ORM: JPA
- Security: Spring Security
- View: Thymeleaf

---

## 시스템 구조
- Controller → Service → Repository 구조
- RESTful API 설계
- 트랜잭션 기반 데이터 처리

---

## 진행 상황
- [x] 프로젝트 초기 세팅
- [x] 상품 CRUD 구현
- [x] 재고 관리 기능 구현
- [ ] 입출고 로직 구현
- [ ] 로그인 / 인증
- [ ] 주문 기능
- [ ] 배포

---
## 문제 해결
- [1. 동시성 문제 및 해결](https://blog.naver.com/kky5163/224261244849)

---
## 만났던 오류
- [1. @Transactional 내부 호출 불가 오류와 해결](https://blog.naver.com/kky5163/224261308322)