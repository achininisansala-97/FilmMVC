<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.css">
<meta charset="UTF-8">
<title>Update Film</title>
</head>
<!-- NAV START -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="./home">Film DB</a>
	</div>
</nav>
<!-- NAV END -->

<!-- BODY START -->
<body>

	<!-- PAGE HEADER FOR INDICATION -->
	<h1>Add Film</h1>

	<!-- FORM TO ADD FILM -->
	<!-- NOTE: All fields required for as one way of data validation -->
	<form method="POST" action="./createFilm">
		<fieldset class="fieldset-updateFilm">
			<div class="form-box">
				<div class="form-group">
					<label for="fTitle" class="mt-4">Title</label> <input type="text"
						class="form-control" name="title" id="title"
						placeholder="The Dark Knight" required>
				</div>
				<div class="form-group">
					<label for="fYear" class="mt-4">Year</label> <input type="number"
						min="1888" class="form-control" name="year" id="year"
						placeholder="2008" required>
				</div>
				<div class="form-group">
					<label for="fDirector" class="mt-4">Director</label> <input
						type="text" class="form-control" name="director" id="director"
						placeholder="Christopher Nolan" required>
				</div>
				<div class="form-group">
					<label for="fStars" class="mt-4">Stars</label> <input type="text"
						class="form-control" name="stars" id="stars"
						placeholder="Christian Bale, Heith Ledger, Aaron Eckhart" required>
				</div>
				<div class="form-group">
					<label for="fGenre" class="mt-4">Genre</label> <input type="text"
						class="form-control" name="genre" id="genre"
						placeholder="Action" required>
				</div>
				<div class="form-group">
					<label for="fRating" class="mt-4">Rating</label> <input type="text"
						class="form-control" name="rating" id="rating"
						placeholder="*****" required>
				</div>
				<div class="form-group">
					<label for="fReview" class="mt-4">Review</label>
					<textarea class="form-control" name="review" id="review" rows="3"
						required></textarea>
				</div>
				<br>
				<button class="btn btn-primary">Add Film.</button>
				<br>
			</div>
		</fieldset>
	</form>


</body>
<!-- BODY END -->
</html>