# 🛒 쇼핑몰 프로젝트 - 디자인

### 토이 프로젝트

참가자 : 권희창

### 🔗 배포

[http://art-auction.pw/](http://art-auction.pw/)

### 📋기능 리스트

- SELLER, USER 권한 구분 OAuth2 Google, Naver Login
- SELLER는 상품 등록, 조회, 수정, 삭제 기능
- User는 카트에 물건 추가, 삭제 + 수량조절 + ~~주문~~
- Review 작성기능
- Product 리스트 카테고리별 검색, 페이징 구현
- 판매순 높은 상위 Product 추천

### 📋 ToDoList

- [x] API 디자인, Page 설계하기
- [x] 초기 프로젝트 생성
- [x] Product 전체 가져오기, 페이징 구현
- [x] Product 별점, 할인, 배송일, 항목 추가
- [x] Seller의 Product 조회, 수정, 삭제 기능 추가
- [x] User별 Cart 분리
- [x] Cart에 담기 구현
- [x] Cart 수정, 삭제 기능 추가
- [x] Spring Security Ouath2 Google, Naver를 사용한 로그인 구현
- [x] API별 권한 부여, User, Guest, Seller
- [x] Review 기능 추가 User, Product와 관계 형성
- [ ] DTO Validator 추가하기
- [ ] 예외 처리
- [ ] 테스트 작성하기
- [x] AWS 서버에 올리기, Maria DB연동
- [x] CI / CD 작업
- [x] 아키텍처 구성 정리
- [x] DNS 붙이기
- [x] bootstrap 프론트 디자인
- [ ] Home, About, footer 채우기
- [x] 페이징 인덱스 동적 처리, 별점 출력 javascript
- [x] cart 계산 기능 추가 javascript

### 📋기술 스텍

**Backend**

SpringBoot

- java 8
- Spring MVC
- Spring Boot Security
- Spring Boot JPA

Build tool

- Gradle

AWS

- EC2
- S3

Database

- MariaDB

**Frontend**

- HTML, CSS, BootStrap
- javascript
- jQuery
- Ajax
- ~~React~~

**API 문서화**

- Swagger

### 📋기술 목록

- REST API
- Spring, Security, JPA
- 페이징
- 트랜잭션
- Git 버전관리
- AWS EC2 배포
- Nginx
- CI / CD

### 📋 서버 아키텍처

![example](https://user-images.githubusercontent.com/22570262/132129166-2cae802a-cdc2-4975-a035-ef9e73fd0af1.png)

### 📋 DB 설계
![Untitled](https://user-images.githubusercontent.com/22570262/134138147-e919c281-bd8f-4bdb-a17a-4ae44ad1a47e.png)

### 📋 REST API
![제목 없음](https://user-images.githubusercontent.com/22570262/134147670-c0953ce8-7714-40fa-943d-74f3ebbe5d25.png)
