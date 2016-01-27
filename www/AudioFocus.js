var exec = require('cordova/exec');

exports.requestFocus = function(success, error) {
    success = success || function() { };
    error = error || function() { };

    exec(success, error, "AudioFocus", "requestFocus", []);
};
