# 환경
OPENJDK 11

# 지뢰찾기 게임 심심풀이 구현

1. 랜덤숫자를 만든다 => SimpleRandomNumberGenerator
2. Bomb전략가(?)를 만든다. 리스트로 내부에 Bomb전략을 가지고 있다.
지뢰번호를 받으면 내부에 가지고 있는 전략에 따라서 + 되어야할 숫자번호를 리턴한다.

3.


# 지뢰찾기 게임의 전략
N * N 바이의 게임이라면?
전략 : UP, LEFT, RIGHT, DOWN, UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT 가 있어야함
전략은 : UP, LEFT, RIGHT, DOWN 만으로 변경이 가능

UP 전략 : -N
LEFT 전략 : -1
RIGHT 전략 : +1
DOWN 전략 : +N

UPLEFT : -N -1
UPRIGHT : -N + 1
DOWNLEFT : +N -1
DOWNRIGHT : +N +1

UP 칸에 +를 주기 위해서는? -N 이 해당범위 안에 포함되는 지 알아야 한다.
UP 을 계산하기 위해 필요한 정보
현재 BOX 의 위치. 게임의 N 사이즈. 현재 전략이 무엇인지 세가지