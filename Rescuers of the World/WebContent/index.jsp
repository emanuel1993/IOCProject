<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ioc.rotw.helper.Constants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
<title><%=Constants.APPLICATION_NAME%></title>
<link rel="stylesheet" type="text/css" href="css/bookstore.css" />
<link rel="icon" type="image/x-icon" href="./images/favicon.ico" />
</head>
<body style="text-align: center">
	<h2><%=Constants.APPLICATION_NAME.toUpperCase()%></h2>
	<form action="IndexServlet" method="post">
		<div id="wrapperabsolute">
			<div id="wrappertop"></div>
			<div id="wrappermiddle">
				<h2><%=Constants.SIGNIN%></h2>
				<div id="mission_name_input">
					<div id="field_input">
						<input type="text" name="mission_name" id="url"
							value="mission_name" onclick="this.value = ''" /> 
					</div>
				</div>
				<div id="level_input">
					<div id="field_input">
						<input type="text" name="level" id="url"
							value="level" onclick="this.value = ''" /> 
					</div>
				</div>
				<div id="participants_input">
					<div id="field_input">
						<input type="text" name="participants" id="url"
							value="participants" onclick="this.value = ''" /> 
					</div>
				</div>
				<div id="description_input">
					<div id="field_input">
						<input type="text" name="description" id="url"
							value="description" onclick="this.value = ''" /> 
					</div>
				</div>
			</div>
			<div id="wrapperbottom"></div>
		</div>
	</form>
</body>
</html>
