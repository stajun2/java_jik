# JQuery

* 자바스크립트 라이브러리
* 초보 개발자는 JQuery를 이용하여 학습하는게 편리



### 요소를 선택

* jquery를 이용

  * ```js
    $('선택자');
    ```

* 자바스크립트를 이용

  * ```js
    //아이디인 경우
    document.getElementById('아이디명');
    //클래스인 경우
    document.getElemntsByClassName('클래스명');
    //태그인 경우
    document.getElemntsByTagName('태그명');
    ```

### 요소에 이벤트를 등록

* jquery에 미리 등록된 이벤트인 경우

* ```js
  //이벤트 등록
  $('선택자').이벤트명(function(){
      //구현;
  });
  //이벤트 호출
  $('선택자').이벤트명();
  ```

* jquery에 등록된 이벤트와 상관 없이 모든 이벤트 등록

* ```js
  //이벤트 등록
  $('선택자').on('이벤트명', function(){
     //구현; 
  });
  //이벤트 호출
  $('선택자').이벤트명();
  ```



### JQuery 유의사항

* $('선택자')를 통해 선택한 요소는 0개, 1개, 여러개일 수 있다
* $('선택자').메소드()는 선택자와 일치하는 모든 요소들에 적용됨
* $('선택자').get()은 선택자와 일치하는 요소 중 첫번째 요소의 값을 가져옴
* 같은 이벤트 안에 있는 this는 항상 같은 요소를 가르키는게 아니다



### show(), hide(), toggle()

* show(), hide(), toggle()

  * ```js
    $('선택자').show(speed, callback);
    $('선택자').hide(speed, callback);
    $('선택자').toggle(speed, callback);
    ```

    * speed : 요소가 나타날 때/사라질때 걸리는 시간
      * fast, slow, 밀리초가 들어 갈 수 있다
    * callback : 요소가 나타난 후/사라진 후 해야할 일이 있으면 함수를 만들어서 넣어 준다

  * show() : 요소를 나타나게 보여줌, display : block 처리

  * hide() : 요소를 안보이게 감춤. display : none 처리

  * toggle() : 요소가 보여지는 상태면 사라지게 하고, 요소가 안 보인 상태면 보이게 함

* 요소의 display를 block으로 만든 후 요소의 높이와 가로가 0에서 지정된 요소의 높이와 가로로 변화 시킴



### fadeIn(), fadeOut(), fadeToggle(), fadeTo()

* 요소의 display를 block으로 만든 후 opacity를 0에서 1로 변화



### slideUp(), slideDown(), slideToggle()

* 요소의 display를 block으로 만든 후 높이를 0에서 지정된 크기로 변화시킴

### animate()

* 요소에 속성을 변경하여 애니메이션을 부여하는 메소드

* 모든 속성을 적용할 수 없다

* 대체로 수치로 설정가능한 속성들이 가능

  * backgroundPositionX, backgroundPositionY, 
  * borderBottomWidth, borderLeftWidth,borderRightWidth, borderTopWidth, borderWidth, borderSpacing
  * margin, marginBottom, marginLeft, marginRight, marginTop, 
  * maxHeight, maxWidth, minHeight, minWidth
  * opacity
  * padding, paddingBottom, paddingLeft, paddingRight, paddingTop
  * right, top, bottom, left
  * textIndent, wordSpacing, fontSize, letterSpacing, lineHeight

* width, height, outlineWidth

* ```js
  $('선택자').animate(params, speed, callback);
  
  $('선택자').animate({
      //속성명에 -가 있는 경우 ''를 붙여야함
      속성명 : 값,
      속성명 : 값
  },'fast'|'slow'|밀리초, function(){
      //애니메이션 종료 후 작업할 내용
  });
  ```



### stop()

* 진행중인 요소의 애니메이션을 정지시키는 메소드



### 요소 정보 가져오기

* text() 
  * 요소 안의 문자 정보를 문자열로 가져오는 메소드
  * 모든 태그 가능
* html() 
  * 요소 안의 html 코드를 문자열로 가져오는 메소드
  * 모든 태그 가능
* val()
  * 입력된 값을 문자열로 가져오는 메소드
  * input 태그, select 태그, textarea태그 처럼 정보를 입력하는 태그만 가능
* 요소의 속성 정보 가져오기
  * attr('속성명')
    * 요소의 속성 정보를 가져옴
  * prop('속성명')
    * 요소의 속성 정보를 가져옴
  * attr()과 prop()는 비슷하지만 다르다
    * 속성 정보를 가져오는건 같다
    * 같은 속성명이라도 가져오는 속성 정보 값이 다름
    * prop()는 표준 속성만 가능하고, attr()은 사용자 지정 속성도 가능



### 요소 정보 설정하기

* text(값)
  * 요소 안의 문자 정보를 값으로 덮어쓰는 메소드
  * 모든 태그 가능
* html(값)
  * 요소 안의 html 코드를 값으로 덮어쓰는 메소드
  * 모든 태그 가능
* val(값)
  * 입력된 값을 주어진 값으로 덮어쓰는 메소드
  * input 태그, select 태그, textarea태그 처럼 정보를 입력하는 태그만 가능
* 요소의 속성 정보 설정하기
  * attr('속성명','값')
    * 요소의 속성 정보를 설정함
  * prop('속성명',값)
    * 요소의 속성 정보를 설정함



### 버블링

* 요소에 이벤트가 발생하면 해당 요소에만 발생하는 것이 아니라 조상 요소에도 동일한 이벤트가 발생하는 현상

* stopPropagation()을 이용하여 버블링을 막을 수 있다

  * ```js
    $('선택자').이벤트(function(e){
        e.stopPropagation();
    })
    ```



### 기본 효과 막기

* preventDefault()를 이용하여 기본 태그에 적용되는 효과를 막을 수 있다

* 주로 a태그로 된 버튼들에 적용을 많이 한다

  * ```js
    $('선택자').click(function(e){
        e.preventDefault();
    })
    ```



### CSS관련 메소드

* addClass('클래스명들')
  * 요소에 클래스를 추가하는 속성으로, 없으면 추가하고 있으면 그대로 놓음
* removeClass('클래스명들')
  * 요소에 클래스를 제거하는 속성으로, 있으면 제거하고 없으면 그대로 놓음
* toggleClass('클래스명들')
  * 요소에 클래스가 있으면 제거, 없으면 추가
* hasClass('클래스명들')
  * 요소에 해당 클래스가 있으면 true 없으면 false를 반환
* css()
  * 요소에 css를 style속성으로 적용
  * css('속성명') : 해당 속성명에 맞는 값을 가져옴
  * css('속성명', '값') : 해당 속성명에 맞는 값을 설정함
  * css({'속성명' : '값' , '속성명' : '값'}) : 여러 속성들을 한번에 설정

### hover 이벤트

* 마우스가 요소 안으로 들어갈때와 나올때 각각 동작한다

* 들어갈 때와 나올때 같은 동작을 하면 함수를 하나만 쓰고, 다르게 동작을 하면 함수를 두개 써서 처리한다

  * ```js
    $('선택자').hover(function(){
    	//들어갈때, 나올때 이벤트 처리
    });
    $('선택자').hover(function(){
    	//들어갈때 이벤트 처리
    }, function(){
    	//나올 때 이벤트 처리
    })
    ```

* 