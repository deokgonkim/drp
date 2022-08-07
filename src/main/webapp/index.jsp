<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="home" lang="ko">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>메인 화면</title>
        <link rel="stylesheet" type="text/css" href="resources/css/screen.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="resources/css/print.css" media="print" />
        <link rel="stylesheet" type="text/css" href="resources/css/content.css" media="screen" />
        
        <link rel="stylesheet" type="text/css" href="${initParam.jqueryui_url}/themes/base/minified/jquery-ui.min.css" media="screen" />
        
        <link rel="stylesheet" type="text/css" href="${initParam.extjs_url}/resources/ext-theme-access/ext-theme-access-all-debug.min.css" media="screen" />
        
        <link rel="stylesheet" type="text/css" href="resources/css/main/welcome.css" />
        <link rel="stylesheet" type="text/css" href="resources/print.css" />
        <style type="text/css">
        
        </style>
        <script type="text/javascript" src="${initParam.jquery_url}/jquery.min.js" charset="UTF-8"></script>
        <script type="text/javascript" src="${initParam.jqueryui_url}js/jquery-ui.min.js" charset="UTF-8"></script>
        <script type="text/javascript" src="${initParam.extjs_url}/ext-debug.min.js" charset="UTF-8"></script>
        
        <script type="text/javascript" src="app.js" charset="UTF-8"></script>
    </head>
    <body>
    <div id="topPanelHtml" class="x-hidden">
        ${pageContext.request.userPrincipal.name}님 환영합니다. <a href="${pageContext.request.contextPath}/logout_process.jsp">로그아웃</a>
    </div>
    <div id="defaultTabContent" class="x-hidden">
        <pre>
 * User Object
   Attributes : dn - 문자열 distinguished name ex. uid=dgkim,ou=Users,o=example
                displayName - 문자열 표시명 ex. 김 덕곤
   Referrer   : IpAddresses(columns : manager, owner)
   Reference  : none 

 * IpAddress Object
   Attributes : ipAddress - 문자열 IP주소
                macAddress - 문자열 macAddress
                org - 문자열 소속
                manager - 문자열 관리자 User객체의 dn값
                owner - 문자열 사용자 User객체의 dn값
                description - 문자열 비고
   Referrer   : none
   Reference  : User Object(columns: dn)

 * Hardware Object
   Attributes : id - 문자열 관리번호?
                hardwareType - 코드 종류 ( LAPTOP - 노트북, DESKTOPC - 조립PC, DESKTOPM - 완제품PC )
                modelName - 문자열 모델명
                serialNumber - 문자열 식별번호 씨리얼
                owner - 문자열 사용자 User객체의 dn값
                purchased - 날짜 구매일자
                warranty - 날짜 보증기한
                lifeTime - 문자열 내용연수
   Referrer   : HardwarePart Object(column: id), SoftwareCopy Object(column: id)
   Reference  : User Object(columns: dn)

 * HardwarePart Object
   Attributes : id - 문자열 관리번호?
                hardwareType - 문자열 부품종류 ( 기본부속, AS부속, 추가부속 )
                hardwareCategory - 문자열 부품형태 ( CPU, Memory, HDD, etc )
                manufacture - 문자열 제조사
                modelName - 문자열 부품명
                serialNumber - 문자열 식별번호 씨리얼
                purchased - 날짜 구매일자
                warrenty - 날짜 보증기한
                lifeTime - 문자열 내용연수
                bind - 문자열 Hardware Object(column: id)
                status - 문자열 상태 ( 사용가능, 사용불가 )
   Referrer   : none
   Reference  : Hardware Object(column: id)

 * Software Object
   Attributes : id - 문자열 관리번호?
                purchased - 문자열 구매여부 ( 구매, 번들, 미구매 )
                manufacturer - 문자열 제조사
                programName - 문자열 제품명
                version - 문자열 버전
                licenseType - 문자열 라이센스 형태 ( 사이트 라이센스, 카피당 라이센스 )
                masterKey - 문자열 마스터키(씨리얼)
   Referrer   : SoftwareCopy
   Reference  : none

 * SoftwareCopy Object
   Attributes : id - 문자열 관리번호?
                purchase - 날짜 구매일자
                serialNumber - 문자열 씨리얼
                software - 문자열 Software Object(column: id)
                bind - 문자열 Hardware Object(column: id)
   Referrer   : none
   Reference  : Software Object(column: id), Hardware Object(column: id)
        </pre>
    </div> 
    <script type="text/javascript">
        var contextPath = '${pageContext.request.contextPath}';
        var userName = '${pageContext.request.userPrincipal.name}';
    </script>
    </body>
</html>