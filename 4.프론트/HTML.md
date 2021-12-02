# HTML

* 태그로 이루어진 문서
* 웹에서 화면 골격에 해당
* 태그의 역할을 기억
* 태그는 <로 시작해서 >로 닫음
* 단일 태그 vs 쌍태그
  * 단일태그
    * <태그> 또는 <태그/>로 사용
  * 쌍태그
    * <태그> 내용 </태그>
* html 태그를 이용하여 화면을 구성할 때 브라우저마다 기본 모양이 다를 수 있음

# 태그 종류

### `<!DOCTYPE html>`

* HTML5 문서임을 알려줌

### `<html>` `</html>`

* html태그로 html문서임을 알려줌

### `<head>` `</head>`

* 문서와 관련된 정보를 모아놓은 태그
* html 파일과 연결돤 css파일, js 파일이 어디에 있는지 알려줌
* 해당 문서를 누가 작성했는지 알려줌
* 어떤 인코딩으로 작성됐는지 알려줌

### `<meta>`

* 문서와 관련된 정보를 나타낼때 사용하는 태그

### `<title>` `</title>`

* 문서의 제목으로 브라우저 좌측 상단에 나타나는 글자

### `<body>` `<body>`

* html 본문에 해당하는 부분
* 실제 화면에 보여지는 부분



# 글자와 관련된 태그

* css로 수정할 수 있기 때문에 원래 목적과 다르게 사용될 수 있다

* h 태그
  * 제목 태그
  * h1~h6까지 있음
  * 숫작가 작을수록 큰 글씨
  * 쌍태그
  * 새 라인시작(block태그)
* b 태그, strong 태그
  * 글자를 두껍게 만드는 태그
  * 글자를 강조할 때 사용
  * 쌍태그
  * 현재 위치에서 시작(inline 태그)
* br 태그
  * 줄을 바꿔주는 태그
  * html에서 엔터는 공백하나로 처리
  * html에서 공백 여러개는 공백 1개로 처리
  * 단일태그
* i 태그, em 태그
  * 글자를 기울이는 태그
  * i태그는 아이콘을 배치할 때 주로 사용
  * 쌍태그, inline 태그
* p태그
  * 문단 태그
  * 쌍태그, block 태그
  * 위아래 여백이 있음, p태그가 겹치면 위아래 여백 중 하나만 적용
* ins 태그
  * 글자 밑줄을 표시
  * 쌍태그, inline 태그
* del 태그
  * 취소선 표시
  * 쌍태그, inline 태그
* sup 태그
  * 위첨자 표시
  * 쌍태그, inline 태그
* sub 태그
  * 아래첨자 표시
  * 쌍태그, inline 태그
* hr 태그
  * 긴 밑줄 표시
  * 단일 태그, block 태그

### input 태그

```html
<input type="종류" name="이름" value="값" placeholder="미리보기" tabindex="숫자" readonly disabled>
```

* input태그는 정보를 입력/선택하여 서버에 전달하기 위해 사용하는 태그
  * type은 input 태그 종류를 선택
  * value는 input태그에 입력한 값
  * placeholder는 입력창 미리보기로, 입력해야할 내용을 미리 알려주는 역할
  * tabindex는 탭키를 눌렀을 때 순서
  * readonly는 값을 수정하지 못하지만 서버에는 전송이 됨
  * disabled는 값을 수정하지 못하고 서버에 전송이 안됨
* input태그는 form태그와 함께 쓰임

* type

  * text

    * 기본 속성으로, 가장 많이 사용됨
    * 주로 검색창에 사용, 회원 가입시 아이디, 비번 입력창 등
    * 영문, 한글, 특수문자, 숫자를 입력받을 수 있음

  * password

    * 비밀번호를 입력할 때 사용됨

  * checkbox

    * 다중 선택해야하는 곳에서 사용
    * 같은 분류의 checkbox들은 속성 name을 동일하게 지정
    * value를 미리 지정해야 됨
    * checked : 미리 선택된 상태로 만듬

  * radio

    * 무조건 하나만 선택해야 하는 곳에서 사용
    * 같은 분류의 checkbox들은 속성 name을 동일하게 지정
    * value를 미리 지정해야 됨
    * checked : 미리 선택된 상태로 만듬

  * color

    * 색상을 선택할 때 사용
    * 색상 정보를 16진수로 표현함

  * month

    * 년 월 표시

  * week

    * 년 주 표시

  * date 

    * 년 월 일 표시

  * datetime-local 

    * 년 월 일 시 분 초 표시

  * time

    * 시 분 초 표시

  * 일반적으로 날짜 관련 부분은 datepicker를 이용

  * email

    * 이메일 형식이어야 전송이 가능
    * 이메일 형식아니면 알림창을 띄움

  * file

    * 첨부파일 선택
    * form태그에 추가적인 작업이 필요, enctype="multipart/form-data"를 추가

  * image

    * 이미지를 넣을 때 사용

    * img 태그로 대체 가능, 커서 모양이 다름

    * ```html
      <input type="image" src="파일위치" alt="이미지없음">
      ```

      * src : 파일 위치
      * alt : 이미지파일이 없는 경우 보여줄 문자열

  * number

    * 숫자만 입력 가능

    * 화살표를 이용하여 숫자를 변경할 수 있음

    * min, max 속성을 이용하여 최대값과 최소값을 지정

    * ```html
      <input type="number" name="number" min="1" max="10">
      ```

  * url

    * url 주소인지 아닌지 확인할 때 사용

  * search

    * text와 비슷하게 문자열을 입력할 수 있음
    * x버튼을 이용하여 입력된 문자열을 지울 수 있음

  * range

    * 상태바가 생겨서 범위를 조절 가능

    * min, max를 이용하여 범위를 설정 할 수 있음

    * ```html
      <input type="range" name="range" min="1" max="6">
      ```

  * hidden

    * 서버에 보내야 할 정보이지만 화면에는 안 보여줄 때 사용

  * button

    * 일반 버튼
    * value로 버튼 이름을 지정
    * button 태그로 대체 가능

  * submit

    * 서버로 전송, form태그 안에 있어야 가능
    * value로 버튼 이름을 지정
    * button 태그로 대체 가능

  * reset

    * form태그 안에 있는 모든 값을 초기값으로 설정
    * value로 버튼 이름을 지정
    * button 태그로 대체 가능