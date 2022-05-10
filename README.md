# 구현 환경
#### 1. java v.1.8 / spring-framework v.4.3.22.RELEASE / tomcat v.9.0.56
#### 2. dependency setting (maven)
###### - oEmbed v.0.8.1
###### - Commons-Validator v.1.6
###### - Json-Simple v.1.1.1
###### - Jakarta.activation v.2.0.0

#### 3. Youtube / Twitter / Vimeo embed 가능
#### 4. instagram 앱 승인 문제로 구현 불가

# 실행 절차

## flow
#### index.jsp > HomeController.class > OembedServiceImpl.class > UrlCtrl.class > JsonParser.class

## detail flow
#### 1. client가 input에 url을 입력
#### 2. url 값이 null이 아닐 때, /embed 로 ajax submit
#### 3. submit된 url을 공백 제거 후 OembedServiceImpl 클래스 execute 메서드 실행
#### 4. urlCtrl 클래스 urlValid 메서드 실행
#### 5. submit된 url의 형태 validation (urlValidator 사용)
#### 6. 제공하는 사이트의 host url을 추출 (URL 객체.getHost() 사용)
#### 7. host url에 맞는 oembed url을 vo객체에 setting
#### 8. oembed url + submit url을 oembed server로 submit (HttpGet 객체 사용)
#### 9. HttpResponse 객체 형태로 return된 oembed 정보를 json형태로 parsing
#### 10. json형태로 ajax return
#### 11. ajax 성공했을 때 resultBox, 에러일 때 errorBox 생성
