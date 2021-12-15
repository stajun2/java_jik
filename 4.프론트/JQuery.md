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

    