
function createSignature(params) {
    var paramArray = [];
    for(var key in params) {
        paramArray.push(key);
    }
    paramArray.sort();
    var sortStr = "";
    for(var i = 0; i < paramArray.length; i++) {
        var key = paramArray[i];
        if('' != params[key] && null != params[key] && undefined != params[key]){
            sortStr = sortStr + key + "=" + params[key] + "&";
        }
    }
    sortStr = sortStr.substring(0, sortStr.lastIndexOf("&"));
    return MD5(sortStr);
}