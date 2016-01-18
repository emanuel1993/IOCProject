<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/rotw.css" rel="stylesheet"></link>
<meta charset="UTF-8">
<title>Missions List</title>
</head>
<body>
	<div class="table">
		<div class="heading">
			<div class="distress cell-with-border">
				<p>DISTRESS LEVEL</p>
			</div>
			<div class="picture cell-with-border">
				<p>PICTURE</p>
			</div>
			<div class="details cell-with-border">
				<p>DETAILS</p>
			</div>
			<div class="participants cell-with-border">
				<p>PARTICIPANTS</p>
			</div>

		</div>
		<c:forEach var="mission" items="${missions}">
			<div class="content" onclick="location.href='GetMissionServlet?mission_type=<c:out value="${mission.missionType}"></c:out>&mission_id=<c:out value="${mission.idmission}"></c:out>'">
				<div class="distress row-border-distress">
					<p>
						<c:out value="${mission.distressLevel.id}"></c:out>
					</p>
				</div>
				<div class="picture row-border">
					<p>
						<c:out value="${mission.picName}"></c:out>
					</p>
				</div>
				<div class="details row-border">
					<p>
						<c:out value="${mission.missionName}"></c:out>
					</p>
				</div>
				<div class="participants row-border-participants">
					<p>
						<c:out value="${mission.participants}"></c:out>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>