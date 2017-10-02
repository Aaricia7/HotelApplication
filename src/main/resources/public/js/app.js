$(function () {

	// Router
	function init() {

		// Routie is a routing library, more info: https://github.com/jgallen23/routie
		routie({
			'': home,
			'guests*': guests,
			'rooms*': rooms,
			'bookings*': bookings,
		});
	}

	// Views
	function home() {
		console.debug('home view');
		setView('home');
	}

	function guests() {
		console.debug('guests view');
		setView('guests');
	}

	function rooms() {
		console.debug('rooms view');
		setView('rooms');
	}

	function bookings() {
		console.debug('bookings view');
		setView('bookings');
	}

	function setView(view) {
		$(".nav-link").removeClass("active");
		$("#" + view).addClass("active");

		$.ajax({
			url: "templates/" + view + ".html",
			cashe: false
		}).done(function (template) {
			$("#content").html(template);
		});
	}
	init();
});