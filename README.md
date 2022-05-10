# 구현 환경
## java v.1.8 / spring-framework v.4.3.22.RELEASE / tomcat v.9.0.56
## dependency setting (maven)
###### - oEmbed v.0.8.1
###### - Commons-Validator v.1.6
###### - Json-Simple v.1.1.1
###### - Jakarta.activation v.2.0.0

# 실행 절차 
01) client가 input에 url을 입력 02) url 값이 null이 아닐 때, /embed 로 ajax submit 03) submit된 url을 공백 제거 후 OembedServiceImpl 클래스 execute 메서드 실행 04) urlCtrl 클래스 urlValid 메서드 실행 05) submit된 url의 형태 validation (urlValidator 사용) 06) 제공하는 사이트의 host url을 추출 (URL 객체.getHost() 사용) 07) host url에 맞는 oembed url을 vo객체에 setting 08) oembed url + submit url을 oembed server로 submit (HttpGet 객체 사용) 09) HttpResponse 객체 형태로 return된 oembed 정보를 json형태로 parsing 10) json형태로 ajax return11. ajax 성공했을 때 resultBox, 에러일 때 errorBox 생성
