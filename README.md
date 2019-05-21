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
    - [x] 0~24 사이의 값만 가질 수 있다.
- [x] StraightLine 클래스 작성
    - [x] 생성자의 인자로 null이 들어올 수 없다.
    - [x] 두 점은 같을 수 없다.
    - [x] 두 점 사이의 거리를 계산해서 출력한다.
    
### 2 단계
- [ ] Points 일급 컬렉션 작성
    - [x] 생성자의 인자로 null이 들어올 수 없다.
    - [ ] 점들을 X 축으로 정렬할 수 있다.
    - [ ] 점들을 Y 축으로 정렬할 수 있다.
    - [x] 인덱스는 0 이상 (점들의 수 - 1) 이하여야 합니다.
    - [x] 점들을 인덱스로 접근할 수 있다.
- [ ] Rectangle 클래스 작성
    - [ ] 직사각형만 허용한다.
    - [ ] 넓이를 계산해서 출력한다.
