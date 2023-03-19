# [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)
## 1. 진행 과정
### 요구 사항
* 1~9 까지의 서로 다른 세자리 수를 생성한다. `NumberGenerator#createRandomNumber()`
* 사용자 입력과 정답을 비교한다. `Referee#compareInput()`
  * 같은 위치에 같은 수가 있는가 `Referee#isSamePlace()`
  * 몇개의 숫자가 같은가 `Referee#countCorrect()`
* 세자리 모두 같은 수 : 스트라이크  -> 테스트코드로 테스트
* 자리 수는 다르지만 같은 수 : 볼   -> 테스트코드로 테스트
* 같은 수가 전혀 없다 : 낫띵        -> 테스트코드로 테스트
* 사용자로부터 받는 입력 예외 처리
  * 1~9 사이에 있는가?
  * 3글자인가?
  * 중복 값이 있는가?
* 사용자 입력에 대한 실행 결과를 출력한다. 1

> 중간 조언<br> 문제를 너무 큰 단위에서 TDD로 구현하려고 해서 어려운 것이다.<br>문제를 작은 단위로 쪼갠 다음에 TDD를 구현해보려 하면 조금 더 해볼만 하다.
---
### 난이도 '하'
* 처음부터 길이 3의 리스트로 접근하는 게 아닌, 한자리 숫자에 대해 테스트한다.


_조언1: Util 성격의 기능이 TDD로 도전하기 좋다._
* 사용자로부터 받는 3개 숫자 예외 처리
    * 1~9 사이에 있는가?
    * 3글자인가?
    * 중복 값이 있는가?

_조언2. 테스트 가능한 부분에 대해 TDD로 도전한다._
* 스트라이크/볼/낫띵 결과값에 대한 테스트
```markdown
  answer / user
  123 / 456 -> 낫띵
  123 / 156 -> 1스트라이크
  123 / 415 -> 1볼
  123 / 123 -> 3스트라이크
```
_조언2_Hint_
* 결과를 ENUM값으로 할 수 있겠다 생각 가능.
* 쉬운 문제로 쪼개 접근하자.
  * `PlayResult result = play(Arrays.asList(1,2,3), Arrays.asList(4,5,6))` 보다는<br>한 글자로 먼저 체크할 수 있다.
  * 작은 단위로 접근해보자.
    * 상태를 가지는 것은 복잡하니까 `static`으로. => `BaseBall.play()`
    * List가 아닌 숫자 1개 vs 1개를 비교하자. => `BaseBall.play(1, 9)`
  ```markdown
        answer / user
        1 4 / 1 4 -> 스트라이크
        1 4 / 2 4 -> 볼
        1 4 / 2 5 -> 낫띵
  ```
* 위치 값과 숫자를 갖는 `Ball`이라는 객체를 만들자. 

---
### 난이도 '중' (up!)
- 컴퓨터 정답은 3자리, 사용자 인풋은 1자리로 테스트해보자.
```markdown
answer / user
 123   / 1 4  -> 낫띵
 123   / 1 2  -> 볼
 123   / 1 1  -> 스트라이크
```






---
## 2. 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```
