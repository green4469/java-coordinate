# java-coordinate
좌표계산기 미션을 진행하기 위한 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)


## car To-do-list

- [x] Car 추상 클래스 정의
    - [x] 이동거리를 인자로 받는 생성자
    - [x] 연료량을 계산하는 메서드 구현
    - [x] 차 이름을 반환하는 메서드 구현
    - [x] 연비를 반환하는 추상메서드 정의
- [x] Car의 서브클래스 정의
    - [x] 연비 클래스 변수
    - [x] 연비를 반환하는 메서드 구현
- [x] 인터페이스를 적용하여 구현
    - [x] Chargeable 인터페이스 적용
    
## coordinate To-do-list

### 1 단계
- [x] Point 클래스 작성
    - [x] x, y가 0~24 사이의 값만 가질 수 있다.
    - [x] x, y getter 메서드를 갖는다.
- [x] StraightLine 클래스 작성
    - [x] 생성자의 인자로 null이 들어올 수 없다.
    - [x] 두 점은 같을 수 없다.
    - [x] 두 점 사이의 거리를 계산한다.
    
### 2 단계
- [x] Points 일급 컬렉션 작성
    - [x] 생성자의 인자로 null이 들어올 수 없다.
    - [x] 점들을 정렬할 수 있다. (x 축 우선, y 축 차선 오름차순 정렬)
        - [(0,0),(5,0),(5,3),(0,3)] -> [(0,0),(0,3),(5,0),(5,3)]
    - [x] 인덱스는 0 이상 (점들의 수 - 1) 이하여야 합니다.
    - [x] 점들을 인덱스로 접근할 수 있다.
- [x] Rectangle 클래스 작성
    - [x] 직사각형만 허용한다.
    - [x] 넓이를 계산한다.

### 3 단계
- [x] Triangle 클래스 작성
    - [x] 생성자의 인자로 null이 들어올 수 없다.
    - [x] 점이 세 개여야 한다.
    - [x] 세 점이 한 직선 위에 존재하면 안 된다.
    - [x] 넓이를 계산한다.
   
### 4 단계
- [x] Rectangle 과 Triangle 이 Points 가 아닌 Lines 를 갖도록 리팩토링
    - [x] StraightLine 을 Line 으로 리네이밍
    - [x] Lines 클래스 작성
    - [x] Points 클래스 삭제
    - [x] Rectangle 과 Triangle 테스트 코드 lines 사용하도록 수정
    - [x] Rectangle 과 Triangle 의 메서드들을 points 중심에서 lines 중심으로 수정
    - [x] 하드코딩 값 상수로 선언
    
- [x] 상속을 이용한 리팩토링
    - [x] Figure 추상 클래스 작성
        - [x] 넓이를 계산하는 추상 메서드 정의
        - [x] 동일한 메서드일 경우 부모 클래스에서 메서드 구현
        
### 5 단계
- [x] 삼각형, 사각형 면적을 구하는 메소드 (area)를 가진 인터페이스 추가 

### 리팩토링
- [x] 패키지 분리
    - [x] domain, view, controller, util
- [ ] 도메인 리팩토링
    - [x] Point 클래스
        - [x] 변수, 상수, 메서드 리네이밍
        - [x] 테스트 추가
    - [x] Line 클래스
        - [x] 불필요한 메서드 제거
        - [x] 테스트 추가