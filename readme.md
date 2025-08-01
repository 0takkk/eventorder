## 요구사항
### 주문
- 주문을 생성하기 위해서는 상품 선택과 수량 지정이 필요하다.
- *주문 생성 시 상품 재고를 확인하여 부족하면 거부해야한다.*
	- 상품 재고 관련 동시성 처리
- 주문 상태를 아래와 같이 변화한다.
	- `CREATED` : 주문이 생성됨
	- `PAYMENT_PENDING` : 결제 대기
	- `COMPLETED` : 결제 완료 및 주문 확정
	- `CANCELLED` : 주문 취소
	- `PAYMENT_FAILED` : 결제 실패로 인한 주문 실패
- 결제가 완료(`PAYMENT_PENDING` -> `COMPLETED`)되면 사용자에게 푸시 알림
	- 해당 알림 푸시 실패했을 때, 주문 상태는?
- *사용자는 본인의 주문 내역을 조회할 수 있어야 한다.*
- 결제 실패 시, 주문은 자동으로 취소되어야 한다.
	- 결제 타임 아웃 발생 시 어떻게 처리해야 할지?
- 동일한 요청이 여러번 들어와도 주문은 한 번만 처리되어야 한다. (멱등성 보장)
- 주문이 생성되면 결제 서비스에 이벤트를 전달해야 한다.
- 결제 성공/실패 결과에 따라 주문 상태를 갱신해야 한다.
- *주문이 생성된 후 결제 결과가 일정 시간 이상 응답되지 않는다면 자동 취소 처리가 되어야 한다.*
- *주문 취소 시, 이미 성공한 결제에 대해서는 환불 처리가 되어야 한다.*

### 상품
- 주문 시점에 상품의 재고가 존재해야 한다.
	- 재고가 부족할 경우 주문은 거부되어야 한다.
- 상품 재고는 동시 주문을 고려하여 재고 감소에 대한 동시성 제어가 필요하다.
- 주문이 취소되거나, 결제에 실패한 경우, 예약된 재고를 복구해야 한다.
	- 보상 트랜잭션
- 재고 차감은 정확히 한 번만 처리되어야 한다.

### 결제
- 결제는 주문 생성 이벤트를 수신한 후 처리되어야 한다.
- 결제 상태는 아래와 같다.
	- `CREATED` : 결제 생성
	- `PENDING` : 결제 대기
	- `SUCCESS` : 결제 성공
	- `FAILED` : 결제 실패
- 이벤트를 통해 결제 결과를 주문 서비스에 전달해야 한다.
- 결제 요청에 대해 멱등성을 보장해야 한다.

- 결제가 완료되면
	- 기프티콘 발급
	- 배송 준비 시작
	- 알림 전송
	- 포인트 적립

## 공통
- 이벤트 처리시 중복 방지 및 재처리 전략, 순서보장이 필요하다.
- *장애 상황을 고려하여 복구 시나리오가 필요하다.*
- ~~결제 서비스가 일시적으로 다운되어도 주문 생성은 실패하지 않아야 한다.~~
	- -> 결제 서비스 장애 시 주문도 안되어야함. !!
- 멱등성 key 설정 필요

---
- 상품 도메인 관련 요구사항 추가 필요
- 결제 완료되면 ~ 
- 배송 관련
- payment_pending 후 알림 푸시 실패 시에 등등 주문 상태에 대한 무결성 
