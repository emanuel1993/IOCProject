<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/rotw.css" rel="stylesheet"></link>
<meta charset="UTF-8">
<c:choose>
	<c:when test="${empty mission_id}">
		<title>New Mission</title>
	</c:when>
	<c:otherwise>
		<title>Update Mission</title>
	</c:otherwise>
</c:choose>
</head>
<body>
	<div>
		<div class="report-from-header">
			<p>Report Form</p>
		</div>

		<form action="UpdateInsertMissionServlet" method="POST">
			<input type="hidden" name="mission_id"
				value="<c:out value="${mission_id}"></c:out>"> <input
				type="hidden" name="mission_type"
				value="<c:out value="${mission_type}"></c:out>"> <input
				type="hidden" name="map_id"
				value="<c:out value="${map_id}"></c:out>"> <input
				type="hidden" name="map_sector11"
				value="<c:out value="${map_sector11}"></c:out>"> <input
				type="hidden" name="map_sector12"
				value="<c:out value="${map_sector12}"></c:out>"> <input
				type="hidden" name="map_sector13"
				value="<c:out value="${map_sector13}"></c:out>"> <input
				type="hidden" name="map_sector21"
				value="<c:out value="${map_sector21}"></c:out>"> <input
				type="hidden" name="map_sector22"
				value="<c:out value="${map_sector22}"></c:out>"> <input
				type="hidden" name="map_sector23"
				value="<c:out value="${map_sector23}"></c:out>"> <input
				type="hidden" name="map_sector31"
				value="<c:out value="${map_sector31}"></c:out>"> <input
				type="hidden" name="map_sector32"
				value="<c:out value="${map_sector32}"></c:out>"> <input
				type="hidden" name="map_sector33"
				value="<c:out value="${map_sector33}"></c:out>">

			<div class="table-row-report">
				<div class="title-report">
					<p>Title:</p>
				</div>
				<div class="title-insert-report">
					<input type="text" name="mission_name" size="50"
						value="<c:out value="${mission_name}"></c:out>">
				</div>
				<div class="priority-report">
					<p>Priority:</p>
				</div>
				<div class="priority-insert-report">
					<select name="distress_level">
						<c:forEach var="distress_level" items="${distress_levels}">
							<c:choose>
								<c:when test="${distress_level_id eq distress_level.id}">
									<option value=<c:out value="${distress_level.id}"></c:out> selected>
										<c:out value="${distress_level.description}"></c:out>
									</option>

								</c:when>
								<c:otherwise>
									<option value=<c:out value="${distress_level.id}"></c:out>>
										<c:out value="${distress_level.description}"></c:out>
									</option>
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</select>
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
								<textarea rows="5" cols="74" name="description"><c:out
										value="${description}"></c:out></textarea>
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
							<div class="location-insert-report">
								<p>Map center coordinates (comma separated latitude and
									longitude):</p>
								<input type="text" name="map_center" size="50"
									value="<c:out value="${map_center}"></c:out>">
								<p>Map zoom:</p>
								<input type="range" name="map_zoom" min="10" max="16" step="1"
									value="<c:out value="${map_zoom}"></c:out>">
								<iframe width="600" height="450" frameborder="0"
									style="border: 0; top: 500px; left: 123px;"
									src="https://www.google.com/maps/embed/v1/view?key=AIzaSyDVQXq3p7JAJgKYkEcVqoabOnz7NdnddHI&center=44.433903, 26.095324&zoom=14">
								</iframe>
									<div class="grid">
										<div class="grid-row">
											<div class="grid-cell" id="11"
												<c:if test="${map_sector11}">style="background-color: rgba(113, 238, 100, 0.23)"</c:if>></div>
											<div class="grid-cell" id="12"
												<c:if test="${map_sector12}">style="background-color: rgba(113, 238, 100, 0.23)"</c:if>></div>
											<div class="grid-cell" id="13"
												<c:if test="${map_sector13}">style="background-color: rgba(113, 238, 100, 0.23)"</c:if>></div>
										</div>
										<div class="grid-row">
											<div class="grid-cell" id="21"
												<c:if test="${map_sector21}">style="background-color: rgba(113, 238, 100, 0.23)"</c:if>></div>
											<div class="grid-cell" id="22"
												<c:if test="${map_sector22}">style="background-color: rgba(113, 238, 100, 0.23)"</c:if>></div>
											<div class="grid-cell" id="23"
												<c:if test="${map_sector23}">style="background-color: rgba(113, 238, 100, 0.23)"</c:if>></div>
										</div>
										<div class="grid-row">
											<div class="grid-cell" id="31"
												<c:if test="${map_sector31}">style="background-color: rgba(113, 238, 100, 0.23)"</c:if>></div>
											<div class="grid-cell" id="32"
												<c:if test="${map_sector32}">style="background-color: rgba(113, 238, 100, 0.23)"</c:if>></div>
											<div class="grid-cell" id="33"
												<c:if test="${map_sector33}">style="background-color: rgba(113, 238, 100, 0.23)"</c:if>></div>
										</div>
									</div>
							</div>
						</div>
						<div class="location-row-report">
							<div class="location-buttons"></div>
							<div class="location-insert-report">
								<c:choose>
									<c:when test="${empty mission_id}">
										<input type="submit" value="Save">
									</c:when>
									<c:otherwise>
										<input type="submit" value="Update">
										<input type="button" value="Delete"
											onclick="location.href='DeleteMissionServlet?mission_id=<c:out value="${mission_id}"></c:out>&mission_type=<c:out value="${mission_type}"></c:out>'">
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
					<div class="participants-table-report">
						<div class="participants-list-report"></div>

					</div>
				</div>

			</div>
		</form>
	</div>
</body>
</html>