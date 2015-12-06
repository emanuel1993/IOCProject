<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/rotw.css" rel="stylesheet"></link>
<meta charset="UTF-8">
<title>New Mission</title>
</head>
<body>
	<div>
		<div class="report-from-header">
			<p>Report Form</p>
		</div>

		<form action="UpdateInsertMissionServlet" method="POST">
			<input type="hidden" name="mission_id" value="<c:out value="${mission_id}"></c:out>">
			<input type="hidden" name="mission_type" value="<c:out value="${mission_type}"></c:out>">
			<div class="table-row-report">
				<div class="title-report">
					<p>Title:</p>
				</div>
				<div class="title-insert-report">
					<input type="text" name="mission_name" size="50">
				</div>
				<div class="priority-report">
					<p>Priority:</p>
				</div>
				<div class="priority-insert-report">
					<input type="text" name="level" size="5">
				</div>
				<div class="participants-report">
					<p>Participants:</p>
				</div>

			</div>
			<div class="table-report">
				<div class="table-row-report">
					<div class="table-column-report">
						<div class="description-row-report">
							<div class="description-report">
								<p>Description:</p>
							</div>
							<div class="description-insert-report">
								<textarea rows="5" cols="74" name="description">
							</textarea>
							</div>
						</div>
						<div class="pictures-row-report">
							<div class="pictures-report">
								<p>Pictures:</p>
							</div>
							<div class="pictures-insert-report">Insert pictures here</div>
						</div>
						<div class="location-row-report">
							<div class="location-report">
								<p>Location:</p>
							</div>
							<div class="location-insert-report">Insert map here</div>
						</div>
						<div class="location-row-report">
							<div class="location-buttons">
							</div>
							<div class="location-insert-report">
								<c:choose>
									<c:when test="${empty mission_id}">
										<input type="submit" value="Save">
									</c:when>
									<c:otherwise>
										<input type="submit" value="Update">
										<input type="button" value="Delete" onclick="location.href='DeleteMissionServlet?mission_id=<c:out value="${mission_id}"></c:out>'">
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
					<div class="participants-table-report">
						<div class="participants-list-report">
							<p>tralalala:</p>
						</div>

					</div>
				</div>

			</div>
		</form>
	</div>
</body>
</html>