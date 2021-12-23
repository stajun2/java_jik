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



### 요소 추가

* html()은 요소안에 코드를 덮어쓰기

* 요소안에 끝, 앞 또는 요소 앞, 요소 뒤등에 코드를 추가

* append()

  * 선택자 안에 마지막 자식 요소 뒤에 코드를 추가

  * ```js
    $('선택자').append('html 코드');
    ```

* appendTo()

  * 선택자 안에 마짐가 자식 요소 뒤에 코드를 추가

  * ```js
    $('html코드').appendTo('선택자');
    ```

* prepend

  * 선택자 안에 첫번째 요소 앞에 코드를 추가

  * ```js
    $('선택자').prepend('html 코드');
    ```

* prependTo

  * 선택자 안에 첫번째 요소 앞에 코드를 추가

  * ```js
    $('html 코드').prependTo('선택자');
    ```

* after

  * 선택자 요소 앞에 코드를 추가

  * ```js
    $('선택자').after('html 코드');
    ```

* before

  * 선택자 요소 뒤에 코드를 추가

  * ```js
    $('선택자').before('html 코드')
    ```

### 요소 삭제

* remove()
  * 본인 요소 포함하여 자손들까지 같이 삭제
* empty()
  * 본인 요소 제외하고 자손요소들을 삭제



### 요소 크기 가져오기

* widht(), height()
  * 컨텐츠 가로/세로
  * box-sizing : content-box 이면 width의 값과 width()의 값이 같음
  * box-sizing : border-box 이면 width의 값과 width()의 값이 다름
* innerWidth(), innerHeight()
  * 컨텐츠 + 패딩 가로/세로
* outerWidth(), outerHeight()
  * 컨텐츠 + 패딩 + 보더 가로/세로
* outerWidth(true), outerHeight(true)
  * 컨텐츠 + 패딩 + 보더 + 마진 가로/세로

### 요소 크기 설정하기

* widht(크기), height(크기)
  * 컨텐츠 가로/세로 크기 설정
* innerWidth(크기), innerHeight(크기)
  * 지정된 크기를 기준으로 패딩값을 제외한 컨텐츠의 가로/세로 크기 설정
* outerWidth(크기), outerHeight(크기)
  * 지정된 크기를 기준으로 패딩+보더값을 제외한 컨텐츠의 가로/세로 크기 설정
* outerWidth(크기,true), outerHeight(크기,true)
  * 지정된 크기를 기준으로 패딩+보더+마진값을 제외한 컨텐츠의 가로/세로 크기 설정



# 요소탐색

* 요소를 기준으로 조상, 자손, 형제를 탐색

### 조상탐색

* parent()

  * 부모 요소를 선택

  * ```js
    //선택자 요소의 부모 요소를 선택
    $('선택자').parent();
    //선택자1 요소의 부모 요소 중 선택자2와 일치하는 부모 요소를 선택
    //선택자1과 일치하는 요소의 부모 중에서 선택자2와 일치하는 부모 요소를 선택
    $('선택자1').parent('선택자2');
    ```

* parents()

  * 조상 요소들을 선택

  * ```js
    //선택자 요소의 조상 요소들을 선택
    $('선택자').parents();
    //선택자1 요소의 조상 요소들 중 선택자2와 일치하는 조상 요소들을 선택
    //선택자1과 일치하는 요소의 조상 중에서 선택자2와 일치하는 조상 요소를 선택
    $('선택자1').parents('선택자2');
    ```

* paretnsUntil()

  * 조상 요소들 중 ~ 요소전까지 선택

  * ```js
    //선택자1 요소의 조상 요소들 중 선택자2와 일치하는 요소 전까지의 조상 요소들을 선택
    //선택자1과 일치하는 요소의 조상 중에서 부모 요소부터 선택자2와 일치하는 조상 요소전까지를 선택
    $('선택자1').paretnsUntil('선택자2');
    ```

### 자손 탐색

* children()

  * 자식 요소들 선택

  * ```js
    //선택자의 자식 요소들을 선택
    $('선택자').children();
    //선택자의 자식 요소들 중 선택자1과 일치하는 자식 요소들을 선택
    $('선택자').children('선택자1');
    ```

* find()

  * 자손 요소들 선택

  * ```js
    //선택자의 자손 요소들을 선택
    $('선택자').find();
    //선택자의 자손 요소들 중 선택자1과 일치하는 자손 요소들을 선택
    $('선택자').find('선택자1');
    ```

### 형제 탐색

* siblings()

  * 형제들 요소를 선택

  * ```js
    //선택자의 모든 형제 요소들
    $('선택자').siblings();
    //선택자의 형제 요소들 중 선택자1과 일치하는 요소들
    $('선택자').siblings('선택자1');
    ```

* prev()
  * 바로 앞 형제 요소
* prevAll()
  * 앞에 있는 형제 요소들
* prevUntil()
  * 바로 앞 형제 요소부터 지정된 요소 전까지 요소들
* next()
  * 바로 뒤 형제 요소
* nextAll()
  * 뒤에 있는 형제 요소들
* nextUntil()
  * 바로 뒤에 있는 형제 요소부터 지정되 요소 전까지 요소들

### 필터

* 선택된 요소 중에 원하는 요소를 선택
* first()
  * 선택된 요소들 중 첫번째 요소
* last()
  * 선택된 요소들 중 마지막 요소
* eq(n)
  * 선택된 요소들 중 n번째 요소
* filter(선택자)
  * 선택된 요소들 중 선택자와 일치하는 요소들
* not(선택자)
  * 선택된 요소들 중 선택자와 일치하지 않은 요소들



### each()

* 요소 각각을 한번 씩 불러서 원하는 기능을 수행할 때 사용하는 메소드

* ```js
  $('선택자').each(function(index){
      //기능을 수행할 코드
      //index : 요소들 중 몇번째 인지 알려주는 매개변수
  });
  ```

### ready(), $()

* html 태그들이 준비가 완료되면 실행하게 하는 메소드

* 스크립트 위치에 따라 스크립트가 실행되지 않을 수 있다

  * 화면 요소가 생성되기 전에 이벤트를 등록하거나 작업을 하면 화면 요소가 없어서 이벤트가 등록되지 않거나 작업을 할 수 없다

* ```js
  $(document).ready(function(){
  	//실행 코드 
  });
  $(function(){
     //실행 코드 
  });
  ```



### detach()

* 요소를 떼어내는 메소드
* 보통 떼어낸 후 어딘가에 붙일 때 사용



### removeAttr()

* 속성을 제거하는 메소드

* ```js
  //해당 속성을 제거
  $('선택자').removeAttr('속성명'); 
  //해당 속성을 ''로 설정
  $('선택자').attr('속성명','');
  ```



### 타이머 함수

* setInterval()
  * 일정시간마다 함수를 실행하도록 등록하고, 아이디를 반환
* clearInterval()
  * 일정시간마다 실행되고 있는 함수를 제거(아이디와 일치하는)
* setTimeout
  * 지정된 시간이 되면 함수 실행하도록 등록



### is()

*  결과값이 참 거짓으로 나오는 메소드로, 무언가를 확인하는 메소드

* :checked

  * ```js
    if($('선택자').is(':checked')){
        //실행문
    }
    if($('선택자').prop('checked')){
        //실행문
    }
    ```

* :animated

  * ```js
    if($('선택자').is(':animated')){
        //실행문
    }
    ```

* :eq(n) 

* :first-child



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