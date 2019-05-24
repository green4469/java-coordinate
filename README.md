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

좌표평면(제 1 사분면)에서 삼각형, 사각형의 넓이를 계산하는 프로그램 구현

### 프로그램 특징 
- 벡터 개념을 사용하여 직사각형인지 여부를 확인하였다.
- 벡터의 내적을 삼각형과 직사각형의 면적 계산 등에 사용하였다.
- 사용자가 점을 입력하는 순서와 상관없이 올바르게 면적을 계산한다.
- 똑바로 누워있는 직사각형과 기울어진 직사각형 모두 올바르게 면적을 계산한다.

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
- [x] 도메인 리팩토링
    - [x] Point 클래스
        - [x] 변수, 상수, 메서드 리네이밍
        - [x] 테스트 추가
    - [x] Line 클래스
        - [x] 불필요한 메서드 제거
        - [x] 테스트 추가
        - [x] 두 점의 순서만 다른 두 라인을 동일한 라인으로 인식한다.
            - e.g., [(0, 0), (1, 1)] == [(1, 1), (0, 0)]
    - [x] Lines 클래스
        - [x] 테스트 추가
    - [x] Rectangle 클래스 
        - [x] 직사각형인지 검증하는 메서드 단순화
        - [x] 두 라인이 직교하는지 검증하는 메서드 Lines 클래스로 옮기기
        - [x] 테스트 추가
    - [x] Vector 클래스 작성
        - [x] Line 클래스를 상속받는 Vector 클래스 작성
            - [x] Vector 생성자는 Line을 인자로 받고, Line의 두 점을 이용하여 벡터를 생성한다.
        - [x] Vector 끼리 내적을 계산 (교환법칙 성립)
        - [x] Vector 의 내적을 이용하여 삼각형의 넓이 계산
        - [x] Vector 를 이용하여 두 라인이 서로 직선인지 판단 (두 벡터의 내적이 0 이면 두 라인은 직교한다.)
        - [x] Vector 를 이용하여 두 라인이 서로 평행한지 판단 (두 벡터의 내적과 두 벡터의 크기의 곱이 같으면  
        두 라인은 평행하다.)
    - [x] Polygon 추상클래스 작성
        - [x] Lines 를 인스턴스변수로 갖는다.
    - [x] AreaCalculable 인터페이스 작성
        - [x] Polygon 이 AreaCalculable 을 구현한다.
    - [x] Figure 추상클래스 작성
        - [x] Line 이 Figure 를 상속받는다.
        - [x] Polygon 이 Figure 를 상속받는다.
    - [x] FigureCreator 인터페이스 작성
    - [x] FigureFactory 클래스 작성
        - [x] FigureFactory 는 FigureCreator 인터페이스를 구현한다.
    - [x] Triangle 과 Rectangle 에 공통된 계산부분을 Polygon에 구현한다.
        - [x] Triangle 과 Rectangle 이 Polygon 의 메서드를 사용하여 면적을 계산하도록 수정한다.
    - [x] LengthCalculable 인터페이스를 작성하여, Figure 가 이를 구현하도록 수정한다.
        - [x] LengthCalculable 인터페이스는 length() 메서드를 선언한다.
        - [x] Lines 클래스에 자신이 가진 라인들의 길이를 모두 합해서 반환하는 메서드를 구현한다.
        - [x] 위의 메서드를 이용하여 Triangle 과 Rectangle 에서 length() 메서드를 구현한다.
    - [x] 테스트 추가

### 뷰
- InputView 클래스 작성
    - [x] 사용자로부터 포인트의 리스트를 입력받는다.
- OutputView 클래스 작성
    - [x] UI와 함께 포인트들을 좌표평면에 보여준다.
    - [x] 도형의 길이 혹은 넓이를 출력한다.

### 컨트롤러
- FigureController 클래스를 작성한다.
    - [x] InputView 와 OutputView 를 호출한다.
    - [x] Input 이 잘못 들어온 경우에 다시 InputView 를 호출한다.
    - [x] 요구에 따라 도메인 객체를 생성하고 필요로하는 정보를 OutputView로 넘긴다.

### 리팩토링
- 테스트코드
    - [x] FigureFactory 클래스를 사용하여 테스트 코드들을 개선한다.
    - [x] 다양한 경우의 입력에 대하여 테스트를 추가한다.
