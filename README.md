# 🛒 쇼핑몰 프로젝트 - 디자인

### 토이 프로젝트

참가자 : 권희창

### 📋 ToDoList

- [ ] API 디자인, Page 설계하기
- [x] Product 전체 가져오기
- [ ] 페이징 구현, 카테고리화 구현
- [ ] Seller의 Product 추가 기능
- [x] Cart에 담기 구현
- [ ] User별 Cart 분리
- [x] 초기 프로젝트 생성
- [ ] DTO Validator 추가하기
- [ ] API별 권한 부여, User, Guest, Seller
- [ ] 예외 처리
- [ ] 반복되는 코드 AOP처리
- [ ] 테스트 작성하기
- [x] Spring Security Ouath2 Google, Naver를 사용한 로그인 구현
- [x] AWS 서버에 올리기, Maria DB연동
- [ ] CI / CD 작업
- [ ] JPA, Security 완벽 분석
- [ ] ajax 스터디

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

- BootStrap
- Ajax
- ~~React~~

**API 문서화**

- Swagger

### 📋기술 목록

- REST API
- Security
- HTTP
- JPA
- 페이징
- 트랜잭션
- Git 버전관리
- AWS EC2 배포
- Nginx
- CI / CD

### 📋기능 리스트

- User Login, Admin Login
- User는 카트에 물건 추가, 삭제 + 수량조절 + ~~주문~~
- Admin은 물건 목록 추가, 삭제
- 물품 리스트 카테고리별 검색, 페이징

**REST API List**

**물품 추가, 조회 삭제**

get /products

post /products

get /products/{id}

put /products/{id}

**장바구니 추가, 삭제 조회**

POST /carts

DELETE /carts/{id}

GET /users/{userid}/carts/{pages}

**카테고리**

/categories

**회원 추가 조회 삭제**

delete /me/{id}

get /me/{id}

put /me/{id}

**DB 설계**

Cart - User 1대 N 관계

Cart - Product 1대 N 관계

**User**

- userName
- id
- password
- Cart
- **Admin or not?**
- 

**Cart**

- ProductId FK
- UserId  FK
- Count
- 

**Product**

- Category
- name
- price
- restCount
- imgsrc
  - subOption
    - color
- ~~sale~~
- ~~review~~

**추후 Update**

**Product마다 Review 기능**

**Order 기능**

- User
- Cart
- Credit Card info, Cache info
- Product들에 반영
- Admin 확인
