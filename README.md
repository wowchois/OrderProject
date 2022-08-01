# 주문 프로젝트
### 충전한 포인트로 메뉴를 주문하고 결제하는 API 구현

### 구현내용
1. 메뉴 조회
2. 사용자 포인트 충전
3. 메뉴 주문 -> 포인트 차감(결제)
4. 주문 내역 로그 저장
5. 주문 상위 메뉴 조회

### 개발 환경
- java
- Spring Boot
- JPA
- R2 DB (In Memory)
- Gradle


### 공통 Response 구조

성공 응답   
```
{
    "resultCode": 200,
    "message": "SUCCESS",
    "data" : []
}
```

에러 응답 
```
{
    "resultCode": 500,
    "message": "에러 메시지",
    "data" : null
}
```


### 구현 API

### 1. 커피 메뉴 목록 조회 API
: 메뉴정보(메뉴 식별자,이름,가격) 리스트로 조회  

* Request  
	* URI : /api/v1/menu/info  
	* HTTP Method : GET  
	* Body : 빈값  

* Response
```
{
    "resultCode": 200,
    "message": "SUCCESS",
    "data": [
        {
            "id": 1,
            "name": "아메리카노",
            "price": 2500
        },
        {
            "id": 2,
            "name": "카페라떼",
            "price": 3500
        },
        {
            "id": 3,
            "name": "바닐라라떼",
            "price": 4000
        },
        ...
        {
            "id": 7,
            "name": "아포카토",
            "price": 5500
        }
    ]
}
```

### 2. 포인트 충전 하기 API
: 사용자 식별자와 포인트를 입력받아 충전 진행 후, 충전한 포인트 정보를 리턴  
존재하지 않는 사용자의 식별자 경우, 입력한 식별자와 기본 포인트 0으로 등록  


* Request  
	* URI : /api/v1/user/charge 
	* HTTP Method : POST  
	* Body : id(사용자ID), points(충전할 포인트)

```
{
    "id":2,
    "points" : 1000
}

```

* Response
: 충전 후 보유한 포인트 정보를 리턴합니다.
```
{
    "resultCode": 200,
    "message": "SUCCESS",
    "data": {
        "id": 2,
        "points": 6000
    }
}
```


### 3. 커피 주문/결제 하기 API
: 주문정보(사용자 식별자, 메뉴 식별자)로 주문/결재 진행  
1. 주문정보 등록  
2. 사용자 보유 포인트와 메뉴 가격 비교   
  > 결제 포인트가 부족할 경우 error리턴, 주문정보 롤백  
  > 결제가 가능한 경우, 보유 포인트에서 차감  
3. 주문내역을 Mock API로 전송  


* Request  
	* URI : /api/v1/order/req 
	* HTTP Method : POST  
	* Body : orderUserId(사용자ID), menuId(메뉴ID)

```
{
    "orderUserId":2,
    "menuId" : 1
}
```

* Response
: 주문/결제 진행 후 주문 정보를 리턴  
```
{
    "resultCode": 200,
    "message": "SUCCESS",
    "data": {
        "id": 8,
        "orderUserId": 2,
        "menuId": 1,
        "createdDate": "2022-06-26T21:18:15.6316784"
    }
}
```

* Error
: 사용자가 보유한 포인트가 결제금액보다 부족한 경우 결과  
```
{
    "resultCode": 500,
    "message": "소지한 포인트가 부족합니다.",
    "data": null
}
```


### 4. 인기메뉴 목록 조회 API
: 최근 7일간 주문이 가장많은 순서대로 3개의 메뉴정보(메뉴 식별자,이름,가격,주문 수)를 조회  

* Request  
	* URI : /api/v1/order/weektop
	* HTTP Method : GET  
	* Body : 빈값


* Response
```
{
    "resultCode": 200,
    "message": "SUCCESS",
    "data": [
        {
            "price": 2500,
            "menuId": 1,
            "cnt": 2,
            "menuName": "아메리카노"
        },
        {
            "price": 5000,
            "menuId": 5,
            "cnt": 1,
            "menuName": "자몽에이드"
        },
        {
            "price": 3500,
            "menuId": 2,
            "cnt": 1,
            "menuName": "카페라떼"
        }
    ]
}
```

