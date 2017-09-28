var exec = require('cordova/exec');

exports.requestFocus = function(success, error) {
	uccess = success || function() { };
	error = error || function() { };

	exec(success, error, "AudioFocus", "requestFocus", []);
};

exports.releaseFocus = function(success, error) {
	success = success || function() { };
	error = error || function() { };

	exec(success, error, "AudioFocus", "releaseFocus", []);
};
