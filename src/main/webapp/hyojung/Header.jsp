<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Dongle:wght@400;700&family=East+Sea+Dokdo&family=Poor+Story&display=swap');
       
        header{
            /* font-family: 'Dongle', sans-serif; */
            /* font-family: 'East Sea Dokdo', cursive; */
            font-family: 'Poor Story', cursive;
            margin-top: 30px;
        }
        .header_list {
            padding: 0 10px 0 10px;
            letter-spacing: 1px;
            opacity: 0.85;/* ���� */
            background-color: black;
            display: flex;
            justify-content: space-around;
            text-align: center;
            height: 100px;
        }
        .header_list >div{
            width: 100px;
            line-height: 100px;
            font-weight: 500;
            color: white;
            font-size: 25px;
        }
        #logo_human{
            width: 160px;
            height: 100px;
        }
        #logo_human > img{
            width: 160px;
            height: 50px;
            vertical-align: middle;
        }
        .login_signup {
            margin-top: 10px;
            display: flex;
            justify-content: flex-end;  
        }
        .login_signup div{
            margin-right: 40px;
            font-weight: 600;
            font-size: 20px;
        }

    </style>
    <script>
<%-- !!!!!!!!!!!!!!���� �̵� �� �����ؾ� �ϴ� �ּ�!!!!!!!!!!!!!!!--%>    
    	funtion headernav(value){
    		if(value="d1"){
    			move.href="jsp";
    		}else if(value=="d2"){
    			move.href="jsp";
    		}
    		}else if(value=="d3"){
    			move.href="jsp";
    		}
    		}else if(value=="d4"){
    			move.href="jsp";
    		}
    		}else if(value=="d5"){
    			move.href="jsp";
    		}
    		}else if(value=="d6"){
    			move.href="jsp";
    		}
    		}else if(value=="d7"){
    			move.href="jsp";
    		}
    		}else if(value=="d8"){
    			move.href="jsp";
    		}else{
    			
    		}
    	}
    </script>
</head>
<body>
    <header>
        <div class="header_list">
            <div id="d1"><span style="cursor: pointer">��ȭ</span></div>
            <div id="d2"><span style="cursor: pointer">����</span></div>
            <div id="d3"><span style="cursor: pointer">����</span></div>
 <%-- !!!!!!!!!!!!!!���� �̵� �� �����ؾ� �ϴ� �ּ�!!!!!!!!!!!!!!!--%>
            <div id="logo_human"><img src="../hyojung/logoCI.png"/></div>
            <div id="d4"><span style="cursor: pointer">�����</span></div>
            <div id="d5"><span style="cursor: pointer">�̺�Ʈ</span></div>
            <div id="d6"><span style="cursor: pointer">������</span></div>
        </div>
        <div class="login_signup">
            <div id="d7"><span style="cursor: pointer">�α���</span></div>
            <div id="d8"><span style="cursor: pointer">ȸ������</span></div>
        </div>
    </header>
</body>
</html>