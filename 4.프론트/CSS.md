# 스타일 적용 방법

1. link 태그를 이용하여 만들어진 css를 연결하는 방법(가장 많이 사용)

2. style 태그를 이용하여 스타일을 적용

   * ```html
     <style>
         선택자 {
             속성명 : 값;
             속성명 : 값;
         }
     </style>
     ```

3. style 속성을 이용하여 스타일을 적용

   * ```html
     <태그명 style="속성명:값; 속성명:값;"></태그명>
     ```

     

### 선택자(selector)

* `*`  : 전체 선택자, 모든 요소를 선택
* `태그명` : 태그 선택자, 특정 태그를 선택
* `#아이디명` : 아이디 선택자, 특정 하나의 아이디를 선택
  * id는 한 화면에서 유일해야한다
  * name은 중복 가능
* `.클래스명` : 클래스 선택자, 클래스 이름이 일치하는 요소를 선택

### 선택자 조합

* 자식 선택자 : >

  * ```css
    /* 선택자명1의 자식으로 선택자명2인 요소들 */
    선택자명1 > 선택자명2{
        
    }
    ```

* 자손 선택자 : 공백

  * ```css
    /* 선택자명1의 자손으로 선택자명2인 요소들 */
    선택자명1 선택자명2{
        
    }
    ```

* 본인 선택자 : 붙여씀

  * ```css
    /* 선택자명1과 선택자명2를 같이 만족하는 요소들 
    - 선택자1과 선택자2 동시에 태그 이름이 올수 없다
      diva => diva태그인 요소를 찾음, div태그이면서 a태그인 요소는 있을 수 없다
    - 선택자2에는 태그명이 올 수 없다.
      link클래스이면서 a태그인요소
      a.link{} => a태그이면서 link클래스를 가진 요소
      .linka{} => 클래스 이름이 linka인 요소들
    */
    선택자명1선택자명2{
    
    }
    ```

* 속성 선택자

  * 특정 속성의 특정값을 가진 요소들을 선택할 때 사용

  * ```css
    선택자[속성명=값]{
        
    }
    /* input 태그 중 text 타입들을 선택 */
    input[type=text]{
        
    }
    ```

* 가상 클래스 선택자
  * 어떤 조건이나 상황에서 스타일을 적요할 때 사용
  * :가상클래스명
    * hover : 마우스가 올라갈때
    * active : 마우스로 클릭하고 있을 때
    * focus : 요소가 활성화될 때(input 태그에 커서가 활성화 될때)
    * link : 방문하지 않은 링크에 적용
    * visited : 방문한 링크에 적용
    * nth-child(n) / nth-of-type(n) : n번째 요소에 적용
    * nth-child(even) : 짝수번째 요소에 적용
    * nth-child(odd) : 홀수번째 요소에 적용

### 색표현 방법

* 색이름으로 표현 : 지정된 색 이름이 140개
* rgb()함수를 이용하여 표현하는 방법
* rgba()함수를 이용하여 표현하는 방법
* 16진수로 표현하는 방법



### 스타일 적용 우선순위

* 부모의 스타일보다 본인의 스타일이 우선(단, 예외가 있음) - 부모의 속성을 상속받아 오버라이딩
* 아이디 : 100점, 클래스 : 10점, 태그 : 1점으로 계산해서 점수가 높은 스타일이 적용
* 우선순위 점수가 같으면 스타일 위치상 제일 아래 있는 스타일이 적용
* `!important`가 있으면 우선순위와 상관없이 무조건 우선적으로 적용, 가급적 사용하지 않은게 좋다

* style 속성에 적용된 우선순위가 제일 높다



### 색 관련 속성

* color : 글자색
* background-color : 배경색
* border-color : 테두리 색



### 텍스트 관련 속성

* text-indent : 들여쓰기, 길이 또는 퍼센트
* text-align : 정렬, left | right | center | justify
* text-decoration : 글자에 줄을 긋는 속성, none | underline | overline | line-through



### 표준 단위

* em : 배수, 해당 요소의 기본 값의 몇배
* % : 퍼센트
  * width, height에서 %는 부모 요소의 크기의 %
  * 기본 block태그는 높이가 0px이기 때문에 부모의 높이를 지정하지 않고 100%로 하면 높이가 안잡힘
* px : 픽셀
* rem : 문서의 기본값의 몇배
* cm : 센티미터
* mm : 밀리미터
* in : 인치, 1in = 2.54cm = 96px
* pt : 포인터, 72pt = 1in
* pc : 피카소, 1px = 12pt
* deg : 각도
* vh : view height의 약자로 브라우저 높이를 의미하고 100vh가 브라우저 높이
* vw : view width의 약자로 브라우저 가로를 의미하고 100vw가 브라우저 가로



### 폰트 관련 속성

* font-family 
  * 폰트를 지정하는 속성
  * 여러 폰트를 ,를 이용하여 입력
  * 폰트가 없는 경우 대채하기 위해서 여러 폰트를 같이 입력
  * 폰트명이 띄어쓰기로 된 경우 ""를 이용
  * 기본 폰트가 아닌 경우, 추가 작업을 통해 공유된 폰트를 가져올 수 있다
  * 폰트명이 한글인 경우, 한글 폰트명과 영문 폰트명을 같이 입력하는게 일반적이다

* font-size
  * 폰트 크기 조절
  * px, em을 주로 사용
* font-style
  * 이탤릭 스타일을 지정
* font-weight
  * 폰트 굵기
  * 100~900까지 가능, 100단위로 입력
  * bold라는 값을 이용, bold는 700
* font
  * font-style, font-weight, font0size, font-family를 한번에 지정하는 단축 속성
  * 순서를 지켜야하고, font-size와 font-famliy를 제외하고 생략 가능



### 박스 모델

* HTML 태그는 사각형 박스로 다룸
* 내용, 여백(밖 여백, 안 여백), 테두리로 구성
  * 내용 : contents
  * 밖 여백 : margin
  * 안 여백 : padding
  * 테두리 : border



### 컨텐츠 관련 속성

* box-sizing
  * 박스 크기를 계산하는 방법을 정하는 속성
  * 기본은 content-box
  * content-box : 가로, 세로를 계산할 때 내용을 기준으로 계산
  * border-box : 가로, 세로를 계산할 때 내용+padding+테두리를 합한 값으로 계산
* width : 가로
  * block태그에 가로를 지정하면 지정한 가로를 제외한 나머지가 margin-right으로 할당됨
* height : 세로
* width와 height는 inline태그들은 적용이 안됨. block과 inline-block만 가능
* input 태그 : 대표적인 inline-block태그, div 태그는 대표적인 block 태그, span 태그는 대표적인 inline 태그



### 패딩 관련 속성

* padding-top, padding-right, padding-bottom, padding-left
  * 패딩을 부여하는 속성
* padding
  * padding-top, padding-right, padding-bottom, padding-left을 한번에 부여하는 속성
  * 순서 지켜야 함
  * 위부터 시계방향
  * padding : top right bottom left;
  * padding : top side bottom;
  * padding : updown side;
  * padding : all;
* 패딩의 배경색을 지정할 수 없음. 컨텐츠 배경색에 따라 감

### 마진 관련 속성

* margin-top, margin-right, margin-bottom, margin-left
  * 마진을 부여하는 속성
* margin
  * margin-top, margin-right, margin-bottom, margin-left을 한번에 부여하는 속성
  * 순서 지켜야 함
  * 위부터 시계방향
  * margin : 0 auto;
    * 컨텐츠를 부모를 기준으로 가로로 가운데 정렬할때 사용
    * 컨텐츠의 가로길이가 있어야 됨
* 마진의 배경색을 지정할 수 없음. 투명. 투명이기에 부모 배경색을 따라감


### 테두리 관련 속성

* border-top-width, border-right-width, border-bottom-width, border-left-width
  * 테두리 두께를 지정하는 속성
* border-width 
  * 테두리 두께를 한번에 지정하는 속성
  * 위부터 시계방향
* border-top-style, border-right-style, border-bottom-style, border-left-style
  * 테두리 종류를 지정하는 속성
* border-style
  * 테두리 종류를 한번에 지정하는 속성
  * 위부터 시계방향
* border-top-color, border-right-color, border-bottom-color, border-left-color
  * 텍두리 색상을 지정하는 속성
* border-color
  * 테두리 색상을 한번에 지정하는 속성
  * 위부터 시계방향
* border-top, border-right, border-bottom, border-left
  * 테두리 색상, 두께, 종류를 지정하는 속성
  * 테두리 색상,두께, 종류 순서는 상관 없음
* border
  * 테두리 색상, 두께, 종류를 한번에 지정하는 속성
  * 모든 테두리가 같을 때 사용
* border-radius 
  * 둥근 테두리를 만드는 속성
  * 왼쪽위의 점부터 시계방향
  * 크기를 입력



### 배경 관련 속성

* background-image
  * 배경 이미지를 지정
  * url()를 이용하여 배경 이미지를 지정
* background-position
  * 배경 이미지 시작 위치를 지정
  * 일반적으로 배경 이미지와 요소의 크기가 다른 경우, 특히 이미지가 더 큰경우 사용
* background-repeat
  * 배경 이미지를 반복할지를 결정
  * 일반적으로 요소의 크기가 이미지보다 큰 경우 어떻게 할지를 결정
  * repeat-y : y축으로 반복
  * repeat-x : x축으로 반복
  * no-repeat : 반복하지 않음 
  * repeat : x,y축으로 반복
* background-size
  * 배경 이미지 크기를 지정
* baground
  * 배경 속성을 한번에 지정하는 단축 속성
  * background : color image position/size repeat;
    * background : 색상;
    * background : url(이미지경로);

### 그림자 관련 속성

* text-shadow
  * 글자에 그림자 효과 주기
  * text-shdow : 수평거리 수직거리 흐림정도 색상|none;
  * ,로 여러 그림자 효과를 한번에 줄수 있다
* box-shadow
  * 상자에 그림자 효과 주기
  * box-shadow : 수평거리 수직거리 흐림정도 그림자크기 color|none|inset
  * inset : 음각효과



### 배치 관련 속성

* display
  * 박스 형태를 제어하는 속성
  * 다양한 값이 있는데 대표적인 값은 inline, block, inline-block, none(안보이게 감춤)
  * block
    * 새라인에서 시작
    * width와 height로 크기 조절
    * padding, border, margin 조절 가능
    * 옆에 다른요소 배치 불가능(기본값으로는)
  * inline
    * 현재 라인에서 시작
    * 옆에 다른요소 배치 가능
    * width와 height로 크기 조절 불가능
    * margin-top, margin-bottom 조절 불가능
  * inline-block
    * 현재 라인에서 시작
    * 옆에 다른요소 배치 가능
    * width와 height로 크기 조절
    * padding, border, margin 조절 가능
* position
  * 박스 배치 방법을 설정하는 속성
    * static : 기본값으로 웹페이지에 입력한 순서대로 나타냄
    * relative : 상대적으로 배치, 주로 absolute를 이용할 때 기준값으로 활용
      * 기본 위치를 기준으로 상대 위치로 배치
      * top, bottom, right, left를 이용하여 위치 조절
    * absolute : 웹페이지 특정 위치에 고정
      * top, bottom, right, left를 이용하여 위치 조절
      * 기준점은 조상들 중에 posotion이 relative를 가진 조상들 중 요소와 가장 가까운 조상
      * 조상들 중에 position이 relative인 조상이 없으면 브라우저가 기준점이 됨
      * width 대신에 left와 right를 설정하면 됨
      * height 대신에 top과 bottom을 설정하면 됨
    * fixed : 웹브라우저 특정 위치에 고정
      * top, bottom, right, left를 이용하여 위치 조절
      * width 대신에 left와 right를 설정하면 됨
      * height 대신에 top과 bottom을 설정하면 됨
    
  * float
  
    * 요소를 배치할 때 사용
  
    * 값은 left, right
  
    * 추가 작업을 하지 않으면 부모가 높이를 계산하지 못함
  
      * float 속성을 적용한 부모 요소에 다음 코드를 추가해야한다
  
      * ```css
        부모선택자::after{
            content : '';
            clear : both;
            display : block;
        }
        ```
  
        
  
    * absolute와 fixed 없이 컨텐츠를 왼쪽, 오른쪽 정렬을 할 수 있다. 
  
    * float 속성을 지정하면 display가 inline-block처럼 처리가 됨

### calc()

* 단위가 다른 값들을 계산하는 함수
* 연산자 앞 뒤로 공백을 넣어야함



### ::after와 ::before

* ::before 
  * 요소를 생성한 후에 요소 앞에 추가하는 내용
* ::after 
  * 요소를 생선한 후에 요소 뒤에 추가하는 내용

### z-index

* 요소들이 겹칠 때 누구를 위로 올리고, 내릴지를 결정해주는 속성
* 기본적으로 코드 위치상 아래 있는 요소들이 위로 올라감
* 기본값은 1
* 숫자가 높을수록 위로 올라간다
* position이 static 요소 A와 postion이 absolute인 요소 B가 겹치면 A의 z-index의 값과 상관없이 B가 위로 배치
  * 이를 해결하기 위해 A의 position을 relative로 수정
* 사촌관계요소(부모가 다른 요소)에서 겹칠때에는 본인 요소의 z-index보다 조상들 중 형제 관계에 있는 요소들의 z-index가 중요
  * 두 조상 요소들이 position이 relative이어야 함

### visibility

* 텍스트를 안보이게 감추는 속성
* 테스트 공간은 남겨놓고 안보이게 감춤
* display:none; 
  * 안보이는 기능은 같은데 해당 요소의 공간도 같이 감춤

### overflow

* 자식 요소가 부모 요소보다 커서 내용이 넘치는 경우 어떻게 할건지를 결정하는 속성
* 값
  * hidden
    * 부모를 넘어서는 내용을 안보이게 감춤
  * visible
    * 부모를 넘어서는 내용을 보이게 함, 기본값
  * scroll
    * 부모를 넘어서는 내용을 안보이게 한 후 스크롤을 통해 다른 부분을 확인할 수 있게 함
    * 이 때 부모를 넘지 않아도 스크롤이 무조건 생김
  * auto
    * 부모를 넘어서면 scoll, 안 넘어서면 scroll이 없어짐
* ...을 할 때 같이 사용되는 속성



### 리스트 관련 속성

* list-style-type 
  * disc | armenian | circle | cjk-ideographic | decimal | georgian | lower-alpha | lower-roman | square | upper-alpha | upper-roman | none
  * 마커를 설정
  * 마커는 리스트 앞에 있는 숫자나 모양
* list-style-image
  * 마커를 대체할 이미지를 설정
* list-style-position
  * inside | outside
  * 마커의 위치, 리스트 안/밖, 기본값은 밖(outside)
* list-style 
  * list-style-type , list-style-image, list-style-position를 한번에 쓰는 단축 속성

### 테이블 관련 속성

* border 
  * 테두리 속성
* border-collapse 
  * 중복된 테두리를 합치는 속성
  * collapse : 합침



### outline

* input태그에 focus 되면 생기는 테두리를 제어하는 속성

* input:focus를 이용하여 outline:none을 하면 focus 되었을 때 테두리를 없앨 수 있다

  * ```css
    input:focus{
    	outline: none;
    }
    ```

    

### line-height

* 글자의 높이를 조절할 때 사용
* 같은 글자 크기라도 line-height 다르면 글자 높낮이가 달라진다
* 글자 크기는 font-size

### white-space

* 공백을 어떻게 처리할건지를 정하는 속성
* 값
  * normal 
    * 기본값, 엔터나 공백을 공백 하나로 처리. 내용이 길면 자동으로 줄을 바꿈
  * nowrap
    * 엔터나 공백을 하나로 처리. 줄바꿈은 `<br>` 로만 바뀜
  * pre
    * 연속 공백이나 엔터를 유지
  * pre-wrap
    * 연속 공백이나 엔터를 유지, 내용이 길면 자동으로 줄을 바꿈
  * pre-line
    * 공백을 하나로 합침. 엔터를 유지. 내용이 길면 자동으로 줄을 바꿈
  * break-space
    * 다음 차이점을 제외하면 pre-wrap과 동일
    * 연속 공백이 끝에 위치해도 공간을 차지
    * 연속 공백의 중간과 끝에서도 자동으로 줄을 바꿈

### word-break

* 라인이 바뀔 때 긴 단어를 어떻게 처리할지를 설정하는 속성
* 값
  * normal
    * 기본값, 기본 줄 바꿈 규칙을 사용
  * break-all
    * 오버플로우를 방지하기 위해 두 문자 사이에서 줄바꿈이 발생할 수 있다(한중일 텍스트 제외)
  * keep-all
    * 한중일 텍스트에서 줄을 바꿀때 단어를 끊지 않는다

### text-overflow

* 글자가 박스를 넘어갈 때 넘어간 글자를 어떻게 할지를 설정하는 속성

* 값

  * clip

    * 넘어가는 부분을 자름. 문자 중간에서 잘릴수 있다

  * ellipsis

    * 넘어가는 문자열을 줄임표(...)로 표시

    * 1줄 말줄임

    * ```css
      .box1{
      			width: 100px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;
      			border: 1px solid black;
      		}
      ```

    * 2줄 말줄임

    * ```css
      .box2{
          width: 100px; overflow: hidden; display: -webkit-box;
          -webkit-line-clamp: 2; -webkit-box-orient: vertical;
          text-overflow: ellipsis; border: 1px solid black;
      }
      ```

      

### direction

* 요소의 배치 방향을 정해주는 속성



### display:flex

* 부모 요소안에 자식 요소들의 가로의 길이합이 부모 요소보다 작으면 그대로 배치
* 부모 요소안에 자식 요소들의 가록의 길이합이 부모 요소보다 크면 부모 요소 안에서 비율에 맞게 배치



### cursor

* 마우스 커서 모양을 설정하는 속성



### animation

* 적용 방법

  1. @keyframes로 애니메이션을 등록

     * ```css
       /* 시간비율은 0%~100%까지, from(0%), to(100%)*/
       @keyframes 애니메이션명{
           시간비율 : {
               속성명 : 값;
           }
           시간비율 : {
               속성명 : 값;
           }
       }
       ```

  2. 원하는 요소의 css에 애니메이션을 적용

     * ```css
       선택자{
           animation-name : 애니메이션명;
           animation-duration : 정수s; /*애니메이션 실행 시간*/
           animation-iteration-count : 숫자 | infinite; /*반복횟수*/
       }
       ```



