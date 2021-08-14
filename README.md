# 🛒 쇼핑몰 프로젝트 - 디자인

### 토이 프로젝트

참가자 : 권희창

### 📋 ToDoList

- [ ]  API 디자인하기
- [ ]  초기 프로젝트 생성

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
- React

**API 문서화**

- Swagger

### 📋기술 키워드

- REST API
- Security
- HTTP
- JPA
- 페이징
- 트랜잭션
- Git 버전관리
- AWS EC2 배포

### 📋기능 리스트

- User Login, Admin Login
- User는 카트에 물건 추가, 삭제 + 수량조절 + ~~주문~~
- Admin은 물건 목록 추가, 삭제
- 물품 리스트 카테고리별 검색?, 페이징

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

**User**

- userName
- id
- password
- Cart
- **Admin or not?**

**Cart**

- ProductList
- Count

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