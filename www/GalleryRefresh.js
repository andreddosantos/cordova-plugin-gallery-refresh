var exec = require('cordova/exec');

function GalleryRefresh(){

}

function _getLocalImagePathWithoutPrefix(url) {
    if (url.indexOf('file:///') === 0) {
        return url.substring(7);
    }
    return url;
}

GalleryRefresh.prototype.refresh = function(path, successCb, errorCb){
  var withoutPrefixPath = _getLocalImagePathWithoutPrefix(path);
  exec(function(params){ successCb(params); }, function(error){ errorCb(error); }, "GalleryRefresh", "refresh", [withoutPrefixPath]);
}

window.galleryRefresh = new GalleryRefresh();
module.exports = galleryRefresh;
